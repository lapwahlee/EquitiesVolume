package com.potodds.dao;

import java.math.BigDecimal;

public class Product {
	public final static int MAX_PRODUCTS = PRODUCT_COLUMNS.values().length;
	public enum PRODUCT_COLUMNS {
		PRODUCTID, TICKER, NAME, SECTOR, INDUSTRY, COUNTRY, MARKETCAP, PE, PRICE, PRICE_CHANGE, VOLUME;
	}
	
	private long productId;
	private String ticker;
	private String name;
	private String sector;
	private String industry;
	private String country;
	private BigDecimal marketCap;
	private BigDecimal pe;
	private BigDecimal price;
	private String price_change;
	private BigDecimal volume;
	
	public String toString() {
		return "" + this.getProductId() 
			+ "" + this.getTicker() 
			+ "" + this.getName()
			+ "" + this.getSector()
			+ "" + this.getIndustry()
			+ "" + this.getCountry()
			+ "" + this.getMarketCap()
			+ "" + this.getPe()
			+ "" + this.getPrice()
			+ "" + this.getPrice_change()
			+ "" + this.getVolume();
	}
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public BigDecimal getMarketCap() {
		return marketCap;
	}
	public void setMarketCap(BigDecimal marketCap) {
		this.marketCap = marketCap;
	}
	public BigDecimal getPe() {
		return pe;
	}
	public void setPe(BigDecimal pe) {
		this.pe = pe;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getPrice_change() {
		return price_change;
	}
	public void setPrice_change(String price_change) {
		this.price_change = price_change;
	}
	public BigDecimal getVolume() {
		return volume;
	}
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}
}
