package dbConnector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleSearchJava 
{

	public static void main(String[] args) throws IOException {
		 
		String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
		String query = "java tutorial";
		String charset = "UTF-8";
	 
		URL url = new URL(address + URLEncoder.encode(query, charset));
	 
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String str;
	 
		while ((str = in.readLine()) != null) {
			System.out.println(str);
		}
	 
		in.close();
	}

}