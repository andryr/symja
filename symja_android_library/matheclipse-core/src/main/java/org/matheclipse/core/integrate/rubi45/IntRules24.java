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
public class IntRules24 { 
  public static IAST RULES = List( 
ISetDelayed(Int(Times(Plus($p("A"),Times($p("B",true),Power(x_,n_))),Power(x_,m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,j_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Times(CN1,Power(x,Plus(m,C1)),Plus($s("A"),Times($s("B"),Power(x,n))),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),Plus(p,C1)),Power(Times(C2,a,n,Plus(p,C1)),-1)),Times(Power(Times(C2,a,n,Plus(p,C1)),-1),Int(Times(Power(x,m),Plus(Times($s("A"),Plus(m,Times(C2,n,Plus(p,C1)),C1)),Times($s("B"),Plus(m,Times(n,Plus(Times(C2,p),C3)),C1),Power(x,n))),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),Plus(p,C1))),x))),And(And(And(And(And(FreeQ(List(a,c,$s("A"),$s("B")),x),ZeroQ(Plus(j,Times(CN1,C2,n)))),PositiveIntegerQ(n)),RationalQ(m,p)),Less(p,CN1)),Less(m,Plus(n,Negate(C1)))))),
ISetDelayed(Int(Times(Plus($p("A"),Times($p("B",true),Power(x_,n_))),Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,j_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Times($s("B"),Power(x,Plus(m,Negate(n),C1)),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),Plus(p,C1)),Power(Times(c,Plus(m,Times(n,Plus(Times(C2,p),C1)),C1)),-1)),Times(CN1,Power(Times(c,Plus(m,Times(n,Plus(Times(C2,p),C1)),C1)),-1),Int(Times(Power(x,Plus(m,Negate(n))),Simp(Plus(Times(a,$s("B"),Plus(m,Negate(n),C1)),Times(Plus(Times(b,$s("B"),Plus(m,Times(n,p),C1)),Times(CN1,c,$s("A"),Plus(m,Times(n,Plus(Times(C2,p),C1)),C1))),Power(x,n))),x),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x))),And(And(And(And(And(And(And(FreeQ(List(a,b,c,$s("A"),$s("B")),x),ZeroQ(Plus(j,Times(CN1,C2,n)))),NonzeroQ(Plus(Sqr(b),Times(CN1,C4,a,c)))),PositiveIntegerQ(n)),RationalQ(m,p)),GreaterEqual(m,n)),And(LessEqual(CN1,p),Less(p,C0))),Unequal(Plus(m,Times(n,Plus(Times(C2,p),C1)),C1),C0)))),
ISetDelayed(Int(Times(Plus($p("A"),Times($p("B",true),Power(x_,n_))),Power(x_,m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,j_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Times($s("B"),Power(x,Plus(m,Negate(n),C1)),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),Plus(p,C1)),Power(Times(c,Plus(m,Times(n,Plus(Times(C2,p),C1)),C1)),-1)),Times(CN1,Power(Times(c,Plus(m,Times(n,Plus(Times(C2,p),C1)),C1)),-1),Int(Times(Power(x,Plus(m,Negate(n))),Plus(Times(a,$s("B"),Plus(m,Negate(n),C1)),Times(CN1,c,$s("A"),Plus(m,Times(n,Plus(Times(C2,p),C1)),C1),Power(x,n))),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),x))),And(And(And(And(And(And(FreeQ(List(a,c,$s("A"),$s("B")),x),ZeroQ(Plus(j,Times(CN1,C2,n)))),PositiveIntegerQ(n)),RationalQ(m,p)),GreaterEqual(m,n)),And(LessEqual(CN1,p),Less(p,C0))),Unequal(Plus(m,Times(n,Plus(Times(C2,p),C1)),C1),C0)))),
ISetDelayed(Int(Times(Plus($p("A"),Times($p("B",true),Power(x_,n_))),Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,j_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Times($s("A"),Power(x,Plus(m,C1)),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),Plus(p,C1)),Power(Times(a,Plus(m,C1)),-1)),Times(Power(Times(a,Plus(m,C1)),-1),Int(Times(Power(x,Plus(m,n)),Simp(Plus(Times(a,$s("B"),Plus(m,C1)),Times(CN1,$s("A"),b,Plus(m,Times(n,Plus(p,C1)),C1)),Times(CN1,c,$s("A"),Plus(m,Times(C2,n,Plus(p,C1)),C1),Power(x,n))),x),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x))),And(And(And(And(And(And(And(FreeQ(List(a,b,c,$s("A"),$s("B")),x),ZeroQ(Plus(j,Times(CN1,C2,n)))),NonzeroQ(Plus(Sqr(b),Times(CN1,C4,a,c)))),PositiveIntegerQ(n)),RationalQ(m,p)),LessEqual(m,Negate(n))),Or(And(LessEqual(CN1,p),Less(p,C0)),Equal(Plus(m,Times(n,Plus(Times(C2,p),C1)),C1),C0))),Unequal(Plus(m,C1),C0)))),
ISetDelayed(Int(Times(Plus($p("A"),Times($p("B",true),Power(x_,n_))),Power(x_,m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,j_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Times($s("A"),Power(x,Plus(m,C1)),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),Plus(p,C1)),Power(Times(a,Plus(m,C1)),-1)),Times(Power(Times(a,Plus(m,C1)),-1),Int(Times(Power(x,Plus(m,n)),Plus(Times(a,$s("B"),Plus(m,C1)),Times(CN1,c,$s("A"),Plus(m,Times(C2,n,Plus(p,C1)),C1),Power(x,n))),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),x))),And(And(And(And(And(And(FreeQ(List(a,c,$s("A"),$s("B")),x),ZeroQ(Plus(j,Times(CN1,C2,n)))),PositiveIntegerQ(n)),RationalQ(m,p)),LessEqual(m,Negate(n))),And(LessEqual(CN1,p),Less(p,C0))),Unequal(Plus(m,C1),C0)))),
ISetDelayed(Int(Times(Plus($p("A"),Times($p("B",true),Power(x_,n_))),Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,j_DEFAULT))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Times($s("A"),Int(Times(Power(x,m),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x)),Times($s("B"),Int(Times(Power(x,Plus(m,n)),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x))),And(FreeQ(List(a,b,c,$s("A"),$s("B"),m,n,p),x),ZeroQ(Plus(j,Times(CN1,C2,n)))))),
ISetDelayed(Int(Times(Plus($p("A"),Times($p("B",true),Power(x_,n_))),Power(x_,m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,j_DEFAULT))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Times($s("A"),Int(Times(Power(x,m),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),x)),Times($s("B"),Int(Times(Power(x,Plus(m,n)),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),x))),And(FreeQ(List(a,c,$s("A"),$s("B"),m,n,p),x),ZeroQ(Plus(j,Times(CN1,C2,n)))))),
ISetDelayed(Int(Times(Power(x_,m_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,j_DEFAULT))),p_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Power(x_,n_))),-1)),x_Symbol),
    Condition(Plus(Times(Power(Times(d,e),-1),Int(Times(Power(x,m),Plus(Times(a,e),Times(c,d,Power(x,n))),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),Plus(p,Negate(C1)))),x)),Times(CN1,Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),Power(Times(d,e),-1),Int(Times(Power(x,Plus(m,n)),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),Plus(p,Negate(C1))),Power(Plus(d,Times(e,Power(x,n))),-1)),x))),And(And(And(And(And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(j,Times(CN1,C2,n)))),NonzeroQ(Plus(Sqr(b),Times(CN1,C4,a,c)))),NonzeroQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))))),RationalQ(m,n,p)),Less(m,C0)),Greater(n,C0)),Greater(p,C0)))),
ISetDelayed(Int(Times(Power(x_,m_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,j_DEFAULT))),p_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Power(x_,n_))),-1)),x_Symbol),
    Condition(Plus(Times(Power(Times(d,e),-1),Int(Times(Power(x,m),Plus(Times(a,e),Times(c,d,Power(x,n))),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),Plus(p,Negate(C1)))),x)),Times(CN1,Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),Power(Times(d,e),-1),Int(Times(Power(x,Plus(m,n)),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),Plus(p,Negate(C1))),Power(Plus(d,Times(e,Power(x,n))),-1)),x))),And(And(And(And(And(And(FreeQ(List(a,c,d,e),x),ZeroQ(Plus(j,Times(CN1,C2,n)))),NonzeroQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))))),RationalQ(m,n,p)),Less(m,C0)),Greater(n,C0)),Greater(p,C0)))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,j_DEFAULT))),p_),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Power(x_,n_))),-1)),x_Symbol),
    Condition(Plus(Times(Power(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),-1),Int(Times(Power(x,Plus(m,Negate(n))),Plus(Times(a,e),Times(c,d,Power(x,n))),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x)),Times(CN1,d,e,Power(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),-1),Int(Times(Power(x,Plus(m,Negate(n))),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),Plus(p,C1)),Power(Plus(d,Times(e,Power(x,n))),-1)),x))),And(And(And(And(And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(j,Times(CN1,C2,n)))),NonzeroQ(Plus(Sqr(b),Times(CN1,C4,a,c)))),NonzeroQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))))),RationalQ(m,n,p)),Greater(m,C0)),Greater(n,C0)),Less(p,CN1)))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,j_DEFAULT))),p_),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Power(x_,n_))),-1)),x_Symbol),
    Condition(Plus(Times(Power(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),-1),Int(Times(Power(x,Plus(m,Negate(n))),Plus(Times(a,e),Times(c,d,Power(x,n))),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),x)),Times(CN1,d,e,Power(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),-1),Int(Times(Power(x,Plus(m,Negate(n))),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),Plus(p,C1)),Power(Plus(d,Times(e,Power(x,n))),-1)),x))),And(And(And(And(And(And(FreeQ(List(a,c,d,e),x),ZeroQ(Plus(j,Times(CN1,C2,n)))),NonzeroQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))))),RationalQ(m,n,p)),Greater(m,C0)),Greater(n,C0)),Less(p,CN1)))),
ISetDelayed(Int(Times(Power(u_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(w_,n_)),Times(c_DEFAULT,Power(z_,j_DEFAULT))),p_),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Power(v_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Times(Power(u,m),Power(Times(Coefficient(v,x,C1),Power(v,m)),-1),Subst(Int(Times(Power(x,m),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),x,v)),And(And(And(And(FreeQ(List(a,b,c,d,e,m,n,p,q),x),ZeroQ(Plus(j,Times(CN1,C2,n)))),LinearPairQ(u,v,x)),ZeroQ(Plus(v,Negate(w)))),ZeroQ(Plus(v,Negate(z)))))),
ISetDelayed(Int(Times(Power(u_,m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Power(v_,n_))),q_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(z_,j_DEFAULT))),p_)),x_Symbol),
    Condition(Times(Power(u,m),Power(Times(Coefficient(v,x,C1),Power(v,m)),-1),Subst(Int(Times(Power(x,m),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),x),x,v)),And(And(And(FreeQ(List(a,c,d,e,m,n,p),x),ZeroQ(Plus(j,Times(CN1,C2,n)))),LinearPairQ(u,v,x)),ZeroQ(Plus(v,Negate(z)))))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(z_,q_DEFAULT),Power(u_,p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(x,m),Power(ExpandToSum(z,x),q),Power(ExpandToSum(u,x),p)),x),And(And(And(FreeQ(List(m,p,q),x),BinomialQ(z,x)),TrinomialQ(u,x)),Not(And(BinomialMatchQ(z,x),TrinomialMatchQ(u,x)))))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(z_,q_DEFAULT),Power(u_,p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(x,m),Power(ExpandToSum(z,x),q),Power(ExpandToSum(u,x),p)),x),And(And(And(FreeQ(List(m,p,q),x),BinomialQ(z,x)),BinomialQ(u,x)),Not(And(BinomialMatchQ(z,x),BinomialMatchQ(u,x))))))
  );
}
