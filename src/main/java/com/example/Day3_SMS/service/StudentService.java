//logic use krna

package com.example.Day3_SMS.service;

import com.example.Day3_SMS.dto.StudentRequestDto;
import com.example.Day3_SMS.dto.StudentResponseDto;
import com.example.Day3_SMS.exception.StudentNotFoundException;
import com.example.Day3_SMS.model.StudentModel;
import com.example.Day3_SMS.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    //Create

//    public StudentModel addStudent(StudentModel student){
//        return repository.save(student);
//    }

    public StudentResponseDto addStudent(StudentRequestDto dto){
        StudentModel student = new StudentModel();

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved = repository.save(student);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }//Interview Question-> why we are creating 2 objects


    //Display
    public List<StudentResponseDto> getAllStudents() {
        return repository.findAll()
                .stream()
                .map(s -> new StudentResponseDto(
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getEmail()
                )).toList();
    }


    //update
//    public StudentModel updateStudent(String id, StudentModel student){
//        StudentModel existingStudent = repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("No Student Found"));
//        existingStudent.setName(student.getName());
//        existingStudent.setAge(student.getAge());
//        existingStudent.setEmail(student.getEmail());
//        return repository.save(existingStudent);
//    }


    public StudentResponseDto updateStudent(String id, StudentRequestDto dto) {

        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student not found with id: " + id
                ));

        existingStudent.setName(dto.getName());
        existingStudent.setAge(dto.getAge());
        existingStudent.setEmail(dto.getEmail());

        StudentModel updated = repository.save(existingStudent);

        return new StudentResponseDto(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }



    //DELETE
//    public void deleteStudent(String id) {
//        repository.deleteById(id);
//    }
    public StudentResponseDto deleteStudent(String id) {
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student not found with id: " + id
                ));
        repository.deleteById(id);
        return new StudentResponseDto(
                existingStudent.getId(),
                existingStudent.getName(),
                existingStudent.getAge(),
                existingStudent.getEmail()
        );
    }




}
