package com.ibm.microservices.bean;

public class ConversionFactoryBean {
	
	  private int id;
	  private int countrycode;
	  private String countryname;
	  private double conversionfactor;
	  
	public ConversionFactoryBean(int countrycode, String countryname, double conversionfactor) {
		super();
		this.countrycode = countrycode;
		this.countryname = countryname;
		this.conversionfactor = conversionfactor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public double getConversionfactor() {
		return conversionfactor;
	}

	public void setConversionfactor(double conversionfactor) {
		this.conversionfactor = conversionfactor;
	}

	  
	
		

}
