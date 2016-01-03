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

/**
 *    <P>
 *    A program for numerical solution of a system of first order ordinary differential equations
 *    y' = f( x, y).<br>
 *    It uses an <b> Extrapolation-Algorithm</b> (GBS), based on the explicit midpoint rule 
 *    (with stepsize control, order selection).<br>
 *    <br> 
 *    This method is described in Section II.9 of the book:<br>
 *    E. Hairer, S.P. Norsett and G. Wanner<br> 
 *    Solving ordinary differential eqiations I. Nonstiff problems.<br> 
 *    2nd edition,  Springer series in computational mathematics,<br>
 *    Springer-Verlag (1993)<br>
 *    <br>
 *    This program is a translation of the original FORTRAN code to JAVA.<br>
 *    The original FORTRAN code was written by  <b>E. Hairer</b> and <b>G. Wanner</b>
 *    Universite de Geneve, Dept. de Mathematiques, CH-1211 Geneve 24, Switzerland<br> 
 *    <i>e-mail</i>:  Ernst.Hairer@math.unige.ch,  Gerhard.Wanner@math.unige.ch<br>
 *    It is avaliable from the prof. Hairer  homepage: 
 *    <b> http://www.unige.ch/math/folks/hairer/software.html </b><br>
 *    <br>
 *    The dence output written by <b>E. Hairer</b> and <b>A. Ostermann</b>
 *    is not implemented yet. May be I will do it later.<br>
 *    </P>
 *    <HR>
 *    <P>
 *    This program has rather many tuning parameters. During instantiation the default values of the 
 *    tuning parameters are set. They are good for most situations. If necessary, they can be changed using 
 *    the methods <i><A HREF="#setIntParameter">setIntParameter</A></i> and 
 *    <i><A HREF="#setDoubleParameter">setDoubleParameter</A></i>.<br> 
 *    <br>
 *    <blockquote>
 *    The constructor has 2 forms:<br> 
 *    <i><STRONG>Extrap</STRONG>( int numberOfEquations )</i> -- recommended <br>
 *    <i><STRONG>Extrap</STRONG>( int numberOfEquations, int maximalNumberOfColumnsInInterpolationTable)</i><br>
 *    </blockquote>
 *    The variable <i>numberOfEquations</i> denotes the number of dependend variables in our system
 *    (the number of Y components). The variable <i>maximalNumberOfColumnsInInterpolationTable</i>
 *    sets the maximal possible number of extrapolation points. By default  
 *    <i>maximalNumberOfColumnsInInterpolationTable</i> = 9.<br>
 *    <br>
 *    <blockquote>
 *    The class has 4 methods:<br>
 *    <br>
 *    <i>void <A HREF="#odex">odex</A> ( DoubleArrayValued F , double[] Y, double XEND, double[] H,
 *    double[] RTOL, double[]  ATOL, int ITOL, DoubleArrayParametrized SOLOUT )</i><br>
 *    <i>void <A HREF="#printStatistics"> printStatistics</A>() </i><br>
 *    <i>void <A HREF="#setIntParameter"> setIntParameter</A> ( int Number , int    Parameter )</i><br>
 *    <i>void <A HREF="#setDoubleParameter"> setDoubleParameter</A>( int Number , double Parameter )</i><br>
 *    </blockquote>
 *    </P>
 *    <HR>
 *    
 *    The method <i><A NAME="odex"> odex</A> ( DoubleArrayValued <A HREF="#f">f</A> , double[] <A HREF="#Y">Y</A>, 
 *    double <A HREF="#XEND">XEND</A>, double[] <A HREF="#H">H</A>, double[] <A HREF="#RTOL">RTOL</A>, double[]  
 *    <A HREF="#ATOL">ATOL</A>, int <A HREF="#ITOL">ITOL</A>, IntegerValued <A HREF="#SOLOUT">SOLOUT</A>, 
 *    int <A HREF="#IOUT">IOUT</A>)</i> calls the integrator. 
 *    It has the following parameters:<br>
 *    <blockquote>
 *    <i>DoubleArrayValued <A HREF="#f">f</A></i> -- an instance of user-defined class for calculating the 
 *    right-hand side of the equation f(x,y).<br>
 *    <i>double[] <A HREF="#Y">Y</A></i> -- an array containing the value of the independent variable <i>x</i> 
 *    and the values of the dependent variables <i>y</i>.<br>
 *    <i> double <A HREF="#XEND">XEND</A></i> -- the end point of the integration interval.<br>
 *    <i>double[] <A HREF="#H">H</A></i> -- the recommended step of integration. It will be corrected authomatiaclly during 
 *    the calculation, if necessary.<br>
 *    <i>double[] <A HREF="#RTOL">RTOL</A></i> -- the relative error tolerance.<br>
 *    <i>double[] <A HREF="#ATOL">ATOL</A></i> -- the absolute error tolerance.<br>
 *    <i> int <A HREF="#ITOL">ITOL</A></i> -- this variable allows to chose, if the tolerances are the same for all components
 *    of the vector <i>y</i>, or each component has his own tolerances.<br>
 *    <i>DoubleArrayParametrized <A HREF="#SOLOUT">SOLOUT</A></i> -- an instance of user-defined class for storing 
 *    or printing the calculated points.<br>
 *    </blockquote>
 *    <br>
 *  

 *    <P>
 *    <i> <A NAME="SOLOUT"><STRONG>SOLOUT</STRONG> </A></i> is a method 
 *    </P>
 *    
 *    <br>
 *    <HR>
 *    The method <i><A NAME="printStatistics">printStatistics</A>()</i> prints the following infomation: 
 *    how many times the right-hand side
 *    of the equation was calculated, how many steps were done, 
 *    how many of them were accepeted, how many of them were rejected.
 *    <HR>
 *    The method <i><A NAME="setIntParameter"> setIntParameter</A>( int Number , int Parameter )</i> assignes 
 *    the value <i>Parameter</i> to the array element <i>IWORK[ Number ]</i>.
 *    <HR>
 *    The method <i><A NAME="setDoubleParameter"> setDoubleParameter</A>( int Number , double Parameter )</i> assignes 
 *    the value <i>Parameter</i> to the array element <i>WORK[ Number ]</i>.<br>
 *    <br>
 *    <HR>
 * 
 * 
 *    @author P.G.Grinevich
*/

public final class Extrap implements OdeSolver, Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private int KM;
	private int numOfEquations;

	private double absTol = 1e-7;
	private double relTol = 1e-7;

	private double[] WORK;
	private int[] IWORK;

	private double[] DY;
	private double[] YH1;
	private double[] YH2;
	private double[] DZ;
	private double[] SCAL;
	private double[] HH;
	private double[] W;
	private double[] A;
	private double[] ERRFAC;

	private double[][] T;

	private int[] NJ;
	private int[] IPOINT;

	private double SAFE1;
	private double SAFE2;
	private double SAFE3;
	private double FAC1;
	private double FAC2;
	private double FAC3;
	private double FAC4;
	private double UROUND;
	private double HMAX;
	private double ERR;
	private double FAC;
	private double ERROLD;

	private int NFCN;
	private int NSTEP;
	private int NACCPT;
	private int NREJCT;
	private int NMAX;
	private int MUDIF;
	private int NSEQU;
	private int MSTAB;
	private int JSTAB;
	private int IDERR;

	private boolean ATOV;
	private boolean REJECT;

	public Extrap(int numOfEquations, int maxTableSize) {

		WORK = new double[21];
		IWORK = new int[22];

		setNumOfEquations(numOfEquations);
		setMaxTableSize(maxTableSize);
	}

	public Extrap(int numOfEquations) {
		this(numOfEquations, 9);
	}

	public Extrap() {
		this(1, 9);
	}

	public int getNumOfEquations() {
		return numOfEquations;
	}

	public void setNumOfEquations(int numOfEquations) {

		if (this.numOfEquations == numOfEquations)
			return;

		this.numOfEquations = numOfEquations;

		DY = new double[numOfEquations];
		YH1 = new double[numOfEquations];
		YH2 = new double[numOfEquations];
		DZ = new double[numOfEquations];
		SCAL = new double[numOfEquations];

		T = new double[KM][numOfEquations];

	}

	/** returns maximal number of columns in interpolation table. */
	public int getMaxTableSize() {
		return KM;
	}

	/** sets the maximal number of columns in interpolation table. 
	@param KM must be bigger then 2 */
	public void setMaxTableSize(int KM) {

		if (this.KM == KM)
			return;

		if (KM < 3)
			throw new IllegalArgumentException("KM must be bigger then 2");

		this.KM = KM;

		HH = new double[KM + 1];
		W = new double[KM + 1];
		A = new double[KM + 1];
		ERRFAC = new double[2 * KM + 1];
		T = new double[KM][numOfEquations + 1];

		NJ = new int[KM + 1];
		IPOINT = new int[KM + 2];

	}

	public double getAbsTol() {
		return absTol;
	}

	public void setAbsTol(double absTol) {
		if (this.absTol == absTol)
			return;

		this.absTol = absTol;

	}

	public double getRelTol() {
		return relTol;
	}

	public void setRelTol(double relTol) {
		if (this.relTol == relTol)
			return;

		this.relTol = relTol;

	}

	public void printStatistics() {
		System.out.println(
			" fcn= "
				+ NFCN
				+ " step= "
				+ NSTEP
				+ " accpt= "
				+ NACCPT
				+ " rejct= "
				+ NREJCT);
	}

	public void setIntParameter(int index, int parameter) {
		IWORK[index] = parameter;
	}

	public void setDoubleParameter(int index, double parameter) {
		WORK[index] = parameter;
	}

	private double[] H = new double[] { 0.1 };

	public double getCurrentStepSize() {
		return H[0];
	}

	public void setCurrentStepSize(double currentStepSize) {
		H[0] = currentStepSize;
	}

	public void odex(ODE f, double[] Y, double xStart, double xEnd) {
			odex(f, Y, xStart, xEnd, H, relTol, absTol, null);
		}
		
	public void odex(ODE f, double[] Y, double tol, double xStart, double xEnd) {
			odex(f, Y, xStart, xEnd, H, tol, tol, null);
		}
		
	public void odex(ODE f, double[] Y, double xStart, double xEnd, ODEIntermediateResultListener solout) {
			odex(f, Y, xStart, xEnd, H, relTol, absTol, solout);
		}
		
	public void odex(ODE f, double[] Y, double xStart, double xEnd, double tol, ODEIntermediateResultListener solout) {
			odex(f, Y, xStart, xEnd, H, tol, tol, solout);
		}
//	
//		public static void solve( ODE f, double [] x, int offsetX, double t0, double t1, double tol ) {	
//			solve(f, x, offsetX, t0, t1, tol, null);
//		}
//	
//
//	public static void solve( ODE f, double [] x, double t0, double t1, double tol ) {	
//		solve(f, x, 0, t0, t1, tol, null);
//	}
//	
	public static void solve( ODE f, double[] x, double t0, double t1, double tol ) {
		int n = f.getNumberOfEquations();
		new Extrap(n).odex(f, x, t0, t1, tol, null);
							}

	public static void solve( ODE f, double[] x, double t0, double t1, double tol, 
			ODEIntermediateResultListener intermediate) {
		int n = f.getNumberOfEquations();
		new Extrap(n).odex(f, x, t0, t1, tol, intermediate );
	}
	public void odex( ODE f, double[] Y, double xEnd ) {
		odex( f, Y, xEnd, new double [] {0.1}, rTol[0], aTol[0], null );
	}
	
	public void odex( ODE f, double[] Y, double xEnd, double[] H,
			double rtol,
			double atol,
			ODEIntermediateResultListener solout ) {
		int n = f.getNumberOfEquations();
			double [] y = new double[n];
			System.arraycopy(Y,1,y,0,n);		
			new Extrap(n).odex(f, y, Y[0], xEnd, H, rtol, atol, solout );
			System.arraycopy(y,0,Y,1,n);
	}

	public void odex(
		ODE f,
		double[] Y,
		double xStart,
		double xEnd,
		double[] H,
		double rtol,
		double atol) {
		odex(f, Y, xStart, xEnd, H, rtol, atol, null);
	}

	private final double[] rTol = new double[1];
	private final double[] aTol = new double[1];

	public void odex(
		ODE f,
		double[] Y,
		double xStart,
		double xEnd,
		double[] H,
		double rtol,
		double atol,
		ODEIntermediateResultListener solout) {

		rTol[0] = rtol;
		aTol[0] = atol;

		odex(f, Y, xStart, xEnd, H, rTol, aTol, 0, solout);
	}

	public void odex(
		ODE f,
		double[] Y,
		double xStart,
		double xEnd,
		double[] H,
		double[] RTOL,
		double[] ATOL,
		int ITOL,
		ODEIntermediateResultListener solout) {

		NFCN = 0;
		NSTEP = 0;
		NACCPT = 0;
		NREJCT = 0;
		if (IWORK[1] == 0) {
			NMAX = 10000;
		} else {
			NMAX = IWORK[1];
			if (NMAX < 0)
				throw new IllegalArgumentException(
					" WRONG INPUT IWORK[ 1 ]= " + IWORK[1]);
		}
		NSEQU = IWORK[3];
		if (NSEQU == 0)
			NSEQU = 1;
		if (NSEQU < 0 || NSEQU >= 6)
			throw new IllegalArgumentException(
				" CURIOUS INPUT IWORK[ 3 ]= " + IWORK[3]);

		if (IWORK[4] == 0)
			MSTAB = 1;
		else
			MSTAB = IWORK[4];
		if (IWORK[5] == 0)
			JSTAB = 2;
		else
			JSTAB = IWORK[5];
		if (IWORK[7] == 0)
			MUDIF = 4;
		else {
			MUDIF = IWORK[7];
			if (MUDIF <= 0 || MUDIF >= 7)
				throw new IllegalArgumentException(
					" WRONG INPUT IWORK[ 7 ]  " + IWORK[7]);
		}

		// -------- UROUND   SMALLEST NUMBER SATISFYING 1.0 + UROUND > 1.0 
		if (WORK[1] == 0.0)
			UROUND = 2.3e-16;
		else {
			UROUND = WORK[1];
			if (UROUND <= 1.e-35 || UROUND >= 1.e0)
				throw new IllegalArgumentException(
					" WHICH MACHINE DO YOU HAVE? YOUR UROUND WAS:  " + WORK[1]);
		}

		if (WORK[2] == 0.0)
			HMAX = xEnd - xStart;
		else
			HMAX = Math.abs(WORK[2]);
		if (WORK[3] == 0.0)
			SAFE3 = 0.5;
		else {
			SAFE3 = WORK[3];
			if (SAFE3 <= UROUND || SAFE3 >= 1.e0)
				throw new IllegalArgumentException(
					" CURIOUS INPUT WORK[ 3 ]= " + WORK[3]);
		}

		if (WORK[4] == 0.e0)
			FAC1 = 0.02;
		else
			FAC1 = WORK[4];
		if (WORK[5] == 0.)
			FAC2 = 4.0;
		else
			FAC2 = WORK[5];
		if (WORK[6] == 0.0)
			FAC3 = 0.8;
		else
			FAC3 = WORK[6];
		if (WORK[7] == 0.e0)
			FAC4 = 0.9;
		else
			FAC4 = WORK[7];
		if (WORK[8] == 0.e0)
			SAFE1 = 0.65;
		else
			SAFE1 = WORK[8];
		if (WORK[9] == 0.e0)
			SAFE2 = 0.94;
		else
			SAFE2 = WORK[9];

		odxcore(f, Y, xStart, xEnd, H, RTOL, ATOL, ITOL, solout);

		IWORK[17] = NFCN;
		IWORK[18] = NSTEP;
		IWORK[19] = NACCPT;
		IWORK[20] = NREJCT;
		//	System.out.println(" fcn= " + NFCN + " step= " + NSTEP + " accpt= " + NACCPT + " rejct= " +     NREJCT );
	}

	//   ----- ... AND HERE IS THE CORE INTEGRATOR  ----------

	private void odxcore(
		ODE f,
		double[] Y,
		double xStart,
		double xEnd,
		double[] H,
		double[] RTOL,
		double[] ATOL,
		int ITOL,
		ODEIntermediateResultListener solout) {

		switch (NSEQU) {
			case 1 :
				for (int i = 1; i <= KM; i++)
					NJ[i] = 2 * i;
				break;

			case 2 :
				NJ[1] = 2;
				for (int i = 2; i <= KM; i++)
					NJ[i] = 4 * i - 4;
				break;

			case 3 :
				NJ[1] = 2;
				NJ[2] = 4;
				NJ[3] = 6;
				for (int i = 4; i <= KM; i++)
					NJ[i] = 2 * NJ[i - 2];
				break;

			case 4 :
				for (int i = 1; i <= KM; i++)
					NJ[i] = 4 * i - 2;
				break;

			case 5 :
				for (int i = 1; i <= KM; i++)
					NJ[i] = 4 * i;
				break;
		}
		double X0 = xStart;
		A[1] = 1.0 + NJ[1];
		for (int i = 2; i <= KM; i++)
			A[i] = A[i - 1] + NJ[i];
		for (int i = 0; i < numOfEquations; i++) {
			if (ITOL == 0)
				SCAL[i] = ATOL[0] + RTOL[0] * Math.abs(Y[i]);
			else
				SCAL[i] = ATOL[i] + RTOL[i] * Math.abs(Y[i]);
		}

		double POSNEG = (xEnd - xStart >= 0.0) ? 1.0 : -1.0;
		int K =
			Math.max(
				2,
				Math.min(
					KM - 1,
					(int) ((-Math.log(RTOL[0]) / Math.log(10.0)) * 0.6 + 1.5)));
		HMAX = Math.abs(HMAX);
		H[0] = Math.max(Math.abs(H[0]), 1.e-4);
		H[0] =
			POSNEG
				* Math.min(H[0], Math.min(HMAX, Math.abs(xEnd - xStart) / 2.0));
		if (solout != null) {
			solout.intermediateResult(xStart, Y, 0);
		}

		ERR = 0.0;
		ERROLD = 1.e10;
		double HOPTDE = POSNEG * HMAX;
		W[1] = 0.0;
		REJECT = false;
		boolean LAST = false;
		int KC = 0;
		loop_10 : for (;;) {
			boolean goto55 = false;
			boolean goto60 = false;
			boolean goto100 = false;
			ATOV = false;
			//  --- IS xEnd REACHED IN THE NEXT STEP?
			if (0.1 * Math.abs(xEnd - xStart) <= (Math.abs(xStart)) * UROUND)
				return;
			H[0] =
				POSNEG
					* Math.min(
						Math.min(Math.abs(H[0]), Math.abs(xEnd - xStart)),
						Math.min(HMAX, Math.abs(HOPTDE)));
			if ((xStart + 1.01 * H[0] - xEnd) * POSNEG > 0.0) {
				H[0] = xEnd - xStart;
				LAST = true;
			}
			f.eval(xStart, Y, DZ);
			NFCN++;
			//C --- THE FIRST AND LAST STEP 
			if ((NSTEP == 0) || LAST) {
				NSTEP++;
				//System.out.println(" First step , K = " + K);
				for (int J = 1; J <= K; J++) {
					KC = J;
					//System.out.println(" midex -call 1 ");
					midex(f, J, xStart, Y, H, RTOL, ATOL, ITOL);
					if (ATOV)
						continue loop_10;
					if (J > 1 && ERR <= 1.0) {
						goto60 = true;
						break;
					}
				}
				goto55 = true;
			}

			//C --- BASIC INTEGRATION STEP  
			loop_30 : for (;;) {
				//  30   CONTINUE
				if (!goto55 && !goto60 && !goto100) {
					goto55 = false;
					NSTEP++;
					if (NSTEP >= NMAX)
						throw new IllegalArgumentException(
							" EXIT OF ODEX AT X= "
								+ xStart
								+ " H = "
								+ H[0]
								+ " NUMBER OF STEPS > "
								+ NSTEP);
					KC = K - 1;
					// System.out.println(" K = " + K + " KC =" + KC);
					for (int J = 1; J <= KC; J++) {
						//System.out.println(" midex -call 2 " + " H =" + H[ 0 ]);
						midex(f, J, xStart, Y, H, RTOL, ATOL, ITOL);
						if (ATOV)
							continue loop_10;
					}
					//40   CONTINUE
					// --- CONVERGENCE MONITOR

					if (K == 2 || REJECT) {
						goto60 = false;
						goto100 = false;
					} else {
						if (ERR <= 1.e0) {
							goto60 = true;
							goto100 = false;
						} else if (
							ERR
								> ((NJ[K + 1] * NJ[K]) / 4.0)
									* ((NJ[K + 1] * NJ[K]) / 4.0)) {
							goto60 = false;
							goto100 = true;
						} else {
							goto60 = false;
							goto100 = false;
						}
					}

					// 50   CONTINUE
					//System.out.println(" goto60= " + goto60 + " goto100 = " + goto100 );
					if (!goto60 && !goto100) {
						//System.out.println(" midex -call 3 ");
						midex(f, K,xStart, Y, H, RTOL, ATOL, ITOL);
						if (ATOV)
							continue loop_10;
						KC = K;
						if (ERR <= 1.0) {
							goto60 = true;
							goto100 = false;
						}
					}
				} else
					goto55 = false;

				// --- HOPE FOR CONVERGENCE IN LINE K+1
				//  55   CONTINUE
				if (!goto60 && !goto100) {
					goto60 = false;
					if (ERR > (NJ[K + 1] / 2.0) * (NJ[K + 1] / 2.0)) {
						goto100 = true;
					} else {
						KC = K + 1;
						//System.out.println(" midex -call 4 ");
						midex(f, KC, xStart, Y, H, RTOL, ATOL, ITOL);
						if (ATOV)
							continue loop_10;
						if (ERR > 1.0) {
							goto100 = true;
						}
					}
				} else
					goto60 = false;

				//C --- STEP IS ACCEPTED 
				// 60
				//System.out.println(" goto60= " + goto60 + " goto100 = " + goto100 );
				if (!goto100) {
					int KOPT;
					xStart += H[0];
					for (int I = 0; I < numOfEquations; I++)
						Y[I] = T[0][I];
					NACCPT++;
					if (solout != null) {
						solout.intermediateResult(xStart, Y, 0);
					}
					//C --- COMPUTE OPTIMAL ORDER
					if (KC == 2) {
						KOPT = Math.min(3, KM - 1);
						if (REJECT)
							KOPT = 2;
					} else {
						if (KC <= K) {
							KOPT = KC;
							if (W[KC - 1] < W[KC] * FAC3)
								KOPT = KC - 1;
							if (W[KC] < W[KC - 1] * FAC4)
								KOPT = Math.min(KC + 1, KM - 1);
						} else {
							KOPT = KC - 1;
							if (KC > 3 && W[KC - 2] < W[KC - 1] * FAC3)
								KOPT = KC - 2;
							if (W[KC] < W[KOPT] * FAC4)
								KOPT = Math.min(KC, KM - 1);
						}
					}

					//C --- AFTER A REJECTED STEP
					//  80   
					if (REJECT) {
						K = Math.min(KOPT, KC);
						H[0] =
							POSNEG * Math.min(Math.abs(H[0]), Math.abs(HH[K]));
						REJECT = false;
					} else {
						//C --- COMPUTE STEPSIZE FOR NEXT STEP
						if (KOPT <= KC)
							H[0] = HH[KOPT];
						else {
							if ((KC < K) && (W[KC] < W[KC - 1] * FAC4))
								H[0] = HH[KC] * A[KOPT + 1] / A[KC];
							else
								H[0] = HH[KC] * A[KOPT] / A[KC];
						}
						K = KOPT;
						H[0] = POSNEG * Math.abs(H[0]);
						//System.out.println( " K= " + K );
					}
					continue loop_10;
				} else {

					// --- STEP IS REJECTED  
					// There was label 100 earlier
					goto100 = false;
					K = Math.min(K, Math.min(KC, KM - 1));
					if ((K > 2) && (W[K - 1] < W[K] * FAC3))
						K = K - 1;
					//System.out.println(" K = " + K + " KC " + KC + " KM " + KM );
					NREJCT++;
					;
					H[0] = POSNEG * HH[K];
					REJECT = true;
					continue loop_30;
				}
			}
		}
	}

	private void midex(
		ODE f,
		int J,
		double xStart, 
		double[] Y,
		double[] H,
		double[] RTOL,
		double[] ATOL,
		int ITOL) {

		//System.out.println("  midex " + H[ 0 ] + " " + HMAX );
		//System.out.println( SAFE1 + " " + SAFE2 + " " + SAFE3 + " " + FAC1 + " " + FAC2 + " " + FAC3 );
		//System.out.println("  midex J = " + J );
		double HJ = H[0] / NJ[J];
		//C --- EULER STARTING STEP
		for (int I = 0; I < numOfEquations; I++) {
			YH1[I] = Y[I];
			YH2[I] = Y[I] + HJ * DZ[I];
		}
		//C --- EXPLICIT MIDPOINT RULE  
		int M = NJ[J] - 1;

		for (int MM = 1; MM <= M; MM++) {
	
			f.eval(xStart + HJ * MM, YH2, DY);
			for (int I = 0; I < numOfEquations; I++) {
				double YS = YH1[I];
				YH1[I] = YH2[I];
				YH2[I] = YS + 2.0 * HJ * DY[I];
			}
			if (MM <= MSTAB && J <= JSTAB)
				// --- STABILITY CHECK
				{
				double DEL1 = 0.0;
				for (int I = 0; I < numOfEquations; I++)
					DEL1 = DEL1 + (DZ[I] / SCAL[I]) * (DZ[I] / SCAL[I]);
				double DEL2 = 0.0;
				for (int I = 0; I < numOfEquations; I++)
					DEL2 =
						DEL2
							+ ((DY[I] - DZ[I]) / SCAL[I])
								* ((DY[I] - DZ[I]) / SCAL[I]);
				double QUOT = DEL2 / Math.max(UROUND, DEL1);
				if (QUOT > 4.0) {
					NFCN++;
					ATOV = true;
					H[0] = H[0] * SAFE3;
					REJECT = true;
					// System.out.println(" return 1");
					return;
				}
			}
		}
		//  35   CONTINUE

		//C --- FINAL SMOOTHING STEP

		f.eval(xStart + H[0], YH2, DY);
		// CALL FCN(N,X+H,YH2,DY,IPAR) 

		for (int I = 0; I < numOfEquations; I++)
			T[J - 1][I] = (YH1[I] + YH2[I] + HJ * DY[I]) / 2.0;
		NFCN = NFCN + NJ[J];
		//C --- POLYNOMIAL EXTRAPOLATION
		if (J == 1) {
			return;
		}
		double DBLENJ = NJ[J];
		for (int L = J; L >= 2; L--) {
			FAC = (DBLENJ / NJ[L - 1]) * (DBLENJ / NJ[L - 1]) - 1.0;
			for (int I = 0; I < numOfEquations; I++)
				T[L - 2][I] = T[L - 1][I] + (T[L - 1][I] - T[L - 2][I]) / FAC;
		}
		ERR = 0.0;
		//C --- SCALING
		for (int I = 0; I < numOfEquations; I++) {
			double T1I = Math.max(Math.abs(Y[I]), Math.abs(T[0][I]));
			if (ITOL == 0)
				SCAL[I] = ATOL[0] + RTOL[0] * T1I;
			else
				SCAL[I] = ATOL[I] + RTOL[I] * T1I;
			ERR =
				ERR
					+ ((T[0][I] - T[1][I]) / SCAL[I])
						* ((T[0][I] - T[1][I]) / SCAL[I]);
		}
		ERR = Math.sqrt(ERR / numOfEquations);
		if (ERR * UROUND >= 1.0) {
			ATOV = true;
			H[0] = H[0] * SAFE3;
			REJECT = true;
			return;
		}

		if (J > 2 && ERR >= ERROLD) {
			ATOV = true;
			H[0] = H[0] * SAFE3;
			REJECT = true;
			return;
		}
		ERROLD = Math.max(4 * ERR, 1.0);
		//C --- COMPUTE OPTIMAL STEPSIZES
		double EXPO = 1.0 / (2 * J - 1);
		double FACMIN = Math.pow(FAC1, EXPO);
		FAC =
			Math.min(
				FAC2 / FACMIN,
				Math.max(FACMIN, Math.pow(ERR / SAFE1, EXPO) / SAFE2));
		FAC = 1.0 / FAC;
		HH[J] = Math.min(Math.abs(H[0]) * FAC, HMAX);
		W[J] = A[J] / HH[J];
		//System.out.println(" return 5 "  + " J = " + J + " HH = " + HH[ J ] );
		return;
	}

	//C ----------------------------------------------------------
	//C     NUMERICAL SOLUTION OF A SYSTEM OF FIRST 0RDER
	//C     ORDINARY DIFFERENTIAL EQUATIONS  Y'=F(X,Y).
	//C     THIS IS AN EXTRAPOLATION-ALGORITHM (GBS), BASED ON THE
	//C     EXPLICIT MIDPOINT RULE (WITH STEPSIZE CONTROL,
	//C     ORDER SELECTION AND DENSE OUTPUT).
	//C     
	//C     AUTHORS: E. HAIRER AND G. WANNER
	//C              UNIVERSITE DE GENEVE, DEPT. DE MATHEMATIQUES
	//C              CH-1211 GENEVE 24, SWITZERLAND 
	//C              E-MAIL:  Ernst.Hairer@math.unige.ch
	//C                       Gerhard.Wanner@math.unige.ch
	//C              DENSE OUTPUT WRITTEN BY E. HAIRER AND A. OSTERMANN
	//C     
	//C     THIS CODE IS DESCRIBED IN SECTION II.9 OF THE BOOK:
	//C         E. HAIRER, S.P. NORSETT AND G. WANNER, SOLVING ORDINARY
	//C         DIFFERENTIAL EQUATIONS I. NONSTIFF PROBLEMS. 2ND EDITION.
	//C         SPRINGER SERIES IN COMPUTATIONAL MATHEMATICS,
	//C         SPRINGER-VERLAG (1993) 
	//C
	//C     VERSION SEPTEMBER 30, 1995
	//C         SMALL CORRECTIONS ON JUNE 11, 1999
	//C
	//C     INPUT PARAMETERS  
	//C     ----------------  
	//C     N           DIMENSION OF THE SYSTEM 
	//C
	//C     FCN         NAME (EXTERNAL) OF SUBROUTINE COMPUTING THE
	//C                 VALUE OF F(X,Y):
	//C                    SUBROUTINE FCN(N,X,Y,F,IPAR)
	//C                    DOUBLE PRECISION X,Y(N),F(N)
	//C                    F(1)=...   ETC.
	//C
	//C     X           INITIAL X-VALUE
	//C
	//C     Y(N)        INITIAL VALUES FOR Y
	//C
	//C     xEnd        FINAL X-VALUE (xEnd-X MAY BE POSITIVE OR NEGATIVE)
	//C
	//C     H           INITIAL STEP SIZE GUESS;
	//C                 H=1.e0/(NORM OF F'), USUALLY 1.e-1 OR 1.e-3, IS GOOD.
	//C                 THIS CHOICE IS NOT VERY IMPORTANT, THE CODE QUICKLY
	//C                 ADAPTS ITS STEP SIZE. WHEN YOU ARE NOT SURE, THEN
	//C                 STUDY THE CHOSEN VALUES FOR A FEW
	//C                 STEPS IN SUBROUTINE "SOLOUT".
	//C                 (IF H=0.e0, THE CODE PUTS H=1.e-4).
	//C
	//C     RTOL,ATOL   RELATIVE AND ABSOLUTE ERROR TOLERANCES. THEY
	//C                 CAN BE BOTH SCALARS OR ELSE BOTH VECTORS OF LENGTH N.
	//C
	//C     ITOL        SWITCH FOR RTOL AND ATOL:
	//C                   ITOL=0: BOTH RTOL AND ATOL ARE SCALARS.
	//C                     THE CODE KEEPS, ROUGHLY, THE LOCAL ERROR OF
	//C                     Y(I) BELOW RTOL*ABS(Y(I))+ATOL
	//C                   ITOL=1: BOTH RTOL AND ATOL ARE VECTORS.
	//C                     THE CODE KEEPS THE LOCAL ERROR OF Y(I) BELOW
	//C                     RTOL(I)*ABS(Y(I))+ATOL(I).
	//C
	//C     SOLOUT      NAME (EXTERNAL) OF SUBROUTINE PROVIDING THE
	//C                 NUMERICAL SOLUTION DURING INTEGRATION. 
	//C                 IF IOUT >= 1, IT IS CALLED AFTER EVERY SUCCESSFUL STEP.
	//C                 SUPPLY A DUMMY SUBROUTINE IF IOUT=0. 
	//C                 IT MUST HAVE THE FORM
	//C                    SUBROUTINE SOLOUT (NR,XOLD,X,Y,N,CON,NCON,ICOMP,ND,
	//C                                       IRTRN)
	//C                    DIMENSION X,Y(N),CON(NCON),ICOMP(ND)
	//C                    ....  
	//C                 SOLOUT FURNISHES THE SOLUTION "Y" AT THE NR-TH
	//C                    GRID-POINT "X" (THEREBY THE INITIAL VALUE IS
	//C                    THE FIRST GRID-POINT).
	//C                 "XOLD" IS THE PRECEEDING GRID-POINT.
	//C                 "IRTRN" SERVES TO INTERRUPT THE INTEGRATION. IF IRTRN
	//C                    IS SET <0, ODEX WILL RETURN TO THE CALLING PROGRAM.
	//C           
	//C          -----  CONTINUOUS OUTPUT (IF IOUT=2): -----
	//C                 DURING CALLS TO "SOLOUT", A CONTINUOUS SOLUTION
	//C                 FOR THE INTERVAL [XOLD,X] IS AVAILABLE THROUGH
	//C                 THE DOUBLE PRECISION FUNCTION
	//C                    >>>   CONTEX(I,S,CON,NCON,ICOMP,ND)   <<<
	//C                 WHICH PROVIDES AN APPROXIMATION TO THE I-TH
	//C                 COMPONENT OF THE SOLUTION AT THE POINT S. THE VALUE
	//C                 S SHOULD LIE IN THE INTERVAL [XOLD,X].
	//C           
	//C     IOUT        SWITCH FOR CALLING THE SUBROUTINE SOLOUT:
	//C                    IOUT=0: SUBROUTINE IS NEVER CALLED
	//C                    IOUT=1: SUBROUTINE IS USED FOR OUTPUT
	//C                    IOUT=2: DENSE OUTPUT IS PERFORMED IN SOLOUT
	//C
	//C     WORK        ARRAY OF WORKING SPACE OF LENGTH "LWORK".
	//C                 SERVES AS WORKING SPACE FOR ALL VECTORS.
	//C                 "LWORK" MUST BE AT LEAST
	//C                    N*(KM+5)+5*KM+20+(2*KM*(KM+2)+5)*NRDENS
	//C                 WHERE NRDENS=IWORK(8) (SEE BELOW) AND
	//C                        KM=9                IF IWORK(2)=0
	//C                        KM=IWORK(2)         IF IWORK(2) > 0
	//C                 WORK(1),...,WORK(20) SERVE AS PARAMETERS
	//C                 FOR THE CODE. FOR STANDARD USE, SET THESE
	//C                 PARAMETERS TO ZERO BEFORE CALLING.
	//C
	//C     LWORK       DECLARED LENGTH OF ARRAY "WORK".
	//C
	//C     IWORK       INTEGER WORKING SPACE OF LENGTH "LIWORK".
	//C                 "LIWORK" MUST BE AT LEAST
	//C                               2*KM+21+NRDENS 
	//C                 IWORK(1),...,IWORK(20) SERVE AS PARAMETERS
	//C                 FOR THE CODE. FOR STANDARD USE, SET THESE
	//C                 PARAMETERS TO ZERO BEFORE CALLING.
	//C
	//C     LIWORK      DECLARED LENGTH OF ARRAY "IWORK".
	//C
	//C     RPAR, IPAR  REAL AND INTEGER PARAMETERS (OR PARAMETER ARRAYS) WHICH  
	//C                 CAN BE USED FOR COMMUNICATION BETWEEN YOUR CALLING
	//C                 PROGRAM AND THE FCN, JAC, MAS, SOLOUT SUBROUTINES. 
	//C
	//C-----------------------------------------------------------------------
	//C 
	//C     SOPHISTICATED SETTING OF PARAMETERS
	//C     -----------------------------------
	//C              SEVERAL PARAMETERS (WORK(1),...,IWORK(1),...) ALLOW
	//C              TO ADAPT THE CODE TO THE PROBLEM AND TO THE NEEDS OF
	//C              THE USER. FOR ZERO INPUT, THE CODE CHOOSES DEFAULT VALUES.
	//C
	//C    WORK(1)   UROUND, THE ROUNDING UNIT, DEFAULT 2.3D-16.
	//C
	//C    WORK(2)   MAXIMAL STEP SIZE, DEFAULT xEnd-X.
	//C
	//C    WORK(3)   STEP SIZE IS REDUCED BY FACTOR WORK(3), IF THE
	//C              STABILITY CHECK IS NEGATIVE, DEFAULT 0.5.
	//C
	//C    WORK(4), WORK(5)   PARAMETERS FOR STEP SIZE SELECTION
	//C              THE NEW STEP SIZE FOR THE J-TH DIAGONAL ENTRY IS
	//C              CHOSEN SUBJECT TO THE RESTRICTION
	//C                 FACMIN/WORK(5) <= HNEW(J)/HOLD <= 1/FACMIN
	//C              WHERE FACMIN=WORK(4)**(1/(2*J-1)) 
	//C              DEFAULT VALUES: WORK(4)=0.02D0, WORK(5)=4.e0
	//C
	//C    WORK(6), WORK(7)   PARAMETERS FOR THE ORDER SELECTION
	//C              STEP SIZE IS DECREASED IF    W(K-1) <= W(K)*WORK(6)
	//C              STEP SIZE IS INCREASED IF    W(K) <= W(K-1)*WORK(7)
	//C              DEFAULT VALUES: WORK(6)=0.8D0, WORK(7)=0.9D0
	//C
	//C    WORK(8), WORK(9)   SAFETY FACTORS FOR STEP CONTROL ALGORITHM
	//C             HNEW=H*WORK(9)*(WORK(8)*TOL/ERR)**(1/(J-1))
	//C             DEFAULT VALUES: WORK(8)=0.65D0,
	//C                        WORK(9)=0.94D0  IF "HOPE FOR CONVERGENCE"
	//C                        WORK(9)=0.90D0  IF "NO HOPE FOR CONVERGENCE"
	//C
	//C    IWORK(1)  THIS IS THE MAXIMAL NUMBER OF ALLOWED STEPS.
	//C              THE DEFAULT VALUE (FOR IWORK(1)=0) IS 10000.
	//C
	//C    IWORK(2)  THE MAXIMUM NUMBER OF COLUMNS IN THE EXTRAPOLATION 
	//C              TABLE. THE DEFAULT VALUE (FOR IWORK(2)=0) IS 9.
	//C              IF IWORK(2).NE.0 THEN IWORK(2) SHOULD BE  >= 3.
	//C
	//C    IWORK(3)  SWITCH FOR THE STEP SIZE SEQUENCE (EVEN NUMBERS ONLY)
	//C              IF IWORK(3) == 1 THEN 2,4,6,8,10,12,14,16,...
	//C              IF IWORK(3) == 2 THEN 2,4,8,12,16,20,24,28,...
	//C              IF IWORK(3) == 3 THEN 2,4,6,8,12,16,24,32,...
	//C              IF IWORK(3) == 4 THEN 2,6,10,14,18,22,26,30,...
	//C              IF IWORK(3) == 5 THEN 4,8,12,16,20,24,28,32,...
	//C              THE DEFAULT VALUE IS IWORK(3)=1 IF IOUT <= 1;
	//C 
	//C    IWORK(4)  STABILITY CHECK IS ACTIVATED AT MOST IWORK(4) TIMES IN
	//C              ONE LINE OF THE EXTRAP. TABLE, DEFAULT IWORK(4)=1. 
	//C
	//C    IWORK(5)  STABILITY CHECK IS ACTIVATED ONLY IN THE LINES
	//C              1 TO IWORK(5) OF THE EXTRAP. TABLE, DEFAULT IWORK(5)=1. 
	//C
	//C    IWORK(6)  IF  IWORK(6)=0  ERROR ESTIMATOR IN THE DENSE
	//C              OUTPUT FORMULA IS ACTIVATED. IT CAN BE SUPPRESSED
	//C              BY PUTTING IWORK(6)=1.
	//C              DEFAULT IWORK(6)=0  (IF IOUT >= 2).
	//C
	//C    IWORK(7)  DETERMINES THE DEGREE OF INTERPOLATION FORMULA 
	//C              MU = 2 * KAPPA - IWORK(7) + 1
	//C              IWORK(7) SHOULD LIE BETWEEN 1 AND 6
	//C              DEFAULT IWORK(7)=4  (IF IWORK(7)=0).
	//C
	//C    IWORK(8)  = NRDENS = NUMBER OF COMPONENTS, FOR WHICH DENSE OUTPUT
	//C              IS REQUIRED
	//C
	//C    IWORK(21),...,IWORK(NRDENS+20) INDICATE THE COMPONENTS, FOR WHICH
	//C              DENSE OUTPUT IS REQUIRED
	//C
	//C----------------------------------------------------------------------C
	//C     OUTPUT PARAMETERS 
	//C     ----------------- 
	//C     X           X-VALUE FOR WHICH THE SOLUTION HAS BEEN COMPUTED
	//C                 (AFTER SUCCESSFUL RETURN X=xEnd).
	//C
	//C     Y(N)        NUMERICAL SOLUTION AT X
	//C 
	//C     H           PREDICTED STEP SIZE OF THE LAST ACCEPTED STEP
	//C
	//C     IDID        REPORTS ON SUCCESSFULNESS UPON RETURN:
	//C                   IDID=1  COMPUTATION SUCCESSFUL,
	//C                   IDID=-1 COMPUTATION UNSUCCESSFUL.
	//C
	//C   IWORK(17)  NFCN    NUMBER OF FUNCTION EVALUATIONS
	//C   IWORK(18)  NSTEP   NUMBER OF COMPUTED STEPS
	//C   IWORK(19)  NACCPT  NUMBER OF ACCEPTED STEPS
	//C   IWORK(20)  NREJCT  NUMBER OF REJECTED STEPS (DUE TO ERROR TEST),
	//C                      (STEP REJECTIONS IN THE FIRST STEP ARE NOT COUNTED)
	//C-----------------------------------------------------------------------

}
