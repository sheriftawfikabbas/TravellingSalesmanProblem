package sherif.multiobjective.economics.CGE.Standard;

public class Parameters {

//a. Parameters appearing in model equations================

//Parameters other than tax rates
 double[] alphaa=new double[Sets.A.length]; //     shift parameter for top level CES function
 double[]alphaac=new double[Sets.C.length];//     shift parameter for domestic commodity aggregation fn
 double[]alphaq=new double[Sets.C.length];//      shift parameter for Armington function
 double[]alphat=new double[Sets.C.length];//      shift parameter for CET function
 double[]alphava=new double[Sets.A.length];//     shift parameter for CES activity production function
 double[][][]betah=new double[Sets.A.length][Sets.C.length][Sets.H.length];//   marg shr of hhd cons on home com c from act a
 double[][]betam=new double[Sets.C.length][Sets.H.length];//     marg share of hhd cons on marketed commodity c
 double[]cwts=new double[Sets.C.length];//        consumer price index weights
 double[]deltaa=new double[Sets.A.length];//      share parameter for top level CES function
 double[][]deltaac=new double[Sets.A.length][Sets.C.length];//   share parameter for domestic commodity aggregation fn
 double[]deltaq=new double[Sets.C.length];//      share parameter for Armington function
 double[]deltat=new double[Sets.C.length];//      share parameter for CET function
 double[][]deltava=new double[Sets.F.length][Sets.A.length];//   share parameter for CES activity production function
 double[]dwts=new double[Sets.C.length];//        domestic sales price weights
 double[][][]gammah=new double[Sets.A.length][Sets.C.length][Sets.H.length];//  per-cap subsist cons for hhd h on home com c fr act a
 double[][]gammam=new double[Sets.C.length][Sets.H.length];//    per-cap subsist cons of marketed com c for hhd h
 double[][]ica=new double[Sets.C.length][Sets.A.length];//       intermediate input c per unit of aggregate intermediate
 double[]inta=new double[Sets.A.length];//        aggregate intermediate input coefficient
 double[]iva=new double[Sets.A.length];//         aggregate value added coefficient
 double[][]icd=new double[Sets.C.length][Sets.C.length];//      trade input of c per unit of comm'y cp produced & sold dom'ly
 double[][]ice=new double[Sets.C.length][Sets.C.length];//      trade input of c per unit of comm'y cp exported
 double[][]icm=new double[Sets.C.length][Sets.C.length];//      trade input of c per unit of comm'y cp imported
 double[]mps01=new double[Sets.INS.length];//     0-1 par for potential flexing of savings rates
 double[]mpsbar=new double[Sets.INS.length];//    marg prop to save for dom non-gov inst ins =new double[Sets.exog part.length];//
 double[]qdst=new double[Sets.C.length];//        inventory investment by sector of origin
 double[]qbarg=new double[Sets.C.length];//       exogenous =new double[Sets.unscaled.length];// government demand
 double[]qbarinv=new double[Sets.C.length];//     exogenous =new double[Sets.unscaled.length];// investment demand
 double[]rhoa=new double[Sets.A.length];//        CES top level function exponent
 double[]rhoac=new double[Sets.C.length];//       domestic commodity aggregation function exponent
 double[]rhoq=new double[Sets.C.length];//        Armington function exponent
 double[]rhot=new double[Sets.C.length];//        CET function exponent
 double[]rhova=new double[Sets.A.length];//       CES activity production function exponent
 double[][]shif=new double[Sets.INS.length][Sets.F.length];//    share of dom. inst'on i in income of factor f
 double[][]shii=new double[Sets.INS.length][Sets.INS.length];// share of inst'on i in post-tax post-sav income of inst ip
 double[]supernum=new double[Sets.H.length];//    LES supernumerary income
 double[][]theta=new double[Sets.A.length][Sets.C.length];//     yield of commodity C per unit of activity A
 double[]tins01=new double[Sets.INS.length];//    0-1 par for potential flexing of dir tax rates
 double[][]trnsfr=new double[Sets.INS.length][Sets.AC.length];// transfers fr. inst. or factor ac to institution ins

//Tax rates
 double[]ta=new double[Sets.A.length];//          rate of tax on producer gross output value
 double[]te=new double[Sets.C.length];//          rate of tax on exports
 double[]tf=new double[Sets.F.length];//          rate of direct tax on factors =new double[Sets.soc sec tax.length];//
 double[]tinsbar=new double[Sets.INS.length];//   rate of =new double[Sets.exog part of.length];// direct tax on dom inst ins
 double[]tm=new double[Sets.C.length];//          rate of import tariff
 double[]tq=new double[Sets.C.length];//          rate of sales tax
 double[]tva=new double[Sets.A.length];//         rate of value-added tax

}
