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

public class RungeKutta implements OdeSolver, Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	int numOfEquations;

	int numberOfSteps = 1;
	
	double [][] tempData;
	
	public RungeKutta(int numOfEquations) {

		setNumOfEquations(numOfEquations);
	}

	public RungeKutta() {

		this(1);
	}

	public int getNumberOfSteps() {
		return numberOfSteps;
	}

	public void setNumberOfSteps(int numberOfSteps) {
		if( numberOfSteps<1 )
			throw new IllegalArgumentException(" number of steps must be positive" );
		
		this.numberOfSteps = numberOfSteps;
	}

	public int getNumOfEquations() {
		return numOfEquations;
	}

	public void setNumOfEquations(int numOfEquations) {

		if (this.numOfEquations == numOfEquations)
			return;

		this.numOfEquations = numOfEquations;

		tempData = new double[5][numOfEquations];
		
	}

	public void odex(ODE ode, double[] x, double tStart, double tEnd) {
		
		if( this.numOfEquations < ode.getNumberOfEquations())
			this.setNumOfEquations( ode.getNumberOfEquations() );
		
		odex(ode, x, tStart, tEnd, numberOfSteps, tempData );
	}

	public static void step( 
			final ODE ode, 
			final double t, 
			final double [] x, 
			final double [] r, 
			final double h, double [][] temp ) {
	
		final double[] y_ = temp[0];
		final double[] k1 = temp[1];
		final double[] k2 = temp[2];
		final double[] k3 = temp[3];
		final double[] k4 = temp[4];
		
		final int n = ode.getNumberOfEquations();

		final double hOver2 = h / 2;
		final double hOver6 = h / 6;

		ode.eval(t, x, k1);

		double x_ = t + hOver2;

		for (int k = 0; k < n; k++)
			y_[k] = x[k] + hOver2 * k1[k];

		ode.eval(x_, y_, k2);

		for (int k = 0; k < n; k++)
			y_[k] = x[k] + hOver2 * k2[k];

		ode.eval(x_, y_, k3);

		x_ = t + h;

		for (int k = 0; k < n; k++)
			y_[k] = x[k] + h * k3[k];

		ode.eval(x_, y_, k4);

		for (int k = 0; k < n; k++)
			r[k] = x[k] + hOver6 * (k1[k] + 2 * (k2[k] + k3[k]) + k4[k]);

	}

	public static void step( 
			final ODE ode, 
			double t, 
			final double [] x, 
			final double [] r, 
			final double h, double [][] tempData, int intermediateSteps ) {
	
		final double hh = h / (intermediateSteps + 1);
		
		step( ode, t, x, r, hh, tempData );
		
		for( int i=0; i<intermediateSteps; i++ ) {
			t+=hh;
			step( ode, t, r, r, hh, tempData );
		}
	}
	
	public static void odex(
		final ODE ode,
		final double[] x,
		final double tStart,
		final double tEnd,
		final int numOfSteps,
		final double[][] tempData ) {

		final double h = (tEnd - tStart) / numOfSteps;

		double t = tStart;
		for (int i = 0; i < numOfSteps; i++) {
			step(ode, t, x, x, h, tempData );
			t += h;
		}

	}

	public static void table(
			final ODE ode,
			final double[] init,
			final double tStart,
			final double tEnd,
			final double [][] table ) {
		table( ode, init, tStart, tEnd, table, 0 );
	}

	public static void table(
			final ODE ode,
			final double[] init,
			final double tStart,
			final double tEnd,
			final double [][] table,
			int intermediateSteps) {
		
			final int numOfSteps = table.length-1;
			
			final double h = (tEnd - tStart) / numOfSteps;

			final int noe = ode.getNumberOfEquations();
			
			final double [][] tempData = new double[5][noe];
			
			System.arraycopy(init,0,table[0],0,noe);
			
			double t = tStart;
			
			if( intermediateSteps==0) {
				for (int i = 0; i < numOfSteps; i++) {			
					step(ode, t, table[i], table[i+1], h, tempData );
					t += h;
				}
			} else {
				for (int i = 0; i < numOfSteps; i++) {			
					step(ode, t, table[i], table[i+1], h, tempData, intermediateSteps );
					t += h;
				}
			}
		}

	/**
	 * @deprecated
	 * use #link step instead
	 */
	public static double rungeKuttaStep(
		final ODE f,
		double x,
		final double[] y,
		final double H,
		final double[] y_,
		final double[] k1,
		final double[] k2,
		final double[] k3,
		final double[] k4) {

		final int n = f.getNumberOfEquations();

		final double hOver2 = H / 2;
		final double hOver6 = H / 6;

		f.eval(x, y, k1);

		double x_ = x + hOver2;

		for (int k = 0; k < n; k++)
			y_[k] = y[k] + hOver2 * k1[k];

		f.eval(x_, y_, k2);

		for (int k = 0; k < n; k++)
			y_[k] = y[k] + hOver2 * k2[k];

		f.eval(x_, y_, k3);

		x_ = x + H;

		for (int k = 0; k < n; k++)
			y_[k] = y[k] + H * k3[k];

		f.eval(x_, y_, k4);

		for (int k = 0; k < n; k++)
			y[k] += hOver6 * (k1[k] + 2 * (k2[k] + k3[k]) + k4[k]);

		return x_; // x + H
	}

}
