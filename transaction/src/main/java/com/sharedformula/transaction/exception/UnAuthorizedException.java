package com.sharedformula.transaction.exception;


public class UnAuthorizedException extends RuntimeException{
    public UnAuthorizedException() {
        super("You're not Authorised to perform this action");
    }

}
