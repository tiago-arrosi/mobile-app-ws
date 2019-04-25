package com.tiagoarrosi.app.ws.exceptions;

public class UserServiceException extends RuntimeException{

	private static final long serialVersionUID = -5387299770348569155L;
 
	public UserServiceException(String message) {
		super(message);
	}
	
}
