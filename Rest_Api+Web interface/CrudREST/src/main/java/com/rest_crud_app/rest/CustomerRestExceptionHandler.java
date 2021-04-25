package com.rest_crud_app.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException customerNotFoundException) {

        CustomerErrorResponse customer = new CustomerErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                customerNotFoundException.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handle(Exception exception) {
        CustomerErrorResponse customer = new CustomerErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(customer, HttpStatus.BAD_REQUEST);

    }

}
