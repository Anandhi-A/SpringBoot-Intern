package com.example.springbootfirst.services;


import com.example.springbootfirst.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class HelloWorldService {

    List<Employee> emp = new ArrayList<>(
            Arrays.asList(new Employee(1,"Prasanth","Trainer"),
                    new Employee(2,"Yuvaraj","Faculty"))
    );
    public String helloWorld(){
        return emp.toString();
    }

    public String postMethod() {
        return "This is Post Method";
    }

    public String putMethod() {
        emp.add(new Employee(3, "Anandhi" , "student"));
        return emp.get(emp.size()-1).toString();
    }

    public String deleteMethod() {
        return "This is Delete Method";
    }
}