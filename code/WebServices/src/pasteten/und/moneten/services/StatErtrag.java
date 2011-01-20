package pasteten.und.moneten.services;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)

public class StatErtrag {

	/**
	 * Ertrag
	 */
	private int n_4000_warenertrag;
	private int n_4100_fabrikateertrag;
	private int n_4200_zinsertrag;

	private int tmp_4000_warenertrag;
	private int tmp_4100_fabrikateertrag;
	private int tmp_4200_zinsertrag;


	public StatErtrag() {
		createTable();
	}


	/**
	 * Anbindung DB, Initialisierung der einzelnen Werte
	 */
	public void createTable() {

	}


	/**
	 * @return the n_4000_warenertrag
	 */
	public int getN_4000_warenertrag() {
		return n_4000_warenertrag;
	}


	/**
	 * @return the n_4100_fabrikateertrag
	 */
	public int getN_4100_fabrikateertrag() {
		return n_4100_fabrikateertrag;
	}


	/**
	 * @return the n_4200_zinsertrag
	 */
	public int getN_4200_zinsertrag() {
		return n_4200_zinsertrag;
	}


	/**
	 * Ertrag
	 * @return
	 */
	public int getErtrag() {
		return n_4000_warenertrag + n_4100_fabrikateertrag + n_4200_zinsertrag;
	}


	/**
	 * reset n_4000_warenertrag
	 */
	public void resetN_4000_warenertrag() {
		n_4000_warenertrag = tmp_4000_warenertrag;
	}


	/**
	 * reset n_4100_fabrikateertrag
	 */
	public void resetN_4100_fabrikateertrag() {
		n_4100_fabrikateertrag = tmp_4100_fabrikateertrag;
	}


	/**
	 * reset n_4200_zinsertrag
	 */
	public void resetN_4200_zinsertrag() {
		n_4200_zinsertrag = tmp_4200_zinsertrag;
	}


	/**
	 * @param n_4000_warenertrag the n_4000_warenertrag to add or to subtract
	 */
	public void setN_4000_warenertrag(boolean plusMinus, int n_4000_warenertrag) {
		tmp_4000_warenertrag = this.n_4000_warenertrag;
		if (plusMinus) {
			this.n_4000_warenertrag += n_4000_warenertrag;
		} else {
			this.n_4000_warenertrag -= n_4000_warenertrag;
		}
	}


	/**
	 * @param n_4100_fabrikateertrag the n_4100_fabrikateertrag to add or to subtract
	 */
	public void setN_4100_fabrikateertrag(boolean plusMinus, int n_4100_fabrikateertrag) {
		tmp_4100_fabrikateertrag = this.n_4100_fabrikateertrag;
		if (plusMinus) {
			this.n_4100_fabrikateertrag += n_4100_fabrikateertrag;
		} else {
			this.n_4100_fabrikateertrag -= n_4100_fabrikateertrag;
		}
	}


	/**
	 * @param n_4200_zinsertrag the n_4200_zinsertrag to add or to subtract
	 */
	public void setN_4200_zinsertrag(boolean plusMinus, int n_4200_zinsertrag) {
		tmp_4200_zinsertrag = this.n_4200_zinsertrag;
		if (plusMinus) {
			this.n_4200_zinsertrag += n_4200_zinsertrag;
		} else {
			this.n_4200_zinsertrag -= n_4200_zinsertrag;
		}
	}

}
