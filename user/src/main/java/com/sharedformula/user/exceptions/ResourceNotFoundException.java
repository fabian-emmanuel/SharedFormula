package com.sharedformula.user.exceptions;


public class ResourceNotFoundException extends GenericRuntimeException {
  private static final String ERROR_CODE = "404";
  public ResourceNotFoundException(String message) {
    super(ERROR_CODE,message);
  }
}
