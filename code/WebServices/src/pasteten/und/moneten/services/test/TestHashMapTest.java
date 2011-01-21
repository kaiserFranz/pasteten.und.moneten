package pasteten.und.moneten.services.test;

import pasteten.und.moneten.services.Konten;

public class TestHashMapTest implements Konten {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		HashMapTest test = new HashMapTest();
		test.createNameWert();
		test.createNummerWert();

		for (String name : Konten.kontenNamen) {
			System.out.println(test.getNameWert().get(name));
		}
		System.out.println();

		for (Integer nummer : Konten.kontenNummern) {
			System.out.println(test.getNummerWert().get(nummer));
		}
	}

}
