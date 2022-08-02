package com.example.spring_data_jpa.controller;

import com.example.spring_data_jpa.entity.Course;
import com.example.spring_data_jpa.entity.Student;
import com.example.spring_data_jpa.entity.Teacher;
import com.example.spring_data_jpa.repository.CourseRepository;
import com.example.spring_data_jpa.repository.StudentRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
    CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<Course> getStudent() {
        List<Course> courseList = courseRepository.findAll();

        return courseList;
    }

    @GetMapping(path = "{courseId}")
    public Course getStudentById(@PathVariable long courseId) {
        return courseRepository.getById(courseId);

    }

    @PostMapping
    public void registerNewStudent(@RequestBody Map<String,String> course) {
        Teacher teacher = Teacher.builder()
                .firstName(course.get("teacherFirstName"))
                .lastName(course.get("TeacherLastName"))
                .build();

        Course coursee = Course
                .builder()
                .title(course.get("courseTitle"))
                .credit(Integer.parseInt(course.get("credit")))
                .teacher(teacher)
                .build();
        System.out.println("coursee = " + coursee);
        courseRepository.save(coursee);
    }
//
//    @DeleteMapping(path = "{studentId}")
//    public String deleteStudent(@PathVariable long studentId){
//        studentRepository.deleteById(studentId);
//        return "deleted";
//    }
}
