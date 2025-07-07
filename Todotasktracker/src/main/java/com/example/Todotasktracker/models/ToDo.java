package com.example.Todotasktracker.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ToDo{
    private int Id;
    private String Title;
    private String Status;
}