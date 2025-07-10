package com.example.springbootfirst.models;
import jakarta.persistence.Entity;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Student {
    @Id

    private int studentID;
    private String studentName;
    private String dept;


}


//    public Student(int studentID, String studentName) {
//        this.studentID=studentID;
//        this.studentName=studentName;
//    }





