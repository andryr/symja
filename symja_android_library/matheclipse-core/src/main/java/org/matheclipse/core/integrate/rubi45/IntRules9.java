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
public class IntRules9 { 
  public static IAST RULES = List( 
ISetDelayed(Int(Times(Plus($p("A",true),Times($p("B",true),Power(x_,n_))),Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_))),p_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Times(Power(n,-1),Subst(Int(Times(Plus($s("A"),Times($s("B"),x)),Power(Plus(a,Times(b,x)),p),Power(Plus(c,Times(d,x)),q)),x),x,Power(x,n))),And(And(And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),m,n,p,q),x),NonzeroQ(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))))),NonzeroQ(Plus(Times($s("B"),c),Times(CN1,$s("A"),d)))),NonzeroQ(Plus(Times(b,c),Times(CN1,a,d)))),ZeroQ(Plus(m,Negate(n),C1))))),
ISetDelayed(Int(Times(Plus($p("A",true),Times($p("B",true),Power(x_,n_))),Power(Times(x_,Plus(a_,Times(b_DEFAULT,Power(x_,n_))),Plus(c_,Times(d_DEFAULT,Power(x_,n_)))),-1)),x_Symbol),
    Condition(Plus(Times($s("A"),Log(x),Power(Times(a,c),-1)),Times(CN1,b,Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Power(Times(a,Plus(Times(b,c),Times(CN1,a,d))),-1),Int(Times(Power(x,Plus(n,Negate(C1))),Power(Plus(a,Times(b,Power(x,n))),-1)),x)),Times(CN1,d,Plus(Times($s("B"),c),Times(CN1,$s("A"),d)),Power(Times(c,Plus(Times(b,c),Times(CN1,a,d))),-1),Int(Times(Power(x,Plus(n,Negate(C1))),Power(Plus(c,Times(d,Power(x,n))),-1)),x))),And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),n),x),NonzeroQ(Plus(Times(b,c),Times(CN1,a,d)))))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Plus($p("A",true),Times($p("B",true),Power(x_,n_))),Power(Times(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),Plus(c_,Times(d_DEFAULT,Power(x_,n_)))),-1)),x_Symbol),
    Condition(Plus(Times(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Power(Plus(Times(b,c),Times(CN1,a,d)),-1),Int(Times(Power(x,m),Power(Plus(a,Times(b,Power(x,n))),-1)),x)),Times(Plus(Times($s("B"),c),Times(CN1,$s("A"),d)),Power(Plus(Times(b,c),Times(CN1,a,d)),-1),Int(Times(Power(x,m),Power(Plus(c,Times(d,Power(x,n))),-1)),x))),And(And(And(And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B")),x),NonzeroQ(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))))),NonzeroQ(Plus(Times($s("B"),c),Times(CN1,$s("A"),d)))),NonzeroQ(Plus(Times(b,c),Times(CN1,a,d)))),RationalQ(m,n)),Less(Less(CN1,m),n)))),
ISetDelayed(Int(Times(Plus($p("A",true),Times($p("B",true),Power(x_,n_))),Power(Times(x_,Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_DEFAULT),Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_))))),-1)),x_Symbol),
    Condition(Plus(Times($s("A"),Power(a,-1),Int(Power(Times(x,Sqrt(Plus(c,Times(d,Power(x,n))))),-1),x)),Times(CN1,Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Power(a,-1),Int(Times(Power(x,Plus(n,Negate(C1))),Power(Times(Plus(a,Times(b,Power(x,n))),Sqrt(Plus(c,Times(d,Power(x,n))))),-1)),x))),And(And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),n),x),NonzeroQ(Plus(Times(b,c),Times(CN1,a,d)))),NonzeroQ(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))))),NonzeroQ(Plus(Times($s("B"),c),Times(CN1,$s("A"),d)))))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Plus($p("A",true),Times($p("B",true),Power(x_,n_))),Power(Times(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_DEFAULT),Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_))))),-1)),x_Symbol),
    Condition(Plus(Times($s("B"),Power(b,-1),Int(Times(Power(x,m),Power(Plus(c,Times(d,Power(x,n))),CN1D2)),x)),Times(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Power(b,-1),Int(Times(Power(x,m),Power(Times(Plus(a,Times(b,Power(x,n))),Sqrt(Plus(c,Times(d,Power(x,n))))),-1)),x))),And(And(And(And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B")),x),NonzeroQ(Plus(Times(b,c),Times(CN1,a,d)))),NonzeroQ(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))))),NonzeroQ(Plus(Times($s("B"),c),Times(CN1,$s("A"),d)))),RationalQ(m,n)),Less(Less(C0,Plus(m,C1)),n)))),
ISetDelayed(Int(Times(Plus($p("A",true),Times($p("B",true),Power(x_,n_))),Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_))),p_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(x,m),Plus($s("A"),Times($s("B"),Power(x,n))),Power(Plus(a,Times(b,Power(x,n))),p),Power(Plus(c,Times(d,Power(x,n))),q)),x),x),And(And(And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),m,n),x),NonzeroQ(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))))),NonzeroQ(Plus(Times($s("B"),c),Times(CN1,$s("A"),d)))),NonzeroQ(Plus(Times(b,c),Times(CN1,a,d)))),Or(PositiveIntegerQ(p,q),And(And(IntegersQ(m,p,q),Greater(p,C0)),Equal(q,CN1)))))),
ISetDelayed(Int(Times(Plus($p("A",true),Times($p("B",true),Power(x_,n_))),Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_))),p_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Plus(Times(CN1,Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Power(x,Plus(m,C1)),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Plus(c,Times(d,Power(x,n))),q),Power(Times(a,b,n,Plus(p,C1)),-1)),Times(Power(Times(a,b,n,Plus(p,C1)),-1),Int(Times(Power(x,m),Simp(Plus(Times(c,Plus(Times($s("A"),b,n,Plus(p,C1)),Times(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Plus(m,C1)))),Times(d,Plus(Times($s("A"),b,n,Plus(p,C1)),Times(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Plus(m,Times(n,q),C1))),Power(x,n))),x),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Plus(c,Times(d,Power(x,n))),Plus(q,Negate(C1)))),x))),And(And(And(And(And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),m,n),x),NonzeroQ(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))))),NonzeroQ(Plus(Times($s("B"),c),Times(CN1,$s("A"),d)))),NonzeroQ(Plus(Times(b,c),Times(CN1,a,d)))),RationalQ(p,q)),Less(p,CN1)),Greater(q,C0)))),
ISetDelayed(Int(Times(Plus($p("A",true),Times($p("B",true),Power(x_,n_))),Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_))),p_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Plus(Times(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Power(x,Plus(m,Negate(n),C1)),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Plus(c,Times(d,Power(x,n))),Plus(q,C1)),Power(Times(b,n,Plus(Times(b,c),Times(CN1,a,d)),Plus(p,C1)),-1)),Times(CN1,Power(Times(b,n,Plus(Times(b,c),Times(CN1,a,d)),Plus(p,C1)),-1),Int(Times(Power(x,Plus(m,Negate(n))),Simp(Plus(Times(c,Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Plus(m,Negate(n),C1)),Times(Plus(Times(d,Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Plus(m,Times(n,q),C1)),Times(CN1,b,n,Plus(Times($s("B"),c),Times(CN1,$s("A"),d)),Plus(p,C1))),Power(x,n))),x),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Plus(c,Times(d,Power(x,n))),q)),x))),And(And(And(And(And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),q),x),NonzeroQ(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))))),NonzeroQ(Plus(Times($s("B"),c),Times(CN1,$s("A"),d)))),NonzeroQ(Plus(Times(b,c),Times(CN1,a,d)))),RationalQ(m,n,p)),Less(Less(C0,n),Plus(m,C1))),Less(p,CN1)))),
ISetDelayed(Int(Times(Plus($p("A",true),Times($p("B",true),Power(x_,n_))),Power(x_,m_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_))),p_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Plus(Times($s("A"),Power(x,Plus(m,C1)),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Plus(c,Times(d,Power(x,n))),q),Power(Times(a,Plus(m,C1)),-1)),Times(CN1,Power(Times(a,Plus(m,C1)),-1),Int(Times(Power(x,Plus(m,n)),Simp(Plus(Times(c,Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Plus(m,C1)),Times($s("A"),n,Plus(Times(b,c,Plus(p,C1)),Times(a,d,q))),Times(d,Plus(Times(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Plus(m,C1)),Times($s("A"),b,n,Plus(p,q,C1))),Power(x,n))),x),Power(Plus(a,Times(b,Power(x,n))),p),Power(Plus(c,Times(d,Power(x,n))),Plus(q,Negate(C1)))),x))),And(And(And(And(And(And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),p),x),NonzeroQ(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))))),NonzeroQ(Plus(Times($s("B"),c),Times(CN1,$s("A"),d)))),NonzeroQ(Plus(Times(b,c),Times(CN1,a,d)))),RationalQ(m,n,q)),Less(m,CN1)),Greater(n,C0)),Greater(q,C0)))),
ISetDelayed(Int(Times(Plus($p("A",true),Times($p("B",true),Power(x_,n_))),Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_))),p_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Plus(Times($s("B"),Power(x,Plus(m,C1)),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Plus(c,Times(d,Power(x,n))),q),Power(Times(b,Plus(m,Times(n,Plus(p,q,C1)),C1)),-1)),Times(Power(Times(b,Plus(m,Times(n,Plus(p,q,C1)),C1)),-1),Int(Times(Power(x,m),Simp(Plus(Times(c,Plus(Times(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Plus(m,C1)),Times($s("A"),b,n,Plus(p,q,C1)))),Times(Plus(Times(d,Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Plus(m,C1)),Times($s("B"),n,q,Plus(Times(b,c),Times(CN1,a,d))),Times($s("A"),b,d,n,Plus(p,q,C1))),Power(x,n))),x),Power(Plus(a,Times(b,Power(x,n))),p),Power(Plus(c,Times(d,Power(x,n))),Plus(q,Negate(C1)))),x))),And(And(And(And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),m,n,p),x),NonzeroQ(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))))),NonzeroQ(Plus(Times($s("B"),c),Times(CN1,$s("A"),d)))),NonzeroQ(Plus(Times(b,c),Times(CN1,a,d)))),RationalQ(q)),Greater(q,C0)))),
ISetDelayed(Int(Times(Plus($p("A",true),Times($p("B",true),Power(x_,n_))),Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_))),p_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Plus(Times(CN1,Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Power(x,Plus(m,C1)),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Plus(c,Times(d,Power(x,n))),Plus(q,C1)),Power(Times(a,n,Plus(Times(b,c),Times(CN1,a,d)),Plus(p,C1)),-1)),Times(Power(Times(a,n,Plus(Times(b,c),Times(CN1,a,d)),Plus(p,C1)),-1),Int(Times(Power(x,m),Simp(Plus(Times(c,Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Plus(m,C1)),Times($s("A"),n,Plus(Times(b,c),Times(CN1,a,d)),Plus(p,C1)),Times(d,Plus(Times($s("A"),b),Times(CN1,a,$s("B"))),Plus(m,Times(n,Plus(p,q,C2)),C1),Power(x,n))),x),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Plus(c,Times(d,Power(x,n))),q)),x))),And(And(And(And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),m,n,q),x),NonzeroQ(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))))),NonzeroQ(Plus(Times($s("B"),c),Times(CN1,$s("A"),d)))),NonzeroQ(Plus(Times(b,c),Times(CN1,a,d)))),RationalQ(p)),Less(p,CN1)))),
ISetDelayed(Int(Times(Plus($p("A",true),Times($p("B",true),Power(x_,n_))),Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_))),p_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Plus(Times($s("B"),Power(x,Plus(m,Negate(n),C1)),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Plus(c,Times(d,Power(x,n))),Plus(q,C1)),Power(Times(b,d,Plus(m,Times(n,Plus(p,q,C1)),C1)),-1)),Times(CN1,Power(Times(b,d,Plus(m,Times(n,Plus(p,q,C1)),C1)),-1),Int(Times(Power(x,Plus(m,Negate(n))),Simp(Plus(Times(a,$s("B"),c,Plus(m,Negate(n),C1)),Times(Plus(Times(a,$s("B"),d,Plus(m,Times(n,q),C1)),Times(CN1,b,Plus(Times(CN1,$s("B"),c,Plus(m,Times(n,p),C1)),Times($s("A"),d,Plus(m,Times(n,Plus(p,q,C1)),C1))))),Power(x,n))),x),Power(Plus(a,Times(b,Power(x,n))),p),Power(Plus(c,Times(d,Power(x,n))),q)),x))),And(And(And(And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),p,q),x),NonzeroQ(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))))),NonzeroQ(Plus(Times($s("B"),c),Times(CN1,$s("A"),d)))),NonzeroQ(Plus(Times(b,c),Times(CN1,a,d)))),RationalQ(m,n)),Less(Less(C0,n),Plus(m,C1))))),
ISetDelayed(Int(Times(Plus($p("A",true),Times($p("B",true),Power(x_,n_))),Power(x_,m_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_))),p_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Plus(Times($s("A"),Power(x,Plus(m,C1)),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Plus(c,Times(d,Power(x,n))),Plus(q,C1)),Power(Times(a,c,Plus(m,C1)),-1)),Times(Power(Times(a,c,Plus(m,C1)),-1),Int(Times(Power(x,Plus(m,n)),Simp(Plus(Times(a,$s("B"),c,Plus(m,C1)),Times(CN1,$s("A"),Plus(Times(b,c),Times(a,d)),Plus(m,n,C1)),Times(CN1,$s("A"),n,Plus(Times(b,c,p),Times(a,d,q))),Times(CN1,$s("A"),b,d,Plus(m,Times(n,Plus(p,q,C2)),C1),Power(x,n))),x),Power(Plus(a,Times(b,Power(x,n))),p),Power(Plus(c,Times(d,Power(x,n))),q)),x))),And(And(And(And(And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),p,q),x),NonzeroQ(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))))),NonzeroQ(Plus(Times($s("B"),c),Times(CN1,$s("A"),d)))),NonzeroQ(Plus(Times(b,c),Times(CN1,a,d)))),RationalQ(m,n)),Less(m,CN1)),Greater(n,C0)))),
ISetDelayed(Int(Times(Plus($p("A"),Times($p("B",true),Power(x_,n_))),Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_))),p_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(x,m),Plus($s("A"),Times($s("B"),Power(x,n))),Power(Plus(a,Times(b,Power(x,n))),p),Power(Plus(c,Times(d,Power(x,n))),q)),x),x),And(And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),m,n,p,q),x),NonzeroQ(Plus(Times($s("A"),b),Times(CN1,a,$s("B"))))),NonzeroQ(Plus(Times($s("B"),c),Times(CN1,$s("A"),d)))),NonzeroQ(Plus(Times(b,c),Times(CN1,a,d)))))),
ISetDelayed(Int(Times(Plus($p("A"),Times($p("B",true),Power(v_,n_))),Power(u_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(w_,n_))),p_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,Power(z_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Times(Power(u,m),Power(Times(Coefficient(v,x,C1),Power(v,m)),-1),Subst(Int(Times(Power(x,m),Plus($s("A"),Times($s("B"),Power(x,n))),Power(Plus(a,Times(b,Power(x,n))),p),Power(Plus(c,Times(d,Power(x,n))),q)),x),x,v)),And(And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),m,n,p,q),x),LinearPairQ(u,v,x)),ZeroQ(Plus(v,Negate(w)))),ZeroQ(Plus(v,Negate(z)))))),
ISetDelayed(Int(Times(Plus($p("A"),Times($p("B",true),Power(x_,n_DEFAULT))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_),Power(Plus(c_,Times(d_DEFAULT,Power(x_,r_DEFAULT))),q_DEFAULT)),x_Symbol),
    Condition(Int(Times(Plus($s("A"),Times($s("B"),Power(x,n))),Power(Plus(a,Times(b,Power(x,n))),p),Power(Plus(d,Times(c,Power(x,n))),q),Power(Power(x,Times(n,q)),-1)),x),And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),n,p),x),ZeroQ(Plus(n,r))),IntegerQ(q)))),
ISetDelayed(Int(Times(Plus($p("A"),Times($p("B",true),Power(x_,n_DEFAULT))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_),Power(Plus(c_,Times(d_DEFAULT,Power(x_,r_DEFAULT))),q_DEFAULT)),x_Symbol),
    Condition(Times(Power(x,Times(n,q)),Power(Plus(c,Times(d,Power(Power(x,n),-1))),q),Power(Power(Plus(d,Times(c,Power(x,n))),q),-1),Int(Times(Plus($s("A"),Times($s("B"),Power(x,n))),Power(Plus(a,Times(b,Power(x,n))),p),Power(Plus(d,Times(c,Power(x,n))),q),Power(Power(x,Times(n,q)),-1)),x)),And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),n,p,q),x),ZeroQ(Plus(n,r))),Not(IntegerQ(q))))),
ISetDelayed(Int(Times(Plus($p("A"),Times($p("B",true),Power(x_,n_DEFAULT))),Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_),Power(Plus(c_,Times(d_DEFAULT,Power(x_,r_DEFAULT))),q_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(x,Plus(m,Times(CN1,n,q))),Plus($s("A"),Times($s("B"),Power(x,n))),Power(Plus(a,Times(b,Power(x,n))),p),Power(Plus(d,Times(c,Power(x,n))),q)),x),And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),m,n,p),x),ZeroQ(Plus(n,r))),IntegerQ(q)))),
ISetDelayed(Int(Times(Plus($p("A"),Times($p("B",true),Power(x_,n_DEFAULT))),Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_),Power(Plus(c_,Times(d_DEFAULT,Power(x_,r_DEFAULT))),q_DEFAULT)),x_Symbol),
    Condition(Times(Power(x,Times(n,q)),Power(Plus(c,Times(d,Power(Power(x,n),-1))),q),Power(Power(Plus(d,Times(c,Power(x,n))),q),-1),Int(Times(Power(x,Plus(m,Times(CN1,n,q))),Plus($s("A"),Times($s("B"),Power(x,n))),Power(Plus(a,Times(b,Power(x,n))),p),Power(Plus(d,Times(c,Power(x,n))),q)),x)),And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),m,n,p,q),x),ZeroQ(Plus(n,r))),Not(IntegerQ(q))))),
ISetDelayed(Int(Times(z_,Power(u_,p_DEFAULT),Power(v_,q_DEFAULT),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(x,m),ExpandToSum(z,x),Power(ExpandToSum(u,x),p),Power(ExpandToSum(v,x),q)),x),And(And(And(And(FreeQ(List(m,p,q),x),BinomialQ(List(z,u,v),x)),ZeroQ(Plus(BinomialDegree(u,x),Negate(BinomialDegree(v,x))))),ZeroQ(Plus(BinomialDegree(u,x),Negate(BinomialDegree(z,x))))),Not(BinomialMatchQ(List(z,u,v),x)))))
  );
}
