package servletspackage;

import wsclient.HalloWeltService;
import wsclient.HalloWelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class Register extends HttpServlet {
       private Connection connection;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
            HalloWeltService service = new HalloWeltService();
            HalloWelt hallo = service.getHalloWeltPort();
            System.out.println();

        out.println("Hallo bre register i ovo:" + hallo.getHalloWelt());
        out.println("</html>");
        out.close();
	}
}
