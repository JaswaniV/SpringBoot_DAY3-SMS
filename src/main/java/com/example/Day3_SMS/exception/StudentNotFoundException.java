package com.example.Day3_SMS.exception;

//This is for error codes starting from 4
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}




