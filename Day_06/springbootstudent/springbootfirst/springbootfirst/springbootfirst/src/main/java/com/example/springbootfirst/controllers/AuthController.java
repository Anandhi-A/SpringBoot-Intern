package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.RegisterDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import com.example.springbootfirst.service.AuthService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;


    @PostMapping("/register")
    public String addNewUser(@RequestBody RegisterDetails register){
        authService.addNewEmployee(register);
        return "Employee Register successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody RegisterDetails login){
        return authService.authenticate(login);
    }
}
