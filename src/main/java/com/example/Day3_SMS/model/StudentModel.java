package com.example.Day3_SMS.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

//@Data // This creates the getters and setters

//Why not data and why getter setter (read from gpt) this is an interview question
/**/
@Data
@AllArgsConstructor // This creates a constructor with all the variables
@NoArgsConstructor// This creates a null constructor
@Document(collection="students")
public class StudentModel {


    @Id // ye annotator jo humne id banayi h neeche usko unique bana dega i.e primary Key
    private String id;

    private String name;
    private int age;
    private String email;
}
