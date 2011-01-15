package pasteten.und.moneten.services;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)

public class StatPassiven {

	/**
	 * Passiven: Fremdkapital: Kurzfristiges Fremdkapital
	 */
	private int n_2000_kreditoren;
	private int n_2002_bank;

	private int tmp_2000_kreditoren;
	private int tmp_2002_bank;

	/**
	 * Passiven: Fremdkapital: Langfristiges Fremdkapital
	 */
	private int n_2010_darlehen;
	private int n_2011_hypotheken;
	private int n_2012_obligationen;

	private int tmp_2010_darlehen;
	private int tmp_2011_hypotheken;
	private int tmp_2012_obligationen;

	/**
	 * Passiven: Eigenkapital: Grundkapital
	 */
	private int n_2100_aktienkapital;

	private int tmp_2100_aktienkapital;

	/**
	 * Passiven: Eigenkapital: Zuwachskapital
	 */
	private int n_2110_reserven;
	private int n_2111_gewinnvortrag;

	private int tmp_2110_reserven;
	private int tmp_2111_gewinnvortrag;


	public StatPassiven() {
		createTable();
	}


	/**
	 * Anbindung DB, Initialisierung der einzelnen Werte
	 */
	public void createTable() {

	}


	/**
	 * @return the n_2000_kreditoren
	 */
	public int getN_2000_kreditoren() {
		return n_2000_kreditoren;
	}


	/**
	 * @return the n_2002_bank
	 */
	public int getN_2002_bank() {
		return n_2002_bank;
	}


	/**
	 * @return the n_2010_darlehen
	 */
	public int getN_2010_darlehen() {
		return n_2010_darlehen;
	}


	/**
	 * @return the n_2011_hypotheken
	 */
	public int getN_2011_hypotheken() {
		return n_2011_hypotheken;
	}


	/**
	 * @return the n_2012_obligationen
	 */
	public int getN_2012_obligationen() {
		return n_2012_obligationen;
	}


	/**
	 * @return the n_2100_aktienkapital
	 */
	public int getN_2100_aktienkapital() {
		return n_2100_aktienkapital;
	}


	/**
	 * @return the n_2110_reserven
	 */
	public int getN_2110_reserven() {
		return n_2110_reserven;
	}


	/**
	 * @return the n_2111_gewinnvortrag
	 */
	public int getN_2111_gewinnvortrag() {
		return n_2111_gewinnvortrag;
	}


	/**
	 * Passiven: Fremdkapital: Kurzfristiges Fremdkapital
	 * @return
	 */
	public int getKFFremdkapital() {
		return n_2000_kreditoren + n_2002_bank;
	}


	/**
	 * Passiven: Fremdkapital: Langfristiges Fremdkapital
	 * @return
	 */
	public int getLFFremdkapital() {
		return n_2010_darlehen + n_2011_hypotheken + n_2012_obligationen;
	}


	/**
	 * Passiven: Fremdkapital
	 * @return
	 */
	public int getFremdkapital() {
		return getKFFremdkapital() + getLFFremdkapital();
	}


	/**
	 * Passiven: Eigenkapital: Grundkapital
	 * @return
	 */
	public int getGrundkapital() {
		return n_2100_aktienkapital;
	}


	/**
	 * Passiven: Eigenkapital: Zuwachskapital
	 * @return
	 */
	public int getZuwachskapital() {
		return n_2110_reserven + n_2111_gewinnvortrag;
	}


	/**
	 * Passiven: Eigenkapital
	 * @return
	 */
	public int getEigenkapital() {
		return getGrundkapital() + getZuwachskapital();
	}


	/**
	 * Passiven
	 * @return
	 */
	public int getPassiven() {
		return getFremdkapital() + getEigenkapital();
	}


	/**
	 * reset n_2000_kreditoren
	 */
	public void resetN_2000_kreditoren() {
		n_2000_kreditoren = tmp_2000_kreditoren;
	}


	/**
	 * reset n_2002_bank
	 */
	public void resetN_2002_bank() {
		n_2002_bank = tmp_2002_bank;
	}


	/**
	 * reset n_2010_darlehen
	 */
	public void resetN_2010_darlehen() {
		n_2010_darlehen = tmp_2010_darlehen;
	}


	/**
	 * reset n_2011_hypotheken
	 */
	public void resetN_2011_hypotheken() {
		n_2011_hypotheken = tmp_2011_hypotheken;
	}


	/**
	 * reset n_2012_obligationen
	 */
	public void resetN_2012_obligationen() {
		n_2012_obligationen = tmp_2012_obligationen;
	}


	/**
	 * reset n_2100_aktienkapital
	 */
	public void resetN_2100_aktienkapital() {
		n_2100_aktienkapital = tmp_2100_aktienkapital;
	}


	/**
	 * reset n_2110_reserven
	 */
	public void resetN_2110_reserven() {
		n_2110_reserven = tmp_2110_reserven;
	}


	/**
	 * reset n_2111_gewinnvortrag
	 */
	public void resetN_2111_gewinnvortrag() {
		n_2111_gewinnvortrag = tmp_2111_gewinnvortrag;
	}


	/**
	 * @param n_2000_kreditoren the n_2000_kreditoren to add or to subtract
	 */
	public void setN_2000_kreditoren(boolean plusMinus, int n_2000_kreditoren) {
		tmp_2000_kreditoren = this.n_2000_kreditoren;
		if (plusMinus) {
			this.n_2000_kreditoren += n_2000_kreditoren;
		} else {
			this.n_2000_kreditoren -= n_2000_kreditoren;
		}
	}


	/**
	 * @param n_2002_bank the n_2002_bank to add or to subtract
	 */
	public void setN_2002_bank(boolean plusMinus, int n_2002_bank) {
		tmp_2002_bank = this.n_2002_bank;
		if (plusMinus) {
			this.n_2002_bank += n_2002_bank;
		} else {
			this.n_2002_bank -= n_2002_bank;
		}
	}


	/**
	 * @param n_2010_darlehen the n_2010_darlehen to add or to subtract
	 */
	public void setN_2010_darlehen(boolean plusMinus, int n_2010_darlehen) {
		tmp_2010_darlehen = this.n_2010_darlehen;
		if (plusMinus) {
			this.n_2010_darlehen += n_2010_darlehen;
		} else {
			this.n_2010_darlehen -= n_2010_darlehen;
		}
	}


	/**
	 * @param n_2011_hypotheken the n_2011_hypotheken to add or to subtract
	 */
	public void setN_2011_hypotheken(boolean plusMinus, int n_2011_hypotheken) {
		tmp_2011_hypotheken = this.n_2011_hypotheken;
		if (plusMinus) {
			this.n_2011_hypotheken += n_2011_hypotheken;
		} else {
			this.n_2011_hypotheken -= n_2011_hypotheken;
		}
	}


	/**
	 * @param n_2012_obligationen the n_2012_obligationen to add or to subtract
	 */
	public void setN_2012_obligationen(boolean plusMinus, int n_2012_obligationen) {
		tmp_2012_obligationen = this.n_2012_obligationen;
		if (plusMinus) {
			this.n_2012_obligationen += n_2012_obligationen;
		} else {
			this.n_2012_obligationen -= n_2012_obligationen;
		}
	}


	/**
	 * @param n_2100_aktienkapital the n_2100_aktienkapital to add or to subtract
	 */
	public void setN_2100_aktienkapital(boolean plusMinus, int n_2100_aktienkapital) {
		tmp_2100_aktienkapital = this.n_2100_aktienkapital;
		if (plusMinus) {
			this.n_2100_aktienkapital += n_2100_aktienkapital;
		} else {
			this.n_2100_aktienkapital -= n_2100_aktienkapital;
		}
	}


	/**
	 * @param n_2110_reserven the n_2110_reserven to add or to subtract
	 */
	public void setN_2110_reserven(boolean plusMinus, int n_2110_reserven) {
		tmp_2110_reserven = this.n_2110_reserven;
		if (plusMinus) {
			this.n_2110_reserven += n_2110_reserven;
		} else {
			this.n_2110_reserven -= n_2110_reserven;
		}
	}


	/**
	 * @param n_2111_gewinnvortrag the n_2111_gewinnvortrag to add or to subtract
	 */
	public void setN_2111_gewinnvortrag(boolean plusMinus, int n_2111_gewinnvortrag) {
		tmp_2111_gewinnvortrag = this.n_2111_gewinnvortrag;
		if (plusMinus) {
			this.n_2111_gewinnvortrag += n_2111_gewinnvortrag;
		} else {
			this.n_2111_gewinnvortrag -= n_2111_gewinnvortrag;
		}
	}

}
