package com.intute.profile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.toString(),request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException exception, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.toString(),request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleResourceNotFoundException(Exception exception, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.toString(),request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
