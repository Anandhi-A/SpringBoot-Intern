package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")

public class HelloWorldController {

    @Autowired
    HelloWorldService hws;

    @GetMapping
    public List<Employee> getEmployee() {
        return hws.getMethod();
    }


    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable int empId){
        return hws.getEmployeeById(empId);
    }

    @GetMapping("/job/{job}")
    public List<Employee> getEmployeeByJob(@PathVariable String job){
        return hws.getbyjob(job);
    }

    @GetMapping("/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name){
        return hws.getbyname(name);
    }

    @PostMapping
    public String postMethod(@RequestBody Employee employee){
        return hws.postMethod(employee);
    }

    @PutMapping("/{id}")
    public String putMethodById(@RequestBody Employee employee, @PathVariable int id){
        return hws.putMethodById(employee, id);
    }

    @DeleteMapping("/{id}")
    public String deleteMethod(@PathVariable int id){
        return hws.deleteMethod(id);
    }
}