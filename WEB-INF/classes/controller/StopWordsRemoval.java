package controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.TreeSet;

import dbConnector.DbConnection;






public class StopWordsRemoval {
	TreeSet <String> tokens=new TreeSet<String>();
	TreeSet <String> afterStopwords=new TreeSet<String>();
	Connection con=null;
	PreparedStatement pst;
	ResultSet rs;
	int numbercount=0;
	
	
	/**
	 * @return the tokens
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public TreeSet<String> getTokens() throws SQLException, ClassNotFoundException {
		
		try {
			DbConnection dbConnection = new DbConnection();
			ResultSet rs=dbConnection.selectOperation("SELECT * FROM `stopwords`");
			Iterator<String> itr=this.tokens.iterator();
			while(itr.hasNext()){ 
				
				 rs.beforeFirst();
				  String Word=itr.next();  
				 
				  while(rs.next())
					{
						String keyword=rs.getString("words");
					    Word=Word.toLowerCase();
					    keyword=keyword.toLowerCase();
				    if(keyword.equals(Word))
				    {
				    	numbercount++;
				    	
				    
				    }
				
					}
				 
					if(numbercount==0)
					{
					afterStopwords.add(Word);
					
					}
					numbercount=0;
			
			} 
			
			return afterStopwords;
		
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return afterStopwords;
	}
		
	/**
	 * @param tokens the tokens to set
	 */
	public void setTokens(TreeSet<String> tokens) {
		this.tokens = tokens;
	} 
	
	

}
