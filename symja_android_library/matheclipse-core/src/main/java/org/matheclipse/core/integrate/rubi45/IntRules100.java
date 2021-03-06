package org.matheclipse.core.integrate.rubi45;


import static org.matheclipse.core.expression.F.*;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.*;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctions.*;
import org.matheclipse.core.interfaces.IAST;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules100 { 
  public static IAST RULES = List( 
ISetDelayed(Int(Times(Power(Plus(a_,Times(b_DEFAULT,Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Times(Power(Times(C2,a),n),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cosh(Plus(Times(CN1,Pi,a,Power(Times(C4,b),-1)),Times(C1D2,c),Times(d,C1D2,x))),Times(C2,n))),x)),And(And(FreeQ(List(a,b,c,d,e,f,m),x),ZeroQ(Plus(Sqr(a),Sqr(b)))),IntegerQ(n)))),
ISetDelayed(Int(Times(Power(Plus(a_,Times(b_DEFAULT,Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Times(Power(Times(C2,a),n),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cosh(Plus(Times(C1D2,c),Times(d,C1D2,x))),Times(C2,n))),x)),And(And(FreeQ(List(a,b,c,d,e,f,m),x),ZeroQ(Plus(a,Negate(b)))),IntegerQ(n)))),
ISetDelayed(Int(Times(Power(Plus(a_,Times(b_DEFAULT,Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Times(Power(Times(CN2,a),n),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sinh(Plus(Times(C1D2,c),Times(d,C1D2,x))),Times(C2,n))),x)),And(And(FreeQ(List(a,b,c,d,e,f,m),x),ZeroQ(Plus(a,b))),IntegerQ(n)))),
ISetDelayed(Int(Times(Power(Plus(a_,Times(b_DEFAULT,Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Times(Power(Times(C2,a),Plus(n,Negate(C1D2))),Sqrt(Plus(a,Times(b,Sinh(Plus(c,Times(d,x)))))),Power(Cosh(Plus(Times(CN1,Pi,a,Power(Times(C4,b),-1)),Times(C1D2,c),Times(d,C1D2,x))),-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cosh(Plus(Times(CN1,Pi,a,Power(Times(C4,b),-1)),Times(C1D2,c),Times(d,C1D2,x))),Times(C2,n))),x)),And(And(FreeQ(List(a,b,c,d,e,f,m),x),ZeroQ(Plus(Sqr(a),Sqr(b)))),Not(IntegerQ(n))))),
ISetDelayed(Int(Times(Power(Plus(a_,Times(b_DEFAULT,Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Times(Power(Times(C2,a),Plus(n,Negate(C1D2))),Sqrt(Plus(a,Times(b,Cosh(Plus(c,Times(d,x)))))),Power(Cosh(Plus(Times(C1D2,c),Times(d,C1D2,x))),-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cosh(Plus(Times(C1D2,c),Times(d,C1D2,x))),Times(C2,n))),x)),And(And(FreeQ(List(a,b,c,d,e,f,m),x),ZeroQ(Plus(a,Negate(b)))),Not(IntegerQ(n))))),
ISetDelayed(Int(Times(Power(Plus(a_,Times(b_DEFAULT,Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Times(Power(Times(CN2,a),Plus(n,Negate(C1D2))),Sqrt(Plus(a,Times(b,Cosh(Plus(c,Times(d,x)))))),Power(Sinh(Plus(Times(C1D2,c),Times(d,C1D2,x))),-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sinh(Plus(Times(C1D2,c),Times(d,C1D2,x))),Times(C2,n))),x)),And(And(FreeQ(List(a,b,c,d,e,f,m),x),ZeroQ(Plus(a,b))),Not(IntegerQ(n))))),
ISetDelayed(Int(Times(x_,Power(Plus(a_,Times(b_DEFAULT,Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-2)),x_Symbol),
    Condition(Plus(Times(a,Power(Plus(Sqr(a),Sqr(b)),-1),Int(Times(x,Power(Plus(a,Times(b,Sinh(Plus(c,Times(d,x))))),-1)),x)),Times(b,Power(Plus(Sqr(a),Sqr(b)),-1),Int(Times(x,Plus(b,Times(CN1,a,Sinh(Plus(c,Times(d,x))))),Power(Plus(a,Times(b,Sinh(Plus(c,Times(d,x))))),-2)),x))),And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(Sqr(a),Sqr(b)))))),
ISetDelayed(Int(Times(x_,Power(Plus(a_,Times(b_DEFAULT,Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-2)),x_Symbol),
    Condition(Plus(Times(a,Power(Plus(Sqr(a),Negate(Sqr(b))),-1),Int(Times(x,Power(Plus(a,Times(b,Cosh(Plus(c,Times(d,x))))),-1)),x)),Times(CN1,b,Power(Plus(Sqr(a),Negate(Sqr(b))),-1),Int(Times(x,Plus(b,Times(a,Cosh(Plus(c,Times(d,x))))),Power(Plus(a,Times(b,Cosh(Plus(c,Times(d,x))))),-2)),x))),And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(Sqr(a),Negate(Sqr(b))))))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Times(Power(Power(C2,n),-1),Int(Times(Power(x,m),Power(Plus(Negate(b),Times(C2,a,Power(E,Plus(c,Times(d,x)))),Times(b,Power(E,Times(C2,Plus(c,Times(d,x)))))),n),Power(Power(E,Times(n,Plus(c,Times(d,x)))),-1)),x)),And(And(And(And(And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(Sqr(a),Sqr(b)))),RationalQ(m)),Greater(m,C0)),IntegerQ(n)),Less(n,C0)))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Times(Power(Power(C2,n),-1),Int(Times(Power(x,m),Power(Plus(b,Times(C2,a,Power(E,Plus(c,Times(d,x)))),Times(b,Power(E,Times(C2,Plus(c,Times(d,x)))))),n),Power(Power(E,Times(n,Plus(c,Times(d,x)))),-1)),x)),And(And(And(And(And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(Sqr(a),Negate(Sqr(b))))),RationalQ(m)),Greater(m,C0)),IntegerQ(n)),Less(n,C0)))),
ISetDelayed(Int(Times(Power(Plus(a_,Times(b_DEFAULT,Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(e,Times(f,x)),m),Power(Plus(a,Times(b,C1D2,Sinh(Plus(Times(C2,c),Times(C2,d,x))))),n)),x),FreeQ(List(a,b,c,d,e,f,m,n),x))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,x_)))))),n_)),x_Symbol),
    Condition(Times(Power(Power(C2,n),-1),Int(Times(Power(x,m),Power(Plus(Times(C2,a),Negate(b),Times(b,Cosh(Plus(Times(C2,c),Times(C2,d,x))))),n)),x)),And(And(And(And(And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(a,Negate(b)))),IntegersQ(m,n)),Greater(m,C0)),Less(n,C0)),Or(Equal(n,CN1),And(Equal(m,C1),Equal(n,CN2)))))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,x_)))))),n_)),x_Symbol),
    Condition(Times(Power(Power(C2,n),-1),Int(Times(Power(x,m),Power(Plus(Times(C2,a),b,Times(b,Cosh(Plus(Times(C2,c),Times(C2,d,x))))),n)),x)),And(And(And(And(And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(a,b))),IntegersQ(m,n)),Greater(m,C0)),Less(n,C0)),Or(Equal(n,CN1),And(Equal(m,C1),Equal(n,CN2))))))
  );
}
