package com.sharedformula.content.exceptions;


public class InvalidRequestException extends GenericRuntimeException {

	private static final String ERROR_CODE = "400";
	public InvalidRequestException(String message) {
		super(ERROR_CODE,message);
	}

}
