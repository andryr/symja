package org.matheclipse.core.reflection.system;

import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IInteger;

/**
 * 
 */
public class Tuples extends AbstractFunctionEvaluator {

	public Tuples() {
	}

	@Override
	public IExpr evaluate(final IAST ast) {
		Validate.checkRange(ast, 2, 3);

		IExpr arg1 = ast.get(1);
		if (ast.size() == 2 && arg1.isListOfLists()) {
			try {
				IAST list = (IAST) arg1;
				// int k = list.size()-1;
				IAST result = F.List();
				IAST temp = F.List();
				tuplesOfLists(list, 1, result, temp);
				return result;
			} catch (ArithmeticException ae) {

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (ast.size() == 3 && arg1.isAST() && ast.get(2).isInteger()) {
			IExpr arg2 = ast.get(2);
			try {
				int k = ((IInteger) arg2).toInt();
				IAST result = F.List();
				IAST temp = F.List();
				tuples((IAST) arg1, k, result, temp);
				return result;
			} catch (ArithmeticException ae) {
				// because of toInt() method
			}
		}
		return null;
	}

	/**
	 * Generate all n-tuples form a list.
	 * 
	 * @param originalList
	 * @param n
	 * @param result
	 * @param subResult
	 */
	private void tuples(final IAST originalList, final int n, IAST result, IAST subResult) {
		if (n == 0) {
			result.add(subResult);
			return;
		}
		IAST temp = null;
		for (int j = 1; j < originalList.size(); j++) {
			temp = subResult.clone();
			temp.add(originalList.get(j));
			tuples(originalList, n - 1, result, temp);
		}

	}

	/**
	 * Generate all tuples from a list of lists.
	 * 
	 * @param originalList
	 *            the list of lists
	 * @param k
	 * @param result
	 *            the result list
	 * @param subResult
	 *            the current subList which should be inserted in the result list
	 */
	private void tuplesOfLists(final IAST originalList, final int k, IAST result, IAST subResult) {
		if (k == originalList.size()) {
			result.add(subResult);
			return;
		}
		IAST temp = null;
		IAST subAST = (IAST) originalList.get(k);
		for (int j = 1; j < subAST.size(); j++) {
			temp = subResult.clone();
			temp.add(subAST.get(j));
			tuplesOfLists(originalList, k + 1, result, temp);
		}

	}

}