package com.example.spring_data_jpa.controller;

import com.example.spring_data_jpa.entity.Student;
import com.example.spring_data_jpa.repository.StudentRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@RestController
@RequestMapping("api/v1/students")
//@PreAuthorize("hasAuthority('student:read')")
public class StudentController {

    //eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsaW5kYSIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJzdHVkZW50OndyaXRlIn0seyJhdXRob3JpdHkiOiJzdHVkZW50OnJlYWQifSx7ImF1dGhvcml0eSI6ImNvdXJzZTpyZWFkIn0seyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn0seyJhdXRob3JpdHkiOiJjb3Vyc2U6d3JpdGUifV0sImlhdCI6MTY1OTYwNzU2NywiZXhwIjoxNjYwNDI0NDAwfQ.DAKvrgbNg3dGn3E4nQex9O5TsxdJltCj3UQRAMTdpiMYJFRfzORDepl1fGgTXhXSTJNOTDf6hIk1znZK5nzRIw
    StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('student:read')")
    public List<Student> getStudent() {
        List<Student> studentList = studentRepository.findAll();

        return studentList;
    }

    @GetMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:read')")
    public Student getStudentById(@PathVariable long studentId) {
        return studentRepository.getById(studentId);

    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
        studentRepository.save(student);
        System.out.println("SAVED !!");
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public String deleteStudent(@PathVariable long studentId){
        studentRepository.deleteById(studentId);
        return "deleted";
    }


}
