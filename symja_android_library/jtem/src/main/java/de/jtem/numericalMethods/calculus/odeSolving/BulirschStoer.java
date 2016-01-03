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

public class BulirschStoer implements OdeSolver, Serializable, Cloneable {
    
    private static final long serialVersionUID = 1L;
    
    int numOfEquations;

    double eps = 1e-7;

    double stepSize = 1e-1; 

    private TempDataContainer tdc = new TempDataContainer( eps );

    private int [] stepInfo = new int[2];

    private double h [] = new double[1];

    public BulirschStoer( int numOfEquations ) {
	
	setNumOfEquations( numOfEquations );
    }

    public BulirschStoer() {
	
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

	tdc = new TempDataContainer( eps );

    }

    public int getNumOfEquations(){ 
	return numOfEquations;
    }
    
    public void setNumOfEquations( int numOfEquations ) {
	
	if( this.numOfEquations == numOfEquations )
	    return;

	this.numOfEquations = numOfEquations;
    }
	
    public void odex( ODE f, double [] y, double xStart, double xEnd ) {
	h[0] = stepSize;
	odex(  f, y, xStart, xEnd, h, 0.0, stepInfo, (ODEIntermediateResultListener)null, tdc );
    }
    
	public void odex( ODE f, double [] y, double xStart, double xEnd,  ODEIntermediateResultListener intermediate ) {
	   h[0] = stepSize;
	   odex(  f, y, xStart, xEnd, h, 0.0, stepInfo, intermediate, tdc );
	   }
	   
	public void odex( ODE f, double [] y, double xStart, double xEnd,  double tol, ODEIntermediateResultListener intermediate ) {
		   h[0] = stepSize;
		   tdc.eps = tol;
		   odex(  f, y, xStart, xEnd, h, 0.0, stepInfo, intermediate, tdc );
		   }

	
	
	public static void solve( ODE f, double [] x, double t0, double t1, double tol ) {	
		solve(f, x, t0, t1, tol, null);
	}
	
	public static void solve( ODE f, double[] x, double t0, double t1, double tol, 
			ODEIntermediateResultListener intermediate) {
		solve(f, x, t0, t1, tol, intermediate );
	}
	
	final static double SAFETY =  0.9;
	final static double PGROW  = -0.2;
	final static double PSHRNK = -0.25;
	final static double ERRCON =  1.89e-4;
	
	
	final static int  KMAXX  = 8;
	final static int  IMAXX  = KMAXX+1;
	
	final static double  SAFE1  = 0.25;
	final static double  SAFE2  = 0.7;
	final static double  REDMAX = 1.0e-5;
	final static double  REDMIN = 0.7;
	final static double  TINY   = 1.0e-30;
	final static double  SCALMX = 0.1;
	
	public static class TempDataContainer implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		double eps;
		
		boolean first = true;
		
		int kmax, kopt;
		
		double []   a   = new double[ IMAXX + 1 ];
		double [][] alf = new double[ KMAXX + 1 ][ KMAXX + 1 ];
		
		double [] err   = new double[ KMAXX + 1 ];
		double [] x     = new double[ KMAXX + 1 ];
		
		double [][] d;
		
		double [] yerr;
		double [] ysav;
		double [] yseq;
		
		double [] yScale;
		double [] yPrime;
		
		double [] y_;
		double [] y__;
		
		TempDataContainer( double eps ) {
			
			this.eps = eps;
			
			final double eps1 = SAFE1*eps;
			
			a[1]=nseq[1]+1;
			
			for( int k=1; k<= KMAXX; k++) 
				a[k+1] = a[k] + nseq[k+1];
			
			for( int iq=2; iq <= KMAXX; iq++) {
				
				for( int k=1; k<iq; k++)
					alf[k][iq] = Math.pow(eps1,(a[k+1]-a[iq+1])/
							((a[iq+1]-a[1]+1.0)*(2*k+1)));
			}
			
			for( kopt=2; kopt<KMAXX; kopt++ )
				if( a[kopt+1] > a[kopt] * alf[kopt-1][kopt] ) 
					break;
			kmax=kopt;
		}
		
		void reinit( int n ) {
			first = true;
			kopt  = kmax;
			
			if( y_ == null || y_.length < n ) {
				
				d = new double[ KMAXX + 1 ][ n ];	
				
				yerr   = new double[n];
				ysav   = new double[n];
				yseq   = new double[n];
				
				yScale = new double[n];
				yPrime = new double[n];
				
				y_     = new double[n];
				y__    = new double[n];
				
			}
		}
	}
	
	static int [] nseq = new int[] {0,2,4,6,8,10,12,14,16,18};
	
	static double step( final ODE f, double X, 
			final double [] y, final double [] yPrime, final double [] h,
			final double [] yScale, final double [] performedH, 
			final TempDataContainer tdc ) {
		
		final int n = f.getNumberOfEquations();
		
		final double []   a   = tdc.a;
		final double [][] alf = tdc.alf;
		
		final double [] err   = tdc.err;
		final double [] x     = tdc.x;
		
		final double [][] d   = tdc.d;
		
		final double [] yerr  = tdc.yerr;
		final double [] ysav  = tdc.ysav;
		final double [] yseq  = tdc.yseq;
		
		final double [] y_    = tdc.y_;
		final double [] y__   = tdc.y__;
		
		final double eps      = tdc.eps;
		
		boolean first = tdc.first;
		
		int kmax = tdc.kmax;
		int kopt = tdc.kopt;
		
		double xsav = X;
		System.arraycopy( y, 0, ysav, 0, n );
		
		boolean reduct = false;
		
		int k, km = 0;
		
		while( true ) {
			
			boolean exitflag = false;
			
			double red = 42;
			
			for( k=1; k <= kmax; k++) {
				
				final double xnew = xsav + h[0];
				
				if( xnew == xsav )
					throw new RuntimeException("step size underflow");
				
				double xseq = midPointStep( f, xsav, ysav, yPrime, h[0], nseq[k], yseq, y_, y__ );
				
				double xest = h[0]/nseq[k]; xest *= xest;
				
//TODO was ist mit xseq[0]??
				polynomialExtrapolation( n, k, xest, yseq, y, yerr, y_, x, d  );
				
				X = xnew;
				
				if( k != 1 ) {
					
					double errmax = TINY;
					
					for( int i=0; i<n; i++) 
						errmax=Math.max(errmax,Math.abs(yerr[i]/yScale[i]));
					
					errmax /= eps;
					
					km = k-1;
					err[km]=Math.pow( errmax/SAFE1,1.0/(2*km+1));
					
					if( k >= kopt-1 || first ) {
						if (errmax < 1.0) {
							exitflag = true;
							break;
						}
						if (k == kmax || k == kopt+1) {
							red=SAFE2/err[km];
							break;
						}
						else if (k == kopt && alf[kopt-1][kopt] < err[km]) {
							red=1.0/err[km];
							break;
						}
						else if (kopt == kmax && alf[km][kmax-1] < err[km]) {
							red=alf[km][kmax-1]*SAFE2/err[km];
							break;
						}
						else if (alf[km][kopt] < err[km]) {
							red=alf[km][kopt-1]/err[km];
							break;
						}
					}
				}
			}
			
			if( exitflag )
				break;
			
			red=Math.min(red,REDMIN);
			red=Math.max(red,REDMAX);
			
			h[0] *= red;
			
			reduct = true;
		}
		
		performedH[0] = h[0];
		
		double wrkmin = 1.0e35;
		double scale  = -99;
		
		for( int kk=1; kk<=km; kk++) {
			
			final double fact=Math.max(err[kk],SCALMX);
			final double work=fact*a[kk+1];
			
			if (work < wrkmin) {
				scale=fact;
				wrkmin=work;
				kopt=kk+1;
			}
		}
		
		double nextH = h[0] / scale;
		
		if( kopt >= k && kopt != kmax && !reduct ) {
			
			double fact = Math.max( scale / alf[kopt-1][kopt], SCALMX );
			
			if( a[kopt+1] * fact <= wrkmin ) {
				nextH=h[0]/fact;
				kopt++;
			}
		}
		
		tdc.first = false;
		tdc.kopt  = kopt;
		
		h[0] = nextH;
		
		return X;
	}
	
	
	
	static void polynomialExtrapolation( final int n, final int iest, final double xest,
			final double [] yest, final double [] yz, final double [] dy, 
			final double [] y_, final double [] x, final double [][] d ) {
	
		x[iest]=xest;
		
		System.arraycopy( yest, 0, dy, 0, n );
		System.arraycopy( yest, 0, yz, 0, n );
		
		if (iest == 1) {
			System.arraycopy( yest, 0, d[1], 0, n );
		} else {
			
			System.arraycopy( yest, 0, y_, 0, n );
			
			for( int k=1; k<iest; k++ ) {
				final double delta = 1.0 / (x[iest-k]-xest);
				
				final double f1 = xest      * delta;
				final double f2 = x[iest-k] * delta;
				
				for( int j=0; j<n; j++ ) {
					final double q = d[k][j];
					
					d[k][j] = dy[j];
					
					final double delta_ = y_[j]-q;
					
					dy[j]  = f1 * delta_;
					y_[j]  = f2 * delta_;
					
					yz[j] += dy[j];
				}
			}
			
			System.arraycopy( dy, 0, d[iest], 0, n );
		}
	}
	
	static double midPointStep(  final ODE f, double x,
			final double [] y, final double [] yPrime, 
			final double totalH, final int nstep,
			final double [] yout, double [] ym, double [] yn ) {
		
		final double h = totalH / nstep;
		
		final int n = y.length;
		
		final double xsav = x;
		
		x += h;
		
		System.arraycopy( y, 0, ym, 0, n );
		
		for( int i=0;i < n; i++) {
			yn[i] = y[i] + h * yPrime[i];
		}
		
		f.eval( x, yn, yout );
		
		double h2 = 2.0*h;
		
		for( int k=2; k <= nstep; k++ ) {
			final double [] swap = ym;
			ym = yn;
			yn = swap;
			
			for( int i=0; i < n; i++) {
				yn[i] += h2*yout[i];
			}
			
			x += h;
			
			f.eval( x, yn, yout );
		}
		
		for( int i=0; i<n; i++ )
			yout[i]=0.5*(ym[i]+yn[i]+h*yout[i]);
		
		return  xsav + totalH;
	}
	
	
	final static int MAX_NUM_OF_STEPS = 10000;
	final static double EPS           = 1e-15;
	
	static public void odex( ODE f, 
			double [] y, double xStart, double xEnd, double eps, double [] h,
			double minH, int [] stepInfo, ODEIntermediateResultListener intermediate ) {
		odex( f, y, xStart, xEnd, h, minH, stepInfo, intermediate, new TempDataContainer( eps ) );
	}
	
	static public void odex( ODE f, 
			double [] y, double xStart, double xEnd, double [] h,
			double minH, int [] stepInfo, 
			ODEIntermediateResultListener intermediate, TempDataContainer tdc ) {
		
		final int n = f.getNumberOfEquations();
		
		tdc.reinit( n );
		
		final double [] yScale = tdc.yScale;
		final double [] yPrime = tdc.yPrime;
		
		final double [] performedH = new double[1];
		
		double x = xStart;
		
		h[0] = xStart < xEnd ? Math.abs( h[0] ) : -Math.abs( h[0] );
		
		int numOfGoodSteps = 0;
		int numOfBadSteps  = 0;
		
		for( int k=0; k < MAX_NUM_OF_STEPS; k++ ) {
			
			f.eval( x, y, yPrime );
			
			for( int i=0; i<n; i++ )
				yScale[i] = Math.abs( y[i] ) + Math.abs( yPrime[i] * h[0] ) + TINY;
			
			if( Math.abs( xEnd - x ) < Math.abs( h[0] ) * 1.2 ) 
				h[0] = xEnd - x;
			
			final double triedH = h[0];
			
			x = step( f, x, y, yPrime, h, yScale, performedH, tdc );
			
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







