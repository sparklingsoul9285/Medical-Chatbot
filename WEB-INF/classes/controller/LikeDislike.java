package controller;

import java.io.IOException; 
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConnector.DbConnection;


/**
 * Servlet implementation class LikeDislike
 */
@WebServlet("/LikeDislike")
public class LikeDislike extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Connection con;
	
	public void init(ServletConfig config) throws ServletException {

		try 
		{
			con=DbConnection.getConnection();
		}
		catch (Exception e) 
		{
			System.out.println("Exc "+e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String p_id	=request.getParameter("p_id");
		String id	=request.getParameter("id");
		System.out.println("P Id "+p_id);
		String sts	=request.getParameter("sts");
		System.out.println("Status "+sts);
		int i=0;
		int j=0;
		if(sts.equals("lk"))
		{
			System.out.println("Like Come");
			i++; 

			try 
			{
				
				PreparedStatement ps=con.prepareStatement("UPDATE `qa_hospital` SET `lk_count`=`lk_count`+'"+i+"' WHERE id='"+p_id+"'");
				int ii=ps.executeUpdate();
				if(ii>0)
					{
						response.sendRedirect("qa_viewuser.jsp?id="+id);
					}
					else
					{
						response.sendRedirect("qa_viewuser.jsp?id="+id);
					}
			}
			catch (Exception e) 
			{
				System.out.println("Exc "+e);
			}
		}
		else
		{
			System.out.println("DLike Come");
			j++;
			try 
			{
				
				PreparedStatement ps=con.prepareStatement("UPDATE `qa_hospital` SET `dlk_count`=`dlk_count`+'"+j+"' WHERE id='"+p_id+"'");
				int ii=ps.executeUpdate();
				if(ii>0)
				{
					response.sendRedirect("qa_viewuser.jsp?id="+id);
				}
				else
				{
					response.sendRedirect("qa_viewuser.jsp?id="+id);
				}
			}
			catch (Exception e) 
			{
				System.out.println("Exc "+e);
			}
		} 
		
	}
}
