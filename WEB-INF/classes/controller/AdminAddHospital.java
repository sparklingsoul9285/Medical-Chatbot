package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConnector.DbConnection;

/**
 * Servlet implementation class AdminAddHospital
 */
@WebServlet("/AdminAddHospital")
public class AdminAddHospital extends HttpServlet {

	String hname,lati,lngi,mobilenumber;
	
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
	
	hname=request.getParameter("hname");
	lati=request.getParameter("lati");
	lngi=request.getParameter("lngi");
	mobilenumber=request.getParameter("mnumber");
	String query="INSERT INTO `hospital_details`(`h_name`, `h_lat`, `h_long`, `h_mobile`) VALUES ('"+hname+"','"+lati+"','"+lngi+"','"+mobilenumber+"')";
	
	try 
	{
		int status=dbConnection.inupdelOperation(query);
		if(status>0)
		{
		response.sendRedirect("adminAddHospital.jsp?Result=Done");
		}
		else
		{
			response.sendRedirect("adminAddHospital.jsp?fail=add");
		}
		
	} catch (SQLException e) 
	{
		System.out.println("Exc "+e);
	}
	
	}


}
