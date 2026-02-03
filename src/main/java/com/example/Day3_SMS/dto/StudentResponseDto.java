package com.example.Day3_SMS.dto;

//in this pass the arguments that you need if you fetch data of a student
public record StudentResponseDto(
        String id,
        String name,
        int age,
        String email
) {
}
