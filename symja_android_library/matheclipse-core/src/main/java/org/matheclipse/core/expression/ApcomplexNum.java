package org.matheclipse.core.expression;

import org.apfloat.Apcomplex;
import org.apfloat.ApcomplexMath;
import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.form.output.OutputFormFactory;
import org.matheclipse.core.interfaces.IComplexNum;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.INumber;
import org.matheclipse.core.interfaces.ISignedNumber;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.visit.IVisitor;
import org.matheclipse.core.visit.IVisitorBoolean;
import org.matheclipse.core.visit.IVisitorInt;

/**
 * <code>IComplexNum</code> implementation which wraps a <code>org.apache.commons.math3.complex.Apcomplex</code> value to represent
 * a numeric complex floating-point number.
 */
public class ApcomplexNum extends ExprImpl implements IComplexNum {

	protected static ApcomplexNum newInstance(final Apcomplex value) {
		return new ApcomplexNum(value);
	}

	protected static ApcomplexNum newInstance(final Apfloat real, final Apfloat imag) {
		return new ApcomplexNum(real, imag);
	}

	public static ApcomplexNum valueOf(final double real, int precision) {
		return newInstance(new Apcomplex(new Apfloat(real, precision), Apfloat.ZERO));
	}

	public static ApcomplexNum valueOf(final double real, final double imaginary, int precision) {
		return newInstance(new Apcomplex(new Apfloat(real, precision), new Apfloat(imaginary, precision)));
	}

	public static ApcomplexNum valueOf(final Apcomplex value) {
		return newInstance(value);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6033055105824482264L;

	/** The square root of -1. A number representing "0.0 + 1.0i" */
	public static final ApcomplexNum I = new ApcomplexNum(Apcomplex.I);

	/** A complex number representing "NaN + NaNi" */
	// public static final ApfloatComplexNum NaN = valueOf(Double.NaN, Double.NaN);

	/** A complex number representing "1.0 + 0.0i" */
	public static final ApcomplexNum ONE = new ApcomplexNum(Apcomplex.ONE);

	/** A complex number representing "0.0 + 0.0i" */
	public static final ApcomplexNum ZERO = new ApcomplexNum(Apcomplex.ZERO);

	Apcomplex fComplex;

	private ApcomplexNum(Apcomplex complex) {
		fComplex = complex;
	}

	private ApcomplexNum(Apfloat real, Apfloat imag) {
		fComplex = new Apcomplex(real, imag);
	}

	/**
	 * @return
	 */
	@Override
	public double getImaginaryPart() {
		double temp = fComplex.imag().doubleValue();
		if (temp == (-0.0)) {
			temp = 0.0;
		}
		return temp;
	}

	public Apcomplex apcomplexValue() {
		return fComplex;
	}

	/**
	 * @return
	 */
	@Override
	public double getRealPart() {
		double temp = fComplex.real().doubleValue();
		if (temp == (-0.0)) {
			temp = 0.0;
		}
		return temp;
	}

	@Override
	public boolean isZero() {
		return fComplex.intValue() == 0;
	}

	@Override
	public int hierarchy() {
		return DOUBLECOMPLEXID;
	}

	@Override
	public IComplexNum add(final IComplexNum val) {
		return newInstance(fComplex.add(((ApcomplexNum) val).fComplex));
	}

	public ApcomplexNum add(final ApcomplexNum that) {
		return newInstance(fComplex.add(that.fComplex));
	}

	@Override
	public IComplexNum multiply(final IComplexNum val) {
		return newInstance(fComplex.multiply(((ApcomplexNum) val).fComplex));
	}

	@Override
	public IComplexNum pow(final IComplexNum val) {
		return newInstance(ApcomplexMath.pow(fComplex, ((ApcomplexNum) val).fComplex));
	}

	/**
	 * @param that
	 * @return
	 */
	public Apcomplex add(final Apcomplex that) {
		return fComplex.add(that);
	}

	/**
	 * @return
	 */
	@Override
	public IComplexNum conjugate() {
		return newInstance(fComplex.conj());
	}

	/**
	 * @param that
	 * @return
	 */
	public Apcomplex divide(final Apcomplex that) {
		return fComplex.divide(that);
	}

	public ApcomplexNum divide(final ApcomplexNum that) throws ArithmeticException {
		return newInstance(fComplex.divide(that.fComplex));
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof ApcomplexNum) {
			return fComplex.equals(((ApcomplexNum) obj).fComplex);
		}
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public IExpr evaluate(EvalEngine engine) {
		if (engine.getNumericPrecision() <= ApfloatNum.DOUBLE_PRECISION) {
			return ComplexNum.valueOf(fComplex.real().doubleValue(), fComplex.imag().doubleValue());
		}
		if (fComplex.imag().intValue() == 0) {
			return ApfloatNum.newInstance(fComplex.real());
		}
		return null;
	}

	@Override
	public boolean isSame(IExpr expression, double epsilon) {
		if (expression instanceof ApcomplexNum) {
			return fComplex.equals(((ApcomplexNum) expression).fComplex);
		}
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public double dabs() {
		// if (isNaN()) {
		// return Double.NaN;
		// }
		//
		// if (isInfinite()) {
		// return Double.POSITIVE_INFINITY;
		// }

		if (Math.abs(getReal()) < Math.abs(getImaginary())) {
			if (getImaginary() == 0.0) {
				return Math.abs(getReal());
			}
			final double q = getReal() / getImaginary();
			return (Math.abs(getImaginary()) * Math.sqrt(1 + q * q));
		} else {
			if (getReal() == 0.0) {
				return Math.abs(getImaginary());
			}
			final double q = getImaginary() / getReal();
			return (Math.abs(getReal()) * Math.sqrt(1 + q * q));
		}
	}

	@Override
	public Num eabs() {
		return Num.valueOf(dabs());
	}

	/** {@inheritDoc} */
	@Override
	public int compareAbsValueToOne() {
		double temp = dabs();
		return Double.compare(temp, 1.0);
	}

	/**
	 * @return
	 */
	// public Apcomplex exp() {
	// return fComplex.exp();
	// }
	/**
	 * @return
	 */
	// public Object export() {
	// return fComplex.export();
	// }
	/**
	 * @return
	 */
	// public float floatValue() {
	// return fComplex.floatValue();
	// }
	/**
	 * @return
	 */
	public double getImaginary() {
		return fComplex.imag().doubleValue();
	}

	/**
	 * @return
	 */
	public double getReal() {
		return fComplex.real().doubleValue();
	}

	@Override
	public final int hashCode() {
		return fComplex.hashCode();
	}

	/**
	 * @param that
	 * @return
	 */
	public ApcomplexNum multiply(final ApcomplexNum that) {
		return newInstance(fComplex.multiply(that.fComplex));
	}

	/**
	 * @return
	 */
	@Override
	public ApcomplexNum negate() {
		return newInstance(fComplex.negate());
	}

	/**
	 * @return
	 */
	@Override
	public INumber opposite() {
		return newInstance(fComplex.negate());
	}

	/**
	 * @param that
	 * @return
	 */
	@Override
	public IExpr plus(final IExpr that) {
		if (that instanceof ApcomplexNum) {
			return newInstance(fComplex.add(((ApcomplexNum) that).fComplex));
		}
		return super.plus(that);
	}

	@Override
	public IExpr inverse() {
		return newInstance(Apcomplex.ONE.divide(fComplex));
		// final double tmp = (fComplex.getReal() * fComplex.getReal()) + (fComplex.getImaginary() * fComplex.getImaginary());
		// return valueOf(fComplex.getReal() / tmp, -fComplex.getImaginary() / tmp);
	}

	/**
	 * @param that
	 * @return
	 */
	public Apcomplex subtract(final Apcomplex that) {
		return fComplex.subtract(that);
	}

	public ApcomplexNum subtract(final ApcomplexNum that) {
		return newInstance(fComplex.subtract(that.fComplex));
	}

	/**
	 * @param that
	 * @return
	 */
	@Override
	public IExpr times(final IExpr that) {
		if (that instanceof ApcomplexNum) {
			return newInstance(fComplex.multiply(((ApcomplexNum) that).fComplex));
		}
		return super.times(that);
	}

	@Override
	public String toString() {
		try {
			StringBuilder sb = new StringBuilder();
			OutputFormFactory.get().convertDoubleComplex(sb, this, Integer.MIN_VALUE);
			return sb.toString();
		} catch (Exception e1) {
		}
		// fall back to simple output format
		return fComplex.toString();
	}

	@Override
	public int complexSign() {
		final int i = (int) fComplex.real().signum();
		if (i == 0) {
			return (int) fComplex.imag().signum();
		}
		return i;
	}

	public int compareTo(final Apcomplex that) {
		if (fComplex.real().compareTo(that.real()) < 0) {
			return -1;
		}
		if (fComplex.real().compareTo(that.real()) > 0) {
			return 1;
		}
		return fComplex.imag().compareTo(that.imag());
	}

	/**
	 * Compares this expression with the specified expression for order. Returns a negative integer, zero, or a positive integer as
	 * this expression is canonical less than, equal to, or greater than the specified expression.
	 */
	@Override
	public int compareTo(final IExpr obj) {
		if (obj instanceof ApcomplexNum) {
			return compareTo(((ApcomplexNum) obj).fComplex);
			// return fComplex.compareTo(((DoubleComplexImpl) obj).fComplex);
		}
		return (hierarchy() - (obj).hierarchy());
	}

	@Override
	public ISymbol head() {
		return F.Complex;
	}

	public Apcomplex getComplex() {
		return fComplex;
	}

	public org.matheclipse.parser.client.math.Complex getCMComplex() {
		return new org.matheclipse.parser.client.math.Complex(fComplex.real().doubleValue(), fComplex.imag().doubleValue());
	}

	/** {@inheritDoc} */
	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

	/** {@inheritDoc} */
	@Override
	public boolean accept(IVisitorBoolean visitor) {
		return visitor.visit(this);
	}

	/** {@inheritDoc} */
	@Override
	public int accept(IVisitorInt visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean equalsInt(int i) {
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public ISignedNumber getIm() {
		return F.num(getImaginaryPart());
	}

	/** {@inheritDoc} */
	@Override
	public ISignedNumber getRe() {
		return F.num(getRealPart());
	}

	@Override
	public INumber ceil() throws ArithmeticException {
		return F.complex(F.integer(ApfloatMath.ceil(fComplex.real()).toBigInteger()),
				F.integer(ApfloatMath.ceil(fComplex.imag()).toBigInteger()));
	}

	@Override
	public INumber floor() throws ArithmeticException {
		return F.complex(F.integer(ApfloatMath.floor(fComplex.real()).toBigInteger()),
				F.integer(ApfloatMath.floor(fComplex.imag()).toBigInteger()));
	}

}