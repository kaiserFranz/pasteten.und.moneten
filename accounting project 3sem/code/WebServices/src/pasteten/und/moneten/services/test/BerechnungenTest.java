/**
 * 
 */
package pasteten.und.moneten.services.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pasteten.und.moneten.services.Berechnungen;
import pasteten.und.moneten.services.Bilanz;

/**
 * @author xy
 * @version 1.01
 * @date 15. Januar 2011
 *
 */
public class BerechnungenTest {

	private Bilanz bilanz;
	private HashMapTest test;
	private Berechnungen berechnungen;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bilanz = new Bilanz();
		test = new HashMapTest();
		bilanz.setNameWert(test.getNameWert());
		bilanz.setNummerWert(test.getNummerWert());
		berechnungen = new Berechnungen(bilanz);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Berechnungen#Berechnungen()}.
	 */
	@Test
	public void testBerechnungen() {
		assertNotNull(berechnungen);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Berechnungen#createValues()}.
	 */
	@Test
	public void testCreateValues() {
		int anlagevermoegen = 11;
		float wert1 = bilanz.getAnyValueByNumber(anlagevermoegen);
		float wert2 = berechnungen.getN_anlagevermoegen();
		boolean condition = false;

		if (wert1 == wert2) {
			condition = true;
		}
		assertTrue(condition);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Berechnungen#IntensitaetAnlagevermoegen()}.
	 */
	@Test
	public void testGetIntensitaetAnlagevermoegen() {
		float anlagevermoegen = berechnungen.getN_anlagevermoegen();
		float gesamtvermoegen = berechnungen.getN_gesamtvermoegen();
		float result = anlagevermoegen * 100 / gesamtvermoegen;
		boolean condition = false;

		if  (berechnungen.getIntensitaetAnlagevermoegen() == result) {
			condition = true;
		}
		assertTrue(condition);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Berechnungen#getFremdfinanzierungsgrad()}.
	 */
	@Test
	public void testGetFremdfinanzierungsgrad() {
		float fremdkapital = berechnungen.getN_fremdkapital();
		float gesamtkapital = berechnungen.getN_gesamtkapital();
		float result = fremdkapital * 100 / gesamtkapital;
		boolean condition = false;

		if (berechnungen.getFremdfinanzierungsgrad() == result) {
			condition = true;
		}
		assertTrue(condition);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Berechnungen#getEigenfinanzierungsgrad()}.
	 */
	@Test
	public void testGetEigenfinanzierungsgrad() {
		float eigenkapital = berechnungen.getN_eigenkapital();
		float gesamtkapital = berechnungen.getN_gesamtkapital();
		float result = eigenkapital * 100 / gesamtkapital;
		boolean condition = false;

		if (berechnungen.getEigenfinanzierungsgrad() == result) {
			condition = true;
		}
		assertTrue(condition);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Berechnungen#getLiquiditaetsgrad2()}.
	 */
	@Test
	public void testGetLiquiditaetsgrad2() {
		float fluessigeMittel = berechnungen.getN_fluessigeMittel();
		float kurzfristigesFremdkapital = berechnungen.getN_kurzfristigesFremdkapital();
		float forderungen = berechnungen.getN_forderungen();
		float result = (fluessigeMittel + forderungen) * 100 / kurzfristigesFremdkapital;
		boolean condition = false;

		if (berechnungen.getLiquiditaetsgrad2() == result) {
			condition = true;
		}
		assertTrue(condition);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Berechnungen#getAnlagendeckungsgrad2()}.
	 */
	@Test
	public void testGetAnlagendeckungsgrad2() {
		float eigenkapital = berechnungen.getN_eigenkapital();
		float langfristigesFremdkapital = berechnungen.getN_langfristigesFremdkapital();
		float anlagevermoegen = berechnungen.getN_anlagevermoegen();
		float result = (eigenkapital + langfristigesFremdkapital) * 100 / anlagevermoegen;
		boolean condition = false;

		if (berechnungen.getAnlagendeckungsgrad2() == result) {
			condition = true;
		}
		assertTrue(condition);
	}

	//	/**
	//	 * Test method for {@link pasteten.und.moneten.services.Berechnungen#getRentabilitaetEigenkapital()}.
	//	 */
	//	@Test
	//	public void testGetRentabilitaetEigenkapital() {
	//		fail("Not yet implemented");
	//	}
	//
	//	/**
	//	 * Test method for {@link pasteten.und.moneten.services.Berechnungen#getRentabilitaetGesamtkapital()}.
	//	 */
	//	@Test
	//	public void testGetRentabilitaetGesamtkapital() {
	//		fail("Not yet implemented");
	//	}
	//
	//	/**
	//	 * Test method for {@link pasteten.und.moneten.services.Berechnungen#getGewinnmarge()}.
	//	 */
	//	@Test
	//	public void testGetGewinnmarge() {
	//		fail("Not yet implemented");
	//	}
	//
	//	/**
	//	 * Test method for {@link pasteten.und.moneten.services.Berechnungen#getBruttogewinnmarge()}.
	//	 */
	//	@Test
	//	public void testGetBruttogewinnmarge() {
	//		fail("Not yet implemented");
	//	}
	//
	//	/**
	//	 * Test method for {@link pasteten.und.moneten.services.Berechnungen#getCashflow()}.
	//	 */
	//	@Test
	//	public void testGetCashflow() {
	//		fail("Not yet implemented");
	//	}
}
