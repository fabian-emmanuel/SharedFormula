package com.sharedformula.transaction.exception;


public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException() {
    super("Resource not found");
  }
}
