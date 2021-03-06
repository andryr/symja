package org.matheclipse.core.builtin.function;

import java.util.HashMap;
import java.util.Map;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.WrongNumberOfArguments;
import org.matheclipse.core.eval.interfaces.AbstractCoreFunctionEvaluator;
import org.matheclipse.core.eval.util.OpenFixedSizeMap;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.generic.Functors;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;

public class Function extends AbstractCoreFunctionEvaluator {

	public Function() {
		// defualt ctor
	}

	@Override
	public IExpr evaluate(final IAST ast, EvalEngine engine) {
		if (ast.head().isAST()) {

			final IAST function = (IAST) ast.head();
			if (function.isAST1()) {
				return replaceSlots(function.arg1(), ast);
			} else if (function.isAST2()) {
				IAST symbolSlots;
				if (function.arg1().isList()) {
					symbolSlots = (IAST) function.arg1();
				} else {
					symbolSlots = F.List(function.arg1());
				}
				if (symbolSlots.size() > ast.size()) {
					throw new WrongNumberOfArguments(ast, symbolSlots.size() - 1, ast.size() - 1);
				}
				return function.arg2().replaceAll(Functors.rules(getRulesMap(symbolSlots, ast)))
						.orElse(function.arg2());
			}

		}
		return F.NIL;
	}

	private Map<IExpr, IExpr> getRulesMap(final IAST symbolSlots, final IAST ast) {
		int size = symbolSlots.size() - 1;
		final Map<IExpr, IExpr> rulesMap;
		if (size <= 5) {
			rulesMap = new OpenFixedSizeMap<IExpr, IExpr>(size * 3 - 1);
		} else {
			rulesMap = new HashMap<IExpr, IExpr>();
		}
		for (int i = 1; i <= size; i++) {
			rulesMap.put(symbolSlots.get(i), ast.get(i));
		}
		return rulesMap;
	}

	public static IExpr replaceSlots(final IExpr expr, final IAST list) {
		return expr.replaceSlots(list).orElse(expr);
	}

	@Override
	public void setUp(final ISymbol symbol) {
		symbol.setAttributes(ISymbol.HOLDALL);
	}
}
