package com.ibm.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.microservices.dao.ConversionFactoryDAO;
import com.ibm.microservices.entity.CurrencyFactorEntity;

@Service
@Transactional
public class ConversionFactoryServiceImpl implements ConversionFactoryService {
	
	@Autowired
	private ConversionFactoryDAO conversionFactoryDAO;
	
	/*
	 * @Override public double getConversionFactor(int countrycode) { return
	 * conversionFactoryDAO.getConversionFactor(countrycode); }
	 */
	
	@Override
	public CurrencyFactorEntity getConversionFactor(int countrycode) {
	return conversionFactoryDAO.getConversionFactor(countrycode);
}

	@Override
	public void updateConversionFactor(int countrycode, double conversionFactor) {
		conversionFactoryDAO.updateConversionFactor(countrycode, conversionFactor);
	}

	@Override
	public void addConversionFactor(CurrencyFactorEntity entityBean) {
		conversionFactoryDAO.addConversionFactor(entityBean);
		
	}

}
