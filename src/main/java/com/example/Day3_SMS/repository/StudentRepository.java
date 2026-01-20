//database use krna and model is the actual database
package com.example.Day3_SMS.repository;

import com.example.Day3_SMS.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository <StudentModel, String> {
}

