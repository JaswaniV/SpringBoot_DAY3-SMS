package com.example.Day3_SMS.controller;

import com.example.Day3_SMS.dto.StudentRequestDto;
import com.example.Day3_SMS.dto.StudentResponseDto;
import com.example.Day3_SMS.model.StudentModel;
import com.example.Day3_SMS.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    //Create function API
    @PostMapping("/add-student")
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> getAllStudents() {
        return service.getAllStudents();
    }

    @PutMapping("/update/{id}")
//    public StudentModel updateStudent(@PathVariable String id, @RequestBody StudentModel student){
//        return service.updateStudent(id, student);
//    }
    public StudentResponseDto updateStudent(
            @PathVariable String id,
            @Valid @RequestBody StudentRequestDto student
    ) {
        return service.updateStudent(id, student);
    }


    @DeleteMapping("/students/{id}")
//    public String deleteStudent(@PathVariable String id) {
//        service.deleteStudent(id);
//        return "Student deleted successfully";
//    }
    public StudentResponseDto deleteStudent(@PathVariable String id) {
        return service.deleteStudent(id);
    }



}
