package com.ibm.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.microservices.entity.CurrencyFactorEntity;
import com.ibm.microservices.exception.CountryCodeNotFoundException;
import com.ibm.microservices.service.ConversionFactoryService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConversionFactoryController {

	@Autowired
	private Environment environment;

	private Logger LOG = LoggerFactory.getLogger(ConversionFactoryController.class);

	@Autowired
	private ConversionFactoryService conversionFactoryService;

	@PostMapping("/addConversionFactor")
	// @HystrixCommand(fallbackMethod = "addConversionFactorFallbackMethod")
	public CurrencyFactorEntity addConversionFactor(@RequestBody CurrencyFactorEntity entityBean) {

		conversionFactoryService.addConversionFactor(entityBean);
		String port = environment.getProperty("local.server.port");
		LOG.debug("Called microservice is running on this port value: {}", port);

		return entityBean;
	}

	@PutMapping("/updateConversionFactor/countryCode/{countryCode}")
//	@HystrixCommand(fallbackMethod = "updateConversionFactorFallbackMethod") 
	public CurrencyFactorEntity updateConversionFactor(@RequestBody CurrencyFactorEntity entityBean,
			@PathVariable("countryCode") int countryCode) {
		CurrencyFactorEntity response = conversionFactoryService.getConversionFactor(countryCode);
		if (response == null) {
			LOG.error("This countrycode - " + countryCode + " does not exist in the database");
			throw new CountryCodeNotFoundException(
					"This countrycode - " + countryCode + " does not exist in the database");
		}
		
		response.setConversionFactor(entityBean.getConversionFactor());
		//response.setCountryCode(entityBean.getCountryCode());
		
		conversionFactoryService.addConversionFactor(response);
				
		//conversionFactoryService.add(entityBean.getCountryCode(), entityBean.getConversionFactor());
		String port = environment.getProperty("local.server.port");
		LOG.debug("Called microservice is running on this port value: {}", port);
		return response;
	}

	@GetMapping("/getConversionFactor/countryCode/{countryCode}")
	@HystrixCommand(fallbackMethod = "getConversionFactorFallbackMethod",ignoreExceptions = { CountryCodeNotFoundException.class })
	public CurrencyFactorEntity getConversionFactor(@PathVariable("countryCode") int countryCode) {
		CurrencyFactorEntity response = conversionFactoryService.getConversionFactor(countryCode);
		// response.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		LOG.info("{}", response);
		if (response == null) {
			LOG.error("This countrycode - " + countryCode + " does not exist in the database");
			throw new CountryCodeNotFoundException("This countrycode  not found : " + countryCode);
			//throw new RuntimeException("This countrycode  not found : " + countryCode);
		}
		
		
		String port = environment.getProperty("local.server.port");
		LOG.debug("Called microservice is running on this port value: {}", port);
		return response;
	}

	public CurrencyFactorEntity updateConversionFactorFallbackMethod(@RequestBody CurrencyFactorEntity entityBean,
			@PathVariable("countryCode") int countryCode) {
		return new CurrencyFactorEntity();
	}

	public CurrencyFactorEntity getConversionFactorFallbackMethod(@PathVariable("countryCode") int countryCode) {
		LOG.info("FallbackMethod called.....");
		return new CurrencyFactorEntity();
	}

	public CurrencyFactorEntity addConversionFactorFallbackMethod(@RequestBody CurrencyFactorEntity entityBean) {
		return new CurrencyFactorEntity();
	}

}
