package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbConnector.DbConnection;

/**
 * Servlet implementation class MedicalChatbotClass
 */
@WebServlet("/MedicalChatbotClass")
public class MedicalChatbotClass extends HttpServlet {

	String conversion="";
	Connection con=null;
	
	public void init(ServletConfig config) throws ServletException 
	{
		try
		{
			con=DbConnection.getConnection();
		} catch (Exception  e) {
			// TODO Auto-generated catch block Size of dd_id
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		conversion=request.getParameter("conversion");
		System.out.println("Last Conversion "+conversion);
		
		Integer id=(Integer)session.getAttribute("id");
		
		
		String keyword=request.getParameter("search");
		keyword=keyword.toLowerCase();
		keyword=keyword.trim();
		
		session.setAttribute("srch", keyword);
		
		GlobalFunction gf=new GlobalFunction();
		String disies_id=gf.getSymptons(keyword);
		
		TreeSet<String> ts=new TreeSet<>();
		
		
		
		//ArrayList<String> dd_id=new ArrayList<>();
		try
		{
			//String[] s_disies_id=disies_id.split(",");
			
		/*	for(String ss_d:s_disies_id)
			{*/
				
				PreparedStatement ps=con.prepareStatement("SELECT * FROM `diseases_medicine` where id='"+disies_id+"'");
				ResultSet rs=ps.executeQuery();
				System.out.println("PS "+ps);
				
				ArrayList<String> disease=new ArrayList<>();
				if(rs.next())
				{
					System.out.println("Hello");
					String diseases=rs.getString("diseases");
					String medicine=rs.getString("medicine");
					
					diseases="As per your symptots we suggest "+diseases+" and FirstAid Medicine is "+medicine+", we suggest please contacr to Nearest Hospital";
					
							ts.add(diseases+"_"+disies_id);
						//	System.out.println("Available "+d_id);
				}
				
				System.out.println("TS Size is "+ts.size());
				int ii=0;
				String final_rsl="";
				
				for(String tts:ts)
				{
					System.out.println(ii+" TTS "+tts);
					final_rsl=final_rsl+tts;
				}
				final_rsl=final_rsl.trim();
				//System.out.println("Finla RSL -- "+final_rsl);
				if(final_rsl.equals(""))
				{
					if(keyword.equals("hello") || keyword.equals("hi"))
					{
					//	System.out.println("True "+keyword);
						final_rsl="Hello Please Enter Symptons_0";
					}
					else
					{
						final_rsl="Please Seach online_0";
					}
				}
				
				conversion=conversion+"@"+keyword+"#"+final_rsl;
				
				System.out.println("Final Conversion is "+conversion);
				
				session.setAttribute("questionanswer",conversion);
				
				System.out.println("Size of dd_id "+ts.size());
				
				response.sendRedirect("ChatbotInteraction.jsp");
					
		}
		catch(Exception e)
		{
			System.out.println("Exc "+e);
		}
		
		/*
		String[] question_answer=conversion.split("@");
		
		
		int size=question_answer.length-1;
        System.out.println("size is "+size);

        for(int i=size;i>0;i--)
        {
	       	String quesanswer=question_answer[i];
	        String []onequesans=quesanswer.split("#");	
	        String question="";
	        String answer="";
	        question="Ritesh"+":"+onequesans[0];
	        answer="Chatbot : "+onequesans[1];
	        
	        System.out.println("Question "+question);
	        System.out.println("Answer "+answer);
	        
        }
		
		
*/		
		
	}

}

