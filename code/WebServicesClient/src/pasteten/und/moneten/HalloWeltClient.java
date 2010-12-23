package pasteten.und.moneten;

public class HalloWeltClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		HalloWeltService service = new HalloWeltService();
		HalloWelt hallo = service.getHalloWeltPort();
		System.out.println(hallo.getHalloWelt());
	}

}