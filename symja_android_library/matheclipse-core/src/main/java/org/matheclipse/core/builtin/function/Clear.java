package org.matheclipse.core.builtin.function;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractCoreFunctionEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;

/** 
 * <p>
 * See the online Symja function reference: <a href="https://bitbucket.org/axelclk/symja_android_library/wiki/Symbols/Clear">Clear</a>
 * </p>
 */
public class Clear extends AbstractCoreFunctionEvaluator {

	public Clear() {
	}

	@Override
	public IExpr evaluate(final IAST ast, EvalEngine engine) {
		Validate.checkRange(ast, 2);

		for (int i = 1; i < ast.size(); i++) {
			if (ast.get(i).isSymbol()) {
				ISymbol symbol = (ISymbol) ast.get(i);
				symbol.clear(engine);
			}
		}

		return F.Null;
	}

	@Override
	public void setUp(ISymbol symbol) {
		symbol.setAttributes(ISymbol.HOLDALL);
	}
}
