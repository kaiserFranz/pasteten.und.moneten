package pasteten.und.moneten;

import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import pasteten.und.moneten.Interface.IMySqlDataProvider;

@WebService
@SOAPBinding(style=Style.RPC)

public class HalloWelt {


	private IMySqlDataProvider m_dataProvider;
	

	public String getHalloWelt() {
		return "Hallo Welt";
	}
	
	
	public int login(String username, String password) {
		return 0;

	 * @throws SQLException 
	 * 
	 */
	
	public int UserLogin(String username, String password) throws SQLException {
		return m_dataProvider.UserFunctions(username, password, "login");
	}
	
	public int UserRegistration(String username, String password) throws SQLException{
		return m_dataProvider.UserFunctions(username, password, "register");
	}

}
