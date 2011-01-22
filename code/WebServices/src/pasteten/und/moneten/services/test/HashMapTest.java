/**
 * 
 */
package pasteten.und.moneten.services.test;

import java.util.HashMap;
import java.util.Map;

import pasteten.und.moneten.services.Konten;

/**
 * Mit der Klasse können HashMaps generiert werden, um den
 * Code zu testen.
 * 
 * @author siddhartha
 * @version 1.01
 * @date 15. Januar 2011
 * 
 */
public class HashMapTest implements Konten {

	private Map<String, Number> nameWert;
	private Map<Number, Number> nummerWert;

	public HashMapTest() {
		//		createNameWert();
		//		createNummerWert();
		createMaps();
	}

	/**
	 * Die Methode initialisiert alle Konten nach
	 * Namen mit einem beliebigen Betrag von 1000 - 9000 CHF.
	 */
	public void createNameWert() {
		nameWert = new HashMap<String, Number>();
		for (String name : Konten.kontenNamen) {
			double rand = Math.round(((Math.random() * 9000) + 1000) * 100);
			rand -= rand % 5;
			rand /= 100;
			nameWert.put(name, rand);
		}
	}

	/**
	 * Die Methode initialisiert alle Konten nach
	 * Nummern mit einem beliebigen Betrag von 1000 - 9000 CHF.
	 */
	public void createNummerWert() {
		nummerWert = new HashMap<Number, Number>();
		for (int nummer : Konten.kontenNummern) {
			double rand = Math.round(((Math.random() * 9000) + 1000) * 100);
			rand -= rand % 5;
			rand /= 100;
			nummerWert.put(nummer, rand);
		}
	}

	/**
	 * Die Methode initialisiert alle Konten nach Namen
	 * und Nummern mit einem beliebigen Betrag von 1000 - 9000 CHF.
	 */
	public void createMaps() {
		nameWert = new HashMap<String, Number>();
		nummerWert = new HashMap<Number, Number>();
		int i = 0;

		for (String name : Konten.kontenNamen) {
			double rand = Math.round(((Math.random() * 9000) + 1000) * 100);
			rand -= rand % 5;
			rand /= 100;
			nameWert.put(name, rand);

			nummerWert.put(Konten.kontenNummern[i], rand);
			i++;
		}

	}

	/**
	 * 
	 * @return nameWert, HashMap nach Kontennamen
	 */
	public Map<String, Number> getNameWert() {
		return nameWert;
	}

	/**
	 * 
	 * @return nummerWert, HashMap nach Kontennummern
	 */
	public Map<Number, Number> getNummerWert() {
		return nummerWert;
	}

}
