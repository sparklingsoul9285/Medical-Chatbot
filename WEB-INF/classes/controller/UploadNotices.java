package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.SimpleAttributeSet;

import dbConnector.DbConnection;

/**
 * Servlet implementation class UploadNotices
 */
@WebServlet("/UploadNotices")
public class UploadNotices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String notice="";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	notice=request.getParameter("notice");	
	DbConnection dbConnection;
	try {
		DateFormat dt=new SimpleDateFormat("dd/MM/yyyy");
		Date cdate=new Date();
		String c_date=dt.format(cdate);
		dbConnection = new DbConnection();
		dbConnection.inupdelOperation("INSERT INTO `notices`(`notice`, `date`) VALUES ('"+notice+"','"+c_date+"')");
	    response.sendRedirect("AdminHome.jsp?Result=");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
