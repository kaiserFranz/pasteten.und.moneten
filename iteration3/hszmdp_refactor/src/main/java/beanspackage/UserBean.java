package beanspackage;

import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;


public class UserBean extends HttpServlet {


   private Connection connection;


   public void init(javax.servlet.ServletConfig config)
      throws ServletException {

      // 
      super.init(config);

      // read database parameter from WEB-INF/web.xml 
      String driver = config.getInitParameter("jdbcClass");
      String dbURL = config.getInitParameter("dbURL");
      String dbUser = config.getInitParameter("username");
      String dbPass = config.getInitParameter("password");

      // Initialisze database connection
      try {
         // load database driver
         Class.forName(driver);

         // create db-connection
         connection =
            DriverManager.getConnection(dbURL, dbUser, dbPass);
      } catch (Exception exc) {
         throw new ServletException("SQL-Exception in init()", exc);
      }
   }
   public String getUserPw(){
       ResultSet rs = null;

	    try {
		    Statement stmt = connection.createStatement();
		    rs = stmt.executeQuery("SELECT password FROM `user` WHERE UserName='milo'");
		    rs.close();
	     } catch (SQLException e) {
	         e.getStackTrace();
        }
	   return "sta je bre";
   }
    public String getTestName(){
        
        return "Ja sam ja la la la";
    }
   

   public void destroy() {
      try {
         connection.close();
      } catch (SQLException exc) {
         log("SQL-Exception in destroy()", exc);
      }
   }
}
