package com.example.spring_data_jpa.controller;

import com.example.spring_data_jpa.entity.Student;
import com.example.spring_data_jpa.entity.Teacher;
import com.example.spring_data_jpa.repository.StudentRepository;
import com.example.spring_data_jpa.repository.TeacherRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@RestController
@RequestMapping("api/v1/teachers")
public class TeacherController {
    TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping
    public List<Teacher> getStudent() {
        List<Teacher>  teachers= teacherRepository.findAll();

        return teachers;
    }

    @GetMapping(path = "{teacherId}")
    public Teacher getStudentById(@PathVariable long teacherId) {
        return teacherRepository.getById(teacherId);

    }

    @PostMapping
    public void registerNewStudent(@RequestBody Teacher teacher) {
        teacherRepository.save(teacher);
        System.out.println("SAVED !!");
    }

    @DeleteMapping(path = "{teacherId}")
    public String deleteStudent(@PathVariable long teacherId){
        teacherRepository.deleteById(teacherId);
        return "deleted";
    }
}
