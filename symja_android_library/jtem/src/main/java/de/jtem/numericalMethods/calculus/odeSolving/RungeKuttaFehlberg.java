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

package de.jtem.numericalMethods.calculus.odeSolving;

import java.io.Serializable;

public class RungeKuttaFehlberg implements OdeSolver, Serializable, Cloneable {
    
    private static final long serialVersionUID = 1L;
    
    int numOfEquations;

    double eps = 1e-7;

    double stepSize = 1e-1; 

    private double [][] temp;

    private int [] stepInfo = new int[2];

    private double h [] = new double[1];

    public RungeKuttaFehlberg( int numOfEquations ) {
	
	setNumOfEquations( numOfEquations );
    }

    public RungeKuttaFehlberg() {
	
	this( 1 );
    }

    public double getStepSize() {
	return stepSize;
    }

    public void setStepSize( double stepSize ) {

	if( this.stepSize == stepSize )
	    return;

	this.stepSize = stepSize;
    }

    public double getEps() {
	return eps;
    }

    public void setEps( double eps ) {

	if( this.eps == eps )
	    return;

	this.eps = eps;
    }

    public int getNumOfEquations(){ 
	return numOfEquations;
    }

    public void setNumOfEquations( int numOfEquations ) {
	
	if( this.numOfEquations == numOfEquations )
	    return;

	this.numOfEquations = numOfEquations;

	temp = new double [10][ numOfEquations + 1 ];
    }
	
    public void odex( ODE f, double [] y, double xStart, double xEnd ) {
	h[0] = stepSize;
	odex( f, y, xStart, xEnd, eps, h, 0, stepInfo, (ODEIntermediateResultListener)null, temp );
    }

	public void odex( ODE f, double [] y, double xStart, double xEnd,  ODEIntermediateResultListener intermediate ) {
	   h[0] = stepSize;
	   odex(  f, y, xStart, xEnd, eps, h, 0, stepInfo, intermediate, temp );
	   }
	   
	public void odex( ODE f, double [] y, double xStart, double xEnd,  double tol, ODEIntermediateResultListener intermediate ) {
		   h[0] = stepSize;
		   odex(  f, y, xStart, xEnd, tol, h, 0, stepInfo, intermediate, temp );
	}

	
	
	public static void solve( ODE f, double [] x, double t0, double t1, double tol ) {	
		solve(f, x, t0, t1, tol, null);
	}
	
	public static void solve( ODE f, double[] x, double t0, double t1, double tol, 
			ODEIntermediateResultListener intermediate) {
		int n = f.getNumberOfEquations();	
		new RungeKuttaFehlberg(n).odex(f, x, t0, t1, tol, intermediate);
	}
	

    final static double SAFETY =  0.9;
    final static double PGROW  = -0.2;
    final static double PSHRNK = -0.25;
    final static double ERRCON =  1.89e-4;
    
    static double step( ODE f, double x,
		      double [] y, double [] yPrime, double [] h, double eps,
		      double [] yScale, double [] performedH, double [][] temp ) {

	final double [] y_     = temp[6];
	final double [] yError = temp[7];

	final int n = f.getNumberOfEquations();
		      
	while( true ) {

	    cashKarpErrorExtimate( f, x, y, yPrime, h[0], y_, yError, temp );

	    double maxError = 0.0;

	    for( int i=0; i<n; i++) 
		maxError = Math.max( maxError, Math.abs( yError[i] / yScale[i]) );

	    maxError /= eps;

	    if( maxError > 1.0) {

		h[0] = SAFETY * h[0] * Math.pow( maxError, PSHRNK );

		if( h[0] < 0.1*h[0] ) h[0] *= 0.1;

		final double xnew = x+h[0];

		if( xnew ==  x) 
		    throw new IllegalArgumentException( "stepsize underflow in rkqs" );

	    } else {

		x += h[0];
		System.arraycopy( y_, 0, y, 0, n );

		performedH[0] = h[0];

		h[0] = maxError > ERRCON ? SAFETY * h[0] * Math.pow( maxError, PGROW ) : 5.0 * h[0];

		break;
	    }
	}
	return x;
    }

    final static double b21=   1./    5;
    final static double b31=   3./   40, b32=   9./ 40;
    final static double b41=   3./   10, b42=  -9./ 10, b43=   6./   5;
    final static double b51= -11./   54, b52=   5./  2, b53= -70./   27, b54=    35./    27;
    final static double b61=1631./55296, b62= 175./512, b63= 575./13824, b64= 44275./110592, b65=253./4096;

    final static double a2 =   1./    5, a3 =   3./ 10, a4 =   3./   5,  a5 =      1,        a6 =  7./   8;

    final static double c1 =  37./  378,                c3 = 250./  621, c4 =   125./   594, c6 =512./1771;

    final static double dc5=-277./14336.;
    
    final static double dc1= c1 -  2825./27648; 
    final static double dc3= c3 - 18575./48384;
    final static double dc4= c4 - 13525./55296;
    final static double dc6= c6 -     1./    4;

	 
    static void cashKarpErrorExtimate(  ODE f, double x,
					double [] y, double [] yPrime, double h, 
					double [] yout , double [] yError, double [][] temp ) {

	final double [] y_    = temp[0];
	final double [] ak2   = temp[1];
	final double [] ak3   = temp[2];
	final double [] ak4   = temp[3];
	final double [] ak5   = temp[4];
	final double [] ak6   = temp[5];
	
	final int n = f.getNumberOfEquations();
    
	double x_ = x + a2 * h;
	
	for( int i=0; i<n; i++ )
	    y_[i]=y[i]+b21*h*yPrime[i];
	    
	f.eval( x_, y_, ak2 );
	
	x_= x + a3 * h;
	for( int i=0; i<n; i++ )
	    y_[i]=y[i]+h*(b31*yPrime[i]+b32*ak2[i]);

	f.eval( x_, y_, ak3 );
	
	x_ = x + a4 * h;
	for( int i=0; i<n; i++ )
	    y_[i]=y[i]+h*(b41*yPrime[i]+b42*ak2[i]+b43*ak3[i]);
	
	f.eval( x_, y_, ak4 );
	
	x_ = x + a5 * h;
	for( int i=0; i<n; i++ )
	    y_[i]=y[i]+h*(b51*yPrime[i]+b52*ak2[i]+b53*ak3[i]+b54*ak4[i]);

	f.eval( x_, y_, ak5 );
	
	x_ = x + a6 * h;
	for( int i=0; i<n; i++ )
	    y_[i]=y[i]+h*(b61*yPrime[i]+b62*ak2[i]+b63*ak3[i]+b64*ak4[i]+b65*ak5[i]);
	
	f.eval( x_, y_, ak6 );
	
	for( int i=0; i<n; i++ ) {
	    yout[i]=y[i]+h*(c1*yPrime[i]+c3*ak3[i]+c4*ak4[i]+c6*ak6[i]);
	    yError[i]=h*(dc1*yPrime[i]+dc3*ak3[i]+dc4*ak4[i]+dc5*ak5[i]+dc6*ak6[i]);
	}
    }
    

    final static int MAX_NUM_OF_STEPS = 10000;
    final static double TINY          = 1.0e-30;
    final static double EPS           = 1e-15;

    static void odex( ODE f, 
		      double [] y, double xStart, double xEnd, double eps, double [] h,
		      double minH, int [] stepInfo, ODEIntermediateResultListener intermediate ) {
	
	final int n = f.getNumberOfEquations();
	
		odex( f, y, xStart, xEnd, eps, h, minH, stepInfo, intermediate, new double [10][n] );
    }

    static void odex( ODE f, 
		      double [] y, double xStart, double xEnd, double eps, double [] h,
		      double minH, int [] stepInfo, 
		      ODEIntermediateResultListener intermediate, double [][] temp ) {

	final int n = f.getNumberOfEquations();
	
	final double [] yScale = temp[8];
	final double [] yPrime = temp[9];

	final double [] performedH = new double[1];

	double x = xStart;

	h[0] = xStart < xEnd ? Math.abs( h[0] ) : -Math.abs( h[0] );

	int numOfGoodSteps   = 0;
	int numOfBadSteps  = 0;

	for( int k=0; k < MAX_NUM_OF_STEPS; k++ ) {

		f.eval( x, y, yPrime );
		
	    for( int i=0; i<n; i++ )
	    	yScale[i] = Math.abs( y[i] ) + Math.abs( yPrime[i] * h[0] ) + TINY;
	    
	    if( Math.abs( xEnd - x ) < Math.abs( h[0] ) * 1.2 ) 
		h[0] = xEnd - x;
	    
	    final double triedH = h[0];

	    x = step( f, x, y, yPrime, h, eps, yScale, performedH, temp );

	    if( intermediate != null ) {
			intermediate.intermediateResult( x, y, 0 );	    
	    }
	    
	    if( h[0] == triedH ) 
		numOfGoodSteps++; 
	    else 
		numOfBadSteps++;
	 
	    if( Math.abs( (x - xEnd) / xEnd ) < EPS ) {
		
		stepInfo[0] = numOfGoodSteps;
		stepInfo[1] = numOfBadSteps;

		return;
	    }
	    
	    if( Math.abs( performedH[0] ) <= minH ) 
		throw new RuntimeException( "too small step in odex" );	   
	}
	
	throw new RuntimeException( "too many steps in odex" );
    }
}    







