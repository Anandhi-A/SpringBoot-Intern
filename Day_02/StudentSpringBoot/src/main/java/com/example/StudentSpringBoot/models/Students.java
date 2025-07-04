package com.example.StudentSpringBoot.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Students {
    private String name;
    private int id;
    private String rollno;
    private String email;

}