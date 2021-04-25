package com.rest_crud_app.rest;

public class CustomerNotFoundException extends RuntimeException{


    public CustomerNotFoundException() {

    }

    public CustomerNotFoundException(String message) {
        super(message);
    }

}
