package wsserver;

import javax.xml.ws.Endpoint;

public class HalloWeltServer {

	public static void main (String args[]) {

		HalloWelt server = new HalloWelt();

		Endpoint endpoint = Endpoint.publish("http://192.168.0.112:8081/hszmdp/services/hallo", server);
	}

}
