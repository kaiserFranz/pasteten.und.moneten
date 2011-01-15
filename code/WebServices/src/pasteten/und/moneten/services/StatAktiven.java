package pasteten.und.moneten.services;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)

public class StatAktiven {

	/**
	 * Aktiven: Umlaufvermögen: Liquide Mittel
	 */
	private int n_1000_kasse;
	private int n_1001_post;
	private int n_1002_bank;
	private int n_1003_wertschriften;

	private int tmp_1000_kasse;
	private int tmp_1001_post;
	private int tmp_1002_bank;
	private int tmp_1003_wertschriften;

	/**
	 * Aktiven: Umlaufvermögen: Forderungen
	 */
	private int n_1010_debitoren;
	private int n_1011_debitorVst;

	private int tmp_1010_debitoren;
	private int tmp_1011_debitorVst;

	/**
	 * Aktiven: Umlaufvermögen: Vorräte
	 */
	private int n_1020_waren;
	private int n_1021_rohmaterial;
	private int n_1022_halbfabrikate;
	private int n_1023_fertigfabrikate;

	private int tmp_1020_waren;
	private int tmp_1021_rohmaterial;
	private int tmp_1022_halbfabrikate;
	private int tmp_1023_fertigfabrikate;

	/**
	 * Aktiven: Anlagevermögen: Materielles Anlagevermögen
	 */
	private int n_1100_maschinen;
	private int n_1101_mobiliar;
	private int n_1102_fahrzeuge;
	private int n_1103_hardUndSoftware;
	private int n_1104_immobilien;

	private int tmp_1100_maschinen;
	private int tmp_1101_mobiliar;
	private int tmp_1102_fahrzeuge;
	private int tmp_1103_hardUndSoftware;
	private int tmp_1104_immobilien;

	/**
	 * Aktiven: Anlagevermögen: Finanzielles Anlagevermögen
	 */
	private int n_1110_beteiligungen;

	private int tmp_1110_beteiligungen;

	/**
	 * Aktiven: Anlagevermögen: Immaterielles Anlagevermögen
	 */
	private int n_1120_patente;

	private int tmp_1120_patente;


	public StatAktiven() {
		createTable();
	}


	/**
	 * Anbindung DB, Initialisierung der einzelnen Werte
	 */
	public void createTable() {

	}


	/**
	 * @return the n_1000_kasse
	 */
	public int getN_1000_kasse() {
		return n_1000_kasse;
	}


	/**
	 * @return the n_1001_post
	 */
	public int getN_1001_post() {
		return n_1001_post;
	}


	/**
	 * @return the n_1002_bank
	 */
	public int getN_1002_bank() {
		return n_1002_bank;
	}


	/**
	 * @return the n_1003_wertschriften
	 */
	public int getN_1003_wertschriften() {
		return n_1003_wertschriften;
	}


	/**
	 * @return the n_1010_debitoren
	 */
	public int getN_1010_debitoren() {
		return n_1010_debitoren;
	}


	/**
	 * @return the n_1011_debitorVst
	 */
	public int getN_1011_debitorVst() {
		return n_1011_debitorVst;
	}


	/**
	 * @return the n_1020_waren
	 */
	public int getN_1020_waren() {
		return n_1020_waren;
	}


	/**
	 * @return the n_1021_rohmaterial
	 */
	public int getN_1021_rohmaterial() {
		return n_1021_rohmaterial;
	}


	/**
	 * @return the n_1022_halbfabrikate
	 */
	public int getN_1022_halbfabrikate() {
		return n_1022_halbfabrikate;
	}


	/**
	 * @return the n_1023_fertigfabrikate
	 */
	public int getN_1023_fertigfabrikate() {
		return n_1023_fertigfabrikate;
	}


	/**
	 * @return the n_1100_maschinen
	 */
	public int getN_1100_maschinen() {
		return n_1100_maschinen;
	}


	/**
	 * @return the n_1101_mobiliar
	 */
	public int getN_1101_mobiliar() {
		return n_1101_mobiliar;
	}


	/**
	 * @return the n_1102_fahrzeuge
	 */
	public int getN_1102_fahrzeuge() {
		return n_1102_fahrzeuge;
	}


	/**
	 * @return the n_1103_hardUndSoftware
	 */
	public int getN_1103_hardUndSoftware() {
		return n_1103_hardUndSoftware;
	}


	/**
	 * @return the n_1104_immobilien
	 */
	public int getN_1104_immobilien() {
		return n_1104_immobilien;
	}


	/**
	 * @return the n_1110_beteiligungen
	 */
	public int getN_1110_beteiligungen() {
		return n_1110_beteiligungen;
	}


	/**
	 * @return the n_1120_patente
	 */
	public int getN_1120_patente() {
		return n_1120_patente;
	}


	/**
	 * Aktiven: Umlaufvermögen: Liquide Mittel
	 * @return
	 */
	public int getLiquideMittel() {
		return n_1000_kasse + n_1001_post + n_1002_bank + n_1003_wertschriften;
	}


	/**
	 * Aktiven: Umlaufvermögen: Forderungen
	 * @return
	 */
	public int getForderungen() {
		return n_1010_debitoren + n_1011_debitorVst;
	}


	/**
	 * Aktiven: Umlaufvermögen: Vorräte
	 * @return
	 */
	public int getVorraete() {
		return n_1020_waren + n_1021_rohmaterial + n_1022_halbfabrikate + n_1023_fertigfabrikate;
	}


	/**
	 * Aktiven: Umlaufvermögen
	 * @return
	 */
	public int getUmlaufvermoegen() {
		return getLiquideMittel() + getForderungen() + getVorraete();
	}


	/**
	 * Aktiven: Anlagevermögen: Materielles Anlagevermögen
	 * @return
	 */
	public int getMAnlagevermoegen() {
		return n_1100_maschinen + n_1101_mobiliar + n_1102_fahrzeuge + n_1103_hardUndSoftware + n_1104_immobilien;
	}


	/**
	 * Aktiven: Anlagevermögen: Finanzielles Anlagevermögen
	 * @return
	 */
	public int getFAnlagevermoegen() {
		return n_1110_beteiligungen;
	}


	/**
	 * Aktiven: Anlagevermögen: Immaterielles Anlagevermögen
	 * @return
	 */
	public int getImAnlagevermoegen() {
		return n_1120_patente;
	}


	/**
	 * Aktiven: Anlagevermögen
	 * @return
	 */
	public int getAnlagevermoegen() {
		return getMAnlagevermoegen() + getFAnlagevermoegen() + getImAnlagevermoegen();
	}


	/**
	 * Aktiven
	 * @return
	 */
	public int getAktiven() {
		return getUmlaufvermoegen() + getAnlagevermoegen();
	}


	/**
	 * reset n_1000_kasse
	 */
	public void resetN_1000_kasse() {
		n_1000_kasse = tmp_1000_kasse;
	}


	/**
	 * reset n_1001_post
	 */
	public void resetN_1001_post() {
		n_1001_post = tmp_1001_post;
	}


	/**
	 * reset n_1002_bank
	 */
	public void resetN_1002_bank() {
		n_1002_bank = tmp_1002_bank;
	}


	/**
	 * reset n_1003_wertschriften
	 */
	public void resetN_1003_wertschriften() {
		n_1003_wertschriften = tmp_1003_wertschriften;
	}


	/**
	 * reset n_1010_debitoren
	 */
	public void resetN_1010_debitoren() {
		n_1010_debitoren = tmp_1010_debitoren;
	}


	/**
	 * reset n_1011_debitorVst
	 */
	public void resetN_1011_debitorVst() {
		n_1011_debitorVst = tmp_1011_debitorVst;
	}


	/**
	 * reset n_1020_waren
	 */
	public void resetN_1020_waren() {
		n_1020_waren = tmp_1020_waren;
	}


	/**
	 * reset n_1021_rohmaterial
	 */
	public void resetN_1021_rohmaterial() {
		n_1021_rohmaterial = tmp_1021_rohmaterial;
	}


	/**
	 * reset n_1022_halbfabrikate
	 */
	public void resetN_1022_halbfabrikate() {
		n_1022_halbfabrikate = tmp_1022_halbfabrikate;
	}


	/**
	 * reset n_1023_fertigfabrikate
	 */
	public void resetN_1023_fertigfabrikate() {
		n_1023_fertigfabrikate = tmp_1023_fertigfabrikate;
	}


	/**
	 * reset n_1100_maschinen
	 */
	public void resetN_1100_maschinen() {
		n_1100_maschinen = tmp_1100_maschinen;
	}


	/**
	 * reset n_1101_mobiliar
	 */
	public void resetN_1101_mobiliar() {
		n_1101_mobiliar = tmp_1101_mobiliar;
	}


	/**
	 * reset n_1102_fahrzeuge
	 */
	public void resetN_1102_fahrzeuge() {
		n_1102_fahrzeuge = tmp_1102_fahrzeuge;
	}


	/**
	 * reset n_1103_hardUndSoftware
	 */
	public void resetN_1103_hardUndSoftware() {
		n_1103_hardUndSoftware = tmp_1103_hardUndSoftware;
	}


	/**
	 * reset n_1104_immobilien
	 */
	public void resetN_1104_immobilien() {
		n_1104_immobilien = tmp_1104_immobilien;
	}


	/**
	 * reset n_1110_beteiligungen
	 */
	public void resetN_1110_beteiligungen() {
		n_1110_beteiligungen = tmp_1110_beteiligungen;
	}


	/**
	 * reset n_1120_patente
	 */
	public void resetN_1120_patente() {
		n_1120_patente = tmp_1120_patente;
	}


	/**
	 * @param n_1000_kasse the n_1000_kasse to add or to subtract
	 */
	public void setN_1000_kasse(boolean plusMinus, int n_1000_kasse) {
		tmp_1000_kasse = this.n_1000_kasse;
		if (plusMinus) {
			this.n_1000_kasse += n_1000_kasse;
		} else {
			this.n_1000_kasse -= n_1000_kasse;	
		}
	}


	/**
	 * @param n_1001_post the n_1001_post to add or to subtract
	 */
	public void setN_1001_post(boolean plusMinus, int n_1001_post) {
		tmp_1001_post = this.n_1001_post;
		if (plusMinus) {
			this.n_1001_post += n_1001_post;
		} else {
			this.n_1001_post -= n_1001_post;	
		}
	}


	/**
	 * @param n_1002_bank the n_1002_bank to add or to subtract
	 */
	public void setN_1002_bank(boolean plusMinus, int n_1002_bank) {
		tmp_1002_bank = this.n_1002_bank;
		if (plusMinus) {
			this.n_1002_bank += n_1002_bank;
		} else {
			this.n_1002_bank -= n_1002_bank;	
		}
	}


	/**
	 * @param n_1003_wertschriften the n_1003_wertschriften to add or to subtract
	 */
	public void setN_1003_wertschriften(boolean plusMinus, int n_1003_wertschriften) {
		tmp_1003_wertschriften = this.n_1003_wertschriften;
		if (plusMinus) {
			this.n_1003_wertschriften += n_1003_wertschriften;
		} else {
			this.n_1003_wertschriften -= n_1003_wertschriften;	
		}
	}


	/**
	 * @param n_1010_debitoren the n_1010_debitoren to add or to subtract
	 */
	public void setN_1010_debitoren(boolean plusMinus, int n_1010_debitoren) {
		tmp_1010_debitoren = this.n_1010_debitoren;
		if (plusMinus) {
			this.n_1010_debitoren += n_1010_debitoren;
		} else {
			this.n_1010_debitoren -= n_1010_debitoren;	
		}
	}


	/**
	 * @param n_1011_debitorVst the n_1011_debitorVst to add or to subtract
	 */
	public void setN_1011_debitorVst(boolean plusMinus, int n_1011_debitorVst) {
		tmp_1011_debitorVst = this.n_1011_debitorVst;
		if (plusMinus) {
			this.n_1011_debitorVst += n_1011_debitorVst;
		} else {
			this.n_1011_debitorVst -= n_1011_debitorVst;	
		}
	}


	/**
	 * @param n_1020_waren the n_1020_waren to add or to subtract
	 */
	public void setN_1020_waren(boolean plusMinus, int n_1020_waren) {
		tmp_1020_waren = this.n_1020_waren;
		if (plusMinus) {
			this.n_1020_waren += n_1020_waren;
		} else {
			this.n_1020_waren -= n_1020_waren;	
		}
	}


	/**
	 * @param n_1021_rohmaterial the n_1021_rohmaterial to add or to subtract
	 */
	public void setN_1021_rohmaterial(boolean plusMinus, int n_1021_rohmaterial) {
		tmp_1021_rohmaterial = this.n_1021_rohmaterial;
		if (plusMinus) {
			this.n_1021_rohmaterial += n_1021_rohmaterial;
		} else {
			this.n_1021_rohmaterial -= n_1021_rohmaterial;	
		}
	}


	/**
	 * @param n_1022_halbfabrikate the n_1022_halbfabrikate to add or to subtract
	 */
	public void setN_1022_halbfabrikate(boolean plusMinus, int n_1022_halbfabrikate) {
		tmp_1022_halbfabrikate = this.n_1022_halbfabrikate;
		if (plusMinus) {
			this.n_1022_halbfabrikate += n_1022_halbfabrikate;
		} else {
			this.n_1022_halbfabrikate -= n_1022_halbfabrikate;	
		}
	}


	/**
	 * @param n_1023_fertigfabrikate the n_1023_fertigfabrikate to add or to subtract
	 */
	public void setN_1023_fertigfabrikate(boolean plusMinus, int n_1023_fertigfabrikate) {
		tmp_1023_fertigfabrikate = this.n_1023_fertigfabrikate;
		if (plusMinus) {
			this.n_1023_fertigfabrikate += n_1023_fertigfabrikate;
		} else {
			this.n_1023_fertigfabrikate -= n_1023_fertigfabrikate;	
		}
	}


	/**
	 * @param n_1100_maschinen the n_1100_maschinen to add or to subtract
	 */
	public void setN_1100_maschinen(boolean plusMinus, int n_1100_maschinen) {
		tmp_1100_maschinen = this.n_1100_maschinen;
		if (plusMinus) {
			this.n_1100_maschinen += n_1100_maschinen;
		} else {
			this.n_1100_maschinen -= n_1100_maschinen;	
		}
	}


	/**
	 * @param n_1101_mobiliar the n_1101_mobiliar to add or to subtract
	 */
	public void setN_1101_mobiliar(boolean plusMinus, int n_1101_mobiliar) {
		tmp_1101_mobiliar = this.n_1101_mobiliar;
		if (plusMinus) {
			this.n_1101_mobiliar += n_1101_mobiliar;
		} else {
			this.n_1101_mobiliar -= n_1101_mobiliar;	
		}
	}


	/**
	 * @param n_1102_fahrzeuge the n_1102_fahrzeuge to add or to subtract
	 */
	public void setN_1102_fahrzeuge(boolean plusMinus, int n_1102_fahrzeuge) {
		tmp_1102_fahrzeuge = this.n_1102_fahrzeuge;
		if (plusMinus) {
			this.n_1102_fahrzeuge += n_1102_fahrzeuge;
		} else {
			this.n_1102_fahrzeuge -= n_1102_fahrzeuge;	
		}
	}


	/**
	 * @param n_1103_hardUndSoftware the n_1103_hardUndSoftware to add or to subtract
	 */
	public void setN_1103_hardUndSoftware(boolean plusMinus, int n_1103_hardUndSoftware) {
		tmp_1103_hardUndSoftware = this.n_1103_hardUndSoftware;
		if (plusMinus) {
			this.n_1103_hardUndSoftware += n_1103_hardUndSoftware;
		} else {
			this.n_1103_hardUndSoftware -= n_1103_hardUndSoftware;	
		}
	}


	/**
	 * @param n_1104_immobilien the n_1104_immobilien to add or to subtract
	 */
	public void setN_1104_immobilien(boolean plusMinus, int n_1104_immobilien) {
		tmp_1104_immobilien = this.n_1104_immobilien;
		if (plusMinus) {
			this.n_1104_immobilien += n_1104_immobilien;
		} else {
			this.n_1104_immobilien -= n_1104_immobilien;	
		}
	}


	/**
	 * @param n_1110_beteiligungen the n_1110_beteiligungen to add or to subtract
	 */
	public void setN_1110_beteiligungen(boolean plusMinus, int n_1110_beteiligungen) {
		tmp_1110_beteiligungen = this.n_1110_beteiligungen;
		if (plusMinus) {
			this.n_1110_beteiligungen += n_1110_beteiligungen;
		} else {
			this.n_1110_beteiligungen -= n_1110_beteiligungen;	
		}
	}


	/**
	 * @param n_1120_patente the n_1120_patente to add or to subtract
	 */
	public void setN_1120_patente(boolean plusMinus, int n_1120_patente) {
		tmp_1120_patente = this.n_1120_patente;
		if (plusMinus) {
			this.n_1120_patente += n_1120_patente;
		} else {
			this.n_1120_patente -= n_1120_patente;	
		}
	}

}
