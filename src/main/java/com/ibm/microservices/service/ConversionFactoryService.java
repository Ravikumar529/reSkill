package com.ibm.microservices.service;

import org.springframework.http.ResponseEntity;

import com.ibm.microservices.entity.CurrencyFactorEntity;

public interface ConversionFactoryService {

	public void updateConversionFactor(int countrycode, double conversionFactor);
	public void addConversionFactor(CurrencyFactorEntity entityBean);
	public CurrencyFactorEntity getConversionFactor(int countrycode);

}
