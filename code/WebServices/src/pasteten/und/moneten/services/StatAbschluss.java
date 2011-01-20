package pasteten.und.moneten.services;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)

public class StatAbschluss {

	/**
	 * Abschluss
	 */
	private int n_5000_eroeffnungsbilanz;
	private int n_5001_schlussbilanz;
	private int n_5100_erfolgsrechnung;

	private int tmp_5000_eroeffnungsbilanz;
	private int tmp_5001_schlussbilanz;
	private int tmp_5100_erfolgsrechnung;


	public StatAbschluss() {
		createTable();
	}


	/**
	 * Anbindung DB, Initialisierung der einzelnen Werte
	 */
	private void createTable() {

	}


	/**
	 * @return the n_5000_eroeffnungsbilanz
	 */
	public int getN_5000_eroeffnungsbilanz() {
		return n_5000_eroeffnungsbilanz;
	}


	/**
	 * @return the n_5001_schlussbilanz
	 */
	public int getN_5001_schlussbilanz() {
		return n_5001_schlussbilanz;
	}


	/**
	 * @return the n_5100_erfolgsrechnung
	 */
	public int getN_5100_erfolgsrechnung() {
		return n_5100_erfolgsrechnung;
	}


	/**
	 * Abschluss
	 */
	public int getAbschluss() {
		return n_5000_eroeffnungsbilanz + n_5001_schlussbilanz + n_5100_erfolgsrechnung;
	}


	/**
	 * reset n_5000_eroeffnungsbilanz
	 */
	public void resetN_5000_eroeffnungsbilanz() {
		n_5000_eroeffnungsbilanz = tmp_5000_eroeffnungsbilanz;
	}


	/**
	 * reset n_5001_schlussbilanz
	 */
	public void resetN_5001_schlussbilanz() {
		n_5001_schlussbilanz = tmp_5001_schlussbilanz;
	}


	/**
	 * reset n_5100_erfolgsrechnung
	 */
	public void resetN_5100_erfolgsrechnung() {
		n_5100_erfolgsrechnung = tmp_5100_erfolgsrechnung;
	}


	/**
	 * @param n_5000_eroeffnungsbilanz the n_5000_eroeffnungsbilanz to add or to subtract
	 */
	public void setN_5000_eroeffnungsbilanz(boolean plusMinus, int n_5000_eroeffnungsbilanz) {
		tmp_5000_eroeffnungsbilanz = this.n_5000_eroeffnungsbilanz;
		if (plusMinus) {
			this.n_5000_eroeffnungsbilanz += n_5000_eroeffnungsbilanz;
		} else {
			this.n_5000_eroeffnungsbilanz -= n_5000_eroeffnungsbilanz;
		}
	}


	/**
	 * @param n_5001_schlussbilanz the n_5001_schlussbilanz to add or to subtract
	 */
	public void setN_5001_schlussbilanz(boolean plusMinus, int n_5001_schlussbilanz) {
		tmp_5001_schlussbilanz = this.n_5001_schlussbilanz;
		if (plusMinus) {
			this.n_5001_schlussbilanz += n_5001_schlussbilanz;
		} else {
			this.n_5001_schlussbilanz -= n_5001_schlussbilanz;
		}
	}


	/**
	 * @param n_5100_erfolgsrechnung the n_5100_erfolgsrechnung to add or to subtract
	 */
	public void setN_5100_erfolgsrechnung(boolean plusMinus, int n_5100_erfolgsrechnung) {
		tmp_5100_erfolgsrechnung = this.n_5100_erfolgsrechnung;
		if (plusMinus) {
			this.n_5100_erfolgsrechnung += n_5100_erfolgsrechnung;
		} else {
			this.n_5100_erfolgsrechnung -= n_5100_erfolgsrechnung;
		}
	}

}
