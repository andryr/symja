package org.matheclipse.core.reflection.system;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.exception.WrongArgumentType;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.INumber;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.parser.client.SyntaxError;

import de.jtem.mfc.field.Complex;

/**
 * 
 * <p>
 * See: <a href="http://en.wikipedia.org/wiki/Hypergeometric_function">Wikipedia
 * - Hypergeometric function</a>
 */
public class Hypergeometric2F1 extends AbstractFunctionEvaluator {

	public Hypergeometric2F1() {
	}

	@Override
	public IExpr evaluate(IAST ast, EvalEngine engine) {
		Validate.checkSize(ast, 5);

		try {
			final Complex a = checkComplexNumericType(ast, 1);
			final Complex b = checkComplexNumericType(ast, 2);
			final Complex c = checkComplexNumericType(ast, 3);
			final Complex z = checkComplexNumericType(ast, 4);

			final Complex result = de.jtem.mfc.specialFunctions.HyperGeometric2F1.evaluate(a, b, c, z);

			return F.complexNum(result.getRe(), result.getIm());
		} catch (RuntimeException re) {

		}
		return null;
	}

	public static Complex checkComplexNumericType(IAST ast, int position) {
		try {
			INumber number = ast.get(position).evalNumber();
			if (number != null) {
				return new Complex(number.getReal(), number.getImaginary());
			}
		} catch (RuntimeException re) {

		}
		throw new WrongArgumentType(ast, ast.get(position), position, "Complex number expected!");
	}

	@Override
	public void setUp(final ISymbol symbol) throws SyntaxError {
		symbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
	}

}
