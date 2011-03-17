/**
 * 
 */
package pasteten.und.moneten.services.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pasteten.und.moneten.services.StatAbschluss;

/**
 * @author xy
 * @version 1.01
 * @date 15. Januar 2011
 *
 */
public class StatAbschlussTest {
	
	private StatAbschluss abschluss1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		abschluss1 = new StatAbschluss();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		abschluss1 = null;
	}


	/**
	 * Test method for {@link pasteten.und.moneten.services.StatAbschluss#getN_5000_eroeffnungsbilanz()}.
	 */
	@Test
	public void testGetN_5000_eroeffnungsbilanz() {
		abschluss1.getN_5000_eroeffnungsbilanz();
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.StatAbschluss#getN_5001_schlussbilanz()}.
	 */
	@Test
	public void testGetN_5001_schlussbilanz() {
		abschluss1.getN_5001_schlussbilanz();
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.StatAbschluss#getN_5100_erfolgsrechnung()}.
	 */
	@Test
	public void testGetN_5100_erfolgsrechnung() {
		abschluss1.getN_5100_erfolgsrechnung();
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.StatAbschluss#getAbschluss()}.
	 */
	@Test
	public void testGetAbschluss() {
		abschluss1.getAbschluss();
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.StatAbschluss#resetN_5000_eroeffnungsbilanz()}.
	 */
	@Test
	public void testResetN_5000_eroeffnungsbilanz() {
		abschluss1.resetN_5000_eroeffnungsbilanz();
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.StatAbschluss#resetN_5001_schlussbilanz()}.
	 */
	@Test
	public void testResetN_5001_schlussbilanz() {
		abschluss1.resetN_5001_schlussbilanz();
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.StatAbschluss#resetN_5100_erfolgsrechnung()}.
	 */
	@Test
	public void testResetN_5100_erfolgsrechnung() {
		abschluss1.resetN_5100_erfolgsrechnung();
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.StatAbschluss#setN_5000_eroeffnungsbilanz(boolean, int)}.
	 */
	@Test
	public void testSetN_5000_eroeffnungsbilanz() {
		boolean plusMinus = true;
		int n_5000_eroeffnungsbilanz = 2000;
		abschluss1.setN_5000_eroeffnungsbilanz(plusMinus, n_5000_eroeffnungsbilanz);
		int expected = 2000;
		assertEquals(expected, n_5000_eroeffnungsbilanz);
			
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.StatAbschluss#setN_5001_schlussbilanz(boolean, int)}.
	 */
	@Test
	public void testSetN_5001_schlussbilanz() {
		boolean plusMinus = false;
		int n_5001_schlussbilanz = 2000;
		abschluss1.setN_5001_schlussbilanz(plusMinus, n_5001_schlussbilanz);
		int expected = 2000;
		assertEquals(expected, n_5001_schlussbilanz);
	}

	/**
	 * Test method for {@link pasteten.und.moneten.services.StatAbschluss#setN_5100_erfolgsrechnung(boolean, int)}.
	 */
	@Test
	public void testSetN_5100_erfolgsrechnung() {
		boolean plusMinus = true;
		int n_5100_erfolgsrechnung = 1500;
		abschluss1.setN_5100_erfolgsrechnung(plusMinus, n_5100_erfolgsrechnung);
		int expected = 1500;
		assertEquals(expected, n_5100_erfolgsrechnung);
	}

}
