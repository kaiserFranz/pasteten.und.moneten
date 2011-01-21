package pasteten.und.moneten.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * Die Bilanz stellt die einzelnen Konten und
 * die darin enthaltenen Beträge zur Verfügung.
 * 
 * @author siddhartha
 * @version 1.01
 * @date 15. Januar 2011
 *
 */

@WebService
@SOAPBinding(style = Style.RPC)

public class Bilanz implements Konten {

	private Map<Number, String> kontenNamen;
	private Map<String, Number> kontenNummern;
	private Map<String, Number> nameWert;
	private Map<Number, Number> nummerWert;
	private Map<String, Number> tmp_nameWert;
	private Map<Number, Number> tmp_nummerWert;

	public Bilanz() {
		createKontenNamen();
		createKontenNummern();
		createNameWert();
		createNummerWert();
		createTmpNameWert();
		createTmpNummerWert();
	}

	/**
	 * Anbindung DB, Initialisierung der einzelnen Werte
	 */
	public void createTable() {

	}

	/**
	 * Die Methode erzeugt eine HashMap Kontennamen
	 */
	public void createKontenNamen() {
		kontenNamen = new HashMap<Number, String>();
		int i = 0;
		for (String name : Konten.kontenNamen) {
			kontenNamen.put(Konten.kontenNummern[i], name);
			i++;
		}
	}

	/**
	 * Die Methode erzeugt eine HashMap Kontennummern
	 */
	public void createKontenNummern() {
		kontenNummern = new HashMap<String, Number>();
		int i = 0;
		for (int nummer : Konten.kontenNummern) {
			kontenNummern.put(Konten.kontenNamen[i], nummer);
			i++;
		}
	}

	/**
	 * Die Methode initialisiert alle Konten
	 * nach Namen mit einem Nullbetrag
	 */
	public void createNameWert() {
		nameWert = new HashMap<String, Number>();
		for (String name : Konten.kontenNamen) {
			nameWert.put(name, 0);
		}
	}

	/**
	 * Gibt eine HashMap mit allen Kontennamen und Betrag aus
	 * @return Konten nach Namen und Betrag
	 */
	public Map<String, Number> getNameWert() {
		return nameWert;
	}

	/**
	 * Die Methode initialisiert alle Konten
	 * nach Nummer mit einem Nullbetrag
	 */
	public void createNummerWert() {
		nummerWert = new HashMap<Number, Number>();
		for (int nummer : Konten.kontenNummern) {
			nummerWert.put(nummer, 0);
		}
	}

	/**
	 * Gibt eine HashMap mit allen Kontennamen und Betrag aus
	 * @return Konten nach Nummer und Betrag
	 */
	public Map<Number, Number> getNummerWert() {
		return nummerWert;
	}

	/**
	 * Die Methode initialisiert eine temporäre HashMap
	 * mit allen Konten nach Namen mit einem Nullbetrag
	 */
	public void createTmpNameWert() {
		tmp_nameWert = new HashMap<String, Number>();
		for (String name : Konten.kontenNamen) {
			tmp_nameWert.put(name, 0);
		}
	}

	/**
	 * Die Methode initialisiert eine temporäre HashMap
	 * mit allen Konten nach Nummer mit einem Nullbetrag
	 */
	public void createTmpNummerWert() {
		tmp_nummerWert = new HashMap<Number, Number>();
		for (int nummer : Konten.kontenNummern) {
			tmp_nummerWert.put(nummer, 0);
		}
	}

	/**
	 * Die Methode manipuliert Soll oder Haben nach Kontennamen.
	 * @param plusMinus
	 * @param key
	 * @param value
	 */
	public void setValueByName(boolean plusMinus, String key, float value) throws IllegalArgumentException {
		if (!nameWert.containsKey(key)) {
			throw new IllegalArgumentException("Bitte geben Sie einen gültigen Kontennamen an.");
		}

		tmp_nameWert.put(key, nameWert.get(key));

		if (plusMinus) {
			nameWert.put(key, value + nameWert.get(key).floatValue());
		} else {
			nameWert.put(key, value - nameWert.get(key).floatValue());
		}
	}

	/**
	 * Die Methode stellt den letzten Wert wieder her(nach Kontennamen).
	 * @param key
	 */
	public void resetValueByName(String key) {
		nameWert.put(key, tmp_nameWert.get(key));
	}

	/**
	 * Die Methode manipuliert Soll oder Haben nach Kontennummer.
	 * @param plusMinus
	 * @param key
	 * @param value
	 */
	public void setValueByNumber(boolean plusMinus, int key, float value) throws IllegalArgumentException {
		if (!nummerWert.containsKey(key)) {
			throw new IllegalArgumentException("Bitte geben Sie einen gültige Kontennummer an.");
		}

		tmp_nummerWert.put(key, nummerWert.get(key));

		if (plusMinus) {
			nummerWert.put(key, value + nummerWert.get(key).floatValue());
		} else {
			nummerWert.put(key, value - nummerWert.get(key).floatValue());
		}
	}

	/**
	 * Die Methode stellt den letzten Wert wieder her(nach Kontennummer).
	 * @param key
	 */
	public void resetValueByNumber(int key) {
		nummerWert.put(key, tmp_nummerWert.get(key));
	}

	/**
	 * Die Methode gibt den gesuchten Wert aus(nach Kontennamen).
	 * @param key
	 * @return value you are looking for by name
	 */
	public float getAnyValueByName(String key) throws IllegalArgumentException {
		if (!kontenNamen.containsKey(key)) {
			throw new IllegalArgumentException("Bitte geben Sie einen gültigen Kontennamen an.");
		}

		int secondaryKey = (Integer) kontenNummern.get(key);
		return getAnyValueByNumber(secondaryKey);
	}

	/**
	 * Die Methode gibt den gesuchten Wert aus(nach Kontenummer).
	 * @param key
	 * @return value you are looking for by number
	 */
	public float getAnyValueByNumber(int key) {
		Map<Number, Number> sortedMap = new TreeMap<Number, Number>(nummerWert);
		Set<Number> ref = sortedMap.keySet();
		Iterator<Number> it = ref.iterator();
		int number = 0;
		float result = 0;

		while (key != number) {
			number = it.next().intValue();
		}

		if (number < 1000) {

			while (number != key + 1) {

				while (number < 1000) {
					number = it.next().intValue();
				}

				while (!(number < 1000)) {
					result += sortedMap.get(number).floatValue();
					number = it.next().intValue();
				}
			}
			return result;

		} else {
			return sortedMap.get(number).floatValue();
		}
	}

	/**
	 * @return the kontenNamen
	 */
	public Map<Number, String> getKontenNamen() {
		return kontenNamen;
	}

	/**
	 * @return the kontenNummern
	 */
	public Map<String, Number> getKontenNummern() {
		return kontenNummern;
	}

	/**
	 * @return the tmp_nameWert
	 */
	public Map<String, Number> getTmpNameWert() {
		return tmp_nameWert;
	}

	/**
	 * @return the tmp_nummerWert
	 */
	public Map<Number, Number> getTmpNummerWert() {
		return tmp_nummerWert;
	}

	/**
	 * @param nameWert the nameWert to set
	 */
	public void setNameWert(Map<String, Number> nameWert) {
		this.nameWert = nameWert;
	}

	/**
	 * @param nummerWert the nummerWert to set
	 */
	public void setNummerWert(Map<Number, Number> nummerWert) {
		this.nummerWert = nummerWert;
	}

}
