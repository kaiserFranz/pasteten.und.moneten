package pasteten.und.moneten;

import javax.xml.ws.Endpoint;

public class HalloWeltServer {

	public static void main (String args[]) {

		HalloWelt server = new HalloWelt();

		Endpoint endpoint = Endpoint.publish("http://localhost:8080/hallo", server);
	}

}
