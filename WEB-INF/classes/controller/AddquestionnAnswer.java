package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConnector.DbConnection;

/**
 * Servlet implementation class AddquestionnAnswer
 */
@WebServlet("/AddquestionnAnswer")
public class AddquestionnAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String answer,question;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path="D:/workspace1/ChatBotR1/WebContent/Doc/chatbotdataset.txt";
		answer=request.getParameter("answer");
		question=request.getParameter("question");
		BufferedReader br = new BufferedReader(new FileReader(path));
	    StringBuilder sb = new StringBuilder();
	    String line = br.readLine();
	    while (line != null) 
	    {
	     sb.append(line);
	    sb.append(System.lineSeparator());
	    line = br.readLine();
	    }
	    String PlainText = sb.toString();
	    PlainText=PlainText+"@\n"+question+"?\n# "+answer;
	    FileWriter fw = new FileWriter(path);
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write(PlainText);
	    bw.close();
	    response.sendRedirect("Addquestion.jsp?Result=");
	}

}
