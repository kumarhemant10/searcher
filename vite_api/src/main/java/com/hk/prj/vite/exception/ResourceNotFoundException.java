package com.hk.prj.vite.exception;

/**
 * @author hemant.kumar
 * @version 1.0.0
 * @since 
 */
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ResourceNotFoundException(Throwable throwable) {
		super(throwable);
	}
	
}
