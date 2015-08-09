package org.matheclipse.core.reflection.system;

import java.math.BigInteger;

import org.apache.commons.math3.analysis.function.Subtract;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractTrigArg1;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IFraction;
import org.matheclipse.core.interfaces.IInteger;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.parser.client.SyntaxError;

/**
 * <p>
 * Returns the PolyGamma function value.
 * </p>
 * 
 * See <a href="https://en.wikipedia.org/wiki/Polygamma_function">Polygamma function</a>
 * 
 */
public class PolyGamma extends AbstractTrigArg1 {

	public PolyGamma() {
	}

	@Override
	public IExpr evaluate(final IAST ast) {
		Validate.checkRange(ast, 2, 4);

		if (ast.size() == 2) {
			return evaluateArg1(ast.arg1());
		}
		return null;
	}

	@Override
	public IExpr evaluateArg1(final IExpr arg1) {
		if (arg1.isInteger()) {
			if (arg1.isPositive()) {
				// Sum(1/k, {1, k, n-1})
				IInteger n = ((IInteger) arg1).subtract(F.C1);
				return F.Subtract(F.Sum(F.Power(F.k, F.CN1), F.List(F.k, F.C1, n)), F.EulerGamma);
			}
			return F.CComplexInfinity;
		}
		// if (arg1.isFraction() && arg1.isPositive()) {
		// IFraction frac = (IFraction) arg1;
		// if (frac.getDenominator().equals(F.C2)) {
		// IInteger n = frac.getNumerator();
		// // Sqrt(Pi) * (n-2)!! / 2^((n-1)/2)
		// return F.Times(F.Sqrt(F.Pi), F.Factorial2(n.subtract(F.C2)), F.Power(F.C2, F.Times(F.C1D2, F.Subtract(F.C1, n))));
		// }
		// } else
		if (arg1.isInfinity() || arg1.isNegativeInfinity() || arg1.equals(F.CIInfinity) || arg1.equals(F.CNIInfinity)
				|| arg1.isComplexInfinity()) {
			return F.CInfinity;
		}
		return null;
	}

	@Override
	public void setUp(final ISymbol symbol) throws SyntaxError {
		symbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
		super.setUp(symbol);
	}
}
