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

package de.jtem.mfc.specialFunctions;

import de.jtem.mfc.field.Complex;
import de.jtem.numericalMethods.calculus.odeSolving.Extrap;
import de.jtem.numericalMethods.calculus.odeSolving.ODE;

public class HyperGeometric2F1 {

	private static final int MAX_ITER = 10000;
	private static final double EPS = 1e-14;
	
	final private Complex a = new Complex();
	final private Complex b = new Complex();
	final private Complex c = new Complex();
	
	final private Complex fac = new Complex();
	final private Complex last = new Complex();
	
	final private Complex aa = new Complex();
	final private Complex bb = new Complex();
	final private Complex cc = new Complex();

	final private Extrap integrator = new Extrap(4);
	
	final private Complex z0 = new Complex();
	final private Complex fOfZ0 = new Complex();
	final private Complex dfOfZ0 = new Complex();
	
	public HyperGeometric2F1() {	
	}
	
	public HyperGeometric2F1(Complex a, Complex b, Complex c ) {
		setABC( a, b, c );
	}
	
	static public Complex evaluateSeries( final Complex a, final Complex b, final Complex c, 
			final Complex z ) {
		Complex result = new Complex();
		new HyperGeometric2F1().evaluateSeries( a, b, c, z, result, new  Complex() );
		return result;
	}
	
	public Complex evaluateSeries( Complex z ) {
		return evaluateSeries( a, b, c, z );
	}
	
	public void evaluateSeries( final Complex a, final Complex b, final Complex c, 
			final Complex z, final Complex f, final Complex df ) {

		if( z.absSqr() >=1 )
			throw new RuntimeException( "z is not inner point of the unit disc!" );
		
		f.assign(1);
		df.assign(0);
		
		fac.assign(1);
		last.assign(0);
		aa.assign(a);
		bb.assign(b);
		cc.assign(c);
		
		for (int n=1;n<MAX_ITER; n++) {
			
			fac.assignTimes(bb);
			fac.assignDivide(cc);
			fac.assignTimes(aa);
			
			df.assignPlus(fac);
			
			fac.assignTimes(z);
			fac.assignDivide( n );
			
			f.assignPlus( fac );
			
			if( f.re == last.re && f.im == last.im ) return;
			
			last.assign(f);
			
			aa.assignPlus(1);
			bb.assignPlus(1);
			cc.assignPlus(1);
		}
		
		throw new RuntimeException( "hypergeometric series did not converge");
	}
	

	static public Complex evaluate( final Complex a, final Complex b, final Complex c, 
			final Complex z ) {
		Complex result = new Complex();
		new HyperGeometric2F1().evaluate( a, b, c, z, result, new  Complex() );
		return result;
	}
	
	public Complex evaluate( Complex z ) {
		return evaluate( a, b, c, z );
	}
	
	public void evaluate( final Complex a, final Complex b, final Complex c, 
			final Complex z, final Complex f, final Complex df ) {
		
		if (  z.absSqr()< 0.25) {
			evaluateSeries(a,b,c,z,f,df);
			return;
		}
		
		if (z.re < 0.0) 
			z0.assign(-0.5,0.0);
		else if (z.re <= 1.0) 
			z0.assign(0.5,0.0);
		else 
			z0.assign(0.0,z.im >= 0.0 ? 0.5 : -0.5);
		
		hgODE.a.assign(a);
		hgODE.b.assign(b);
		hgODE.c.assign(c);
		
		hgODE.dz.assignMinus(z,z0);
		
		evaluateSeries(a,b,c, z0, fOfZ0, dfOfZ0 );
		
		double [] x = new double[] { fOfZ0.re, fOfZ0.im, dfOfZ0.re, dfOfZ0.im };
		
		integrator.odex( hgODE, x, EPS, 0, 1 );
		
		f.assign(  x[0], x[1]);
		df.assign( x[2], x[3]);
	}
	

	HyperGeometricODE hgODE = new HyperGeometricODE();
	
	class HyperGeometricODE implements ODE {

		public int getNumberOfEquations() {
			return 4;
		}
		
		final Complex f0 = new Complex();
		final Complex f1 = new Complex();
		
		final Complex df0 = new Complex();
		final Complex df1 = new Complex();
		
		final Complex z  = new Complex();
		final Complex dz = new Complex();
		
		final Complex tmp = new Complex();
		
		final Complex a   = new Complex();
		final Complex b   = new Complex();
		final Complex c   = new Complex();
		
		public void eval(double t, double[] x, double[] y) {
	
			f0.assign(x[0],x[1]); // f
			f1.assign(x[2],x[3]); //df
			
			z.assignTimes( dz, t );
			z.assignPlus( z0 );
			
			df0.assignTimes(f1, dz);
			
			df1.assignTimes(a,b); //a b
			df1.assignTimes(f0);  //a b x1
			
			tmp.assignPlus(a,b);  //   a+b
			tmp.assignPlus(1);    //   a+b+1
			tmp.assignTimes(z);   //  (a+b+1)z
			tmp.assignMinus(c);   // ((a+b+1)z)-c
			tmp.assignTimes(f1);  //(((a+b+1)z)-c) x2
			
			df1.assignPlus(tmp);  //(a b x1) + (((a+b+1)z)-c)x2
			
			tmp.assignMinus( 1, z );
			tmp.assignTimes( z );
			
			df1.assignDivide(tmp);
			
			df1.assignTimes(dz);
			
			y[0] = df0.re;
			y[1] = df0.im;
			y[2] = df1.re;
			y[3] = df1.im;
		}
		
	}

	public Complex getA() {
		return new  Complex(a);
	}

	public void setA(Complex a) {
		this.a.assign(a);
	}

	public Complex getB() {
		return new Complex(b);
	}

	public void setB(Complex b) {
		this.b.assign(b);
	}

	public Complex getC() {
		return new Complex(c);
	}

	public void setC(Complex c) {
		this.c.assign(c);
	};
	
	public void setABC( Complex a, Complex b, Complex c ) {
		setA(a);
		setB(b);
		setC(c);
	}
}
