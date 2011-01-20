package pasteten.und.moneten.services;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)

public class StatAufwand {

	/**
	 * Aufwand
	 */
	private int n_3000_warenaufwand;
	private int n_3001_rohmaterialaufwand;
	private int n_3100_personalaufwand;
	private int n_3200_mietaufwand;
	private int n_3300_zinsaufwand;
	private int n_3400_abschreibungen;
	private int n_3500_unterhaltUndReparaturen;
	private int n_3600_versicherungsaufwand;
	private int n_3700_energieaufwand;
	private int n_3800_werbeaufwand;
	private int n_3900_uebrigerAufwand;

	private int tmp_3000_warenaufwand;
	private int tmp_3001_rohmaterialaufwand;
	private int tmp_3100_personalaufwand;
	private int tmp_3200_mietaufwand;
	private int tmp_3300_zinsaufwand;
	private int tmp_3400_abschreibungen;
	private int tmp_3500_unterhaltUndReparaturen;
	private int tmp_3600_versicherungsaufwand;
	private int tmp_3700_energieaufwand;
	private int tmp_3800_werbeaufwand;
	private int tmp_3900_uebrigerAufwand;


	public StatAufwand() {
		createTable();
	}


	/**
	 * Anbindung DB, Initialisierung der einzelnen Werte
	 */
	public void createTable() {

	}


	/**
	 * @return the n_3000_warenaufwand
	 */
	public int getN_3000_warenaufwand() {
		return n_3000_warenaufwand;
	}


	/**
	 * @return the n_3001_rohmaterialaufwand
	 */
	public int getN_3001_rohmaterialaufwand() {
		return n_3001_rohmaterialaufwand;
	}


	/**
	 * @return the n_3100_personalaufwand
	 */
	public int getN_3100_personalaufwand() {
		return n_3100_personalaufwand;
	}


	/**
	 * @return the n_3200_mietaufwand
	 */
	public int getN_3200_mietaufwand() {
		return n_3200_mietaufwand;
	}


	/**
	 * @return the n_3300_zinsaufwand
	 */
	public int getN_3300_zinsaufwand() {
		return n_3300_zinsaufwand;
	}


	/**
	 * @return the n_3400_abschreibungen
	 */
	public int getN_3400_abschreibungen() {
		return n_3400_abschreibungen;
	}


	/**
	 * @return the n_3500_unterhaltUndReparaturen
	 */
	public int getN_3500_unterhaltUndReparaturen() {
		return n_3500_unterhaltUndReparaturen;
	}


	/**
	 * @return the n_3600_versicherungsaufwand
	 */
	public int getN_3600_versicherungsaufwand() {
		return n_3600_versicherungsaufwand;
	}


	/**
	 * @return the n_3700_energieaufwand
	 */
	public int getN_3700_energieaufwand() {
		return n_3700_energieaufwand;
	}


	/**
	 * @return the n_3800_werbeaufwand
	 */
	public int getN_3800_werbeaufwand() {
		return n_3800_werbeaufwand;
	}


	/**
	 * @return the n_3900_uebrigerAufwand
	 */
	public int getN_3900_uebrigerAufwand() {
		return n_3900_uebrigerAufwand;
	}


	/**
	 * Aufwand
	 * @return
	 */
	public int getAufwand() {
		return n_3000_warenaufwand + n_3001_rohmaterialaufwand + n_3100_personalaufwand + n_3200_mietaufwand +
		n_3300_zinsaufwand + n_3400_abschreibungen + n_3500_unterhaltUndReparaturen + n_3600_versicherungsaufwand +
		n_3700_energieaufwand + n_3800_werbeaufwand + n_3800_werbeaufwand + n_3900_uebrigerAufwand;
	}


	/**
	 * reset n_3000_warenaufwand
	 */
	public void resetN_3000_warenaufwand() {
		n_3000_warenaufwand = tmp_3000_warenaufwand;
	}


	/**
	 * reset n_3001_rohmaterialaufwand
	 */
	public void resetN_3001_rohmaterialaufwand() {
		n_3001_rohmaterialaufwand = tmp_3001_rohmaterialaufwand;
	}


	/**
	 * reset n_3100_personalaufwand
	 */
	public void resetN_3100_personalaufwand() {
		n_3100_personalaufwand = tmp_3100_personalaufwand;
	}


	/**
	 * reset n_3200_mietaufwand
	 */
	public void resetN_3200_mietaufwand() {
		n_3200_mietaufwand = tmp_3200_mietaufwand;
	}


	/**
	 * reset n_3300_zinsaufwand
	 */
	public void resetN_3300_zinsaufwand() {
		n_3300_zinsaufwand = tmp_3300_zinsaufwand;
	}


	/**
	 * reset n_3400_abschreibungen
	 */
	public void resetN_3400_abschreibungen() {
		n_3400_abschreibungen = tmp_3400_abschreibungen;
	}


	/**
	 * reset n_3500_unterhaltUndReparaturen
	 */
	public void resetN_3500_unterhaltUndReparaturen() {
		n_3500_unterhaltUndReparaturen = tmp_3500_unterhaltUndReparaturen;
	}


	/**
	 * reset n_3600_versicherungsaufwand
	 */
	public void resetN_3600_versicherungsaufwand() {
		n_3600_versicherungsaufwand = tmp_3600_versicherungsaufwand;
	}


	/**
	 * reset n_3700_energieaufwand
	 */
	public void resetN_3700_energieaufwand() {
		n_3700_energieaufwand = tmp_3700_energieaufwand;
	}


	/**
	 * reset n_3800_werbeaufwand
	 */
	public void resetN_3800_werbeaufwand() {
		n_3800_werbeaufwand = tmp_3800_werbeaufwand;
	}


	/**
	 * reset n_3900_uebrigerAufwand
	 */
	public void resetN_3900_uebrigerAufwand() {
		n_3900_uebrigerAufwand = tmp_3900_uebrigerAufwand;
	}


	/**
	 * @param n_3000_warenaufwand the n_3000_warenaufwand to add or to subtract
	 */
	public void setN_3000_warenaufwand(boolean plusMinus, int n_3000_warenaufwand) {
		tmp_3000_warenaufwand = this.n_3000_warenaufwand;
		if (plusMinus) {
			this.n_3000_warenaufwand += n_3000_warenaufwand;
		} else {
			this.n_3000_warenaufwand -= n_3000_warenaufwand;
		}
	}


	/**
	 * @param n_3001_rohmaterialaufwand the n_3001_rohmaterialaufwand to add or to subtract
	 */
	public void setN_3001_rohmaterialaufwand(boolean plusMinus, int n_3001_rohmaterialaufwand) {
		tmp_3001_rohmaterialaufwand = this.n_3001_rohmaterialaufwand;
		if (plusMinus) {
			this.n_3001_rohmaterialaufwand += n_3001_rohmaterialaufwand;
		} else {
			this.n_3001_rohmaterialaufwand -= n_3001_rohmaterialaufwand;
		}
	}


	/**
	 * @param n_3100_personalaufwand the n_3100_personalaufwand to add or to subtract
	 */
	public void setN_3100_personalaufwand(boolean plusMinus, int n_3100_personalaufwand) {
		tmp_3100_personalaufwand = this.n_3100_personalaufwand;
		if (plusMinus) {
			this.n_3100_personalaufwand += n_3100_personalaufwand;
		} else {
			this.n_3100_personalaufwand -= n_3100_personalaufwand;
		}
	}


	/**
	 * @param n_3200_mietaufwand the n_3200_mietaufwand to add or to subtract
	 */
	public void setN_3200_mietaufwand(boolean plusMinus, int n_3200_mietaufwand) {
		tmp_3200_mietaufwand = this.n_3200_mietaufwand;
		if (plusMinus) {
			this.n_3200_mietaufwand += n_3200_mietaufwand;
		} else {
			this.n_3200_mietaufwand -= n_3200_mietaufwand;
		}
	}


	/**
	 * @param n_3300_zinsaufwand the n_3300_zinsaufwand to add or to subtract
	 */
	public void setN_3300_zinsaufwand(boolean plusMinus, int n_3300_zinsaufwand) {
		tmp_3300_zinsaufwand = this.n_3300_zinsaufwand;
		if (plusMinus) {
			this.n_3300_zinsaufwand += n_3300_zinsaufwand;
		} else {
			this.n_3300_zinsaufwand -= n_3300_zinsaufwand;
		}
	}


	/**
	 * @param n_3400_abschreibungen the n_3400_abschreibungen to add or to subtract
	 */
	public void setN_3400_abschreibungen(boolean plusMinus, int n_3400_abschreibungen) {
		tmp_3400_abschreibungen = this.n_3400_abschreibungen;
		if (plusMinus) {
			this.n_3400_abschreibungen += n_3400_abschreibungen;
		} else {
			this.n_3400_abschreibungen -= n_3400_abschreibungen;
		}
	}


	/**
	 * @param n_3500_unterhaltUndReparaturen the n_3500_unterhaltUndReparaturen to add or to subtract
	 */
	public void setN_3500_unterhaltUndReparaturen(boolean plusMinus, int n_3500_unterhaltUndReparaturen) {
		tmp_3500_unterhaltUndReparaturen = this.n_3500_unterhaltUndReparaturen;
		if (plusMinus) {
			this.n_3500_unterhaltUndReparaturen += n_3500_unterhaltUndReparaturen;
		} else {
			this.n_3500_unterhaltUndReparaturen -= n_3500_unterhaltUndReparaturen;
		}
	}


	/**
	 * @param n_3600_versicherungsaufwand the n_3600_versicherungsaufwand to add or to subtract
	 */
	public void setN_3600_versicherungsaufwand(boolean plusMinus, int n_3600_versicherungsaufwand) {
		tmp_3600_versicherungsaufwand = this.n_3600_versicherungsaufwand;
		if (plusMinus) {
			this.n_3600_versicherungsaufwand += n_3600_versicherungsaufwand;
		} else {
			this.n_3600_versicherungsaufwand -= n_3600_versicherungsaufwand;
		}
	}


	/**
	 * @param n_3700_energieaufwand the n_3700_energieaufwand to add or to subtract
	 */
	public void setN_3700_energieaufwand(boolean plusMinus, int n_3700_energieaufwand) {
		tmp_3700_energieaufwand = this.n_3700_energieaufwand;
		if (plusMinus) {
			this.n_3700_energieaufwand += n_3700_energieaufwand;
		} else {
			this.n_3700_energieaufwand -= n_3700_energieaufwand;
		}
	}


	/**
	 * @param n_3800_werbeaufwand the n_3800_werbeaufwand to add or to subtract
	 */
	public void setN_3800_werbeaufwand(boolean plusMinus, int n_3800_werbeaufwand) {
		tmp_3800_werbeaufwand = this.n_3800_werbeaufwand;
		if (plusMinus) {
			this.n_3800_werbeaufwand += n_3800_werbeaufwand;
		} else {
			this.n_3800_werbeaufwand -= n_3800_werbeaufwand;
		}
	}


	/**
	 * @param n_3900_uebrigerAufwand the n_3900_uebrigerAufwand to add or to subtract
	 */
	public void setN_3900_uebrigerAufwand(boolean plusMinus, int n_3900_uebrigerAufwand) {
		tmp_3900_uebrigerAufwand = this.n_3900_uebrigerAufwand;
		if (plusMinus) {
			this.n_3900_uebrigerAufwand += n_3900_uebrigerAufwand;
		} else {
			this.n_3900_uebrigerAufwand -= n_3900_uebrigerAufwand;
		}
	}

}
