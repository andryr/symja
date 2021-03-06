package org.matheclipse.core.expression;

import java.math.BigInteger;

import org.apache.commons.math4.fraction.BigFraction;
import org.apfloat.Apcomplex;
import org.apfloat.Apfloat;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.form.output.OutputFormFactory;
import org.matheclipse.core.interfaces.IComplex;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IFraction;
import org.matheclipse.core.interfaces.IInteger;
import org.matheclipse.core.interfaces.INumber;
import org.matheclipse.core.interfaces.IRational;
import org.matheclipse.core.interfaces.ISignedNumber;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.visit.IVisitor;
import org.matheclipse.core.visit.IVisitorBoolean;
import org.matheclipse.core.visit.IVisitorInt;
import org.matheclipse.core.visit.IVisitorLong;

/**
 * A symbolic complex number implementation
 * 
 */
public class ComplexSym extends ExprImpl implements IComplex {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1489050560741527824L;

	private final static ComplexSym ZERO = ComplexSym.valueOf(F.C0);
	private final static ComplexSym ONE = ComplexSym.valueOf(F.C1);

	public static ComplexSym valueOf(final BigFraction real, final BigFraction imaginary) {
		final ComplexSym c = new ComplexSym();
		c.fReal = AbstractFractionSym.valueOf(real);
		c.fImaginary = AbstractFractionSym.valueOf(imaginary);
		return c;
	}

	public static ComplexSym valueOf(final BigInteger real) {
		final ComplexSym c = new ComplexSym();
		c.fReal = AbstractIntegerSym.valueOf(real);
		c.fImaginary = F.C0;
		return c;
	}

	public static ComplexSym valueOf(final BigInteger real, final BigInteger imaginary) {
		final ComplexSym c = new ComplexSym();
		c.fReal = AbstractIntegerSym.valueOf(real);
		c.fImaginary = AbstractIntegerSym.valueOf(imaginary);
		return c;
	}

	public static ComplexSym valueOf(final IFraction real) {
		final ComplexSym c = new ComplexSym();
		c.fReal = real;
		c.fImaginary = F.C0;
		return c;
	}

	public static ComplexSym valueOf(final IRational real) {
		final ComplexSym c = new ComplexSym();
		c.fReal = real;
		c.fImaginary = F.C0;
		return c;
	}

	public static ComplexSym valueOf(final IRational real, final IRational imaginary) {
		final ComplexSym c = new ComplexSym();
		c.fReal = real;
		c.fImaginary = imaginary;
		return c;
	}

	public static ComplexSym valueOf(final long real_numerator, final long real_denominator, final long imag_numerator,
			final long imag_denominator) {
		final ComplexSym c = new ComplexSym();
		c.fReal = AbstractFractionSym.valueOf(real_numerator, real_denominator);
		c.fImaginary = AbstractFractionSym.valueOf(imag_numerator, imag_denominator);
		return c;
	}

	private IRational fReal;

	private IRational fImaginary;

	private transient int fHashValue;

	private ComplexSym() {
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

	/** {@inheritDoc} */
	@Override
	public long accept(IVisitorLong visitor) {
		return visitor.visit(this);
	}

	public ComplexSym add(final ComplexSym parm1) {
		return ComplexSym.valueOf(fReal.add(parm1.fReal), fImaginary.add(parm1.fImaginary));
	}

	@Override
	public IComplex add(final IComplex parm1) {
		return ComplexSym.valueOf(fReal.add(parm1.getRealPart()), fImaginary.add(parm1.getImaginaryPart()));
	}

	@Override
	public ApcomplexNum apcomplexNumValue(long precision) {
		return ApcomplexNum.valueOf(apcomplexValue(precision));
	}

	public Apcomplex apcomplexValue(long precision) {
		Apfloat real = new Apfloat(fReal.getBigNumerator(), precision)
				.divide(new Apfloat(fReal.getBigDenominator(), precision));
		Apfloat imag = new Apfloat(fImaginary.getBigNumerator(), precision)
				.divide(new Apfloat(fImaginary.getBigDenominator(), precision));
		return new Apcomplex(real, imag);
	}

	@Override
	public INumber ceilFraction() {
		return valueOf((IRational) fReal.ceilFraction(), (IRational) fImaginary.ceilFraction());
	}

	/** {@inheritDoc} */
	@Override
	public int compareAbsValueToOne() {
		IRational temp = fReal.multiply(fReal).add(fImaginary.multiply(fImaginary));
		return temp.compareTo(F.C1);
	}

	/**
	 * Compares this expression with the specified expression for order. Returns
	 * a negative integer, zero, or a positive integer as this expression is
	 * canonical less than, equal to, or greater than the specified expression.
	 */
	@Override
	public int compareTo(final IExpr expr) {
		if (expr instanceof ComplexSym) {
			final int cp = fReal.compareTo(((ComplexSym) expr).fReal);
			if (cp != 0) {
				return cp;
			}
			return fImaginary.compareTo(((ComplexSym) expr).fImaginary);
		}
		return super.compareTo(expr);
	}

	@Override
	public ComplexNum complexNumValue() {
		// double precision complex number
		double nr = fReal.getNumerator().doubleValue();
		double dr = fReal.getDenominator().doubleValue();
		double ni = fImaginary.getNumerator().doubleValue();
		double di = fImaginary.getDenominator().doubleValue();
		return ComplexNum.valueOf(nr / dr, ni / di);
	}

	@Override
	public int complexSign() {
		final int i = fReal.getNumerator().sign();

		if (i == 0) {
			return fImaginary.getNumerator().sign();
		}

		return i;
	}

	/** {@inheritDoc} */
	@Override
	public IComplex conjugate() {
		return ComplexSym.valueOf(fReal, fImaginary.negate());
	}

	/** {@inheritDoc} */
	@Override
	public IExpr eabs() {
		return F.Sqrt(fReal.multiply(fReal).add(fImaginary.multiply(fImaginary)));
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof ComplexSym) {
			if (hashCode() != obj.hashCode()) {
				return false;
			}
			if (this == obj) {
				return true;
			}
			return fReal.equals(((ComplexSym) obj).fReal) && fImaginary.equals(((ComplexSym) obj).fImaginary);
		}
		return false;
	}

	@Override
	public boolean equalsInt(int i) {
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public IExpr evaluate(EvalEngine engine) {
		if (engine.isNumericMode()) {
			return numericNumber();
		}
		final INumber cTemp = normalize();
		return (cTemp == this) ? F.NIL : cTemp;
	}

	@Override
	public INumber floorFraction() {
		return valueOf((IRational) fReal.floorFraction(), (IRational) fImaginary.floorFraction());
	}

	@Override
	public String fullFormString() {
		StringBuilder buf = new StringBuilder("Complex");
		if (Config.PARSER_USE_LOWERCASE_SYMBOLS) {
			buf.append('(');
		} else {
			buf.append('[');
		}
		if (fReal.getDenominator().isOne()) {
			buf.append(fReal.getNumerator().toString());
		} else {
			buf.append("Rational");
			if (Config.PARSER_USE_LOWERCASE_SYMBOLS) {
				buf.append('(');
			} else {
				buf.append('[');
			}
			buf.append(fReal.getNumerator().toString());
			buf.append(',');
			buf.append(fReal.getDenominator().toString());
			if (Config.PARSER_USE_LOWERCASE_SYMBOLS) {
				buf.append(')');
			} else {
				buf.append(']');
			}
		}
		buf.append(',');

		if (fImaginary.getDenominator().isOne()) {
			buf.append(fImaginary.getNumerator().toString());
		} else {
			buf.append("Rational");
			if (Config.PARSER_USE_LOWERCASE_SYMBOLS) {
				buf.append('(');
			} else {
				buf.append('[');
			}
			buf.append(fImaginary.getNumerator().toString());
			buf.append(',');
			buf.append(fImaginary.getDenominator().toString());
			if (Config.PARSER_USE_LOWERCASE_SYMBOLS) {
				buf.append(')');
			} else {
				buf.append(']');
			}
		}
		if (Config.PARSER_USE_LOWERCASE_SYMBOLS) {
			buf.append(')');
		} else {
			buf.append(']');
		}
		return buf.toString();
	}

	@Override
	public ISignedNumber getIm() {
		if (fImaginary.getDenominator().isOne()) {
			return fImaginary.getNumerator();
		}
		return fImaginary;
	}

	/**
	 * Returns the imaginary part of a complex number
	 * 
	 * @return imaginary part
	 */
	@Override
	public IRational getImaginaryPart() {
		return fImaginary;
	}

	@Override
	public ISignedNumber getRe() {
		if (fReal.getDenominator().isOne()) {
			return fReal.getNumerator();
		}
		return fReal;
	}

	/**
	 * Returns the real part of a complex number
	 * 
	 * @return real part
	 */
	@Override
	public IRational getRealPart() {
		return fReal;
	}

	@Override
	public final int hashCode() {
		if (fHashValue == 0) {
			fHashValue = fReal.hashCode() * 29 + fImaginary.hashCode();
		}
		return fHashValue;
	}

	@Override
	public ISymbol head() {
		return F.Complex;
	}

	@Override
	public int hierarchy() {
		return COMPLEXID;
	}

	@Override
	public String internalFormString(boolean symbolsAsFactoryMethod, int depth) {
		return internalJavaString(symbolsAsFactoryMethod, depth, false);
	}

	@Override
	public String internalJavaString(boolean symbolsAsFactoryMethod, int depth, boolean useOperators) {
		if (fReal.isZero()) {
			if (fImaginary.isOne()) {
				return "CI";
			}
			if (fImaginary.isMinusOne()) {
				return "CNI";
			}
		}

		int realNumerator = NumberUtil.toInt(fReal.getBigNumerator());
		int realDenominator = NumberUtil.toInt(fReal.getBigDenominator());
		int imagNumerator = NumberUtil.toInt(fImaginary.getBigNumerator());
		int imagDenominator = NumberUtil.toInt(fImaginary.getBigDenominator());
		return "CC(" + realNumerator + "L," + realDenominator + "L," + imagNumerator + "L," + imagDenominator + "L)";
	}

	@Override
	public String internalScalaString(boolean symbolsAsFactoryMethod, int depth) {
		return internalJavaString(symbolsAsFactoryMethod, depth, true);
	}

	@Override
	public IExpr inverse() {
		final IRational tmp = (fReal.multiply(fReal)).add(fImaginary.multiply(fImaginary));
		return ComplexSym.valueOf(fReal.divideBy(tmp), fImaginary.negate().divideBy(tmp));
	}

	@Override
	public boolean isZero() {
		return NumberUtil.isZero(fReal) && NumberUtil.isZero(fImaginary);
	}

	@Override
	public IComplex multiply(final IComplex parm1) {
		return ComplexSym.valueOf(
				fReal.multiply(parm1.getRealPart()).subtract(fImaginary.multiply(parm1.getImaginaryPart())),
				fReal.multiply(parm1.getImaginaryPart()).add(parm1.getRealPart().multiply(fImaginary)));
	}

	@Override
	public ComplexSym negate() {
		return ComplexSym.valueOf(fReal.negate(), fImaginary.negate());
	}

	@Override
	public INumber normalize() {
		if (fImaginary.isZero()) {
			if (fReal instanceof IFraction) {
				if (fReal.getDenominator().isOne()) {
					return fReal.getNumerator();
				}
				if (fReal.getNumerator().isZero()) {
					return F.C0;
				}
			}
			return fReal;
		}
		boolean evaled = false;
		IRational newRe = fReal;
		IRational newIm = fImaginary;
		if (fReal instanceof IFraction) {
			if (fReal.getDenominator().isOne()) {
				newRe = fReal.getNumerator();
				evaled = true;
			}
			if (fReal.getNumerator().isZero()) {
				newRe = F.C0;
				evaled = true;
			}
		}
		if (fImaginary instanceof IFraction && fImaginary.getDenominator().isOne()) {
			newIm = fImaginary.getNumerator();
			evaled = true;
		}
		return evaled ? valueOf(newRe, newIm) : this;
	}

	@Override
	public final INumber numericNumber() {
		return F.complexNum(this);
	}

	@Override
	public INumber opposite() {
		return ComplexSym.valueOf(fReal.negate(), fImaginary.negate());
	}

	@Override
	public IExpr plus(final IExpr that) {
		if (that instanceof ComplexSym) {
			return this.add((ComplexSym) that);
		}
		if (that instanceof IInteger) {
			return this.add(valueOf((IInteger) that));
		}
		if (that instanceof IFraction) {
			return this.add(valueOf((IFraction) that));
		}
		return super.plus(that);
	}

	@Override
	public IComplex pow(final int parm1) {
		int temp = parm1;

		if ((parm1 == 0) && fReal.isZero() && fImaginary.isZero()) {
			throw new java.lang.ArithmeticException();
		}

		if (parm1 == 1) {
			return this;
		}

		IComplex res = ONE;

		if (parm1 < 0) {
			temp *= -1;
			for (int i = 0; i < temp; i++) {
				res = res.multiply(this);
			}
			final IRational d = res.getRealPart().multiply(res.getRealPart())
					.add(res.getImaginaryPart().multiply(res.getImaginaryPart()));

			return ComplexSym.valueOf(res.getRealPart().divideBy(d), res.getImaginaryPart().negate().divideBy(d));
		}
		for (int i = 0; i < temp; i++) {
			res = res.multiply(this);
		}

		return res;
	}

	@Override
	public IExpr times(final IExpr that) {
		if (that instanceof ComplexSym) {
			return multiply((ComplexSym) that);
		}
		if (that instanceof IInteger) {
			return this.multiply(valueOf((IInteger) that));
		}
		if (that instanceof IFraction) {
			return this.multiply(valueOf((IFraction) that));
		}
		return super.times(that);
	}

	@Override
	public String toString() {
		try {
			StringBuilder sb = new StringBuilder();
			OutputFormFactory.get().convertComplex(sb, this, Integer.MIN_VALUE, OutputFormFactory.NO_PLUS_CALL);
			return sb.toString();
		} catch (Exception e1) {
			// fall back to simple output format
			final StringBuilder tb = new StringBuilder();
			tb.append('(');
			tb.append(fReal.toString());
			tb.append(")+I*(");
			tb.append(fImaginary.toString());
			tb.append(')');
			return tb.toString();
		}
	}

	@Override
	public double getImaginary() {
		return fImaginary.doubleValue();
	}

	@Override
	public double getReal() {
		return fReal.doubleValue();
	}
}