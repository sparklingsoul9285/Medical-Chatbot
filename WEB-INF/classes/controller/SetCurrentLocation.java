package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetCurrentLocation
 */
@WebServlet("/SetCurrentLocation")
public class SetCurrentLocation extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String lt=request.getParameter("lt");
		String lng=request.getParameter("lng");
		System.out.println("Lat "+lt);
		System.out.println("Lng "+lng);
		HttpSession session=request.getSession();
		session.setAttribute("lt", lt);
		session.setAttribute("lng", lng);
		response.sendRedirect("ChatbotInteraction.jsp?Result=");
	}
	

}
