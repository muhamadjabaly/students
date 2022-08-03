package com.example.spring_data_jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class TemplateController {
    @GetMapping("login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("courses")
    public String getCourses() {
        return "courses";
    }
}
