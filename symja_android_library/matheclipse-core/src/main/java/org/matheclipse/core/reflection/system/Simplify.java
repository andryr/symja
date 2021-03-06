package org.matheclipse.core.reflection.system;

import org.matheclipse.core.builtin.function.Refine;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.exception.WrongArgumentType;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.eval.util.Assumptions;
import org.matheclipse.core.eval.util.IAssumptions;
import org.matheclipse.core.eval.util.Options;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IComplex;
import org.matheclipse.core.interfaces.IComplexNum;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IFraction;
import org.matheclipse.core.interfaces.IInteger;
import org.matheclipse.core.interfaces.INum;
import org.matheclipse.core.interfaces.INumber;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.visit.AbstractVisitorBoolean;
import org.matheclipse.core.visit.VisitorExpr;

/**
 * Try to simplify a given expression
 */
public class Simplify extends AbstractFunctionEvaluator {

	private static class IsBasicExpressionVisitor extends AbstractVisitorBoolean {
		public IsBasicExpressionVisitor() {
			super();
		}

		@Override
		public boolean visit(IAST ast) {
			if (ast.isTimes() || ast.isPlus()) {
				// check the arguments
				for (int i = 1; i < ast.size(); i++) {
					if (!ast.get(i).accept(this)) {
						return false;
					}
				}
				return true;
			}
			if (ast.isPower() && (ast.arg2().isInteger())) {
				// check the arguments
				return ast.arg1().accept(this);
			}
			return false;
		}

		@Override
		public boolean visit(IComplex element) {
			return true;
		}

		@Override
		public boolean visit(IComplexNum element) {
			return true;
		}

		@Override
		public boolean visit(IFraction element) {
			return true;
		}

		@Override
		public boolean visit(IInteger element) {
			return true;
		}

		@Override
		public boolean visit(INum element) {
			return true;
		}

		@Override
		public boolean visit(ISymbol symbol) {
			return true;
		}
	}

	private static class SimplifyVisitor extends VisitorExpr {
		final IsBasicExpressionVisitor isBasicAST = new IsBasicExpressionVisitor();

		public SimplifyVisitor() {
			super();
		}

		private IExpr tryExpandAllTransformation(IAST plusAST, IExpr test) {
			IExpr result = F.NIL;
			long minCounter = plusAST.leafCount();
			IExpr temp;
			long count;

			try {
				temp = F.evalExpandAll(test);
				count = temp.leafCount();
				if (count < minCounter) {
					result = temp;
				}
			} catch (WrongArgumentType wat) {
				//
			}

			return result;
		}

		private IExpr tryTransformations(IExpr expr) {
			IExpr result = F.NIL;
			if (expr.isAST()) {
				// try ExpandAll, Together, Apart, Factor to reduce the
				// expression
				long minCounter = expr.leafCount();
				IExpr temp;
				long count;

				try {
					temp = F.evalExpandAll(expr);
					count = temp.leafCount();
					if (count < minCounter) {
						minCounter = count;
						result = temp;
					}
				} catch (WrongArgumentType wat) {
					//
				}

				try {
					temp = F.eval(F.Together(expr));
					count = temp.leafCount();
					if (count < minCounter) {
						minCounter = count;
						result = temp;
					}
				} catch (WrongArgumentType wat) {
					//
				}

				try {
					temp = F.eval(F.Factor(expr));
					count = temp.leafCount();
					if (count < minCounter) {
						minCounter = count;
						result = temp;
					}
				} catch (WrongArgumentType wat) {
					//
				}

				try {
					temp = F.eval(F.Apart(expr));
					count = temp.leafCount();
					if (count < minCounter) {
						minCounter = count;
						result = temp;
					}
				} catch (WrongArgumentType wat) {
					//
				}
			}
			return result;

		}

		@Override
		public IExpr visit(IAST ast) {
			IExpr temp;

			temp = visitAST(ast);
			if (temp.isPresent()) {
				return temp;
			}

			if (ast.isPlus()) {
				IAST basicPlus = F.Plus();
				IAST restPlus = F.Plus();

				for (int i = 1; i < ast.size(); i++) {
					temp = ast.get(i);
					if (temp.accept(isBasicAST)) {
						basicPlus.add(temp);
					} else {
						restPlus.add(temp);
					}
				}
				if (basicPlus.size() > 1) {
					temp = tryTransformations(basicPlus.getOneIdentity(F.C0));
					if (temp.isPresent()) {
						if (restPlus.isAST0()) {
							return temp;
						}
						return F.Plus(temp, restPlus);
					}
				}
			} else if (ast.isTimes()) {
				IAST basicTimes = F.Times();
				IAST restTimes = F.Times();
				INumber number = null;
				if (ast.arg1().isNumber()) {
					number = (INumber) ast.arg1();
				}
				IExpr reduced;
				for (int i = 1; i < ast.size(); i++) {
					temp = ast.get(i);
					if (temp.accept(isBasicAST)) {
						if (i != 1 && number != null) {
							if (temp.isPlus()) {
								// <number> * Plus[.....]
								reduced = tryExpandAll(ast, temp, number, i);
								if (reduced.isPresent()) {
									return reduced;
								}
							} else if (temp.isPower() && ((IAST) temp).arg1().isPlus()
									&& ((IAST) temp).arg2().isMinusOne()) {
								// <number> * Power[Plus[...], -1 ]
								reduced = tryExpandAll(ast, ((IAST) temp).arg1(), number.inverse(), i);
								if (reduced.isPresent()) {
									return F.Power(reduced, F.CN1);
								}
							}
						}
						basicTimes.add(temp);
					} else {
						restTimes.add(temp);
					}
				}

				if (basicTimes.size() > 1) {
					temp = tryTransformations(basicTimes.getOneIdentity(F.C0));
					if (temp.isPresent()) {
						if (restTimes.isAST0()) {
							return temp;
						}
						return F.Times(temp, restTimes);
					}
				}
			}

			temp = F.evalExpandAll(ast);
			long minCounter = ast.leafCount();
			long count = temp.leafCount();
			if (count < minCounter) {
				return temp;
			}
			return F.NIL;
		}

		private IExpr tryExpandAll(IAST ast, IExpr temp, IExpr arg1, int i) {
			IExpr expandedAst = tryExpandAllTransformation((IAST) temp, F.Times(arg1, temp));
			if (expandedAst.isPresent()) {
				IAST result = F.Times();
				ast.range(2, ast.size()).toList(result);
				result.set(i - 1, expandedAst);
				return result;
			}
			return F.NIL;
		}
	}

	public Simplify() {
	}

	@Override
	public IExpr evaluate(final IAST ast, EvalEngine engine) {
		Validate.checkRange(ast, 2, 3);

		IExpr arg1 = ast.arg1();
		if (arg1.isAtom()) {
			return arg1;
		}

		if (ast.size() > 2) {
			IExpr arg2 = ast.arg2();
			IAssumptions assumptions = Refine.determineAssumptions(ast.topHead(), arg2, engine);
			if (assumptions != null) {
				arg1 = Refine.refineAssumptions(arg1, assumptions, engine);
			}
		}

		long minCounter = arg1.leafCount();

		IExpr result = arg1;
		long count = 0L;
		IExpr temp = arg1.accept(new SimplifyVisitor());
		while (temp.isPresent()) {
			count = temp.leafCount();
			if (count < minCounter) {
				minCounter = count;
				result = temp;
				temp = result.accept(new SimplifyVisitor());
			} else {
				return result;
			}
		}
		return result;
	}

}
