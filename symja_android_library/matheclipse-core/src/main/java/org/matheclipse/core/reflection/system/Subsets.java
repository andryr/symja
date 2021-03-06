package org.matheclipse.core.reflection.system;

import java.util.Iterator;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.eval.util.LevelSpecification;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;

/**
 * Generate a list of all k-combinations from a given list
 * 
 * See <a href="http://en.wikipedia.org/wiki/Combination">Combination</a>
 */
public class Subsets extends AbstractFunctionEvaluator {
	/**
	 * Iterable for all k-combinations from a set
	 * 
	 * See <a href="http://en.wikipedia.org/wiki/Combination">Combination</a>
	 */
	private final static class KSubsetsIterable implements Iterator<int[]>, Iterable<int[]> {

		final private int n;
		final private int k;
		final private int x[];
		private long bin;
		private boolean first;

		public KSubsetsIterable(final int len, final int parts) {
			super();
			n = len;
			k = parts;
			// f = fun;
			x = new int[n];
			for (int a = 0; a < n; a++) {
				x[a] = a;
			}
			bin = binomial(n, k);
			first = true;
		}

		@Override
		public int[] next() {
			if (bin-- == 0) {
				return null;
			}
			if (first) {
				first = false;
				return x;
			}
			int i = k - 1;
			while (x[i] == n - k + i) {
				i--;
			}
			x[i] = x[i] + 1;
			for (int j = i + 1; j < n; j++) {
				x[j] = x[j - 1] + 1;
			}
			return x;
		}

		public static long binomial(final long n, final long k) {
			long bin = 1;
			long kSub = k;
			if (kSub > (n / 2)) {
				kSub = n - kSub;
			}
			for (long i = 1; i <= kSub; i++) {
				bin = (bin * (n - i + 1)) / i;
			}
			return bin;
		}

		@Override
		public boolean hasNext() {
			return true;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Iterator<int[]> iterator() {
			return this;
		}
	}
	/**
	 * Iterate over the lists of all k-combinations from a given list
	 * 
	 * See <a href="http://en.wikipedia.org/wiki/Combination">Combination</a>
	 */
	public final static class KSubsetsList implements Iterator<IAST>, Iterable<IAST> {

		final private IAST fList;
		final private IAST fResultList;
		final private int fOffset;
		final private Iterator<int[]> fIterable;
		final private int fK;

		public KSubsetsList(final Iterator<int[]> iterable, final IAST list, final int k, IAST resultList) {
			this(iterable, list, k, resultList, 0);
		}

		public KSubsetsList(final Iterator<int[]> iterable, final IAST list, final int k, IAST resultList, final int offset) {
			fIterable = iterable;
			fList = list;
			fK = k;
			fResultList = resultList;
			fOffset = offset;
		}

		/**
		 * Get the index array for the next partition.
		 * 
		 * @return <code>null</code> if no further index array could be generated
		 */
		@Override
		public IAST next() {
			int j[] = fIterable.next();
			if (j == null) {
				return null;
			}

			IAST temp = fResultList.clone();
			for (int i = 0; i < fK; i++) {
				temp.add(fList.get(j[i] + fOffset));
			}

			return temp;
		}

		@Override
		public boolean hasNext() {
			return fIterable.hasNext();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Iterator<IAST> iterator() {
			return this;
		}

	}

	public Subsets() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IExpr evaluate(final IAST ast, EvalEngine engine) {
		Validate.checkRange(ast, 2, 3);

		if (ast.arg1().isAST()) {
			final IAST f = (IAST) ast.arg1();
			final int n = f.size() - 1;
			final LevelSpecification level;
			if (ast.isAST2()) {
				level = new LevelSpecification(ast.arg2(), false);
			} else {
				level = new LevelSpecification(0, n);
			}

			int k;
			final IAST result = F.ast(f.head());
			level.setFromLevelAsCurrent();
			while (level.isInRange()) {
				k = level.getCurrentLevel();
				final KSubsetsList iter = createKSubsets(f, k, F.ast(F.List), 1);
				for (IAST part : iter) {
					if (part == null) {
						break;
					}
					result.add(part);
				}
				level.incCurrentLevel();
			}

			return result;
		}
		return F.NIL;
	}

	public static KSubsetsList createKSubsets(final IAST list, final int k, IAST resultList, final int offset) {
		return new KSubsetsList(new KSubsetsIterable(list.size() - offset, k), list, k, resultList, offset);
	}
}
