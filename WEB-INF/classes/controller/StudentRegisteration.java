package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.FNEG;

import dbConnector.DbConnection;

/**
 * Servlet implementation class StudentRegisteration
 */
@WebServlet("/StudentRegisteration")
public class StudentRegisteration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String firstname,lastname,prn,birthday,emailaddress,gender,password,query,mobilenumber;
	
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
	String uu_type=request.getParameter("u_type");
	firstname=request.getParameter("fname");
	lastname=request.getParameter("lname");
	mobilenumber=request.getParameter("mnumber");
	emailaddress=request.getParameter("email");
	birthday=request.getParameter("dob");
	gender=request.getParameter("gender");
	password=request.getParameter("password");
	query="INSERT INTO `user_details`(`fname`, `lname`, `mobile`,`email`,`dob`, `gender`, `pwd`) VALUES ('"+firstname+"','"+lastname+"','"+mobilenumber+"','"+emailaddress+"','"+birthday+"','"+gender+"','"+password+"')";
	
	try 
	{
		int status=dbConnection.inupdelOperation(query);
		
		if(uu_type.equals("User"))
		{
		response.sendRedirect("UserSignUp.jsp?Result=Done");
		}
		else
		{
			response.sendRedirect("adminAddUser.jsp?Result=Done");
		}
	} catch (SQLException e) 
	{
		System.out.println("Exc "+e);
	}
	
	}

}
