/**
 * @author jivertow
 * Interface used to connect to mySql Database
 */

package pasteten.und.moneten.Interface;

import java.sql.SQLException;

public interface IMySqlDataProvider {

	public int UserFunctions(String username, String password, String function) throws SQLException;
	
}
