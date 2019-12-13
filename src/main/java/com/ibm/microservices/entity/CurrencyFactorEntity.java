package com.ibm.microservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CURRENCYCONVERTER")
public class CurrencyFactorEntity {
	

	@Id
	@Column(name="countrycode")
	private int countryCode;
	@Column(name="countryname")
	private String countryName;
	@Column(name="currency")
	private String currency;
	@Column(name="conversionfactor")
	private double conversionFactor;
	//private int port;
	
	public CurrencyFactorEntity() {
		
	}

	

	

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	

	public CurrencyFactorEntity(int countryCode, String countryName, String currency, double conversionFactor) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.currency = currency;
		this.conversionFactor = conversionFactor;
	}


	/*
	 * public int getPort() { return port; }
	 * 
	 * public void setPort(int port) { this.port = port; }
	 */
	
	
	

}
