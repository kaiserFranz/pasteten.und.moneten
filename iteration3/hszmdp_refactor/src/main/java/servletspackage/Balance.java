package servletspackage;

/**
 * Created by IntelliJ IDEA.
 * User: Milorad1389
 * Date: 21.12.2010
 * Time: 00:15:48
 * To change this template use File | Settings | File Templates.
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class Balance extends HttpServlet {
       private Connection connection;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String forwardToJsp = "/jsp/balance.jsp";

		RequestDispatcher dispatcherHeader = getServletContext().getRequestDispatcher(forwardToJsp);
		dispatcherHeader.forward(request, response);

	}
}
