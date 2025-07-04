package com.example.StudentSpringBoot.controllers;

import com.example.StudentSpringBoot.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class StudentController {

    @Autowired
    StudentService s;
    @GetMapping("/get")
    public String displayStudents(){
        return s.showstudents();
    }

    @PostMapping("/")
    public String addStudent(){
        return s.addStudent();
    }

    @PutMapping("/")
    public String editStudent(){
        return s.updatedStudent();
    }

    @DeleteMapping("/")
    public String deleteStudent(){
        return s.deletestudent();
    }
}