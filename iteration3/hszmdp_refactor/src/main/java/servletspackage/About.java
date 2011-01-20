package servletspackage;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.io.IOException;



@SuppressWarnings("serial")
public class About extends HttpServlet {
       private Connection connection;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String forwardToJsp = "/jsp/about.jsp";

		RequestDispatcher dispatcherHeader = getServletContext().getRequestDispatcher(forwardToJsp);
		dispatcherHeader.forward(request, response);

	}
}
