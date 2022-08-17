package com.sharedformula.transaction.exceptions;


public class UnAuthorizedException extends GenericRuntimeException {
    private static final String ERROR_CODE = "403";
    public UnAuthorizedException(String message) {
        super(ERROR_CODE,message);
    }

}
