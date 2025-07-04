package com.example.StudentSpringBoot.services;

import com.example.StudentSpringBoot.models.Students;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Students> s = new ArrayList<>(
            Arrays.asList(new Students("Anandhi" , 99 , "23AD099" , "anandhi@gmail.com"),
                    new Students("Abi" , 100 , "23AD100" , "abi@gmail.com"))
    );

    public String showstudents(){
        return s.toString();
    }
    public String addStudent(){
        s.add(new Students("John" , 101 , "23AD101" , "john@gmail.com"));
        return s.toString();
    }

    public String updatedStudent(){
        return "This is updateStudent method";
    }

    public String deletestudent() {
        return "This is deletestudent method";
    }
}