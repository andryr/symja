package org.matheclipse.core.eval.interfaces;

import org.apache.commons.math4.linear.FieldMatrix;
import org.apache.commons.math4.linear.RealMatrix;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.convert.Convert;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.exception.WrongArgumentType;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;

public abstract class AbstractMatrix1Expr extends AbstractFunctionEvaluator {

	public AbstractMatrix1Expr() {
	}

	@Override
	public IExpr evaluate(final IAST ast, EvalEngine engine) {
		Validate.checkSize(ast, 2);

		FieldMatrix<IExpr> matrix;
		try {

			int[] dim = ast.arg1().isMatrix();
			if (dim != null) {
				final IAST list = (IAST) ast.arg1();
				matrix = Convert.list2Matrix(list);
				if (matrix != null) {
					return matrixEval(matrix);
				}
			}

		} catch (final ClassCastException e) {
			if (Config.SHOW_STACKTRACE) {
				e.printStackTrace();
			}
		} catch (final IndexOutOfBoundsException e) {
			if (Config.SHOW_STACKTRACE) {
				e.printStackTrace();
			}
		}

		return F.NIL;
	}

	@Override
	public IExpr numericEval(final IAST ast, EvalEngine engine) {
		Validate.checkSize(ast, 2);

		RealMatrix matrix;
		final IAST list = (IAST) ast.arg1();
		try {
			if (engine.isApfloat()) {
				FieldMatrix<IExpr> fieldMatrix = Convert.list2Matrix(list);
				if (fieldMatrix != null) {
					return matrixEval(fieldMatrix);
				}
				return F.NIL;
			}
			matrix = Convert.list2RealMatrix(list);
			return realMatrixEval(matrix);
		} catch (final WrongArgumentType e) {
			// WrongArgumentType occurs in list2RealMatrix(),
			// if the matrix elements aren't pure numerical values
			FieldMatrix<IExpr> fieldMatrix = Convert.list2Matrix(list);
			return matrixEval(fieldMatrix);
		} catch (final IndexOutOfBoundsException e) {
			if (Config.SHOW_STACKTRACE) {
				e.printStackTrace();
			}
		}

		return F.NIL;
	}

	/**
	 * Evaluate the symbolic matrix for this algorithm.
	 * 
	 * @param matrix
	 *            the matrix which contains symbolic values
	 * @return
	 */
	public abstract IExpr matrixEval(FieldMatrix<IExpr> matrix);

	/**
	 * Evaluate the numeric matrix for this algorithm.
	 * 
	 * @param matrix
	 *            the matrix which contains numeric values
	 * @return
	 */
	public abstract IExpr realMatrixEval(RealMatrix matrix);
}