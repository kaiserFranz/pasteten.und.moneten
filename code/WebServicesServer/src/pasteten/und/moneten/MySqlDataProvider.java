/**
 * @author jivertow
 * Implementation of IMySqlDataProvider to connect to Database via JDBC
 */
package pasteten.und.moneten;

import pasteten.und.moneten.Interface.IMySqlDataProvider;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


public class MySqlDataProvider implements IMySqlDataProvider {
	
	private static String connectionString = "";

	public MySqlDataProvider(){
		
	}
	
	public int UserFunctions(String username, String password, String function) throws SQLException{
		Connection conn = ConnectToDb(connectionString);
		ResultSet result = null;
		String statementString = "";
		//check which functions is asked for
		if (function == "register"){
			//statement has to be in JDBC-Escape-Syntax
			statementString = "{call spr_register(?, ?, ?)}";
		}
		if (function == "login"){
			statementString = "{call spr_login(?, ?, ?)}";
		}
		//preparing call and registering all parameters for stored procedure call
		CallableStatement statement = conn.prepareCall(statementString);
		statement.setString("userName", username);
		statement.setString("pw", password);
		statement.registerOutParameter("userId", Types.INTEGER);
		//execute query
		boolean resultAvailable = statement.execute();
		
		while (resultAvailable) {
			//assign procedure call result to variable
			result = statement.getResultSet();
			resultAvailable = statement.getMoreResults();
		}
		//closing all connections
		statement.close();
		conn.close();
		return result.getInt("userId");
	}
	
	private Connection ConnectToDb(String connString){
		try {
			Connection connection = DriverManager.getConnection(connString);
			return connection;
		}catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
		}
	}

}
