package servletspackage;

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
public class LoggedIn extends HttpServlet {
       private Connection connection;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String forwardToJsp = "/jsp/loggedin.jsp";

		RequestDispatcher dispatcherHeader = getServletContext().getRequestDispatcher(forwardToJsp);
		dispatcherHeader.forward(request, response);

	}
    public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		doGet(request, response);
	}
}
