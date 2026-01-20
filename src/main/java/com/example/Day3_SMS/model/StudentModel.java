package com.example.Day3_SMS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="students")
public class StudentModel {

    @Id // ye annotator jo humne id banayi h neeche usko unique bana dega i.e primary Key
    private String id;

    private String name;
    private int age;
    private String email;
}
