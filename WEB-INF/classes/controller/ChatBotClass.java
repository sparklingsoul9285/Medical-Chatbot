package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
 * Servlet implementation class ChatBotClass
 */
@WebServlet("/ChatBotClass")
public class ChatBotClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TreeSet<String>data=new TreeSet<String>();
	String conversion="";
	Connection con=null;
	int wordcount=0,checkall=0;
	DbConnection dbConnection=null;
	TreeSet <String> afterStopwords=new TreeSet<String>();
	
	public void init(ServletConfig config) throws ServletException 
	{
		try {
			dbConnection=new DbConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		data.clear();
		HttpSession session=request.getSession();
		conversion=request.getParameter("conversion");
		Integer id=(Integer)session.getAttribute("id");
		if(conversion.equals(null))
		{
			conversion="";
		}
		
		String typeofquestion="";
		String questiontag="";
		String keyvalue="";
		checkall=0;
		try 
		{
			ResultSet rs=dbConnection.selectOperation("SELECT * FROM `questiontag`");
			while(rs.next())
			{
				questiontag=questiontag+rs.getString("name")+",";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String []questiontags=questiontag.split(",");
		String keyword=request.getParameter("search");
		System.out.println("keyword is "+keyword);
		for(String question:questiontags)
		{
			int stop=0;
			System.out.println("Question take "+question);
			keyword=keyword.toLowerCase();
			question=question.toLowerCase();
			if(keyword.contains(question))
			{
			typeofquestion=question;
			stop++;
			}
			if(stop==1)
            break;
		}
		System.out.println(typeofquestion);
		ExtractDataAndCreateTokens extractDataAndCreateTokens=new ExtractDataAndCreateTokens();
		extractDataAndCreateTokens.setData(keyword);
		TreeSet <String> tokens=new TreeSet<String>();
		tokens=extractDataAndCreateTokens.getTokens();
		System.out.println(tokens);
		StopWordsRemoval stopWordsRemoval=new StopWordsRemoval();
		stopWordsRemoval.setTokens(tokens);
	
		try {
			afterStopwords=stopWordsRemoval.getTokens();
			System.out.println(afterStopwords +"After stop word removal");
			
			BufferedReader br = new BufferedReader(new FileReader("D:/workspace1/ChatBotR1/WebContent/Doc/chatbotdataset.txt"));
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    while (line != null) 
		    {
		     sb.append(line);
		    sb.append(System.lineSeparator());
		    line = br.readLine();
		    }
		    String PlainText = sb.toString();
		    String []array=PlainText.split("@");
		    for(String lines:array)
		    {
		    	
		    	lines=lines.toLowerCase();
		    	typeofquestion=typeofquestion.toLowerCase();
		    	String []question=lines.split("#");
		    	String ques=question[0];
		    	int flag=0;
		    	wordcount=0;
		    	if(ques.contains(typeofquestion) )
		    	{
		    		//System.out.println("line contain question tag "+lines);
		    		wordcount=afterStopwords.size();
		    		Iterator<String> itr=afterStopwords.iterator();
				  while(itr.hasNext())
				   {
					    keyvalue=itr.next();
						keyvalue=keyvalue.toLowerCase();
						//System.out.println(keyvalue);
						if(ques.contains(keyvalue))
						{
						flag++;	
						System.out.println();
						}
					}
				  if(flag==wordcount)
				  {
					  String []ans=lines.split("#");
					  System.out.println("answer "+ans[1]);
					  data.add(ans[1]);
					  checkall++;
					  flag=0;
				  }
				  
				}
		    }
		    if(checkall<1)
		    {
		    	
		    	
			    if(conversion.equals(""))
		    	{
		    	conversion=keyword+"#sorry";	
		    	}
		    	else
		    	{
			    conversion=conversion+"@"+keyword+"#sorry";
		    	}
				    
			    DateFormat dt=new SimpleDateFormat("dd/MM/yyyy");
				Date cdate=new Date();
				String c_date=dt.format(cdate);
			    String query="INSERT INTO `Newquestion`( `question`, `askby`,`Date`) VALUES ('"+keyword+"','"+id+"','"+c_date+"')";
			   dbConnection.inupdelOperation(query);
			    }
			    else if(checkall>1)
			   {
				if(conversion.equals(""))
				{
				conversion=keyword+"#Be Specific";	
				}
				else
				{
				conversion=conversion+"@"+keyword+"#Be Spcific";
				}
			}
		    else if(checkall==1)
			{
		    	String ans="";
		    	Iterator<String> itr=data.iterator();
		    	while(itr.hasNext())
		    	{
			    	ans=itr.next();	
			    	}
				    if(conversion.equals(""))
					{
					conversion=keyword+"# "+ans;	
					}
					else
					{
					conversion=conversion+"@"+keyword+"# "+ans;
					}
			    }
				
		    data.clear();
		    session.setAttribute("questionanswer",conversion);
		    response.sendRedirect("ChatbotInteraction.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    /*
 */
	}

}
