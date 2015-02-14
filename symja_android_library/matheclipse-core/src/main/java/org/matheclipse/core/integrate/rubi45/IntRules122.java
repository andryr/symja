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
public class IntRules122 { 
  public static IAST RULES = List( 
ISetDelayed(Int(Times(Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Times(Power(e,-1),Int(Times(Power(x,Plus(m,Negate(C2))),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),n)),x)),Times(CN1,d,Power(e,-1),Int(Times(Power(x,Plus(m,Negate(C2))),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),n)),x))),And(And(And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))),IntegersQ(m,n,Times(C2,p))),Less(p,CN1)),Greater(m,C1)),Unequal(n,CN1)))),
ISetDelayed(Int(Times(Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Times(Power(e,-1),Int(Times(Power(x,Plus(m,Negate(C2))),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),n)),x)),Times(CN1,d,Power(e,-1),Int(Times(Power(x,Plus(m,Negate(C2))),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),n)),x))),And(And(And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))),IntegersQ(m,n,Times(C2,p))),Less(p,CN1)),Greater(m,C1)),Unequal(n,CN1)))),
ISetDelayed(Int(Times(Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Times(Power(d,-1),Int(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),n)),x)),Times(CN1,e,Power(d,-1),Int(Times(Power(x,Plus(m,C2)),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),n)),x))),And(And(And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))),IntegersQ(m,n,Times(C2,p))),Less(p,CN1)),Less(m,C0)),Unequal(n,CN1)))),
ISetDelayed(Int(Times(Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Times(Power(d,-1),Int(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),n)),x)),Times(CN1,e,Power(d,-1),Int(Times(Power(x,Plus(m,C2)),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),n)),x))),And(And(And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))),IntegersQ(m,n,Times(C2,p))),Less(p,CN1)),Less(m,C0)),Unequal(n,CN1)))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(n,C1)),Power(Times(b,c,d,Plus(n,C1)),-1)),Times(CN1,m,Power(Times(b,c,Plus(n,C1)),-1),Int(Times(Power(x,Plus(m,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(n,C1))),x)),Times(c,Plus(m,Times(C2,p),C2),Power(Times(b,Plus(n,C1)),-1),Int(Times(Power(x,Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(n,C1))),x))),And(And(And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))),RationalQ(m,n,p)),Less(p,CN1)),Less(n,CN1)),NonzeroQ(Plus(m,Times(C2,p),C2))))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(n,C1)),Power(Times(b,c,d,Plus(n,C1)),-1)),Times(CN1,m,Power(Times(b,c,Plus(n,C1)),-1),Int(Times(Power(x,Plus(m,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(n,C1))),x)),Times(c,Plus(m,Times(C2,p),C2),Power(Times(b,Plus(n,C1)),-1),Int(Times(Power(x,Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(n,C1))),x))),And(And(And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))),RationalQ(m,n,p)),Less(p,CN1)),Less(n,CN1)),NonzeroQ(Plus(m,Times(C2,p),C2))))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Times(Power(d,p),Power(Power(c,Plus(m,C1)),-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Power(Sinh(x),m),Power(Power(Cosh(x),Plus(m,Times(C2,Plus(p,C1)))),-1)),x),x,ArcTanh(Times(c,x)))),And(And(And(And(FreeQ(List(a,b,c,d,e,n),x),ZeroQ(Plus(Times(Sqr(c),d),e))),PositiveIntegerQ(m)),NegativeIntegerQ(Plus(m,Times(C2,p),C1))),Or(IntegerQ(p),PositiveQ(d))))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Times(Power(d,Plus(p,C1D2)),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x)))),Power(Plus(d,Times(e,Sqr(x))),CN1D2),Int(Times(Power(x,m),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),p),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),n)),x)),And(And(And(And(FreeQ(List(a,b,c,d,e,n),x),ZeroQ(Plus(Times(Sqr(c),d),e))),PositiveIntegerQ(m)),NegativeIntegerQ(Plus(m,Times(C2,p),C1))),Not(Or(IntegerQ(p),PositiveQ(d)))))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Times(CN1,Power(Negate(d),p),Power(Power(c,Plus(m,C1)),-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Power(Cosh(x),m),Power(Power(Sinh(x),Plus(m,Times(C2,Plus(p,C1)))),-1)),x),x,ArcCoth(Times(c,x)))),And(And(And(And(FreeQ(List(a,b,c,d,e,n),x),ZeroQ(Plus(Times(Sqr(c),d),e))),PositiveIntegerQ(m)),NegativeIntegerQ(Plus(m,Times(C2,p),C1))),IntegerQ(p)))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Times(CN1,Power(Negate(d),Plus(p,C1D2)),x,Sqrt(Times(Plus(Times(Sqr(c),Sqr(x)),Negate(C1)),Power(Times(Sqr(c),Sqr(x)),-1))),Power(Times(Power(c,m),Sqrt(Plus(d,Times(e,Sqr(x))))),-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Power(Cosh(x),m),Power(Power(Sinh(x),Plus(m,Times(C2,Plus(p,C1)))),-1)),x),x,ArcCoth(Times(c,x)))),And(And(And(And(FreeQ(List(a,b,c,d,e,n),x),ZeroQ(Plus(Times(Sqr(c),d),e))),PositiveIntegerQ(m)),NegativeIntegerQ(Plus(m,Times(C2,p),C1))),Not(IntegerQ(p))))),
ISetDelayed(Int(Times(x_,Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(Plus(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Plus(a,Times(b,ArcTanh(Times(c,x)))),Power(Times(C2,e,Plus(p,C1)),-1)),Times(CN1,b,c,Power(Times(C2,e,Plus(p,C1)),-1),Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x))),And(FreeQ(List(a,b,c,d,e,p),x),NonzeroQ(Plus(p,C1))))),
ISetDelayed(Int(Times(x_,Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(Plus(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Plus(a,Times(b,ArcCoth(Times(c,x)))),Power(Times(C2,e,Plus(p,C1)),-1)),Times(CN1,b,c,Power(Times(C2,e,Plus(p,C1)),-1),Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x))),And(FreeQ(List(a,b,c,d,e,p),x),NonzeroQ(Plus(p,C1))))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(Module(List(Set(u,Block(List(Set($s("§showsteps"),False),Set($s("§stepcounter"),Null)),Int(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),p)),x)))),Plus(Dist(Plus(a,Times(b,ArcTanh(Times(c,x)))),u,x),Times(CN1,b,c,Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x),x)))),And(FreeQ(List(a,b,c,d,e,m,p),x),Or(Or(And(PositiveIntegerQ(p),Not(And(NegativeIntegerQ(Times(C1D2,Plus(m,Negate(C1)))),Greater(Plus(m,Times(C2,p),C3),C0)))),And(PositiveIntegerQ(Times(C1D2,Plus(m,C1))),Not(And(NegativeIntegerQ(p),Greater(Plus(m,Times(C2,p),C3),C0))))),And(NegativeIntegerQ(Times(C1D2,Plus(m,Times(C2,p),C1))),Not(NegativeIntegerQ(Times(C1D2,Plus(m,Negate(C1)))))))))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(Module(List(Set(u,Block(List(Set($s("§showsteps"),False),Set($s("§stepcounter"),Null)),Int(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),p)),x)))),Plus(Dist(Plus(a,Times(b,ArcCoth(Times(c,x)))),u,x),Times(CN1,b,c,Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x),x)))),And(FreeQ(List(a,b,c,d,e,m,p),x),Or(Or(And(PositiveIntegerQ(p),Not(And(NegativeIntegerQ(Times(C1D2,Plus(m,Negate(C1)))),Greater(Plus(m,Times(C2,p),C3),C0)))),And(PositiveIntegerQ(Times(C1D2,Plus(m,C1))),Not(And(NegativeIntegerQ(p),Greater(Plus(m,Times(C2,p),C3),C0))))),And(NegativeIntegerQ(Times(C1D2,Plus(m,Times(C2,p),C1))),Not(NegativeIntegerQ(Times(C1D2,Plus(m,Negate(C1)))))))))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),n),Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),p)),x),x),And(And(And(FreeQ(List(a,b,c,d,e,m),x),IntegerQ(p)),PositiveIntegerQ(n)),Or(Greater(p,C0),And(And(Less(p,CN1),IntegerQ(m)),Unequal(m,C1)))))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),n),Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),p)),x),x),And(And(And(FreeQ(List(a,b,c,d,e,m),x),IntegerQ(p)),PositiveIntegerQ(n)),Or(Greater(p,C0),And(And(Less(p,CN1),IntegerQ(m)),Unequal(m,C1)))))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Plus(a_,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(Plus(Times(a,Int(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),p)),x)),Times(b,Int(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),p),ArcTanh(Times(c,x))),x))),FreeQ(List(a,b,c,d,e,m,p),x))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Plus(a_,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(Plus(Times(a,Int(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),p)),x)),Times(b,Int(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),p),ArcCoth(Times(c,x))),x))),FreeQ(List(a,b,c,d,e,m,p),x))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition($(Defer($s("Int")),Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),n)),x),FreeQ(List(a,b,c,d,e,m,n,p),x))),
ISetDelayed(Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition($(Defer($s("Int")),Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),n)),x),FreeQ(List(a,b,c,d,e,m,n,p),x))),
ISetDelayed(Int(Times(ArcTanh(u_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Times(C1D2,Int(Times(Log(Plus(C1,u)),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),n),Power(Plus(d,Times(e,Sqr(x))),-1)),x)),Times(CN1,C1D2,Int(Times(Log(Plus(C1,Negate(u))),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),n),Power(Plus(d,Times(e,Sqr(x))),-1)),x))),And(And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))),RationalQ(n)),Greater(n,C0)),ZeroQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(c,x)),-1)))))))))),
ISetDelayed(Int(Times(ArcCoth(u_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Times(C1D2,Int(Times(Log(SimplifyIntegrand(Plus(C1,Power(u,-1)),x)),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),n),Power(Plus(d,Times(e,Sqr(x))),-1)),x)),Times(CN1,C1D2,Int(Times(Log(SimplifyIntegrand(Plus(C1,Negate(Power(u,-1))),x)),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),n),Power(Plus(d,Times(e,Sqr(x))),-1)),x))),And(And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))),RationalQ(n)),Greater(n,C0)),ZeroQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(c,x)),-1)))))))))),
ISetDelayed(Int(Times(ArcTanh(u_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Times(C1D2,Int(Times(Log(Plus(C1,u)),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),n),Power(Plus(d,Times(e,Sqr(x))),-1)),x)),Times(CN1,C1D2,Int(Times(Log(Plus(C1,Negate(u))),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),n),Power(Plus(d,Times(e,Sqr(x))),-1)),x))),And(And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))),RationalQ(n)),Greater(n,C0)),ZeroQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(CN1,c,x)),-1)))))))))),
ISetDelayed(Int(Times(ArcCoth(u_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Times(C1D2,Int(Times(Log(SimplifyIntegrand(Plus(C1,Power(u,-1)),x)),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),n),Power(Plus(d,Times(e,Sqr(x))),-1)),x)),Times(CN1,C1D2,Int(Times(Log(SimplifyIntegrand(Plus(C1,Negate(Power(u,-1))),x)),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),n),Power(Plus(d,Times(e,Sqr(x))),-1)),x))),And(And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))),RationalQ(n)),Greater(n,C0)),ZeroQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(CN1,c,x)),-1)))))))))),
ISetDelayed(Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),n_DEFAULT),Log(u_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),n),PolyLog(C2,Together(Plus(C1,Negate(u)))),Power(Times(C2,c,d),-1)),Times(CN1,b,C1D2,n,Int(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(n,Negate(C1))),PolyLog(C2,Together(Plus(C1,Negate(u)))),Power(Plus(d,Times(e,Sqr(x))),-1)),x))),And(And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))),RationalQ(n)),Greater(n,C0)),ZeroQ(Plus(Sqr(Plus(C1,Negate(u))),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(c,x)),-1)))))))))),
ISetDelayed(Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),n_DEFAULT),Log(u_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),n),PolyLog(C2,Together(Plus(C1,Negate(u)))),Power(Times(C2,c,d),-1)),Times(CN1,b,C1D2,n,Int(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(n,Negate(C1))),PolyLog(C2,Together(Plus(C1,Negate(u)))),Power(Plus(d,Times(e,Sqr(x))),-1)),x))),And(And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))),RationalQ(n)),Greater(n,C0)),ZeroQ(Plus(Sqr(Plus(C1,Negate(u))),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(c,x)),-1)))))))))),
ISetDelayed(Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),n_DEFAULT),Log(u_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Times(CN1,Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),n),PolyLog(C2,Together(Plus(C1,Negate(u)))),Power(Times(C2,c,d),-1)),Times(b,C1D2,n,Int(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(n,Negate(C1))),PolyLog(C2,Together(Plus(C1,Negate(u)))),Power(Plus(d,Times(e,Sqr(x))),-1)),x))),And(And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))),RationalQ(n)),Greater(n,C0)),ZeroQ(Plus(Sqr(Plus(C1,Negate(u))),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(CN1,c,x)),-1)))))))))),
ISetDelayed(Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),n_DEFAULT),Log(u_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Times(CN1,Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),n),PolyLog(C2,Together(Plus(C1,Negate(u)))),Power(Times(C2,c,d),-1)),Times(b,C1D2,n,Int(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(n,Negate(C1))),PolyLog(C2,Together(Plus(C1,Negate(u)))),Power(Plus(d,Times(e,Sqr(x))),-1)),x))),And(And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))),RationalQ(n)),Greater(n,C0)),ZeroQ(Plus(Sqr(Plus(C1,Negate(u))),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(CN1,c,x)),-1)))))))))),
ISetDelayed(Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),n_DEFAULT),PolyLog(p_,u_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Times(CN1,Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),n),PolyLog(Plus(p,C1),u),Power(Times(C2,c,d),-1)),Times(b,C1D2,n,Int(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(n,Negate(C1))),PolyLog(Plus(p,C1),u),Power(Plus(d,Times(e,Sqr(x))),-1)),x))),And(And(And(And(FreeQ(List(a,b,c,d,e,p),x),ZeroQ(Plus(Times(Sqr(c),d),e))),RationalQ(n)),Greater(n,C0)),ZeroQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(c,x)),-1)))))))))),
ISetDelayed(Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),n_DEFAULT),PolyLog(p_,u_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Times(CN1,Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),n),PolyLog(Plus(p,C1),u),Power(Times(C2,c,d),-1)),Times(b,C1D2,n,Int(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(n,Negate(C1))),PolyLog(Plus(p,C1),u),Power(Plus(d,Times(e,Sqr(x))),-1)),x))),And(And(And(And(FreeQ(List(a,b,c,d,e,p),x),ZeroQ(Plus(Times(Sqr(c),d),e))),RationalQ(n)),Greater(n,C0)),ZeroQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(c,x)),-1)))))))))),
ISetDelayed(Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),n_DEFAULT),PolyLog(p_,u_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),n),PolyLog(Plus(p,C1),u),Power(Times(C2,c,d),-1)),Times(CN1,b,C1D2,n,Int(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(n,Negate(C1))),PolyLog(Plus(p,C1),u),Power(Plus(d,Times(e,Sqr(x))),-1)),x))),And(And(And(And(FreeQ(List(a,b,c,d,e,p),x),ZeroQ(Plus(Times(Sqr(c),d),e))),RationalQ(n)),Greater(n,C0)),ZeroQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(CN1,c,x)),-1)))))))))),
ISetDelayed(Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),n_DEFAULT),PolyLog(p_,u_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),n),PolyLog(Plus(p,C1),u),Power(Times(C2,c,d),-1)),Times(CN1,b,C1D2,n,Int(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(n,Negate(C1))),PolyLog(Plus(p,C1),u),Power(Plus(d,Times(e,Sqr(x))),-1)),x))),And(And(And(And(FreeQ(List(a,b,c,d,e,p),x),ZeroQ(Plus(Times(Sqr(c),d),e))),RationalQ(n)),Greater(n,C0)),ZeroQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(CN1,c,x)),-1)))))))))),
ISetDelayed(Int(Power(Times(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),Plus(d_,Times(e_DEFAULT,Sqr(x_))),Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_))))),-1),x_Symbol),
    Condition(Times(Plus(Negate(Log(Plus(a,Times(b,ArcCoth(Times(c,x)))))),Log(Plus(a,Times(b,ArcTanh(Times(c,x)))))),Power(Times(Sqr(b),c,d,Plus(ArcCoth(Times(c,x)),Negate(ArcTanh(Times(c,x))))),-1)),And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))))),
ISetDelayed(Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(m,C1)),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),n),Power(Times(b,c,d,Plus(m,C1)),-1)),Times(CN1,n,Power(Plus(m,C1),-1),Int(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(m,C1)),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(n,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),-1)),x))),And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))),IntegersQ(m,n)),And(Less(C0,n),LessEqual(n,m))))),
ISetDelayed(Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(m,C1)),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),n),Power(Times(b,c,d,Plus(m,C1)),-1)),Times(CN1,n,Power(Plus(m,C1),-1),Int(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(m,C1)),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(n,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),-1)),x))),And(And(And(FreeQ(List(a,b,c,d,e),x),ZeroQ(Plus(Times(Sqr(c),d),e))),IntegersQ(m,n)),Less(Less(C0,n),m)))),
ISetDelayed(Int(Times(ArcTanh(Times(a_DEFAULT,x_)),Power(Plus(c_,Times(d_DEFAULT,Power(x_,n_DEFAULT))),-1)),x_Symbol),
    Condition(Plus(Times(C1D2,Int(Times(Log(Plus(C1,Times(a,x))),Power(Plus(c,Times(d,Power(x,n))),-1)),x)),Times(CN1,C1D2,Int(Times(Log(Plus(C1,Times(CN1,a,x))),Power(Plus(c,Times(d,Power(x,n))),-1)),x))),And(And(FreeQ(List(a,c,d),x),IntegerQ(n)),Not(And(Equal(n,C2),ZeroQ(Plus(Times(Sqr(a),c),d))))))),
ISetDelayed(Int(Times(ArcCoth(Times(a_DEFAULT,x_)),Power(Plus(c_,Times(d_DEFAULT,Power(x_,n_DEFAULT))),-1)),x_Symbol),
    Condition(Plus(Times(C1D2,Int(Times(Log(Plus(C1,Power(Times(a,x),-1))),Power(Plus(c,Times(d,Power(x,n))),-1)),x)),Times(CN1,C1D2,Int(Times(Log(Plus(C1,Negate(Power(Times(a,x),-1)))),Power(Plus(c,Times(d,Power(x,n))),-1)),x))),And(And(FreeQ(List(a,c,d),x),IntegerQ(n)),Not(And(Equal(n,C2),ZeroQ(Plus(Times(Sqr(a),c),d))))))),
ISetDelayed(Int(Times(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),Plus(d_DEFAULT,Times(e_DEFAULT,Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_))))))),x_Symbol),
    Condition(Plus(Times(x,Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x))))))),Times(CN1,C2,e,g,Int(Times(Sqr(x),Plus(a,Times(b,ArcTanh(Times(c,x)))),Power(Plus(f,Times(g,Sqr(x))),-1)),x)),Times(CN1,b,c,Int(Times(x,Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x))),FreeQ(List(a,b,c,d,e,f,g),x))),
ISetDelayed(Int(Times(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),Plus(d_DEFAULT,Times(e_DEFAULT,Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_))))))),x_Symbol),
    Condition(Plus(Times(x,Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x))))))),Times(CN1,C2,e,g,Int(Times(Sqr(x),Plus(a,Times(b,ArcCoth(Times(c,x)))),Power(Plus(f,Times(g,Sqr(x))),-1)),x)),Times(CN1,b,c,Int(Times(x,Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x))),FreeQ(List(a,b,c,d,e,f,g),x))),
ISetDelayed(Int(Times(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),Power(x_,m_DEFAULT),Plus(d_DEFAULT,Times(e_DEFAULT,Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_))))))),x_Symbol),
    Condition(Plus(Times(Power(x,Plus(m,C1)),Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Power(Plus(m,C1),-1)),Times(CN1,C2,e,g,Power(Plus(m,C1),-1),Int(Times(Power(x,Plus(m,C2)),Plus(a,Times(b,ArcTanh(Times(c,x)))),Power(Plus(f,Times(g,Sqr(x))),-1)),x)),Times(CN1,b,c,Power(Plus(m,C1),-1),Int(Times(Power(x,Plus(m,C1)),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x))),And(FreeQ(List(a,b,c,d,e,f,g),x),NegativeIntegerQ(Times(C1D2,m))))),
ISetDelayed(Int(Times(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),Power(x_,m_DEFAULT),Plus(d_DEFAULT,Times(e_DEFAULT,Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_))))))),x_Symbol),
    Condition(Plus(Times(Power(x,Plus(m,C1)),Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Power(Plus(m,C1),-1)),Times(CN1,C2,e,g,Power(Plus(m,C1),-1),Int(Times(Power(x,Plus(m,C2)),Plus(a,Times(b,ArcCoth(Times(c,x)))),Power(Plus(f,Times(g,Sqr(x))),-1)),x)),Times(CN1,b,c,Power(Plus(m,C1),-1),Int(Times(Power(x,Plus(m,C1)),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x))),And(FreeQ(List(a,b,c,d,e,f,g),x),NegativeIntegerQ(Times(C1D2,m))))),
ISetDelayed(Int(Times(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),Power(x_,m_DEFAULT),Plus(d_DEFAULT,Times(e_DEFAULT,Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_))))))),x_Symbol),
    Condition(Module(List(Set(u,Block(List(Set($s("§showsteps"),False),Set($s("§stepcounter"),Null)),Int(Times(Power(x,m),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x))))))),x)))),Plus(Dist(Plus(a,Times(b,ArcTanh(Times(c,x)))),u,x),Times(CN1,b,c,Int(ExpandIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x),x)))),And(FreeQ(List(a,b,c,d,e,f,g),x),PositiveIntegerQ(Times(C1D2,Plus(m,C1)))))),
ISetDelayed(Int(Times(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),Power(x_,m_DEFAULT),Plus(d_DEFAULT,Times(e_DEFAULT,Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_))))))),x_Symbol),
    Condition(Module(List(Set(u,Block(List(Set($s("§showsteps"),False),Set($s("§stepcounter"),Null)),Int(Times(Power(x,m),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x))))))),x)))),Plus(Dist(Plus(a,Times(b,ArcCoth(Times(c,x)))),u,x),Times(CN1,b,c,Int(ExpandIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x),x)))),And(FreeQ(List(a,b,c,d,e,f,g),x),PositiveIntegerQ(Times(C1D2,Plus(m,C1)))))),
ISetDelayed(Int(Times(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_)))),Power(x_,m_DEFAULT),Plus(d_DEFAULT,Times(e_DEFAULT,Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_))))))),x_Symbol),
    Condition(Module(List(Set(u,Block(List(Set($s("§showsteps"),False),Set($s("§stepcounter"),Null)),Int(Times(Power(x,m),Plus(a,Times(b,ArcTanh(Times(c,x))))),x)))),Plus(Dist(Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),u,x),Times(CN1,C2,e,g,Int(ExpandIntegrand(Times(x,u,Power(Plus(f,Times(g,Sqr(x))),-1)),x),x)))),And(And(FreeQ(List(a,b,c,d,e,f,g),x),IntegerQ(m)),Unequal(m,CN1)))),
ISetDelayed(Int(Times(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_)))),Power(x_,m_DEFAULT),Plus(d_DEFAULT,Times(e_DEFAULT,Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_))))))),x_Symbol),
    Condition(Module(List(Set(u,Block(List(Set($s("§showsteps"),False),Set($s("§stepcounter"),Null)),Int(Times(Power(x,m),Plus(a,Times(b,ArcCoth(Times(c,x))))),x)))),Plus(Dist(Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),u,x),Times(CN1,C2,e,g,Int(ExpandIntegrand(Times(x,u,Power(Plus(f,Times(g,Sqr(x))),-1)),x),x)))),And(And(FreeQ(List(a,b,c,d,e,f,g),x),IntegerQ(m)),Unequal(m,CN1)))),
ISetDelayed(Int(Times(x_,Sqr(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Times(c_DEFAULT,x_))))),Plus(d_DEFAULT,Times(e_DEFAULT,Log(Plus(f_,Times(g_DEFAULT,Sqr(x_))))))),x_Symbol),
    Condition(Plus(Times(Plus(f,Times(g,Sqr(x))),Sqr(Plus(a,Times(b,ArcTanh(Times(c,x))))),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Power(Times(C2,g),-1)),Times(CN1,e,Sqr(x),C1D2,Sqr(Plus(a,Times(b,ArcTanh(Times(c,x)))))),Times(b,Power(c,-1),Int(Times(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x))))))),x)),Times(b,c,e,Int(Times(Sqr(x),Plus(a,Times(b,ArcTanh(Times(c,x)))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x))),And(FreeQ(List(a,b,c,d,e,f,g),x),ZeroQ(Plus(Times(Sqr(c),f),g))))),
ISetDelayed(Int(Times(x_,Sqr(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Times(c_DEFAULT,x_))))),Plus(d_DEFAULT,Times(e_DEFAULT,Log(Plus(f_,Times(g_DEFAULT,Sqr(x_))))))),x_Symbol),
    Condition(Plus(Times(Plus(f,Times(g,Sqr(x))),Sqr(Plus(a,Times(b,ArcCoth(Times(c,x))))),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Power(Times(C2,g),-1)),Times(CN1,e,Sqr(x),C1D2,Sqr(Plus(a,Times(b,ArcCoth(Times(c,x)))))),Times(b,Power(c,-1),Int(Times(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x))))))),x)),Times(b,c,e,Int(Times(Sqr(x),Plus(a,Times(b,ArcCoth(Times(c,x)))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x))),And(FreeQ(List(a,b,c,d,e,f,g),x),ZeroQ(Plus(Times(Sqr(c),f),g))))),
ISetDelayed(Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Plus(c_,Times(d_DEFAULT,x_))))),n_DEFAULT),x_Symbol),
    Condition(Times(Power(d,-1),Subst(Int(Power(Plus(a,Times(b,ArcTanh(x))),n),x),x,Plus(c,Times(d,x)))),And(FreeQ(List(a,b,c,d),x),PositiveIntegerQ(n)))),
ISetDelayed(Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Plus(c_,Times(d_DEFAULT,x_))))),n_DEFAULT),x_Symbol),
    Condition(Times(Power(d,-1),Subst(Int(Power(Plus(a,Times(b,ArcCoth(x))),n),x),x,Plus(c,Times(d,x)))),And(FreeQ(List(a,b,c,d),x),PositiveIntegerQ(n)))),
ISetDelayed(Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Plus(c_,Times(d_DEFAULT,x_))))),n_),x_Symbol),
    Condition($(Defer($s("Int")),Power(Plus(a,Times(b,ArcTanh(Plus(c,Times(d,x))))),n),x),And(FreeQ(List(a,b,c,d,n),x),Not(PositiveIntegerQ(n))))),
ISetDelayed(Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Plus(c_,Times(d_DEFAULT,x_))))),n_),x_Symbol),
    Condition($(Defer($s("Int")),Power(Plus(a,Times(b,ArcCoth(Plus(c,Times(d,x))))),n),x),And(FreeQ(List(a,b,c,d,n),x),Not(PositiveIntegerQ(n))))),
ISetDelayed(Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Plus(c_,Times(d_DEFAULT,x_))))),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Times(Power(d,-1),Subst(Int(Times(Power(Plus(Times(Plus(Times(d,e),Times(CN1,c,f)),Power(d,-1)),Times(f,x,Power(d,-1))),m),Power(Plus(a,Times(b,ArcTanh(x))),n)),x),x,Plus(c,Times(d,x)))),And(FreeQ(List(a,b,c,d,e,f,m,n),x),PositiveIntegerQ(n)))),
ISetDelayed(Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Plus(c_,Times(d_DEFAULT,x_))))),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Times(Power(d,-1),Subst(Int(Times(Power(Plus(Times(Plus(Times(d,e),Times(CN1,c,f)),Power(d,-1)),Times(f,x,Power(d,-1))),m),Power(Plus(a,Times(b,ArcCoth(x))),n)),x),x,Plus(c,Times(d,x)))),And(FreeQ(List(a,b,c,d,e,f,m,n),x),PositiveIntegerQ(n)))),
ISetDelayed(Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Plus(c_,Times(d_DEFAULT,x_))))),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_)),x_Symbol),
    Condition($(Defer($s("Int")),Times(Power(Plus(e,Times(f,x)),m),Power(Plus(a,Times(b,ArcTanh(Plus(c,Times(d,x))))),n)),x),And(FreeQ(List(a,b,c,d,e,f,m,n),x),Not(PositiveIntegerQ(n))))),
ISetDelayed(Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Plus(c_,Times(d_DEFAULT,x_))))),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_)),x_Symbol),
    Condition($(Defer($s("Int")),Times(Power(Plus(e,Times(f,x)),m),Power(Plus(a,Times(b,ArcCoth(Plus(c,Times(d,x))))),n)),x),And(FreeQ(List(a,b,c,d,e,f,m,n),x),Not(PositiveIntegerQ(n))))),
ISetDelayed(Int(Times(Power(Plus($p("A",true),Times($p("B",true),x_),Times($p("C",true),Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Plus(c_,Times(d_DEFAULT,x_))))),n_DEFAULT)),x_Symbol),
    Condition(Times(Power(d,-1),Subst(Int(Times(Power(Plus(Times(CN1,$s("C"),Power(d,-2)),Times($s("C"),Power(d,-2),Sqr(x))),p),Power(Plus(a,Times(b,ArcTanh(x))),n)),x),x,Plus(c,Times(d,x)))),And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),$s("C"),n,p),x),ZeroQ(Plus(Times($s("B"),Plus(C1,Negate(Sqr(c)))),Times(C2,$s("A"),c,d)))),ZeroQ(Plus(Times(C2,c,$s("C")),Times(CN1,$s("B"),d)))))),
ISetDelayed(Int(Times(Power(Plus($p("A",true),Times($p("B",true),x_),Times($p("C",true),Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Plus(c_,Times(d_DEFAULT,x_))))),n_DEFAULT)),x_Symbol),
    Condition(Times(Power(d,-1),Subst(Int(Times(Power(Plus(Times($s("C"),Power(d,-2)),Times($s("C"),Power(d,-2),Sqr(x))),p),Power(Plus(a,Times(b,ArcCoth(x))),n)),x),x,Plus(c,Times(d,x)))),And(And(FreeQ(List(a,b,c,d,$s("A"),$s("B"),$s("C"),n,p),x),ZeroQ(Plus(Times($s("B"),Plus(C1,Negate(Sqr(c)))),Times(C2,$s("A"),c,d)))),ZeroQ(Plus(Times(C2,c,$s("C")),Times(CN1,$s("B"),d)))))),
ISetDelayed(Int(Times(Power(Plus($p("A",true),Times($p("B",true),x_),Times($p("C",true),Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcTanh(Plus(c_,Times(d_DEFAULT,x_))))),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Times(Power(d,-1),Subst(Int(Times(Power(Plus(Times(Plus(Times(d,e),Times(CN1,c,f)),Power(d,-1)),Times(f,x,Power(d,-1))),m),Power(Plus(Times(CN1,$s("C"),Power(d,-2)),Times($s("C"),Power(d,-2),Sqr(x))),p),Power(Plus(a,Times(b,ArcTanh(x))),n)),x),x,Plus(c,Times(d,x)))),And(And(FreeQ(List(a,b,c,d,e,f,$s("A"),$s("B"),$s("C"),m,n,p),x),ZeroQ(Plus(Times($s("B"),Plus(C1,Negate(Sqr(c)))),Times(C2,$s("A"),c,d)))),ZeroQ(Plus(Times(C2,c,$s("C")),Times(CN1,$s("B"),d)))))),
ISetDelayed(Int(Times(Power(Plus($p("A",true),Times($p("B",true),x_),Times($p("C",true),Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCoth(Plus(c_,Times(d_DEFAULT,x_))))),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Times(Power(d,-1),Subst(Int(Times(Power(Plus(Times(Plus(Times(d,e),Times(CN1,c,f)),Power(d,-1)),Times(f,x,Power(d,-1))),m),Power(Plus(Times(CN1,$s("C"),Power(d,-2)),Times($s("C"),Power(d,-2),Sqr(x))),p),Power(Plus(a,Times(b,ArcCoth(x))),n)),x),x,Plus(c,Times(d,x)))),And(And(FreeQ(List(a,b,c,d,e,f,$s("A"),$s("B"),$s("C"),m,n,p),x),ZeroQ(Plus(Times($s("B"),Plus(C1,Negate(Sqr(c)))),Times(C2,$s("A"),c,d)))),ZeroQ(Plus(Times(C2,c,$s("C")),Times(CN1,$s("B"),d))))))
  );
}
