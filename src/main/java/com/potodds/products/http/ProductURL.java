package com.potodds.products.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProductURL {
	private final String finvizURL = "http://elite.finviz.com/export.ashx?auth=lapwah.lee@gmail.com&v=151&f=ind_stocksonly";	
	
	public void run() {

		URL obj;
		try {
			obj = new URL(finvizURL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
//            String userpass = "lapwah.lee@gmail.com" + ":" + "murano2005";
//            String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());
//            con.setRequestProperty ("Authorization", basicAuth);

			// optional default is GET
//			con.setRequestMethod("GET");
			

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + finvizURL);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ProductURL().run();
	}
}
