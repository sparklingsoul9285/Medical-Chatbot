package dbConnector;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewRecord
 */
@WebServlet("/AddNewRecord")
public class AddNewRecord extends HttpServlet {

	DbConnection dbConnection;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			dbConnection = new DbConnection();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String a = request.getParameter("a");
		String b = request.getParameter("b");

		String query = "INSERT INTO `diseases_medicine`(`diseases`, `medicine`) VALUES ('"+a+"','"+b+"')";

		try 
		{
			int status = dbConnection.inupdelOperation(query);
			response.sendRedirect("addSymptonMedicine.jsp?Result=Done");

		} catch (SQLException e) {
			System.out.println("Excc "+e);
		}

	}

}
