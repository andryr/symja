{
{
  ArcCos->((-1)*(1-#^2)^(-1/2)&),
  ArcCosh->((#^2-1)^(-1/2)&),
  ArcCot->((-1)*(1+#^2)^(-1)&),
  ArcCoth->((1-#^2)^(-1)&),
  ArcCsc->(-1*#^(-2)*(1-#^(-2))^(-1/2)&),
  ArcCsch->(-1*Abs(#)^(-1)*(1+#^2)^(-1/2)&),
  ArcSin->((1-#^2)^(-1/2)&),
  ArcSinh->((1+#^2)^(-1/2)&),
  ArcTan->((1+#^2)^(-1)&),
  ArcTanh->((1-#^2)^(-1)&),
  ArcSec->(#^(-2)*(1-#^(-2))^(-1/2)&),
  ArcSech->(-1*#^(-1)*(1-#^2)^(-1/2)&),
  Ceiling->(0&),
  Erf->((2*E^(-#^(2))/Sqrt(Pi))&),
  Erfc->((-2*E^(-#^(2))/Sqrt(Pi))&),
  Erfi->((2*E^(#^(2))/Sqrt(Pi))&),
  Floor->(0&),
  FractionalPart->(1&),
  Gamma->(Gamma(#)*PolyGamma(#)&),
  IntegerPart->(0&),
  InverseErf->((1/2*Sqrt(Pi)*E^(InverseErf(x)^2))&),
  Log->(#^(-1)&),
  PolyGamma->(PolyGamma(1,#)&),
  Cot->((-1)*Csc(#)^2&),
  Coth->((-1)*Sinh(#)^(-2)&),
  Cos->((-1)*Sin(#)&),
  Cosh->(Sinh(#)&),
  Csc->((-1)*Cot(#)*Csc(#)&),
  Csch->((-1)*Coth(#)*Csch(#)&),
  Round->(0&),
  Sin->(Cos(#)&),
  Sinh->(Cosh(#)&),
  Tan->(Sec(#)^2&),
  Tanh->(Sech(#)^(2)&),
  Sec->(Sec(#)*Tan(#)&),
  Sech->((-1)*Tanh(#)*Sech(#)&)
},
{
  ArcSin->(#*(1-#^2)^(-3/2)&),
  Gamma->(Gamma(#)*PolyGamma(#)^2+Gamma(#)*PolyGamma(1,#)&),
  Log->((-1)*#^(-2)&),
  PolyGamma->(PolyGamma(2,#)&),
  Cot->(2*Csc(#)^2*Cot(#)&),
  Tan->(2*Sec(#)^2*Tan(#)&)
},
{
  Log->((-1)^(#2-1)*(#2-1)!*#^(-#2)&),
  PolyGamma->(PolyGamma(#2,#)&),
  Cos->((Cos(#+(Pi*#2)/2))&),
  Sin->((Sin(#+(Pi*#2)/2))&)
},
{
  {Power,1,0}->(#^(-1+#2)*#2&),
  {Power,0,1}->(Log(#)*#^#2 & ),
  {Power,1,1}->(#^(-1+#2)+Log(#)*#^(-1+#2)*#2&),
  {ProductLog,0,1}->(ProductLog(#, #2)/#2 * (1+ProductLog(#, #2)) &)
}
}