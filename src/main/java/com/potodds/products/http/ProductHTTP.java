package com.potodds.products.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.potodds.dao.Product;

public class ProductHTTP {
	private final String finvizURL = "http://elite.finviz.com/export.ashx?auth=lapwah.lee@gmail.com&v=151&f=ind_stocksonly";	
	
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<>();
		
		URL obj;
		try {
			obj = new URL(finvizURL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + finvizURL);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				String[] tokens = inputLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (tokens != null && tokens.length == Product.MAX_PRODUCTS) {
					if (!tokens[0].equals("\"No.\""))
						products.add(parseProduct(tokens));
				} else
					System.out.println("Product attributes are missing[" + Arrays.toString(tokens) + "]");
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	private BigDecimal getBigDecimal(String value) {
		if (value == null || value.equals("")) return new BigDecimal(0.0);
		return BigDecimal.valueOf(Double.parseDouble(value));
	}
	
	private Product parseProduct(String[] tokens) {
		if (tokens == null || tokens.length == 0) return null;		
		Product prod = new Product();
		prod.setProductId(Long.parseLong(tokens[Product.PRODUCT_COLUMNS.PRODUCTID.ordinal()]));
		prod.setTicker(tokens[Product.PRODUCT_COLUMNS.TICKER.ordinal()]);
		prod.setName(tokens[Product.PRODUCT_COLUMNS.NAME.ordinal()]);
		prod.setSector(tokens[Product.PRODUCT_COLUMNS.SECTOR.ordinal()]); 
		prod.setIndustry(tokens[Product.PRODUCT_COLUMNS.INDUSTRY.ordinal()]); 
		prod.setCountry(tokens[Product.PRODUCT_COLUMNS.COUNTRY.ordinal()]); 
		prod.setMarketCap(getBigDecimal(tokens[Product.PRODUCT_COLUMNS.MARKETCAP.ordinal()])); 
		prod.setPe(getBigDecimal(tokens[Product.PRODUCT_COLUMNS.PE.ordinal()])); 
		prod.setPrice(getBigDecimal(tokens[Product.PRODUCT_COLUMNS.PRICE.ordinal()])); 
		prod.setPrice_change(tokens[Product.PRODUCT_COLUMNS.PRICE_CHANGE.ordinal()]); 
		prod.setVolume(getBigDecimal(tokens[Product.PRODUCT_COLUMNS.VOLUME.ordinal()]));
				
		return prod;
	}
	
	public static void main(String[] args) {		
		List<Product> prods = new ProductHTTP().getProducts();
		for(Product p : prods) {
			System.out.println(p);
		}
		System.out.println(prods.size());
	}
}
