package org.matheclipse.core.reflection.system;

import org.matheclipse.core.convert.VariablesSet;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;

/**
 * Determine the variable symbols of an expression
 */
public class BooleanVariables extends AbstractFunctionEvaluator {

	public BooleanVariables() {
		// empty ctor
	}

	/**
	 */
	@Override
	public IExpr evaluate(final IAST ast, EvalEngine engine) {
		Validate.checkSize(ast, 2);

		VariablesSet eVar = new VariablesSet();
		eVar.addBooleanVarList(ast.arg1());
		return eVar.getVarList();

	}

	@Override
	public void setUp(final ISymbol symbol) {
		symbol.setAttributes(ISymbol.HOLDALL);
	}

}
