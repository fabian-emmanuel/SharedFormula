package com.sharedformula.user.config;

import com.sharedformula.user.exceptions.InvalidRequestException;
import com.sharedformula.user.exceptions.ProcessingException;
import com.sharedformula.user.util.ApiResponseUtil;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.logging.Level;

@Log
@ControllerAdvice
@RestController
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity handleResourceNotFoundException(InvalidRequestException e) {
        return ApiResponseUtil.errorResponse(HttpStatus.BAD_REQUEST, e.getErrorMessage());
    }

    @ExceptionHandler(ProcessingException.class)
    public ResponseEntity handleResourceNotFoundException(ProcessingException e) {
        return ApiResponseUtil.errorResponse(HttpStatus.NOT_MODIFIED, e.getErrorMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        log.log(Level.SEVERE, "Exception: ", e);
        return ApiResponseUtil.errorResponse(HttpStatus.INTERNAL_SERVER_ERROR,String.format("An unknown error has occurred: %s", e.getMessage()));
    }
}
