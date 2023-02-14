package sherif.multiobjective.economics.CGE.Standard;

import java.util.EnumSet;

import org.apache.commons.lang.enums.EnumUtils;

public class Sets {
	public enum ACCOUNTS {
		// activities
		AAGEX, // agricultural exports act's
		AAGFO, // agricultural food act's
		AAGOT, // other agricultural act's
		AMINE, // mining
		ANAFO, // non-ag food processing act's
		ANAOI, // non-ag other industry
		ANASE, // non-ag service act's
		// commodities
		CAGEX, // agricultural exports com's
		CAGFO, // agricultural food com's
		CAGOT, // other agricultural com's
		CMINE, // mining
		CNAFO, // non-ag food processing com's
		CNAOI, // non-ag other industry
		CNASE, // non-ag service com's
		// factors
		LABUSK, // unskilled labor
		LABSK, // skilled labor
		CAPLSC, // capital large-scale
		CAPSH, // capital small-holders
		CAPOT, // other capital
		LANDLS, // land large-scale
		LANDSH, // land small-scale
		// Domestic non-government institutions
		// households
		HLSUPP, // large-scale owner and manager
		HLSLOW, // large-scale farm workers
		HSHHLD, // small-holders
		HURBUPP, // urban high income
		HURBLOW, // urban low income
		// enterprises
		ENTR, // enterprises
		// taxes
		YTAX, // direct income tax collection
		ATAX, // indirect activity tax collection
		STAX, // indirect sales tax collection
		TAR, // tariff collection
		ETAX, // export tax collection

		// Required accounts
		GOV, // government
		ROW, // rest of the world
		S_I, // savings-investment
		DSTK, // stock changes

		TRNCSTDOM, // domestic transactions cost account
		TRNCSTEXP, // export transactions cost account
		TRNCSTIMP, // import transactions cost account

		INSTAX, // direct taxes on domestic institutions
		FACTAX, // direct factor taxes
		IMPTAX, // import taxes
		EXPTAX, // export taxes
		VATAX, // value-added taxes
		ACTTAX, // indirect taxes on activity revenue
		COMTAX, // indirect taxes on commodity sales in domestic market
		DUM, // dummy

		TOTAL // total
	};

	public static ACCOUNTS[] A = { ACCOUNTS.AAGEX, ACCOUNTS.AAGFO, ACCOUNTS.AAGOT,
			ACCOUNTS.AMINE, ACCOUNTS.ANAFO, ACCOUNTS.ANAOI, ACCOUNTS.ANASE };
	public static ACCOUNTS[] AAGR = { ACCOUNTS.AAGEX, ACCOUNTS.AAGFO, ACCOUNTS.AAGOT };
	public static ACCOUNTS[] C = { ACCOUNTS.CAGEX, ACCOUNTS.CAGFO, ACCOUNTS.CAGOT, ACCOUNTS.CMINE, ACCOUNTS.CNAFO, ACCOUNTS.CNAOI, ACCOUNTS.CNASE };
	public static ACCOUNTS[] CAGR = { ACCOUNTS.CAGEX, ACCOUNTS.CAGFO, ACCOUNTS.CAGOT };
	public static ACCOUNTS[] F = { ACCOUNTS.LABUSK, ACCOUNTS.LABSK, ACCOUNTS.CAPLSC,
			ACCOUNTS.CAPSH, ACCOUNTS.CAPOT, ACCOUNTS.LANDLS, ACCOUNTS.LANDSH };
	public static ACCOUNTS[] FLAB = { ACCOUNTS.LABUSK, ACCOUNTS.LABSK };
	public static ACCOUNTS[] FLND = { ACCOUNTS.LANDLS, ACCOUNTS.LANDSH };
	public static ACCOUNTS[] FCAP = { ACCOUNTS.CAPLSC, ACCOUNTS.CAPSH, ACCOUNTS.CAPOT };
	public static ACCOUNTS[] INS = {
			// Households
			ACCOUNTS.HLSUPP, ACCOUNTS.HLSLOW, ACCOUNTS.HSHHLD,
			ACCOUNTS.HURBUPP, ACCOUNTS.HURBLOW,
			// Enterprises
			ACCOUNTS.ENTR,
			// Government and Rest of World
			ACCOUNTS.GOV, ACCOUNTS.ROW };
	public static ACCOUNTS[] INSD = {
			// Households
			ACCOUNTS.HLSUPP, ACCOUNTS.HLSLOW, ACCOUNTS.HSHHLD,
			ACCOUNTS.HURBUPP, ACCOUNTS.HURBLOW,
			// Enterprises
			ACCOUNTS.ENTR,
			// Government
			ACCOUNTS.GOV };
	public static ACCOUNTS[] INSDNG = {
			// Households
			ACCOUNTS.HLSUPP, ACCOUNTS.HLSLOW, ACCOUNTS.HSHHLD,
			ACCOUNTS.HURBUPP, ACCOUNTS.HURBLOW,
			// Enterprises
			ACCOUNTS.ENTR };
	public static ACCOUNTS[] EN = { ACCOUNTS.ENTR };
	public static ACCOUNTS[] H = { ACCOUNTS.HLSUPP, ACCOUNTS.HLSLOW, ACCOUNTS.HSHHLD,
			ACCOUNTS.HURBUPP, ACCOUNTS.HURBLOW };

	public static ACCOUNTS[] AC = {
			// activities
			ACCOUNTS.AAGEX, // agricultural exports act's
			ACCOUNTS.AAGFO, // agricultural food act's
			ACCOUNTS.AAGOT, // other agricultural act's
			ACCOUNTS.AMINE, // mining
			ACCOUNTS.ANAFO, // non-ag food processing act's
			ACCOUNTS.ANAOI, // non-ag other industry
			ACCOUNTS.ANASE, // non-ag service act's
			// commodities
			ACCOUNTS.CAGEX, // agricultural exports com's
			ACCOUNTS.CAGFO, // agricultural food com's
			ACCOUNTS.CAGOT, // other agricultural com's
			ACCOUNTS.CMINE, // mining
			ACCOUNTS.CNAFO, // non-ag food processing com's
			ACCOUNTS.CNAOI, // non-ag other industry
			ACCOUNTS.CNASE, // non-ag service com's
			// factors
			ACCOUNTS.LABUSK, // unskilled labor
			ACCOUNTS.LABSK, // skilled labor
			ACCOUNTS.CAPLSC, // capital large-scale
			ACCOUNTS.CAPSH, // capital small-holders
			ACCOUNTS.CAPOT, // other capital
			ACCOUNTS.LANDLS, // land large-scale
			ACCOUNTS.LANDSH, // land small-scale
			// Domestic non-government institutions
			// households
			ACCOUNTS.HLSUPP, // large-scale owner and manager
			ACCOUNTS.HLSLOW, // large-scale farm workers
			ACCOUNTS.HSHHLD, // small-holders
			ACCOUNTS.HURBUPP, // urban high income
			ACCOUNTS.HURBLOW, // urban low income
			// enterprises
			ACCOUNTS.ENTR, // enterprises
			// taxes
			ACCOUNTS.YTAX, // direct income tax collection
			ACCOUNTS.ATAX, // indirect activity tax collection
			ACCOUNTS.STAX, // indirect sales tax collection
			ACCOUNTS.TAR, // tariff collection
			ACCOUNTS.ETAX, // export tax collection

			// Required accounts
			ACCOUNTS.GOV, // government
			ACCOUNTS.ROW, // rest of the world
			ACCOUNTS.S_I, // savings-investment
			ACCOUNTS.DSTK, // stock changes

			ACCOUNTS.TRNCSTDOM, // domestic transactions cost account
			ACCOUNTS.TRNCSTEXP, // export transactions cost account
			ACCOUNTS.TRNCSTIMP, // import transactions cost account

			ACCOUNTS.INSTAX, // direct taxes on domestic institutions
			ACCOUNTS.FACTAX, // direct factor taxes
			ACCOUNTS.IMPTAX, // import taxes
			ACCOUNTS.EXPTAX, // export taxes
			ACCOUNTS.VATAX, // value-added taxes
			ACCOUNTS.ACTTAX, // indirect taxes on activity revenue
			ACCOUNTS.COMTAX, // indirect taxes on commodity sales in domestic
								// market
			ACCOUNTS.DUM, // dummy

			ACCOUNTS.TOTAL // total
	};

	public static ACCOUNTS[] ACT = {
			// activities
			ACCOUNTS.AAGEX, // agricultural exports act's
			ACCOUNTS.AAGFO, // agricultural food act's
			ACCOUNTS.AAGOT, // other agricultural act's
			ACCOUNTS.AMINE, // mining
			ACCOUNTS.ANAFO, // non-ag food processing act's
			ACCOUNTS.ANAOI, // non-ag other industry
			ACCOUNTS.ANASE, // non-ag service act's
			// commodities
			ACCOUNTS.CAGEX, // agricultural exports com's
			ACCOUNTS.CAGFO, // agricultural food com's
			ACCOUNTS.CAGOT, // other agricultural com's
			ACCOUNTS.CMINE, // mining
			ACCOUNTS.CNAFO, // non-ag food processing com's
			ACCOUNTS.CNAOI, // non-ag other industry
			ACCOUNTS.CNASE, // non-ag service com's
			// factors
			ACCOUNTS.LABUSK, // unskilled labor
			ACCOUNTS.LABSK, // skilled labor
			ACCOUNTS.CAPLSC, // capital large-scale
			ACCOUNTS.CAPSH, // capital small-holders
			ACCOUNTS.CAPOT, // other capital
			ACCOUNTS.LANDLS, // land large-scale
			ACCOUNTS.LANDSH, // land small-scale
			// Domestic non-government institutions
			// households
			ACCOUNTS.HLSUPP, // large-scale owner and manager
			ACCOUNTS.HLSLOW, // large-scale farm workers
			ACCOUNTS.HSHHLD, // small-holders
			ACCOUNTS.HURBUPP, // urban high income
			ACCOUNTS.HURBLOW, // urban low income
			// enterprises
			ACCOUNTS.ENTR, // enterprises
			// taxes
			ACCOUNTS.YTAX, // direct income tax collection
			ACCOUNTS.ATAX, // indirect activity tax collection
			ACCOUNTS.STAX, // indirect sales tax collection
			ACCOUNTS.TAR, // tariff collection
			ACCOUNTS.ETAX, // export tax collection

			// Required accounts
			ACCOUNTS.GOV, // government
			ACCOUNTS.ROW, // rest of the world
			ACCOUNTS.S_I, // savings-investment
			ACCOUNTS.DSTK, // stock changes

			ACCOUNTS.TRNCSTDOM, // domestic transactions cost account
			ACCOUNTS.TRNCSTEXP, // export transactions cost account
			ACCOUNTS.TRNCSTIMP, // import transactions cost account

			ACCOUNTS.INSTAX, // direct taxes on domestic institutions
			ACCOUNTS.FACTAX, // direct factor taxes
			ACCOUNTS.IMPTAX, // import taxes
			ACCOUNTS.EXPTAX, // export taxes
			ACCOUNTS.VATAX, // value-added taxes
			ACCOUNTS.ACTTAX, // indirect taxes on activity revenue
			ACCOUNTS.COMTAX, // indirect taxes on commodity sales in domestic
								// market
			ACCOUNTS.DUM // dummy
	};

}
