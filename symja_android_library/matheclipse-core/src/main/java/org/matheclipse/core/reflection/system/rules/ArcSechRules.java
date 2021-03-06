package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.IAST;

/**
 * Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.<br />
 * See GIT repository at: <a href="https://bitbucket.org/axelclk/symja_android_library">https://bitbucket.org/axelclk/symja_android_library under the tools directory</a>.
 */
public interface ArcSechRules {
  /**
   * <ul>
   * <li>index 0 - number of equal rules in <code>RULES</code></li>
	 * </ul>
	 */
  final public static int[] SIZES = { 20, 0 };

  final public static IAST RULES = List(
    IInit(ArcSech, SIZES),
    ISet(ArcSech(C0),
      CInfinity),
    ISet(ArcSech(C1),
      C0),
    ISet(ArcSech(CN1),
      Times(CI,Pi)),
    ISet(ArcSech(Times(C2,C1DSqrt3)),
      Times(CC(0L,1L,1L,6L),Pi)),
    ISet(ArcSech(Times(CN2,C1DSqrt3)),
      Times(CC(0L,1L,5L,6L),Pi)),
    ISet(ArcSech(Plus(CN1,CSqrt5)),
      Times(CC(0L,1L,1L,5L),Pi)),
    ISet(ArcSech(Plus(C1,Negate(CSqrt5))),
      Times(CC(0L,1L,4L,5L),Pi)),
    ISet(ArcSech(CSqrt2),
      Times(CC(0L,1L,1L,4L),Pi)),
    ISet(ArcSech(Negate(CSqrt2)),
      Times(CC(0L,1L,3L,4L),Pi)),
    ISet(ArcSech(C2),
      Times(CC(0L,1L,1L,3L),Pi)),
    ISet(ArcSech(CN2),
      Times(CC(0L,1L,2L,3L),Pi)),
    ISet(ArcSech(Plus(C1,CSqrt5)),
      Times(CC(0L,1L,2L,5L),Pi)),
    ISet(ArcSech(Plus(CN1,Negate(CSqrt5))),
      Times(CC(0L,1L,3L,5L),Pi)),
    ISet(ArcSech(CI),
      Plus(Times(CC(0L,1L,-1L,2L),Pi),Log(Plus(C1,CSqrt2)))),
    ISet(ArcSech(CNI),
      Plus(Times(CC(0L,1L,1L,2L),Pi),Log(Plus(C1,CSqrt2)))),
    ISet(ArcSech(CInfinity),
      Times(CC(0L,1L,1L,2L),Pi)),
    ISet(ArcSech(CNInfinity),
      Times(CC(0L,1L,1L,2L),Pi)),
    ISet(ArcSech(DirectedInfinity(CI)),
      Times(CC(0L,1L,-1L,2L),Pi)),
    ISet(ArcSech(DirectedInfinity(CNI)),
      Times(CC(0L,1L,1L,2L),Pi)),
    ISet(ArcSech(CComplexInfinity),
      Indeterminate)
  );
}
