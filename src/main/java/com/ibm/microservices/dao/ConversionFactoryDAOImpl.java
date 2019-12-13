package com.ibm.microservices.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ibm.microservices.entity.CurrencyFactorEntity;

@Repository
//@Transactional
public class ConversionFactoryDAOImpl implements ConversionFactoryDAO{

	@PersistenceContext
    private EntityManager entityManger;
	
	/*
	 * public double getConversionFactor(int countrycode) { CurrencyFactorEntity
	 * currencyFactorEntity = entityManger.find(CurrencyFactorEntity.class,
	 * countrycode); return currencyFactorEntity.getConversionFactor(); }
	 */
	
	public CurrencyFactorEntity getConversionFactor(int countrycode) {
		CurrencyFactorEntity currencyFactorEntity = entityManger.find(CurrencyFactorEntity.class, countrycode);
		return currencyFactorEntity;
	}
	
	
	@Override
	public void addConversionFactor(CurrencyFactorEntity entity) {
	     entityManger.persist(entity);
	}

	public void updateConversionFactor(int countrycode, double conversionFactor) {
		CurrencyFactorEntity currencyFactorEntity = entityManger.find(CurrencyFactorEntity.class, countrycode);
		currencyFactorEntity.setConversionFactor(conversionFactor);
		entityManger.persist(currencyFactorEntity);
	}

}
