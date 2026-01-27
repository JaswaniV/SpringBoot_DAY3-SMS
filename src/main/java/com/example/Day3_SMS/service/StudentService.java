//logic use krna

package com.example.Day3_SMS.service;

import com.example.Day3_SMS.model.StudentModel;
import com.example.Day3_SMS.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    //Create

    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }


    //Display
    public List<StudentModel> getAllStudents() {
        return repository.findAll();
    }


    //update
    public StudentModel updateStudent(String id, StudentModel student){
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Student Found"));
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());
        return repository.save(existingStudent);
    }

    public void deleteStudent(String id) {
        repository.deleteById(id);
    }





}
