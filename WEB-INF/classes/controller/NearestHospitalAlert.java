package controller;

import java.io.IOException; 
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;


import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbConnector.DbConnection;

/**
 * Servlet implementation class NearestHospitalAlert
 */
@WebServlet("/NearestHospitalAlert")
public class NearestHospitalAlert extends HttpServlet {
	String conversion="";
	Connection con=null;
	
	public void init(ServletConfig config) throws ServletException 
	{
		try
		{
			con=DbConnection.getConnection();
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("id");
		HttpSession session=request.getSession();
		String c_lt=session.getAttribute("lt").toString();
		String c_lng=session.getAttribute("lng").toString();
		
		
		
		try 
		{
			String h_id="";
			PreparedStatement ps=con.prepareStatement("SELECT * FROM `diseases_medicine` where id='"+id+"'");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				h_id=rs.getString("hospital_id");
			}
			
			String[] h_id_array=h_id.split(",");
			
			System.out.println("h_id_array "+Arrays.toString(h_id_array));
			
			GlobalFunction gf=new GlobalFunction();
			CalculaeDistanceHaversine cdh=new CalculaeDistanceHaversine();
			
			double c_lt_d=Double.parseDouble(c_lt);
			double c_lng_d=Double.parseDouble(c_lng);
			
			HashMap<String,Double> hm=new HashMap<String,Double>();
			//Map<String, Double> budget = new HashMap<>();
			for(String hh:h_id_array)
			{
				String lt=gf.getLatitude(hh);
				String lng=gf.getLongitude(hh);
				
				double lt_d=Double.parseDouble(lt);
				double lng_d=Double.parseDouble(lng);
				
				double distance=cdh.distance(c_lt_d, c_lng_d, lt_d, lng_d, "K");
				System.out.println("Distance "+distance);
				hm.put(hh, distance);
				
			}
			
		System.out.println("Hash Map is "+hm);
			
		
		Map<Integer, String> map = sortByValues(hm); 
		System.out.println("After Sorting:");
		
		ArrayList<String> vl=new ArrayList<>();
 		
	      Set set2 = map.entrySet();
	      Iterator iterator2 = set2.iterator();
	      while(iterator2.hasNext()) 
	      {
	    	  
	           Map.Entry me2 = (Map.Entry)iterator2.next();
	          
	           System.out.print(me2.getKey() + ": ");
	           vl.add(me2.getKey().toString());
	           System.out.println(me2.getValue());
	      }
	      String small_id=vl.get(0);

	      System.out.println("Small ID is( Nearest Hospital ID ) "+small_id);
	      
	      String n_h_mobile=gf.getHospMobileNumber(small_id);
	      String n_h_name=gf.getHospName(small_id);
	
	      System.out.println("Nearest Hospital Mobile Number "+n_h_mobile);
	      
	      String sms="Nearest Hospital Details <br/> Hospital Name: "+n_h_name+" <br/>Contact No."+n_h_mobile;
	      
	      //String sms="Please Help me, I Request u from Medical chatbot system my Location is "+c_lt+" "+c_lng;
	      
	      SendSMS s=new SendSMS();
	      s.callURL(sms, n_h_mobile);
	      
	      response.sendRedirect("ChatbotInteraction.jsp");
	      
	      
	      
	     	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	public static HashMap sortByValues(HashMap map) 
	{ 
	       List list = new LinkedList(map.entrySet());
	       // Defined Custom Comparator here
	       Collections.sort(list, new Comparator() {
	            public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o1)).getValue())
	                  .compareTo(((Map.Entry) (o2)).getValue());
	            }
	       });

	       // Here I am copying the sorted list in HashMap
	       // using LinkedHashMap to preserve the insertion order
	       HashMap sortedHashMap = new LinkedHashMap();
	       for (Iterator it = list.iterator(); it.hasNext();) {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
	  }
}

