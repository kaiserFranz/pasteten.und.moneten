package pasteten.und.moneten.services;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


@WebService
@SOAPBinding(style = Style.RPC)


public class HalloWelt {

	public String getHalloWelt() {
		return "Hallo Welt";
	}

}
