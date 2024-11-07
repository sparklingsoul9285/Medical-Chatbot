package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import dbConnector.DbConnection;

public class GlobalFunction {

	public static void main(String[] args) 
	{
		//String keyword=" i have no headaches but eye of pain is bigg please help";
		String keyword=" i have problem Watery but";
		//String disease="bleeding";
		//String kw="Mr. Ritesh ";
		//kw=kw.replaceAll("\\.", "");
		//System.out.println("KK WW "+kw);
		//	System.out.println(" Status "+keyword.contains(disease));
		GlobalFunction gf=new GlobalFunction();
		gf.getSymptons(keyword);
			
	}
	
	public String getSymptons(String kw) 
	{
		
		Set<Integer> i=new TreeSet<>();
		String result="";
		try 
		{
			Connection con=DbConnection.getConnection();
			int ii=19;
			PreparedStatement ps=con.prepareStatement("SELECT * FROM `diseases_medicine`");
			ResultSet rs=ps.executeQuery();
			
			ArrayList<String> avlb_sz=new ArrayList<>();
				
			while(rs.next())
			{
				result=rs.getString("symptons");
			//	System.out.println("Result "+result);
				String[] lines = result.split("\r\n|\r|\n"); //headaches
				String ii_id=rs.getString("id");
				//System.out.println("Size "+lines.length);
				//System.out.println("Line is -- "+Arrays.toString(lines));
				
				for(String ln_kw:lines)
				{
					
					//System.out.println("ln-Kw "+ln_kw); //Line  //headaches
					//System.out.println("Kw "+kw); //Line    //i not headaches but eye of pain
					
					kw=kw.replaceAll("\\.", "");
					ln_kw=ln_kw.replaceAll("\\.", "");
					
					ln_kw=ln_kw.trim().toLowerCase();    				//headaches
					kw=kw.trim().toLowerCase();				//i not headaches but eye of pain
					
					String[] a_ln_kw=ln_kw.split(" ");			//[headaches] 
					String[] a_kw=kw.split(" ");				//[i,not,headaches,but,eye,of,pain]
				//	System.out.println("a_ln_kw is -- "+Arrays.toString(a_ln_kw));
					//System.out.println("a_kw is -- "+Arrays.toString(a_kw));
						   
						for(String s1:a_ln_kw) //   S1=headaches
						{
							String l_w="yes";
							for(String s2:a_kw) //s2=i
							{
							//System.out.println("lW "+l_w+" "+s2+" equals "+s1+"---"+s2.equals(s1));
							if(s2.equals(s1))
							{
								if(!l_w.equals("not"))
								{
									//System.out.println(ii_id+" Yes Word Available");
									//System.out.println();
									avlb_sz.add(ii_id);
								}
							}
							
							l_w=s2;
							//System.out.println("last word "+l_w);
						}
					}
					
					/*if(avlb_sz.size()>0)
					{
						i.add(rs.getInt("id"));
					}*/
					
					/*
					
					kw=kw.replaceAll("\\.", "");
					ln_kw=ln_kw.replaceAll("\\.", "");
					System.out.println("1: "+kw+" 2: "+ln_kw);
					
					if(kw.contains(ln_kw))
					{
						i.add(rs.getInt("id"));
					}*/
				}
					
			}
			
			
		//	System.out.println("Avable Size "+avlb_sz);
			int countA=Collections.frequency(avlb_sz, 1);
			
			System.out.println("Count 1"+countA);
			
			
			
			Map<String, Integer> hm = new HashMap<String, Integer>(); 
			  
	        for (String i3 : avlb_sz) 
	        { 
	            Integer j = hm.get(i3); 
	            hm.put(i3, (j == null) ? 1 : j + 1); 
	        } 
	  
	        /*// displaying the occurrence of elements in the arraylist 
	        for (Map.Entry<String, Integer> val : hm.entrySet()) 
	        { 
	            System.out.println("Element " + val.getKey() + " "+ "occurs"+ ": " + val.getValue() + " times"); 
	        }*/ 
			
	        Map<String, Integer> map = sortByValues(hm); 
			System.out.println("After Sorting:");
			
			ArrayList<String> vl=new ArrayList<>();
	 		
		      Set set2 = map.entrySet();
		      Iterator iterator2 = set2.iterator();
		      
		      HashMap<Integer, Integer> fin=new HashMap<>();
		      
		      while(iterator2.hasNext()) 
		      {
		    	  
		           Map.Entry me2 = (Map.Entry)iterator2.next();
		          
		           //System.out.print(me2.getKey() + " : ");
		           vl.add(me2.getKey().toString());
		           //System.out.println(me2.getValue());
		           int kkey=Integer.parseInt(me2.getKey().toString());
		           int kvalue=Integer.parseInt(me2.getValue().toString());
		           fin.put(kkey, kvalue);
		      }
		      System.out.println("Final Size "+fin.size());
		      System.out.println("elent "+vl.toString());
		      String related_id="nones";
		      if(fin.size()>=2)
		      {
		    	  //related_id=vl.get(fin.size()-1)+","+vl.get(fin.size()-2);
		    	  related_id=vl.get(fin.size()-1);
		      }
		      else if(fin.size()==1)
		      {
		    	  related_id=vl.get(fin.size()-1);
		      }
		      else
		      {
		    	  related_id="none";
		      }
		      
		      System.out.println("final id "+related_id);
		      result=related_id;    
		      
			
			
			
			
			
			
			
			
		} catch (Exception e) 
		{
			System.out.println("123 Exc "+e);
		}
		return result;
	}
	
	
	public String getLatitude(String h_id) 
	{
		String result="";
		try 
		{
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM `hospital_details` where h_id='"+h_id+"'");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				result=rs.getString("h_lat");
				
			}
			
		} catch (Exception e) 
		{
			System.out.println("Exc "+e);
		}
		return result;
	}
	
	public String getLongitude(String h_id) 
	{
		String result="";
		try 
		{
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM `hospital_details` where h_id='"+h_id+"'");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				result=rs.getString("h_long");
				
			}
			
		} catch (Exception e) {
			System.out.println("Exc "+e);
		}
		return result;
	}
	

	public String getHospMobileNumber(String h_id) 
	{
		String result="";
		try 
		{
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM `hospital_details` where h_id='"+h_id+"'");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				result=rs.getString("h_mobile");
				
			}
			
		} catch (Exception e) {
			System.out.println("Exc "+e);
		}
		return result;
	}
	public String getHospName(String h_id) 
	{
		String result="";
		try 
		{
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM `hospital_details` where h_id='"+h_id+"'");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				result=rs.getString("h_name");
				
			}
			
		} catch (Exception e) {
			System.out.println("Exc "+e);
		}
		return result;
	}
	
	
	private static HashMap sortByValues(Map<String, Integer> hm) { 
	       List list = new LinkedList(hm.entrySet());
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
