package com.potodds.prices.http;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PricesHTTP {	
	public static void main(String args[]) {
		try {
			Document doc = Jsoup.connect("https://finance.yahoo.com/q?s=ibm").get();
			Elements e = doc.select("td.yfnc_tabledata1");
			System.out.println(e.get(0).text());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
}
