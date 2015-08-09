package org.matheclipse.core.reflection.system;

import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IFraction;
import org.matheclipse.core.interfaces.IInteger;
import org.matheclipse.core.interfaces.IRational;

/**
 * Power series expansion
 */
public class Series extends AbstractFunctionEvaluator {
	public Series() {
	}

	private IExpr sin_taylor_term(long n, IExpr x) {
		if (n < 0 || n % 2 == 0) {
			return F.C0;
		} else {
			long d = n / 2;
			if (d == 1) {
				return F.Times(F.CN1, F.Divide(F.Power(x, F.integer(n)), F.Factorial(F.integer(n))));
			} else {
				return F.Divide(F.Power(x, F.integer(n)), F.Factorial(F.integer(n)));
			}
			// return (-1)**(n//2) * x**(n)/C.factorial(n)
		}
	}

	private IExpr cos_taylor_term(long n, IExpr x) {
		if (n < 0 || n % 2 == 1) {
			return F.C0;
		} else {
			long d = n / 2;
			if (d == 1) {
				return F.Times(F.CN1, F.Divide(F.Power(x, F.integer(n)), F.Factorial(F.integer(n))));
			} else {
				return F.Divide(F.Power(x, F.integer(n)), F.Factorial(F.integer(n)));
			}
			// return (-1)**(n//2) * x**(n)/C.factorial(n)
		}
	}

	private IExpr tan_taylor_term(long n, IExpr x) {
		if (n < 0 || n % 2 == 0) {
			return F.C0;
		} else {
			long n1 = n + 1L;
			long a = (n - 1L) / 2L;
			IExpr b = F.Power(F.C2, n1);
			IFraction B = BernoulliB.bernoulliNumber(F.integer(n1));
			if (B == null) {
				return null;
			}
			IInteger Fac = Factorial.factorial(F.integer(n1));
			if (Fac == null) {
				return null;
			}
			if (a == 1L) {
				return F.Times(F.CN1, b, F.Subtract(b, F.C1), F.Divide(B, Fac), F.Power(x, F.integer(n)));
			} else {
				return F.Times(b, F.Subtract(b, F.C1), F.Divide(B, Fac), F.Power(x, F.integer(n)));
			}
			// return (-1)**(n//2) * x**(n)/C.factorial(n)
		}
	}

	private IExpr fx_taylor_term(long n, IAST f, IExpr a) {
		if (n < 0) {
			return F.C0;
		} else {

			// Series[f[x],{x,a,3}] =>
			// SeriesData[x, a, {f[a], Derivative[1][f][a], Derivative[2][f][a]/2, Derivative[3][f][a]/6}, 0, 4, 1]
			if (n == 0) {
				IAST clone = f.clone();
				clone.set(1, a);
				return clone;
			}
			IAST deriv = F.Derivative(F.integer(n));
			IAST fDeriv = F.ast(deriv);
			fDeriv.add(f.topHead());
			IAST fDerivParam = F.ast(fDeriv);
			// for (int i = 1; i < f.size(); i++) {
			// fDerivParam.add(f.get(i));
			// }
			fDerivParam.add(a);
			return F.Divide(fDerivParam, F.Factorial(F.integer(n)));

			// TODO multi variate functions
			// Series[f[x,y],{y,a,3}] =>
			// SeriesData[y, a, {f[x, a], Derivative[0, 1][f][x, a], Derivative[0, 2][f][x, a]/2, Derivative[0, 3][f][x, a]/6}, 0,
			// 4, 1]
		}
	}

	public IAST plusSeriesData(IAST f, IAST g) {
		IAST composed = f.clone();
		IAST composedArg3 = ((IAST) f.arg3()).clone();
		composed.set(3, composedArg3);

		IAST fArg3 = (IAST) f.arg3();
		IAST gArg3 = (IAST) g.arg3();
		for (int i = 1; i < fArg3.size(); i++) {
			composedArg3.set(i, F.eval(F.Plus(fArg3.get(i), gArg3.get(i))));
		}
		return composed;
	}

	public IAST timesSeriesData(IAST f, IAST g) {
		IAST composed = f.clone();
		IAST composedArg3 = ((IAST) f.arg3()).clone();
		composed.set(3, composedArg3);

		IAST fArg3 = (IAST) f.arg3();
		IAST gArg3 = (IAST) g.arg3();
		IAST temp;
		for (int i = 1; i < fArg3.size(); i++) {
			temp = F.Plus();
			for (int j = 1; j < gArg3.size(); j++) {
				temp.add(F.Times(fArg3.get(i), gArg3.get(j)));
			}
			composedArg3.set(i, F.eval(temp));
		}
		return composed;
	}

	public IAST composeSeriesData(IAST f, IAST g) {
		IAST composed = f.clone();
		IAST composedArg3 = ((IAST) f.arg3()).clone();
		composed.set(3, composedArg3);

		IAST fArg3 = (IAST) f.arg3();
		IAST gArg3 = (IAST) g.arg3();
		IAST temp;
		for (int i = 1; i < fArg3.size(); i++) {
			temp = F.Plus();
			for (int j = 1; j < gArg3.size(); j++) {
				temp.add(F.Times(fArg3.get(i), gArg3.get(j)));
			}
			composedArg3.set(i, F.eval(temp));
		}
		return composed;
	}

	public IAST powerSeriesData(IExpr a, IExpr b, int upperLimit) {
		if (b.isRational()) {
			IRational r = (IRational) b;
			IAST seriesData = F.SeriesData(a, F.C0);
			IAST coefficientList = F.List();
			coefficientList.add(F.C1);
			seriesData.add(coefficientList);
			seriesData.add(r.getNumerator());
			seriesData.add(F.integer(upperLimit));
			seriesData.add(r.getDenominator());
			return seriesData;
		}
		return null;

	}

	@Override
	public IExpr evaluate(final IAST ast) {
		if (ast.size() == 3 && (ast.arg2().isVector() == 3)) {

			IAST range = (IAST) ast.arg2();
			final int lowerLimit = 0;
			// Validate.checkIntType(range, 2, Integer.MIN_VALUE);
			// if (lowerLimit != 0) {
			// // TODO support other cases than 0
			// return null;
			// }
			final int upperLimit = Validate.checkIntType(range, 3, Integer.MIN_VALUE);
			if (upperLimit < 0) {
				return null;
			}
			if (lowerLimit > upperLimit) {
				return null;
			}
			IExpr startValue = range.arg2();
			IAST seriesData = F.SeriesData(range.arg1(), startValue);
			IExpr den = F.C1;
			IAST coefficientList = F.List();
			IExpr factor = null;
			int leadingZeroIndex = -1;
			IAST ast1 = (IAST) ast.arg1();
			IExpr temp = ast.arg1();
			for (int i = lowerLimit; i <= upperLimit; i++) {
				temp = F.eval(F.D(temp, range.arg1()));
				if (ast1.size() == 2) {
					factor = fx_taylor_term(i, ast1, range.arg2());
				}
				// factor = tan_taylor_term(i, F.C1);
				if (leadingZeroIndex < 0 && !factor.isZero()) {
					leadingZeroIndex = i;
				}
				// factor = F.Times(F.Power(F.Factorial(F.integer(i)), F.CN1));
				// F.Power(F.Plus(list.arg1(), F.Times(F.CN1, list.arg2())), F.integer(i)));
				coefficientList.add(F.eval(factor));
				// coefficientList.add( F.eval(F.Times(F.ReplaceAll(temp, F.Rule(list.arg1(), list.arg2())), factor )));
			}
			if (leadingZeroIndex > 0) {
				IAST list = F.List();
				list.addAll(coefficientList, leadingZeroIndex + 1, coefficientList.size());
				coefficientList = list;
			}
			int trailingZeroIndex = coefficientList.size();
			do {
				trailingZeroIndex--;
			} while (trailingZeroIndex > 1 && coefficientList.get(trailingZeroIndex).isZero());
			if (trailingZeroIndex + 1 < coefficientList.size()) {
				IAST list = F.List();
				list.addAll(coefficientList, 1, trailingZeroIndex + 1);
				coefficientList = list;
			}
			seriesData.add(coefficientList);

			if (leadingZeroIndex > 0) {
				seriesData.add(F.integer(leadingZeroIndex));
			} else {
				seriesData.add(F.integer(lowerLimit));
			}
			seriesData.add(F.eval(F.Plus(upperLimit, den)));
			seriesData.add(den);
			return seriesData;

		}
		return null;
	}
}
