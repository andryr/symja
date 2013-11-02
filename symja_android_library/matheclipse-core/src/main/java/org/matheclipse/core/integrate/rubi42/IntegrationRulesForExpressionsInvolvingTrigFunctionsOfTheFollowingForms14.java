package org.matheclipse.core.integrate.rubi42;


import static org.matheclipse.core.expression.F.*;
import static org.matheclipse.core.integrate.rubi42.UtilityFunctionCtors.*;
import static org.matheclipse.core.integrate.rubi42.UtilityFunctions.*;

import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;
/** 
 * IntegrationRules rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntegrationRulesForExpressionsInvolvingTrigFunctionsOfTheFollowingForms14 { 
  public static IAST RULES = List( 
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m,true))),$p(x,SymbolHead)),
    Condition(Module(List(Set(e,FreeFactors(Sin(Plus(c,Times(d,x))),x))),Times(e,Power(d,CN1),Subst(Int(Times(Power(Plus(C1,Times(CN1,Power(e,C2),Power(x,C2))),Times(C1D2,Plus(m,Times(CN1,C1)))),Power(Plus(a,Times(b,e,x)),n)),x),x,Times(Sin(Plus(c,Times(d,x))),Power(e,CN1))))),And(FreeQ(List(a,b,c,d,n),x),OddQ(m)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m,true))),$p(x,SymbolHead)),
    Condition(Module(List(Set(e,FreeFactors(Cos(Plus(c,Times(d,x))),x))),Times(CN1,e,Power(d,CN1),Subst(Int(Times(Power(Plus(C1,Times(CN1,Power(e,C2),Power(x,C2))),Times(C1D2,Plus(m,Times(CN1,C1)))),Power(Plus(a,Times(b,e,x)),n)),x),x,Times(Cos(Plus(c,Times(d,x))),Power(e,CN1))))),And(FreeQ(List(a,b,c,d,n),x),OddQ(m)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m,true))),$p(x,SymbolHead)),
    Condition(Times(b,Power(Cos(Plus(c,Times(d,x))),Plus(m,C1)),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),n),Power(Times(a,d,n),CN1)),And(And(FreeQ(List(a,b,c,d,m,n),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),ZeroQ(Plus(m,n,C1))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n,true)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m,true))),$p(x,SymbolHead)),
    Condition(Times(CN1,b,Power(Sin(Plus(c,Times(d,x))),Plus(m,C1)),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),n),Power(Times(a,d,n),CN1)),And(And(FreeQ(List(a,b,c,d,m,n),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),ZeroQ(Plus(m,n,C1))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Times(b,Power(Cos(Plus(c,Times(d,x))),Plus(m,C1)),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C1))),Power(Times(d,Plus(n,Times(CN1,C1))),CN1)),And(And(And(FreeQ(List(a,b,c,d,m,n),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),ZeroQ(Plus(m,Times(C2,n),Times(CN1,C1)))),NonzeroQ(Plus(n,Times(CN1,C1)))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Times(CN1,b,Power(Sin(Plus(c,Times(d,x))),Plus(m,C1)),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C1))),Power(Times(d,Plus(n,Times(CN1,C1))),CN1)),And(And(And(FreeQ(List(a,b,c,d,m,n),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),ZeroQ(Plus(m,Times(C2,n),Times(CN1,C1)))),NonzeroQ(Plus(n,Times(CN1,C1)))))),
SetDelayed(Int(Times(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),CN1)),$p(x,SymbolHead)),
    Condition(Times(CN1,b,Log(RemoveContent(Plus(a,Times(CN1,b,Sin(Plus(c,Times(d,x))))),x)),Power(d,CN1)),And(FreeQ(List(a,b,c,d),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))))),
SetDelayed(Int(Times(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),CN1)),$p(x,SymbolHead)),
    Condition(Times(b,Log(RemoveContent(Plus(a,Times(CN1,b,Cos(Plus(c,Times(d,x))))),x)),Power(d,CN1)),And(FreeQ(List(a,b,c,d),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))))),
SetDelayed(Int(Times(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m,true))),$p(x,SymbolHead)),
    Condition(Plus(Times(CN1,b,Power(Cos(Plus(c,Times(d,x))),Plus(m,C1)),Power(Times(d,Plus(m,C1)),CN1)),Times(a,Int(Power(Cos(Plus(c,Times(d,x))),m),x))),And(And(FreeQ(List(a,b,c,d,m),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),NonzeroQ(Plus(m,C1))))),
SetDelayed(Int(Times(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m,true))),$p(x,SymbolHead)),
    Condition(Plus(Times(b,Power(Sin(Plus(c,Times(d,x))),Plus(m,C1)),Power(Times(d,Plus(m,C1)),CN1)),Times(a,Int(Power(Sin(Plus(c,Times(d,x))),m),x))),And(And(FreeQ(List(a,b,c,d,m),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),NonzeroQ(Plus(m,C1))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(CN1,b,Power(Cos(Plus(c,Times(d,x))),Plus(m,C1)),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),n),Power(Times(a,d,Plus(m,C1)),CN1)),Times(a,Plus(m,n,C1),Power(Plus(m,C1),CN1),Int(Times(Power(Cos(Plus(c,Times(d,x))),Plus(m,C2)),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C1)))),x))),And(And(And(And(And(FreeQ(List(a,b,c,d),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(m,n)),Less(Less(C0,n),C1)),Less(m,CN1)),NonzeroQ(Plus(m,n,C1))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(b,Power(Sin(Plus(c,Times(d,x))),Plus(m,C1)),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),n),Power(Times(a,d,Plus(m,C1)),CN1)),Times(a,Plus(m,n,C1),Power(Plus(m,C1),CN1),Int(Times(Power(Sin(Plus(c,Times(d,x))),Plus(m,C2)),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C1)))),x))),And(And(And(And(And(FreeQ(List(a,b,c,d),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(m,n)),Less(Less(C0,n),C1)),Less(m,CN1)),NonzeroQ(Plus(m,n,C1))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(CN2,b,Power(Cos(Plus(c,Times(d,x))),Plus(m,C1)),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C1))),Power(Times(d,Plus(m,C1)),CN1)),Times(Power(b,C2),Plus(m,Times(C2,n),Times(CN1,C1)),Power(Plus(m,C1),CN1),Int(Times(Power(Cos(Plus(c,Times(d,x))),Plus(m,C2)),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C2)))),x))),And(And(And(And(And(FreeQ(List(a,b,c,d),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(m,n)),Greater(n,C1)),Less(m,CN1)),NonzeroQ(Plus(m,Times(C2,n),Times(CN1,C1)))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(C2,b,Power(Sin(Plus(c,Times(d,x))),Plus(m,C1)),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C1))),Power(Times(d,Plus(m,C1)),CN1)),Times(Power(b,C2),Plus(m,Times(C2,n),Times(CN1,C1)),Power(Plus(m,C1),CN1),Int(Times(Power(Sin(Plus(c,Times(d,x))),Plus(m,C2)),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C2)))),x))),And(And(And(And(And(FreeQ(List(a,b,c,d),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(m,n)),Greater(n,C1)),Less(m,CN1)),NonzeroQ(Plus(m,Times(C2,n),Times(CN1,C1)))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n,true)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m,true))),$p(x,SymbolHead)),
    Condition(Plus(Times(CN1,b,Power(Cos(Plus(c,Times(d,x))),Plus(m,C1)),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C1))),Power(Times(d,Plus(m,n)),CN1)),Times(a,Plus(m,Times(C2,n),Times(CN1,C1)),Power(Plus(m,n),CN1),Int(Times(Power(Cos(Plus(c,Times(d,x))),m),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C1)))),x))),And(And(And(And(And(FreeQ(List(a,b,c,d,m),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(n)),Greater(n,C0)),Not(And(RationalQ(m),Less(m,CN1)))),NonzeroQ(Plus(m,n))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n,true)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m,true))),$p(x,SymbolHead)),
    Condition(Plus(Times(b,Power(Sin(Plus(c,Times(d,x))),Plus(m,C1)),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C1))),Power(Times(d,Plus(m,n)),CN1)),Times(a,Plus(m,Times(C2,n),Times(CN1,C1)),Power(Plus(m,n),CN1),Int(Times(Power(Sin(Plus(c,Times(d,x))),m),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C1)))),x))),And(And(And(And(And(FreeQ(List(a,b,c,d,m),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(n)),Greater(n,C0)),Not(And(RationalQ(m),Less(m,CN1)))),NonzeroQ(Plus(m,n))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),CN1),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(Power(Cos(Plus(c,Times(d,x))),Plus(m,Times(CN1,C1))),Power(Times(b,d,Plus(m,Times(CN1,C1))),CN1)),Times(Power(a,CN1),Int(Power(Cos(Plus(c,Times(d,x))),Plus(m,Times(CN1,C2))),x))),And(And(FreeQ(List(a,b,c,d,m),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),NonzeroQ(Plus(m,Times(CN1,C1)))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),CN1),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(CN1,Power(Sin(Plus(c,Times(d,x))),Plus(m,Times(CN1,C1))),Power(Times(b,d,Plus(m,Times(CN1,C1))),CN1)),Times(Power(a,CN1),Int(Power(Sin(Plus(c,Times(d,x))),Plus(m,Times(CN1,C2))),x))),And(And(FreeQ(List(a,b,c,d,m),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),NonzeroQ(Plus(m,Times(CN1,C1)))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),CN1D2),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(CN2,b,Power(Cos(Plus(c,Times(d,x))),Plus(m,C1)),Power(Times(d,Plus(Times(C2,m),Times(CN1,C1)),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),QQ(3L,2L))),CN1)),Times(C2,a,Plus(m,Times(CN1,C2)),Power(Plus(Times(C2,m),Times(CN1,C1)),CN1),Int(Times(Power(Cos(Plus(c,Times(d,x))),m),Power(Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),QQ(3L,2L)),CN1)),x))),And(And(And(FreeQ(List(a,b,c,d),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(m)),Greater(m,C2)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),CN1D2),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(C2,b,Power(Sin(Plus(c,Times(d,x))),Plus(m,C1)),Power(Times(d,Plus(Times(C2,m),Times(CN1,C1)),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),QQ(3L,2L))),CN1)),Times(C2,a,Plus(m,Times(CN1,C2)),Power(Plus(Times(C2,m),Times(CN1,C1)),CN1),Int(Times(Power(Sin(Plus(c,Times(d,x))),m),Power(Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),QQ(3L,2L)),CN1)),x))),And(And(And(FreeQ(List(a,b,c,d),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(m)),Greater(m,C2)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),CN1D2),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),CN2)),$p(x,SymbolHead)),
    Condition(Plus(Times(Tan(Plus(c,Times(d,x))),Power(Times(d,Sqrt(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))))),CN1)),Times(C1D2,b,Int(Times(Sin(Plus(c,Times(d,x))),Power(Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),QQ(3L,2L)),CN1)),x))),And(FreeQ(List(a,b,c,d),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),CN1D2),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),CN2)),$p(x,SymbolHead)),
    Condition(Plus(Times(CN1,Cot(Plus(c,Times(d,x))),Power(Times(d,Sqrt(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))))),CN1)),Times(C1D2,b,Int(Times(Cos(Plus(c,Times(d,x))),Power(Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),QQ(3L,2L)),CN1)),x))),And(FreeQ(List(a,b,c,d),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),CN1D2),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(CN1,b,Power(Cos(Plus(c,Times(d,x))),Plus(m,C1)),Power(Times(a,d,Plus(m,C1),Sqrt(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))))),CN1)),Times(a,Plus(Times(C2,m),C1),Power(Times(C2,Plus(m,C1)),CN1),Int(Times(Power(Cos(Plus(c,Times(d,x))),Plus(m,C2)),Power(Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),QQ(3L,2L)),CN1)),x))),And(And(And(FreeQ(List(a,b,c,d),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(m)),Less(m,CN2)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),CN1D2),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(b,Power(Sin(Plus(c,Times(d,x))),Plus(m,C1)),Power(Times(a,d,Plus(m,C1),Sqrt(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))))),CN1)),Times(a,Plus(Times(C2,m),C1),Power(Times(C2,Plus(m,C1)),CN1),Int(Times(Power(Sin(Plus(c,Times(d,x))),Plus(m,C2)),Power(Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),QQ(3L,2L)),CN1)),x))),And(And(And(FreeQ(List(a,b,c,d),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(m)),Less(m,CN2)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(CN1,Power(Cos(Plus(c,Times(d,x))),Plus(m,Times(CN1,C1))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(b,d,Plus(n,C1)),CN1)),Times(C2,Power(a,CN1),Int(Times(Power(Cos(Plus(c,Times(d,x))),Plus(m,Times(CN1,C2))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1))),x))),And(And(And(And(FreeQ(List(a,b,c,d),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(m,n)),Less(n,CN1)),Equal(Plus(m,Times(C2,n),C1),C0)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(Power(Sin(Plus(c,Times(d,x))),Plus(m,Times(CN1,C1))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(b,d,Plus(n,C1)),CN1)),Times(C2,Power(a,CN1),Int(Times(Power(Sin(Plus(c,Times(d,x))),Plus(m,Times(CN1,C2))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,C1))),x))),And(And(And(And(FreeQ(List(a,b,c,d),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(m,n)),Less(n,CN1)),Equal(Plus(m,Times(C2,n),C1),C0)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(C2,Power(Cos(Plus(c,Times(d,x))),Plus(m,Times(CN1,C1))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(b,d,Plus(m,Times(C2,n),C1)),CN1)),Times(Plus(m,Times(CN1,C1)),Power(Times(Power(b,C2),Plus(m,Times(C2,n),C1)),CN1),Int(Times(Power(Cos(Plus(c,Times(d,x))),Plus(m,Times(CN1,C2))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C2))),x))),And(And(And(And(And(FreeQ(List(a,b,c,d),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(m,n)),Less(n,CN1)),Unequal(Plus(m,Times(C2,n),C1),C0)),Greater(m,C1)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(CN2,Power(Sin(Plus(c,Times(d,x))),Plus(m,Times(CN1,C1))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(b,d,Plus(m,Times(C2,n),C1)),CN1)),Times(Plus(m,Times(CN1,C1)),Power(Times(Power(b,C2),Plus(m,Times(C2,n),C1)),CN1),Int(Times(Power(Sin(Plus(c,Times(d,x))),Plus(m,Times(CN1,C2))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,C2))),x))),And(And(And(And(And(FreeQ(List(a,b,c,d),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(m,n)),Less(n,CN1)),Unequal(Plus(m,Times(C2,n),C1),C0)),Greater(m,C1)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m,true))),$p(x,SymbolHead)),
    Condition(Plus(Times(b,Power(Cos(Plus(c,Times(d,x))),Plus(m,C1)),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),n),Power(Times(a,d,Plus(m,Times(C2,n),C1)),CN1)),Times(Plus(m,n,C1),Power(Times(a,Plus(m,Times(C2,n),C1)),CN1),Int(Times(Power(Cos(Plus(c,Times(d,x))),m),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1))),x))),And(And(And(And(And(FreeQ(List(a,b,c,d,m),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(n)),Less(n,CN1)),NonzeroQ(Plus(m,Times(C2,n),C1))),Not(And(RationalQ(m),Greater(m,C1)))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n,true)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m,true))),$p(x,SymbolHead)),
    Condition(Plus(Times(CN1,b,Power(Sin(Plus(c,Times(d,x))),Plus(m,C1)),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),n),Power(Times(a,d,Plus(m,Times(C2,n),C1)),CN1)),Times(Plus(m,n,C1),Power(Times(a,Plus(m,Times(C2,n),C1)),CN1),Int(Times(Power(Sin(Plus(c,Times(d,x))),m),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,C1))),x))),And(And(And(And(And(FreeQ(List(a,b,c,d,m),x),ZeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(n)),Less(n,CN1)),NonzeroQ(Plus(m,Times(C2,n),C1))),Not(And(RationalQ(m),Greater(m,C1)))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n,true)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m,true))),$p(x,SymbolHead)),
    Condition(Int(ExpandTrig(Power(Cos(Plus(c,Times(d,x))),m),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),n),x),x),And(And(FreeQ(List(a,b,c,d,m),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),PositiveIntegerQ(n)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n,true)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m,true))),$p(x,SymbolHead)),
    Condition(Int(ExpandTrig(Power(Sin(Plus(c,Times(d,x))),m),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),n),x),x),And(And(FreeQ(List(a,b,c,d,m),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),PositiveIntegerQ(n)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),C4)),$p(x,SymbolHead)),
    Condition(Plus(Times(Plus(Power(a,C2),Times(CN1,Power(b,C2))),Cos(Plus(c,Times(d,x))),Sin(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(a,Power(b,C2),d,Plus(n,C1)),CN1)),Times(CN1,Cos(Plus(c,Times(d,x))),Sin(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C2)),Power(Times(Power(b,C2),d,Plus(n,C4)),CN1)),Times(CN1,Power(Times(a,Power(b,C2),Plus(n,C1),Plus(n,C4)),CN1),Int(Times(Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1)),Simp(Plus(Times(C3,Power(a,C2)),Times(CN1,Power(b,C2),Plus(n,C2),Plus(n,C4)),Times(a,b,Plus(n,C1),Sin(Plus(c,Times(d,x)))),Times(CN1,Plus(Times(ZZ(6L),Power(a,C2)),Times(CN1,Power(b,C2),Plus(n,C3),Plus(n,C4))),Power(Sin(Plus(c,Times(d,x))),C2))),x)),x))),And(And(And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(n)),And(LessEqual(CN2,n),Less(n,CN1))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),C4)),$p(x,SymbolHead)),
    Condition(Plus(Times(CN1,Plus(Power(a,C2),Times(CN1,Power(b,C2))),Sin(Plus(c,Times(d,x))),Cos(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(a,Power(b,C2),d,Plus(n,C1)),CN1)),Times(Sin(Plus(c,Times(d,x))),Cos(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,C2)),Power(Times(Power(b,C2),d,Plus(n,C4)),CN1)),Times(CN1,Power(Times(a,Power(b,C2),Plus(n,C1),Plus(n,C4)),CN1),Int(Times(Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,C1)),Simp(Plus(Times(C3,Power(a,C2)),Times(CN1,Power(b,C2),Plus(n,C2),Plus(n,C4)),Times(a,b,Plus(n,C1),Cos(Plus(c,Times(d,x)))),Times(CN1,Plus(Times(ZZ(6L),Power(a,C2)),Times(CN1,Power(b,C2),Plus(n,C3),Plus(n,C4))),Power(Cos(Plus(c,Times(d,x))),C2))),x)),x))),And(And(And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(n)),And(LessEqual(CN2,n),Less(n,CN1))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),C4)),$p(x,SymbolHead)),
    Condition(Plus(Times(Plus(Power(a,C2),Times(CN1,Power(b,C2))),Cos(Plus(c,Times(d,x))),Sin(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(a,Power(b,C2),d,Plus(n,C1)),CN1)),Times(CN1,Plus(Times(Power(a,C2),Plus(n,Times(CN1,C1))),Times(Power(b,C2),Plus(n,C2))),Cos(Plus(c,Times(d,x))),Sin(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C2)),Power(Times(Power(a,C2),Power(b,C2),d,Plus(n,C1),Plus(n,C2)),CN1)),Times(CN1,Power(Times(Power(a,C2),Power(b,C2),Plus(n,C1),Plus(n,C2)),CN1),Int(Times(Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C2)),Simp(Plus(Times(C3,Power(a,C2)),Times(CN1,Power(b,C2),Plus(n,C2),Plus(n,C3)),Times(a,b,Plus(n,C2),Sin(Plus(c,Times(d,x)))),Times(CN1,Plus(Times(ZZ(6L),Power(a,C2)),Times(CN1,Power(b,C2),Plus(n,C2),Plus(n,C4))),Power(Sin(Plus(c,Times(d,x))),C2))),x)),x))),And(And(And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(n)),Less(n,CN2)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),C4)),$p(x,SymbolHead)),
    Condition(Plus(Times(CN1,Plus(Power(a,C2),Times(CN1,Power(b,C2))),Sin(Plus(c,Times(d,x))),Cos(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(a,Power(b,C2),d,Plus(n,C1)),CN1)),Times(Plus(Times(Power(a,C2),Plus(n,Times(CN1,C1))),Times(Power(b,C2),Plus(n,C2))),Sin(Plus(c,Times(d,x))),Cos(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,C2)),Power(Times(Power(a,C2),Power(b,C2),d,Plus(n,C1),Plus(n,C2)),CN1)),Times(CN1,Power(Times(Power(a,C2),Power(b,C2),Plus(n,C1),Plus(n,C2)),CN1),Int(Times(Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,C2)),Simp(Plus(Times(C3,Power(a,C2)),Times(CN1,Power(b,C2),Plus(n,C2),Plus(n,C3)),Times(a,b,Plus(n,C2),Cos(Plus(c,Times(d,x)))),Times(CN1,Plus(Times(ZZ(6L),Power(a,C2)),Times(CN1,Power(b,C2),Plus(n,C2),Plus(n,C4))),Power(Cos(Plus(c,Times(d,x))),C2))),x)),x))),And(And(And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(n)),Less(n,CN2)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),C4)),$p(x,SymbolHead)),
    Condition(Plus(Times(C3,a,Cos(Plus(c,Times(d,x))),Sin(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(Power(b,C2),d,Plus(n,C3),Plus(n,C4)),CN1)),Times(CN1,Cos(Plus(c,Times(d,x))),Power(Sin(Plus(c,Times(d,x))),C2),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(b,d,Plus(n,C4)),CN1)),Times(CN1,Power(Times(Power(b,C2),Plus(n,C3),Plus(n,C4)),CN1),Int(Times(Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),n),Simp(Plus(Times(C3,Power(a,C2)),Times(CN1,Power(b,C2),Plus(n,C3),Plus(n,C4)),Times(a,b,n,Sin(Plus(c,Times(d,x)))),Times(CN1,Plus(Times(ZZ(6L),Power(a,C2)),Times(CN1,Power(b,C2),Plus(n,C3),Plus(n,C5))),Power(Sin(Plus(c,Times(d,x))),C2))),x)),x))),And(And(FreeQ(List(a,b,c,d,n),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),Not(And(RationalQ(n),Less(n,CN1)))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),C4)),$p(x,SymbolHead)),
    Condition(Plus(Times(CN3,a,Sin(Plus(c,Times(d,x))),Cos(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(Power(b,C2),d,Plus(n,C3),Plus(n,C4)),CN1)),Times(Sin(Plus(c,Times(d,x))),Power(Cos(Plus(c,Times(d,x))),C2),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(b,d,Plus(n,C4)),CN1)),Times(CN1,Power(Times(Power(b,C2),Plus(n,C3),Plus(n,C4)),CN1),Int(Times(Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),n),Simp(Plus(Times(C3,Power(a,C2)),Times(CN1,Power(b,C2),Plus(n,C3),Plus(n,C4)),Times(a,b,n,Cos(Plus(c,Times(d,x)))),Times(CN1,Plus(Times(ZZ(6L),Power(a,C2)),Times(CN1,Power(b,C2),Plus(n,C3),Plus(n,C5))),Power(Cos(Plus(c,Times(d,x))),C2))),x)),x))),And(And(FreeQ(List(a,b,c,d,n),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),Not(And(RationalQ(n),Less(n,CN1)))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(Power(Cos(Plus(c,Times(d,x))),Plus(m,Times(CN1,C1))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(b,d,Plus(n,C1)),CN1)),Times(Plus(m,Times(CN1,C1)),Power(Times(b,Plus(n,C1)),CN1),Int(Times(Power(Cos(Plus(c,Times(d,x))),Plus(m,Times(CN1,C2))),Sin(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1))),x))),And(And(And(And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),NonzeroQ(Plus(n,C1))),PositiveIntegerQ(m)),LessEqual(m,C4)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(CN1,Power(Sin(Plus(c,Times(d,x))),Plus(m,Times(CN1,C1))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(b,d,Plus(n,C1)),CN1)),Times(Plus(m,Times(CN1,C1)),Power(Times(b,Plus(n,C1)),CN1),Int(Times(Power(Sin(Plus(c,Times(d,x))),Plus(m,Times(CN1,C2))),Cos(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,C1))),x))),And(And(And(And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),NonzeroQ(Plus(n,C1))),PositiveIntegerQ(m)),LessEqual(m,C4)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n,true)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Int(ExpandTrig(Times(Power(Plus(C1,Times(CN1,Power($($s("§sin"),Plus(c,Times(d,x))),C2))),Times(C1D2,m)),Power(Plus(a,Times(b,$($s("§sin"),Plus(c,Times(d,x))))),n)),x),x),And(And(And(And(And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),EvenQ(m)),Greater(m,C2)),IntegerQ(n)),Less(n,CN1)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n,true)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Int(ExpandTrig(Times(Power(Plus(C1,Times(CN1,Power($($s("§cos"),Plus(c,Times(d,x))),C2))),Times(C1D2,m)),Power(Plus(a,Times(b,$($s("§cos"),Plus(c,Times(d,x))))),n)),x),x),And(And(And(And(And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),EvenQ(m)),Greater(m,C2)),IntegerQ(n)),Less(n,CN1)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n,true)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),CN2)),$p(x,SymbolHead)),
    Condition(Plus(Times(Tan(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),n),Power(d,CN1)),Times(CN1,b,n,Int(Times(Sin(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C1)))),x))),And(And(FreeQ(List(a,b,c,d,n),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),NonzeroQ(Plus(n,C1))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n,true)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),CN2)),$p(x,SymbolHead)),
    Condition(Plus(Times(CN1,Cot(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),n),Power(d,CN1)),Times(CN1,b,n,Int(Times(Cos(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C1)))),x))),And(And(FreeQ(List(a,b,c,d,n),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),NonzeroQ(Plus(n,C1))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Int(ExpandIntegrand(Times(Power(Plus(C1,Times(CN1,Power(Sin(Plus(c,Times(d,x))),C2))),Times(C1D2,m)),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),n)),x),x),And(And(And(And(And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),EvenQ(m)),Less(m,CN2)),IntegerQ(n)),Less(n,CN1)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Int(ExpandIntegrand(Times(Power(Plus(C1,Times(CN1,Power(Cos(Plus(c,Times(d,x))),C2))),Times(C1D2,m)),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),n)),x),x),And(And(And(And(And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),EvenQ(m)),Less(m,CN2)),IntegerQ(n)),Less(n,CN1)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(CN1,Plus(Power(a,C2),Times(CN1,Power(b,C2))),Int(Times(Power(Cos(Plus(c,Times(d,x))),m),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C2)))),x)),Times(C2,a,Int(Times(Power(Cos(Plus(c,Times(d,x))),m),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C1)))),x)),Times(CN1,Power(b,C2),Int(Times(Power(Cos(Plus(c,Times(d,x))),Plus(m,C2)),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C2)))),x))),And(And(And(And(FreeQ(List(a,b,c,d),x),RationalQ(m,n)),Greater(n,C1)),Less(m,CN1)),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),$p(n)),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(CN1,Plus(Power(a,C2),Times(CN1,Power(b,C2))),Int(Times(Power(Cos(Plus(c,Times(d,x))),m),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C2)))),x)),Times(C2,a,Int(Times(Power(Cos(Plus(c,Times(d,x))),m),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C1)))),x)),Times(CN1,Power(b,C2),Int(Times(Power(Cos(Plus(c,Times(d,x))),Plus(m,C2)),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Times(CN1,C2)))),x))),And(And(And(And(FreeQ(List(a,b,c,d),x),RationalQ(m,n)),Greater(n,C1)),Less(m,CN1)),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),CN1),Power($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(Power(Cos(Plus(c,Times(d,x))),Plus(m,Times(CN1,C1))),Power(Times(b,d,Plus(m,Times(CN1,C1))),CN1)),Times(a,Power(Power(b,C2),CN1),Int(Power(Cos(Plus(c,Times(d,x))),Plus(m,Times(CN1,C2))),x)),Times(CN1,Plus(Power(a,C2),Times(CN1,Power(b,C2))),Power(Power(b,C2),CN1),Int(Times(Power(Cos(Plus(c,Times(d,x))),Plus(m,Times(CN1,C2))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),CN1)),x))),And(And(And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(m)),Greater(m,C1)))),
SetDelayed(Int(Times(Power(Plus(Times($($s("§cos"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(b,true)),$p(a)),CN1),Power($($s("§sin"),Plus(Times($p(d,true),$p(x)),$p(c,true))),$p(m))),$p(x,SymbolHead)),
    Condition(Plus(Times(CN1,Power(Sin(Plus(c,Times(d,x))),Plus(m,Times(CN1,C1))),Power(Times(b,d,Plus(m,Times(CN1,C1))),CN1)),Times(a,Power(Power(b,C2),CN1),Int(Power(Sin(Plus(c,Times(d,x))),Plus(m,Times(CN1,C2))),x)),Times(CN1,Plus(Power(a,C2),Times(CN1,Power(b,C2))),Power(Power(b,C2),CN1),Int(Times(Power(Sin(Plus(c,Times(d,x))),Plus(m,Times(CN1,C2))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),CN1)),x))),And(And(And(FreeQ(List(a,b,c,d),x),NonzeroQ(Plus(Power(a,C2),Times(CN1,Power(b,C2))))),RationalQ(m)),Greater(m,C1))))
  );
}