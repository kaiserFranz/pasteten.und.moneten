/**
 * 
 */
package pasteten.und.moneten.services.test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pasteten.und.moneten.services.Bilanz;
import pasteten.und.moneten.services.Konten;

/**
 * @author xy
 * @version 1.01
 * @date 15. Januar 2011
 *
 */
public class BilanzTest implements Konten {

	private Bilanz bilanz;
	private HashMapTest test;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bilanz = new Bilanz();
		test = new HashMapTest();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Bilanz#Bilanz()}.
	 */
	@Test
	public void testBilanz() {
		assertNotNull(bilanz);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Bilanz#createKontenNamen()}.
	 */
	@Test
	public void testCreateKontenNamen() {
		Map<Number, String> kontenNamen = bilanz.getKontenNamen();
		int i = 0;
		boolean condition = false;

		for (Integer nummer : Konten.kontenNummern){
			if (kontenNamen.get(nummer).equals(Konten.kontenNamen[i])) {
				condition = true;
			} else {
				condition = false;
			}
			i++;
		}
		assertTrue(condition);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Bilanz#createKontenNummern()}.
	 */
	@Test
	public void testCreateKontenNummern() {
		Map<String, Number> kontenNummern = bilanz.getKontenNummern();
		int i = 0;
		boolean condition = false;

		for (String name : Konten.kontenNamen) {
			if (kontenNummern.get(name).intValue() == Konten.kontenNummern[i]) {
				condition = true;
			} else {
				condition = false;
			}
			i++;
		}
		assertTrue(condition);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Bilanz#createNameWert()}.
	 */
	@Test
	public void testCreateNameWert() {
		Map<String, Number> nameWert = bilanz.getNameWert();
		int i = 0;
		boolean condition = false;

		for (String name : Konten.kontenNamen) {
			if (nameWert.get(name).intValue() == 0) {
				condition = true;
			} else {
				condition = false;
			}
			i++;
		}
		assertTrue(condition);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Bilanz#createNummerWert()}.
	 */
	@Test
	public void testCreateNummerWert() {
		Map<Number, Number> nummerWert = bilanz.getNummerWert();
		int i = 0;
		boolean condition = true;

		for (Integer nummer : Konten.kontenNummern) {
			if (nummerWert.get(nummer).intValue() == 0) {
				condition = true;
			} else {
				condition = false;
			}
			i++;
		}
		assertTrue(condition);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Bilanz#createTmpNameWert()}.
	 */
	@Test
	public void testCreateTmpNameWert() {
		Map<String, Number> tmp_nameWert = bilanz.getTmpNameWert();
		int i = 0;
		boolean condition = false;

		for (String name : Konten.kontenNamen) {
			if (tmp_nameWert.get(name).intValue() == 0) {
				condition = true;
			} else {
				condition = false;
			}
			i++;
		}
		assertTrue(condition);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Bilanz#createTmpNummerWert()}.
	 */
	@Test
	public void testCreateTmpNummerWert() {
		Map<Number, Number> tmp_nummerWert = bilanz.getTmpNummerWert();
		int i = 0;
		boolean condition = false;

		for (Integer nummer : Konten.kontenNummern) {
			if (tmp_nummerWert.get(nummer).intValue() == 0) {
				condition = true;
			} else {
				condition = false;
			}
			i++;
		}
		assertTrue(condition);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Bilanz#setValueByName(boolean, java.lang.String, float)}.
	 */
	@Test
	public void testSetValueByName() {
		Map<String, Number> nameWert = bilanz.getNameWert();
		String konto = "Maschinen";
		float wert = 1000;
		boolean condition1 = false;
		boolean condition2 = false;
		boolean condition3 = false;

		if (nameWert.get(konto).floatValue() == 0) {
			condition1 = true;
		}

		bilanz.setValueByName(true, konto, wert);

		if (nameWert.get(konto).floatValue() == wert) {
			condition2 = true;
		}

		bilanz.setValueByName(false, konto, wert);

		if (nameWert.get(konto).floatValue() == 0) {
			condition3 = true;
		}

		assertTrue(condition1 && condition2 && condition3);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Bilanz#resetValueByName(java.lang.String)}.
	 */
	@Test
	public void testResetValueByName() {
		bilanz.setNameWert(test.getNameWert());
		String konto = "Warenertrag";
		float betrag = 2000;
		float wert1 = bilanz.getNameWert().get(konto).floatValue();

		bilanz.setValueByName(false, konto, betrag);
		bilanz.resetValueByName(konto);

		float wert2 = bilanz.getNameWert().get(konto).floatValue();
		boolean condition = false;

		if (wert1 == wert2) {
			condition = true;
		}
		assertTrue(condition);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Bilanz#setValueByNumber(boolean, int, float)}.
	 */
	@Test
	public void testSetValueByNumber() {
		Map<Number, Number> nummerWert = bilanz.getNummerWert();
		int konto = 1100;
		float betrag = 1000;
		boolean condition1 = false;
		boolean condition2 = false;
		boolean condition3 = false;

		if (nummerWert.get(konto).floatValue() == 0) {
			condition1 = true;
		}

		bilanz.setValueByNumber(true, konto, betrag);

		if (nummerWert.get(konto).floatValue() == betrag) {
			condition2 = true;
		}

		bilanz.setValueByNumber(false, konto, betrag);

		if (nummerWert.get(konto).floatValue() == 0) {
			condition3 = true;
		}

		assertTrue(condition1 && condition2 && condition3);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Bilanz#resetValueByNumber(int)}.
	 */
	@Test
	public void testResetValueByNumber() {
		bilanz.setNummerWert(test.getNummerWert());
		int konto = 4000;
		float betrag = 2000;
		float wert1 = bilanz.getNummerWert().get(konto).floatValue();

		bilanz.setValueByNumber(false, konto, betrag);
		bilanz.resetValueByNumber(konto);

		float wert2 = bilanz.getNummerWert().get(konto).floatValue();
		boolean condition = false;

		if (wert1 == wert2) {
			condition = true;
		}
		assertTrue(condition);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Bilanz#getAnyValueByName(java.lang.String)}.
	 */
	@Test
	public void testGetAnyValueByName() {
		bilanz.setNameWert(test.getNameWert());
		// Die Methode arbeitet intern mit der GetAnyValueByNumber-Methode weiter
		bilanz.setNummerWert(test.getNummerWert());
		float eroeffnungsbilanz = bilanz.getNameWert().get("Eröffnungsbilanz").floatValue();
		float schlussbilanz = bilanz.getNameWert().get("Schlussbilanz").floatValue();
		float erfolgsrechnung = bilanz.getNameWert().get("Erfolgsrechnung").floatValue();
		float abschluss = eroeffnungsbilanz + schlussbilanz + erfolgsrechnung;
		boolean condition = false;

		if (bilanz.getAnyValueByName("Abschluss") == abschluss) {
			condition = true;
		}
		assertTrue(condition);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.Bilanz#getAnyValueByNumber(int)}.
	 */
	@Test
	public void testGetAnyValueByNumber() {
		bilanz.setNummerWert(test.getNummerWert());
		float eroeffnungsbilanz = bilanz.getNummerWert().get(5000).floatValue();
		float schlussbilanz = bilanz.getNummerWert().get(5001).floatValue();
		float erfolgsrechnung = bilanz.getNummerWert().get(5100).floatValue();
		float abschluss = eroeffnungsbilanz + schlussbilanz + erfolgsrechnung;
		boolean condition = false;

		if (bilanz.getAnyValueByNumber(5) == abschluss) {
			condition = true;
		}
		assertTrue(condition);
	}

}
