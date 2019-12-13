package com.ibm.microservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND )
public class CountryCodeNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4879821358417219363L;

	public CountryCodeNotFoundException(String exception) {
	    super(exception);
	  }

}
