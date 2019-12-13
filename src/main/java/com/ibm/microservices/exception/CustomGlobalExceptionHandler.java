package com.ibm.microservices.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
	public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	    // Let Spring ConversionFactoryController handle the exception, we just override the status code
	/*
	 * @ExceptionHandler(CountryCodeNotFoundException.class) public void
	 * springHandleNotFound(HttpServletResponse response) throws IOException {
	 * response.sendError(HttpStatus.NOT_FOUND.value()); }
	 */
	    
	    @ExceptionHandler(CountryCodeNotFoundException.class)
	    public ResponseEntity<CustomErrorResponse> customHandleNotFound(Exception ex, WebRequest request) {

	        CustomErrorResponse errors = new CustomErrorResponse();
	        errors.setTimestamp(LocalDateTime.now());
	        errors.setError(ex.getMessage());
	        errors.setStatus(HttpStatus.NOT_FOUND.value());

	        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

	    }
	    
	    
	    
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
	    public ResponseEntity<CustomErrorResponse>  handleBadRequest(HttpServletRequest req, Exception ex) {
	    	
	    	 CustomErrorResponse errors = new CustomErrorResponse();
		        errors.setTimestamp(LocalDateTime.now());
		        errors.setError(ex.getMessage());
		        errors.setStatus(HttpStatus.BAD_REQUEST.value());

		        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	      // return new CustomErrorResponse(new Date(), ex.getMessage(), req.getRequestURI());
	    }
	    
	    
	    

}
