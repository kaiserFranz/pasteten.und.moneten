package pasteten.und.moneten.server;

import javax.xml.ws.Endpoint;
import pasteten.und.moneten.services.HalloWelt;


public class HalloWeltServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		HalloWelt server = new HalloWelt();
		Endpoint endpoint = Endpoint.publish("http://localhost:8080/calculator", server);

	}

}
