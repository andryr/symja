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

public class Euler implements OdeSolver, Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	int numOfEquations;

	int numberOfSteps = 1;
	
	double [][] tempData;
	
	public Euler(int numOfEquations) {

		setNumOfEquations(numOfEquations);
	}

	public Euler() {

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
			final double h, double [][] tempData  ) {
	
		final int n = ode.getNumberOfEquations();

		final double [] y = tempData[0];
		
		ode.eval(t, x, y);

		for (int k = 0; k < n; k++)
			r[k] = y[k]*h + x[k];

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
			final double[] x,
			final double tStart,
			final double tEnd,
			final double [][] table ) {
		table( ode, x, tStart, tEnd, table, 0 );
	}

	public static void table(
			final ODE ode,
			final double[] x,
			final double tStart,
			final double tEnd,
			final double [][] table,
			int intermediateSteps) {
		
			final int numOfSteps = table.length-1;
			
			final double h = (tEnd - tStart) / numOfSteps;

			final int noe = ode.getNumberOfEquations();
			
			final double [][] tempData = new double[5][noe];
			
			System.arraycopy(x,0,table[0],0,noe);
			
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

}
