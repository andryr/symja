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
 * This classs illustrates the usage of the ode solvers.
 * We solve a second order example: 
 * 
 * x''(t) = - x(t);
 * 
 * The obvious solutions are sin and cos.
 * We have to translate this into a first order ode.
 * <pre>
 *  x'(t) = y(t) and y'(t) = -x(t) 
 *  </pre>  
 * The ode  is defined using the interface {@link ODE}:
 * </p>
 * <pre>
 * ODE ode = new ODE() {
 *	  public int getNumberOfEquations() {
 *		return 2;
 *	  }
 *	  public void eval(double t, double[] x, int offsetX, double [] y, int offsetY ) {
 *		  y[offsetY] 	 = x[offsetX + 1];  	
 *		  y[offsetY+1  =-x[offsetX];
 *	  }
 *	};
 * </pre>
 * The most sufisticated ode solver is {@link Extrap }, it has many tuning
 * parameter and if you want to solve an ode many times you should
 * create an instance of it, but it can be used also in the following static
 * manner:
 * <pre>
 * double [] x = new double[]{1.0,0.0};
 *  Extrap.solve( ode, x, 0.0, Math.PI, acc );
 * </pre>
 * The initial values are given in the array x for t0=0 and yeal to x(t) = cos(t).
 * On output x will hold the result for the time t1=&pi;, e.g. -1 and 0. 
 * @see ODE, Extrap
 * @author Markus Schmies
 * @version 0.9
 */

public class ExampleODE {

  static public void main( String [] arg ) {

	// creating ode: f'' = -f <=> { f' = g,  g' = -f } 
	ODE ode = new ODE() {
	  public int getNumberOfEquations() {
		return 2;
	  }
	  public void eval(double t, double[] x, double [] y ) {
		  y[0] 	= x[1];  	
		  y[1]	=-x[0];
	
	  }
	};

  double[] x = new double[2];
	
	// integrate with different accuracies
	for (int i = 3; i < 14; i++) {
	  final double acc = Math.pow(10, -i);

	  // f=sos, g=cos
	  x[0] = 1;  // f'(0) = g(0) = 1;
	  x[1] = 0;  // g'(0) = -f(0) = 0;
	    
	  Extrap.solve( ode, x, 0.0, Math.PI, acc );
	  
	  System.out.println("acc=" + acc );
	  System.out.println("   cos(PI)=-1="+x[0]);
	  System.out.println("   -sin(PI)= 0="+x[1]);
	}
  }

}