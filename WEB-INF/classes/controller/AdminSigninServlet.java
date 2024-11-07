package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConnector.DbConnection;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/AdminSigninServlet")
public class AdminSigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String emailaddress,password,query;
	DbConnection dbConnection;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			dbConnection=new DbConnection();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		emailaddress=request.getParameter("email");
		password=request.getParameter("password");
		query="SELECT * FROM adminrecord WHERE username='"+emailaddress+"' And password='"+password+"'";
		try {
			ResultSet Rs=dbConnection.selectOperation(query);
			if(Rs.next())
			{
			response.sendRedirect("AdminHome.jsp?Result=Done");
			}
			else
			{
				response.sendRedirect("AdminSignIn.jsp?Result=failed");	
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
