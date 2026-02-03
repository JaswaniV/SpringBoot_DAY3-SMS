package com.example.Day3_SMS.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//DTO -> data transfer object
public class StudentRequestDto {
    @NotBlank(message = "Name cannot be black")
    private String name;

    @Min(value=5 , message = "Age cannot be less than 5")
    @Max(value=100, message = "Age cannot be greater than 100")
    private int age;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be black")
    private String email;

}
