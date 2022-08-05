package com.sharedformula.content.exception;


public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException() {
    super("Resource not found");
  }
}
