package com.example.Day3_SMS.exception;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
//This is for th actual error which occur at code 5
public class ErrorResponse {

    private int status;
    private String message;
    private Map<String, String> errors;
}
