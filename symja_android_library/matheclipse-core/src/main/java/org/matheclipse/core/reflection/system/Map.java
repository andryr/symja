package org.matheclipse.core.reflection.system;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.eval.util.Options;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.generic.Functors;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.visit.VisitorLevelSpecification;

/**
 * 
 * @see Scan
 */
public class Map extends AbstractFunctionEvaluator {

	public Map() {
	}

	@Override
	public IExpr evaluate(final IAST ast, EvalEngine engine) {
		Validate.checkRange(ast, 3, 5);

		int lastIndex = ast.size() - 1;
		boolean heads = false;
		final Options options = new Options(ast.topHead(), ast, lastIndex, engine);
		IExpr option = options.getOption("Heads");
		if (option.isPresent()) {
			lastIndex--;
			if (option.isTrue()) {
				heads = true;
			}
		} else {
			Validate.checkRange(ast, 3, 4);
		}

		final IAST arg1 = F.ast(ast.arg1());
		if (lastIndex == 3) {
			VisitorLevelSpecification level = new VisitorLevelSpecification(Functors.append(arg1), ast.get(lastIndex),
					heads);
			final IExpr result = ast.arg2().accept(level);
			return result.isPresent() ? result : ast.arg2();
		} else {
			VisitorLevelSpecification level = new VisitorLevelSpecification(Functors.append(arg1), 1, heads);
			final IExpr result = ast.arg2().accept(level);
			return result.isPresent() ? result : ast.arg2();
		}
	}

}
