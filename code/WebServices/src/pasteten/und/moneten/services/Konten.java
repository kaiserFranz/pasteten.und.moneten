package pasteten.und.moneten.services;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * Das Interface Konten bildet den Kontenplan ab.
 * 
 * @author siddhartha
 * @version 1.01
 * @date 15. Januar 2011
 *
 */

@WebService
@SOAPBinding(style = Style.RPC)

public interface Konten {

	/**
	 * Array mit allen Kontennamen
	 */
	String[] kontenNamen = {"Aktiven",
			"Umlaufverm�gen",
			"Liquide Mittel",
			"Kasse",
			"Post",
			"Bank",
			"Wertschriften",
			"Forderungen",
			"Debitoren",
			"Debitor Vst.",
			"Vorr�te",
			"Waren",
			"Rohmaterial",
			"Halbfabrikate",
			"Fertigfabrikate",
			"Anlageverm�gen",
			"Materielles Anlageverm�gen",
			"Maschinen",
			"Mobiliar",
			"Fahrzeuge",
			"Hard- und Software",
			"Immobilien",
			"Finanzielles Anlageverm�gen",
			"Beteiligungen",
			"Immaterielles Anlageverm�gen",
			"Patente",
			"Passiven",
			"Fremdkapital",
			"Kurzfristiges Fremdkapital",
			"Kreditoren",
			"Bank",
			"Langfristiges Anlageverm�gen",
			"Darlehen",
			"Hypotheken",
			"Obligationen",
			"Eigenkapital",
			"Grundkapital",
			"Aktienkapital",
			"Zuwachskapital",
			"Reserven",
			"Gewinnvortrag",
			"Aufwand",
			"Warenaufwand",
			"Rohmaterialaufwand",
			"Personalaufwand",
			"Mietaufwand",
			"Zinsaufwand",
			"Abschreibungen",
			"Unterhalt und Reparaturen",
			"Versicherungsaufwand",
			"Energieaufwand",
			"Werbeaufwand",
			"�briger Aufwand",
			"Ertrag",
			"Warenertrag",
			"Fabrikateertrag",
			"Zinsertrag",
			"Abschluss",
			"Er�ffnungsbilanz",
			"Schlussbilanz",
			"Erfolgsrechnung",
			"Geisterkonto1",
			"Geisterkonto2"
	};

	/**
	 * Array mit allen Kontennummern
	 */
	int[] kontenNummern = {1,
			10,
			100,
			1000,
			1001,
			1002,
			1003,
			101,
			1010,
			1011,
			102,
			1020,
			1021,
			1022,
			1023,
			11,
			110,
			1100,
			1101,
			1102,
			1103,
			1104,
			111,
			1110,
			112,
			1120,
			2,
			20,
			200,
			2000,
			2002,
			201,
			2010,
			2011,
			2012,
			21,
			210,
			2100,
			211,
			2110,
			2111,
			3,
			3000,
			3001,
			3100,
			3200,
			3300,
			3400,
			3500,
			3600,
			3700,
			3800,
			3900,
			4,
			4000,
			4100,
			4200,
			5,
			5000,
			5001,
			5100,
			6,
			6000
	};

	/**
	 * Aktiven: Umlaufverm�gen: Liquide Mittel
	 */
	String[] liquideMittelNa = {"Kasse",
			"Post",
			"Bank",
			"Wertschriften"
	};

	int[] liquideMittelNu = {1000,
			1001,
			1002,
			1003
	};

	/**
	 * Aktiven: Umlaufverm�gen: Forderungen
	 */
	String[] forderungenNa = {"Debitoren",
			"Debitor Vst."
	};

	int[] forderungenNu = {1010,
			1011
	};

	/**
	 * Aktiven: Umlaufverm�gen: Vorr�te
	 */
	String[] vorraeteNa = {"Ware",
			"Rohmaterial",
			"Halbfabrikate",
			"Fertigfabrikate"
	};

	int[] vorraeteNu = {1020,
			1021,
			1022,
			1023
	};

	/**
	 * Aktiven: Anlageverm�gen: Materielles Anlageverm�gen
	 */
	String[] materiellesAnlagevermoegenNa = {"Maschinen",
			"Mobiliar",
			"Fahrzeuge",
			"Hard- und Software",
			"Immobilien"
	};

	int[] materiellesAnlageverm�genNu = {1100,
			1101,
			1102,
			1103,
			1104
	};

	/**
	 * Aktiven: Anlageverm�gen: Finanzielles Anlageverm�gen
	 */
	String[] finanziellesAnlagevermoegenNa = {"Beteiligungen"};

	int[] finanziellesAnlagevermoegenNu = {1110};

	/**
	 * Aktiven: Anlageverm�gen: Immaterielles Anlageverm�gen
	 */
	String[] immateriellesAnlagevermoegenNa = {"Patente"};

	int[] immateriellesAnlagevermoegenNu = {1120};

	/**
	 * Passiven: Fremdkapital: Kurzfristiges Fremdkapital
	 */
	String[] kurzfristigesFremdkapitalNa = {"Kreditoren",
			"Bank"
	};

	int[] kurzfristigesFremdkapitalNu = {2000,
			2002
	};

	/**
	 * Passiven: Fremdkapital: Langfristiges Fremdkapital
	 */
	String[] langfristigesFremdkapitalNa = {"Darlehen",
			"Hypotheken",
			"Obligationen"
	};

	int[] langfristigesFremdkapitalNu = {2010,
			2011,
			2012
	};

	/**
	 * Passiven: Eigenkapital: Grundkapital
	 */
	String[] grundkapitalNa = {"Aktienkapital"};

	int[] grundkapitalNu = {2100};

	/**
	 * Passiven: Eigenkapital: Zuwachskapital
	 */
	String[] zuwachskapital = {"Reserven",
			"Gewinnvortrag"
	};

	/**
	 * Aufwand
	 */
	String[] aufwandNa = {"Warenaufwand",
			"Rohmaterialaufwand",
			"Personalaufwand",
			"Mietaufwand",
			"Zinsaufwand",
			"Abschreibungen",
			"Unterhalt und Reparaturen",
			"Versicherungsaufwand",
			"Energieaufwand",
			"Werbeaufwand",
			"�briger Aufwand"
	};

	int[] aufwandNu = {3000,
			3001,
			3100,
			3200,
			3300,
			3400,
			3500,
			3600,
			3700,
			3800,
			3900
	};

	/**
	 * Ertrag
	 */
	String[] ertragNa = {"Warenertrag",
			"Fabrikateertrag",
			"Zinsertrag"
	};

	int[] ertragNu = {4000,
			4100,
			4200
	};

	/**
	 * Abschluss
	 */
	String[] abschlussNa = {"Er�ffnungsbilanz",
			"Schlussbilanz",
			"Erfolgsrechnung"
	};

	int[] abschlussNu = {5000,
			5001,
			5100
	};

}
