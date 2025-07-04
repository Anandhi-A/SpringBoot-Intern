package com.example.springbootfirst.controllers;


import com.example.springbootfirst.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody

public class HelloWorldController {

    @Autowired
    HelloWorldService hws;

    @GetMapping("/")
    public String hello(){
        return hws.helloWorld();
    }

    @PostMapping("/")
    public String postMethod(){
        return hws.postMethod();
    }

    @PutMapping("/")
    public String putMethod(){
        return hws.putMethod();
    }

    @DeleteMapping("/")
    public String deleteMethod(){
        return hws.deleteMethod();
    }
}