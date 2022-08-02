package com.example.spring_data_jpa.controller;

import com.example.spring_data_jpa.entity.Student;
import com.example.spring_data_jpa.repository.StudentRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudent() {
        List<Student> studentList = studentRepository.findAll();

        return studentList;
    }

    @GetMapping(path = "{studentId}")
    public Student getStudentById(@PathVariable long studentId) {
        return studentRepository.getById(studentId);

    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentRepository.save(student);
        System.out.println("SAVED !!");
    }

    @DeleteMapping(path = "{studentId}")
    public String deleteStudent(@PathVariable long studentId){
        studentRepository.deleteById(studentId);
        return "deleted";
    }


}
