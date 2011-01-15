package beanspackage;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class registerUser {
    private Connection connection;
    String driver = "com.mysql.jdbc.Driver";
    String dbURL = "jdbc:mysql://192.168.0.112/hszmdp";
    String dbUser = "admin";
    String dbPass = "admin";

    public String getUserPw() throws ClassNotFoundException, SQLException{

        String toReturn = null;

        // load database driver
        Class.forName(driver);

        // create db-connection
        connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
        ResultSet rs = null;

	    try {
		    Statement stmt = connection.createStatement();
		    rs = stmt.executeQuery("SELECT password FROM `user` WHERE UserName='milo'");
            //toReturn = rs.getString("password");
            while (rs.next()) {
                   toReturn = rs.getString("password");
            }
		    rs.close();

	     } catch (SQLException e) {
	         e.getStackTrace();
        }

        return toReturn;
        
    }
}

