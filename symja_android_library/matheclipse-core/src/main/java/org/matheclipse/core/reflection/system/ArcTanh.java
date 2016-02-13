package org.matheclipse.core.reflection.system;

import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.Negate;

import org.apache.commons.math4.util.FastMath;
import org.apfloat.Apcomplex;
import org.apfloat.ApcomplexMath;
import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.eval.interfaces.AbstractTrigArg1;
import org.matheclipse.core.eval.interfaces.INumeric;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.reflection.system.rules.ArcTanhRules;
import org.matheclipse.parser.client.SyntaxError;

/**
 * Inverse hyperbolic tangent
 * 
 * See
 * <a href="http://en.wikipedia.org/wiki/Inverse_hyperbolic_function"> Inverse
 * hyperbolic functions</a>
 */
public class ArcTanh extends AbstractTrigArg1 implements INumeric, ArcTanhRules {

	@Override
	public IAST getRuleAST() {
		return RULES;
	}

	public ArcTanh() {
	}

	@Override
	public IExpr evaluateArg1(final IExpr arg1) {
		IExpr negExpr = AbstractFunctionEvaluator.getNormalizedNegativeExpression(arg1);
		if (negExpr != null) {
			return Negate(ArcTanh(negExpr));
		}
		IExpr imPart = AbstractFunctionEvaluator.getPureImaginaryPart(arg1);
		if (imPart != null) {
			return F.Times(F.CI, F.ArcTan(imPart));
		}
		return F.NIL;
	}

	@Override
	public IExpr e1DblArg(final double arg1) {
		double val = FastMath.atanh(arg1);
		if (Double.isNaN(val)) {
		}
		return F.num(val);

	}

	@Override
	public double evalReal(final double[] stack, final int top, final int size) {
		if (size != 1) {
			throw new UnsupportedOperationException();
		}
		return FastMath.atanh(stack[top]);
	}

	@Override
	public IExpr e1ApfloatArg(Apfloat arg1) {
		return F.num(ApfloatMath.atanh(arg1));
	}

	@Override
	public IExpr e1ApcomplexArg(Apcomplex arg1) {
		return F.complexNum(ApcomplexMath.atanh(arg1));
	}

	@Override
	public void setUp(final ISymbol symbol) throws SyntaxError {
		symbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
		super.setUp(symbol);
	}
}
