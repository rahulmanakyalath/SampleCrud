package com.example.newCrud.Service;


import com.example.newCrud.Entity.Student;
import com.example.newCrud.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public Student studentRegistration(Student student) {

        Student udt = null;
        ;
        if (!studentRepo.existsById(student.getId())) {
            System.out.println("reached service");
            studentRepo.save(student);
            udt = student;
        }
        return udt;
    }

    public List<Student> fullList() {
        List<Student> lists;
        lists = studentRepo.findAll();
        return lists;
    }

    public Student studentUpdation(Student student) {

        Student udt = null;
        if (studentRepo.existsById(student.getId())) {
            studentRepo.save(student);
            udt = student;
        }
        return udt;
    }

    public Student getStudentDetails(String name, String fathername){
        Student std =studentRepo.Studentdetails(name,fathername);
        return std;

    }
    public String deleteStudentDetails(Long id) {
        String delete = "Student not deleted";
        if (studentRepo.existsById(id)) {
            delete = "Student deleted";
            studentRepo.deleteById(id);
        }
        return delete;
    }


}
