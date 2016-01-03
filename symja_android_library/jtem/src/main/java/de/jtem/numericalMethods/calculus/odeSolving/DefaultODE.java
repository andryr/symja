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

/**
 * Default abstract implementation for the ODE interface.
 * Using this implementation saves the programmer to
 * implement the getNumberOfEquations methods.
 * The associated property becomes immuatable here.
 * 
 * Example: 
 * Encoding the ode for the exponential function: f'=f
 * <code>
 * ODE ode = new DefaultODE(1) {
 *   public void eval( double t, double [] x, double [] y ) {
 *     y[0] = x[0]; 
 *   }
 * }
 * </code>
 * @author schmies
 *
 */
abstract class DefaultODE implements ODE {
	
	final int numberOfEquations;
	
	public DefaultODE( int numberOfEquations ) {
		this.numberOfEquations = numberOfEquations;
	}
	
	final public int getNumberOfEquations() {
		return numberOfEquations;
	}
	

	public static void main( String [] arg ) {
		
		double x0 = 0, y0 = 0;
		double t0 = 0, t1 = 1;
		
		ODE ode = new DefaultODE(2) {
			public void eval(double t, double[] x, double[] y) {
				y[0] =  x[1];
				y[1] = -Math.sin(x[0]);
			}
		};
		
		double [][] table = new double[100][2];
		double []   init  = new double[] { x0, y0 };
		
		RungeKutta.table( ode, init, t0, t1, table );
		
		
	}
}