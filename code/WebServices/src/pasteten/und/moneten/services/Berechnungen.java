package pasteten.und.moneten.services;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * Die Berechnungen liefern alle finanzmarktrelevanten Daten
 * zur Buchhaltung einer Firma.
 * 
 * @author siddhartha
 * @version 1.01
 * @date 15. Januar 2011
 *
 */

@WebService
@SOAPBinding(style = Style.RPC)

public class Berechnungen {

	/**
	 * Intensität des Anlagevermögens
	 */
	private float n_anlagevermoegen;
	private float n_gesamtvermoegen;

	/**
	 * Fremdfinanzierungsgrad
	 */
	private float n_fremdkapital;
	private float n_gesamtkapital;

	/**
	 * Eigenfinanzierungsgrad
	 */
	private float n_eigenkapital;

	/**
	 * Liquiditätsgrad 2
	 */
	private float n_fluessigeMittel;
	private float n_forderungen;
	private float n_kurzfristigesFremdkapital;

	/**
	 * Anlagedeckungsgrad 2
	 */
	private float n_langfristigesFremdkapital;

	/**
	 * Rentabilität des Eigenkapitals
	 */
	private float n_gewinn;

	/**
	 * Rentabilität des Gesamtkapitals
	 */
	private float n_zinsen;

	/**
	 * Gewinnmarge
	 */
	private float n_umsatz;

	/**
	 * Bruttogewinnmarge
	 */
	private float n_bruttogewinn;

	/**
	 * Cashflow
	 */
	private float n_aufwand;
	private float n_ertrag;


	public Berechnungen() {
		createValues();
	}

	public void createValues() {
		// Aktiven
		Bilanz bilanz = new Bilanz();
		n_fluessigeMittel = bilanz.getAnyValueByNumber(100);
		n_forderungen = bilanz.getAnyValueByNumber(101);
		n_anlagevermoegen = bilanz.getAnyValueByNumber(11);
		n_gesamtvermoegen = bilanz.getAnyValueByNumber(1);

		// Passiven
		n_kurzfristigesFremdkapital = bilanz.getAnyValueByNumber(200);
		n_langfristigesFremdkapital = bilanz.getAnyValueByNumber(201);
		n_fremdkapital = bilanz.getAnyValueByNumber(20);
		n_eigenkapital = bilanz.getAnyValueByNumber(21);
		n_gesamtkapital = bilanz.getAnyValueByNumber(2);

		// Aufwand
		n_aufwand = bilanz.getAnyValueByNumber(3);

		// Ertrag
		n_ertrag = bilanz.getAnyValueByNumber(4);

	}


	/**
	 * Die Software berechnet die Intensität des Anlagevermögens
	 * @return Intensität des Anlagevermögens
	 */
	public float IntensitaetAnlagevermoegen() {
		return n_anlagevermoegen * 100 / n_gesamtvermoegen;
	}

	/**
	 * Die Software berechnet den Fremdfinanzierungsgrad
	 * @return Fremdfinanzierungsgrad
	 */
	public float getFremdfinanzierungsgrad() {
		return n_fremdkapital * 100 / n_gesamtkapital;
	}

	/**
	 * Die Software berechnet den Eigenfinanzierungsgrad
	 * @return Eigenfinanzierungsgrad
	 */
	public float getEigenfinanzierungsgrad() {
		return n_eigenkapital * 100 / n_gesamtkapital;
	}

	/**
	 * Die Software berechnet den Liquiditätsgrad 2
	 * @return Liquiditätsgrad 2
	 */
	public float getLiquiditaetsgrad2() {
		return (n_fluessigeMittel + n_forderungen) * 100 / n_kurzfristigesFremdkapital;
	}

	/**
	 * Die Software berechnet den Anlagendeckungsgrad 2
	 * @return Anlagendeckungsgrad 2
	 */
	public float getAnlagendeckungsgrad2() {
		return (n_eigenkapital + n_langfristigesFremdkapital) * 100 / n_anlagevermoegen;
	}

	/**
	 * Die Software berechnet die Rentabilität des Eigenkapitals
	 * @return Rentabilität des Eigenkapitals
	 */
	public float getRentabilitaetEigenkapital() {
		return n_gewinn * 100 / n_eigenkapital;
	}

	/**
	 * Die Software berechnet die Rentabilität des Gesamtkapitals
	 * @return Rentabilität des Gesamtkapitals
	 */
	public float getRentabilitaetGesamtkapital() {
		return (n_gewinn + n_zinsen) * 100 / n_gesamtkapital;
	}

	/**
	 * Die Software berechnet die Gewinnmarge, der Gewinn
	 * und der Umsatz sind aber noch nicht verfügbar.
	 * @return Gewinnmarge
	 */
	public float getGewinnmarge() {
		return n_gewinn * 100 / n_umsatz;
	}

	/**
	 * Die Software berechnet die Bruttogewinnmarge, derBruttogewinn
	 * und der Umsatz sind aber noch nicht verfügbar.
	 * @return Bruttogewinnmarge
	 */
	public float getBruttogewinnmarge() {
		return n_bruttogewinn * 100 / n_umsatz;
	}

	/**
	 * Die Software berechnet den Cashflow, der Gewinn
	 * ist aber noch nicht verfügbar.
	 * @return Cashflow
	 */
	public float getCashflow() {
		return n_gewinn + n_aufwand;
		//		return n_ertrag - n_aufwand;
	}

}
