package com.demo.second.model;

public class StudentNotFound extends RuntimeException{

    public StudentNotFound(String message) {
        super(message);
    }
}
