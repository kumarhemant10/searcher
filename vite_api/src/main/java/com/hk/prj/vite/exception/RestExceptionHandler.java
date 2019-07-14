package com.hk.prj.vite.exception;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



/**
 * exception handler for errors in rest apis
 * 
 * @author hemant.kumar
 * @since 14-July-2019
 * @version 1.0.0
 * 
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler {
	
	/**
	 * handle ResourceNotFoundException
	 * @param ex
	 * @return
	 */
    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<String> handleEntityNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
