package com.example.newCrud.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    private Long id;
    private String name;
    private String father;
    private int age;
    private String dob;
    private String phnumber;
    private String gender;
}
