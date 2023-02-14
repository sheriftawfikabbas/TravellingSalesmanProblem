package sherif.multiobjective.economics.CGE.Standard;

public class Variables {

    double CPI;  //       consumer price index (PQ-based)
    double DPI;   //      index for domestic producer prices (PDS-based)
    double DMPS;  //       change in marginal propensity to save for selected inst
    double DTINS;  //      change in domestic institution tax share
    double EG;   //      total current government expenditure
    double[] EH = new double[Sets.H.length];//         household consumption expenditure
    double EXR;    //      exchange rate
    double FSAV;   //      foreign savings
    double GADJ;   //      government demand scaling factor
    double GOVSHR; //      govt consumption share of absorption
    double GSAV;   //      government savings
    double IADJ;   //      investment scaling factor (for fixed capital formation)
    double INVSHR;  //     investment share of absorption
    double[] MPS = new double[Sets.INS.length];//      marginal propensity to save for dom non-gov inst ins
    double MPSADJ;  //     savings rate scaling factor
    double[] PA = new double[Sets.A.length];//         output price of activity a
    double[] PDD = new double[Sets.C.length];//        demand price for com'y c produced & sold domestically
    double[] PDS = new double[Sets.C.length];//        supply price for com'y c produced & sold domestically
    double[] PE = new double[Sets.C.length];//         price of exports
    double[] PINTA = new double[Sets.A.length];//      price of intermediate aggregate
    double[] PM = new double[Sets.C.length];//         price of imports
    double[] PQ = new double[Sets.C.length];//         price of composite good c
    double[] PVA = new double[Sets.A.length];//        value added price
    double[] PWE = new double[Sets.C.length];//        world price of exports
    double[] PWM = new double[Sets.C.length];//        world price of imports
    double[] PX = new double[Sets.C.length];//         average output price
    double[][] PXAC = new double[Sets.A.length][Sets.C.length];//     price of commodity c from activity a
    double[] QA = new double[Sets.A.length];//         level of domestic activity
    double[] QD = new double[Sets.C.length];//         quantity of domestic sales
    double[] QE = new double[Sets.C.length];//         quantity of exports
    double[][] QF = new double[Sets.F.length][Sets.A.length];//       quantity demanded of factor f from activity a
    double[] QFS = new double[Sets.F.length];//        quantity of factor supply
    double[] QG = new double[Sets.C.length];//         quantity of government consumption
    double[][] QH = new double[Sets.C.length][Sets.H.length];//       quantity consumed of marketed commodity c by household h
    double[][][] QHA = new double[Sets.A.length][Sets.C.length][Sets.H.length];//    quantity consumed of home commodity c fr act a by hhd h
    double[][] QINT = new double[Sets.C.length][Sets.A.length];//     quantity of intermediate demand for c from activity a
    double[] QINTA = new double[Sets.A.length];//      quantity of aggregate intermediate input
    double[] QINV = new double[Sets.C.length];//       quantity of fixed investment demand
    double[] QM = new double[Sets.C.length];//         quantity of imports
    double[] QQ = new double[Sets.C.length];//         quantity of composite goods supply
    double[] QT = new double[Sets.C.length];//         quantity of trade and transport demand for commodity c
    double[] QVA = new double[Sets.A.length];//        quantity of aggregate value added
    double[] QX = new double[Sets.C.length];//         quantity of aggregate marketed commodity output
    double[][] QXAC = new double[Sets.A.length][Sets.C.length];//     quantity of ouput of commodity c from activity a
    double TABS;  //      total absorption
    double[] TINS = new double[Sets.INS.length];//     rate of direct tax on domestic institutions ins
    double TINSADJ;  //    direct tax scaling factor
    double[][] TRII = new double[Sets.INS.length][Sets.INS.length];// transfers to dom. inst. insdng from insdngp
    double WALRAS;   //    savings-investment imbalance(should be zero)
    double WALRASSQR;  //   Walras squared
    double[] WF = new double[Sets.F.length];//         economy-wide wage (rent) for factor f
    double[][] WFDIST = new double[Sets.F.length][Sets.A.length];//   factor wage distortion variable
    double[] YF = new double[Sets.F.length];//         factor income
    double YG;   //        total current government income
    double[][] YIF = new double[Sets.INS.length][Sets.F.length];//    income of institution ins from factor f
    double[] YI = new double[Sets.INS.length];//       income of =new double[Sets.domestic non-governmental) institution ins
}
