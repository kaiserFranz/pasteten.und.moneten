package pasteten.und.moneten;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


@WebService
@SOAPBinding(style=Style.RPC)

public class HalloWelt {

	public String getHalloWelt() {
		return "Hallo Welt";
	}
	
	/**
	 * DB-Anbindung
	 * Methode für Login
	 * Methode für Registrierung
	 * Class Bilanzen laden und speichern über User ID
	 * Calculation
	 * 
	 */
	
	public int login(String username, String password) {
		return 0;
	}

}
