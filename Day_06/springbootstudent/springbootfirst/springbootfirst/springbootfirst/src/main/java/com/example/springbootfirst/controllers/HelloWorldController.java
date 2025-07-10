package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Student;

import com.example.springbootfirst.service.HelloWorldService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stud")

public class HelloWorldController {

    @Autowired
    private HelloWorldService hws;
     @PreAuthorize("hasAnyRole('ADMIN','USER')")
     @GetMapping
     public List<Student> getMethod(){
         return hws.getAllStudents();
     }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{studentID}")
    public Student getStudentByID(@PathVariable int studentID) {
        return hws.getStudentsByID(studentID);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/dept/{dept}")
    public List<Student> getStudentByDept(@PathVariable String dept) {
        return hws.getStudentsByDept(dept);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public String addStudent(@RequestBody Student stud){
        return hws.addStudent(stud);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping
    public String updateStudent(@RequestBody Student student) {
        return hws.UpdateStudent(student);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{studentID}")
    public String deleteStudentById(@PathVariable int studentID)  {
        return hws.deleteStudentById(studentID);
    }
}
