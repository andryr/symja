/**
This file is part of a jTEM project.
All jTEM projects are licensed under the FreeBSD license 
or 2-clause BSD license (see http://www.opensource.org/licenses/bsd-license.php). 

Copyright (c) 2002-2009, Technische Universität Berlin, jTEM
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

-	Redistributions of source code must retain the above copyright notice, 
	this list of conditions and the following disclaimer.

-	Redistributions in binary form must reproduce the above copyright notice, 
	this list of conditions and the following disclaimer in the documentation 
	and/or other materials provided with the distribution.
 
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS 
BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, 
OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT 
OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, 
STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING 
IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY 
OF SUCH DAMAGE.
**/

package de.jtem.mfc.field;

import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.ListIterator;

/** This class provides static functions for complex number.
  *
  * @author schmies
  */

public abstract class ComplexValue implements Field.Complex {

    final static double EPS    = 1.e-14;
    final static double EPSSQR = EPS * EPS;

    /** Returns real part of <code>u</code>.
     * @return <code>u.re</code>.
     */
    public final static double re( final Field.Complex u) {
        return u.getRe();
    }

    /** Returns imag. part of <code>u</code>.
     * @return <code>u.im</code>.
     */
    public final static double im(Field.Complex u) {
        return u.getIm();
    }

    /** Returns <code>r = <u,v>_R^2</code>.
     * Creates double with sum of multiplication between real and imag. parts of <code>u,v</code>
     */
    public final static double dot(final Field.Complex u,
                                   final Field.Complex v) {
	return u.getRe() * v.getRe() + u.getIm() * v.getIm();
    }

    /** Returns r = det(u,v).
     * Creates double with vlaue of determinant <code>u,v</code>.
     */
    public final static double det( final Field.Complex u, final Field.Complex v ) {
	return u.getRe() * v.getIm() - u.getIm() * v.getRe();
    }

    /** Returns r = |u-v|^2 */
    public final static double distSqr( final Field.Complex u, final Field.Complex v ) {
        double subRe = u.getRe() - v.getRe();
        double subIm = u.getIm() - v.getIm();

        return subRe*subRe + subIm*subIm;
    }

    /** Returns r = |u-v| */
    public final static double dist(final Field.Complex u,
                                    final Field.Complex v) {
	return Math.sqrt(distSqr(u, v));
    }

    /** Returns |x+iy| */
    public final static double abs(final double x, final double y) {
	return Math.sqrt(x * x + y * y);
    }

    /** Returns r = |u| */
    public final static double abs( final Field.Complex u ) {
	return abs( u.getRe(), u.getIm() );
    }

    /** Returns |x+iy|^2 */
    public final static double absSqr( final double x, final double y ) {
	return x*x + y*y;
    }

    /** Returns |u.re+iu.im|^2 */
    public final static double absSqr( final Field.Complex u ) {
        return u.getRe()*u.getRe() + u.getIm()*u.getIm();
    }


    /** Returns positive argument of u.
     * Returns 0 for the positive real axis, Pi for the negative,
     * 1/2 Pi for the positive imaginary axis and 3/2 for the negative. */
    public final static double argPositive(final double x, final double y) {
      if (Math.abs(x) > Math.abs(y)) {
        if (x > 0.) {
          return (y >= 0.) ? Math.atan(y / x) : Math.atan(y / x) + 2 * Math.PI;
        }
        else {
          return Math.atan(y / x) + Math.PI;
        }
      }
      else {
        if (y > 0.) {
          return Math.PI / 2. - Math.atan(x / y);
        }
        else {
          return (y < 0.) ? 3. * Math.PI / 2. - Math.atan(x / y) : 0.;
        }
      }
    }

    /** Returns positive argument of u.
     * Returns 0 for the positive real axis, Pi for the negative,
     * 1/2 Pi for the positive imaginary axis and 3/2 for the negative. */
    public final static double argPositive(final Field.Complex u) {
      return argPositive(u.getRe(), u.getIm());
        }

    /** Returns negative argument of u.
     * Returns 0 for the positive real axis, Pi for the negative,
     * 1/2 Pi for the positive imaginary axis and -1/2 Pi for the negative. */
    public final static double arg(final double x, final double y) {
      if (Math.abs(x) > Math.abs(y)) {
        if (x > 0.) {
          return (y >= 0.) ? Math.atan(y / x) : Math.atan(y / x) ;
        }
        else {
	    return (y >= 0.) ? ( Math.PI + Math.atan(y/x) ) : ( Math.atan(y/x) -Math.PI );
        }
      }
      else {
        if (y > 0.) {
          return Math.PI / 2. - Math.atan(x / y);
        }
        else {
          return (y < 0.) ? (- Math.atan(x / y) - ( Math.PI / 2. )) : 0.;
        }
      }
    }

     /** Returns negative argument of u.
     * Returns 0 for the positive real axis, Pi for the negative,
     * 1/2 Pi for the positive imaginary axis and -1/2 Pi for the negative. */
    public final static double arg(final Field.Complex u) {
	return arg(u.getRe(), u.getIm());
    }

    /** Checks whether some other Field.Complex is "equal to" this one.*/
    public boolean equals( Field.Complex z ) {
    	return equals( getRe(), getIm(), z.getRe(), z.getIm() );
    }

    /** Checks whether some other object is "equal to" this one.*/
    public final boolean equals( final Object o )
    {
	try
	{
          if( o==this)
            return true;

          return equals((Field.Complex) o);
	}
	catch(ClassCastException ex)
	{
	    return false;
	}
    }

    /**Indicates whether x1 + iy1 is "equal to" x2 + iy2.*/
    public static final boolean equals( final double x1, final double y1,
                                        final double x2, final double y2, final double eps )
    {
        return (Math.abs(x1-x2) < EPS) && (Math.abs(y1-y2) < eps );
    }

    /**Indicates whether x1 + iy1 is "equal to" x2 + iy2.*/
    public static final boolean equals(final double x1, final double y1,
                                       final double x2, final double y2) {
	return (Math.abs(x1 - x2) < EPS) && (Math.abs(y1 - y2) < EPS);
    }

    /**Indicates whether <code>c1</code> equal to <code>c2</code>*/
    public static final boolean arraysCoinside(final Field.Complex[] c1,
                                               final Field.Complex[] c2,
                                               final double eps) {
	if (c1 == null && c2 == null)
	    return true;
	if ( (c1 == null && c2 != null) || (c2 == null && c1 != null) ||
	     (c2.length != c1.length))
	    return false;
	final int l = c1.length;
	for (int i = 0; i < l; i++) {
	    if (!equals(c1[i].getRe(), c1[i].getIm(), c2[i].getRe(), c2[i].getIm(),
			eps))
		return false;
	}
	return true;
    }


    /**Indicates whether <code>c1</code> equal to <code>c2</code>*/
    public static final boolean arraysCoincide(final Field.Complex[] c1,
                                               final Field.Complex[] c2) {
	return arraysCoinside(c1, c2, EPS);
    }


    /**Indicates whether <code>c1</code> equal to <code>c2</code> as sets.*/
    public static final boolean setsCoincide( final Field.Complex[] c1, final Field.Complex[] c2,
					      final double eps ){
	if( c1==null && c2==null ) return true;
	if(( c1== null && c2!=null )|| ( c2== null && c1!=null )||( c2.length!=c1.length))
	    return false;
	final int l = c1.length;
	LinkedList liste = new LinkedList();
	for( int i = 0; i< l; i++)
	    liste.add( c2[i] );
	ListIterator it;
	for( int i=0;i<l;i++){
	    it = liste.listIterator( 0 );
	    while( it.hasNext()){
		Field.Complex next = (Field.Complex)it.next();
		if( equals(c1[i].getRe(), c1[i].getIm(), next.getRe(), next.getIm(),
			   eps)) {
		    it.remove();// remove aus der "vergleichliste "
		    break;
		}else if( !it.hasNext()) return false;
	    }
	}
	return liste.size()==0;
    }

    /**Indicates whether <code>c1</code> equal to <code>c2</code> as sets.*/
    public static final boolean setsCoincide( final Field.Complex[] c1, final Field.Complex[] c2 ){
	return setsCoincide( c1, c2, Complex.EPS );
    }

    /**
     * Returns the string representation of the specified Field.Complex object.
     */
    static public String toString( Field.Complex complex, boolean withBrackets )
    {
	StringBuffer sb=new StringBuffer(20);

	if( withBrackets )
	    sb.append( '(' );

	sb.append(complex.getRe() );
	if(complex.getIm()>=0.0) sb.append("+");
	sb.append(complex.getIm()).append('i');

	if( withBrackets )
	    sb.append( ')' );

	return sb.toString();
    }

    /** Return <code>this</code> as string */
    public final String toString() {
	return toString( this, true );
    }

    /**
     * Returns a new Field.Complex object initialized to the value of the specified
     * String. Throws an IllegalArgumentException if the String cannot be
     * interpreted to a Field.Complex cause of a wrong syntax. The right Syntax
     * of the specified String is the following:<br>
     * <br>
     * <tt>[+|-] number [(+|- number i)|i]</tt><br>
     * <br>
     * @throws IllegalArgumentException If the Syntax of the entered Field.Complex-
     * String does not correspond to a Field.Complex-Value.
     */
    public final static Complex parseComplex(String s)
    {
    try
    {
      StreamTokenizer st=new StreamTokenizer(new StringReader(s));
      st.resetSyntax();
      st.wordChars('0', '9');
      st.wordChars('.', '.');
      st.whitespaceChars('\u0000', '\u0020');
      double cRe = 0;
      double cIm = 0;

      int t=st.nextToken();
      if(t=='i')
      {
	t=st.nextToken();
        if(t==StreamTokenizer.TT_EOF)
	{
          cIm=1.;
	  return new Complex( cRe, cIm );
	}
	else
	  throw new IllegalArgumentException(
                      "Syntax: [+|-] number [(+|- number i)|i]");
      }
      double num=numerical(t, st);
      t=st.ttype;
      if(t==StreamTokenizer.TT_EOF)
      {
        cRe=num;
        return new Complex( cRe, cIm );
      }
      if(t=='i')
      {
	t=st.nextToken();
        if(t==StreamTokenizer.TT_EOF)
	{
          cIm=num;
	  return new Complex( cRe, cIm );
	}
	else
	  throw new IllegalArgumentException(
                      "Syntax: [+|-] number [(+|- number i)|i]");
      }
      cRe=num;
      num=numerical(t, st);
      t=st.ttype;
      if(t=='i')
      {
	t=st.nextToken();
        if(t==StreamTokenizer.TT_EOF)
	{
          cIm=num;
	  return new Complex( cRe, cIm );
	}
	else
	  throw new IllegalArgumentException(
                      "Syntax: [+|-] number [(+|- number i)|i]");
      }
      else
        throw new IllegalArgumentException("missing i part");
    }
    catch(java.io.IOException ex){ throw new Error(); }
  }
  /**
   * @throws NumberFormatException If one or more tokens of the specified
   * StreamTokenizer can't be parsed to double values.<br>
   * (e.g.: 12.34.56 - it's one word (token) parsed by the StreamTokenizer
   * but it's no regular double value)
   */
  static private double numerical(int t, StreamTokenizer st)
    throws java.io.IOException
  {
    boolean minus;
    double num, exp;
    if(t=='+' || t=='-')
    {
      minus=(t=='-');
      t=st.nextToken();
      if(t=='i') // e.g.: +i, -i, 1.0-i
      {
        num=minus?-1.0:1.0;
        return num;
      }
    }
    else
      minus=false;
    if(t==StreamTokenizer.TT_WORD)
    {
      num=Double.parseDouble(st.sval);
      if(minus)
        num=-num;
    }
    else
      throw new IllegalArgumentException(
                  "Syntax: [+|-] number [(+|- number i)|i]");

    t=st.nextToken();
    if(t=='E' || t=='e')
    {
      t=st.nextToken();
      if(t=='+' || t=='-')
      {
        minus=(t=='-');
        t=st.nextToken();
      }
      else
        minus=false;
      if(t==StreamTokenizer.TT_WORD)
      {
        exp=Double.parseDouble(st.sval);
        if(minus)
          exp=-exp;
	num*=Math.pow(10, exp);
        t=st.nextToken();
      }
      else
        throw new IllegalArgumentException(
                    "Syntax: [+|-] number [(+|- number i)|i]");
    }
    return num;
  }

}
