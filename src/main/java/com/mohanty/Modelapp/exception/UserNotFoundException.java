package com.mohanty.Modelapp.exception;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8087215712039225586L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
