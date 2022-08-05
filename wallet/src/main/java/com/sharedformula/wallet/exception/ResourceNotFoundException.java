package com.sharedformula.wallet.exception;


public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException() {
    super("Resource not found");
  }
}
