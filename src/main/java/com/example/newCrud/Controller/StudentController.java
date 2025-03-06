package com.example.newCrud.Controller;


import com.example.newCrud.Entity.Student;
import com.example.newCrud.Enumerations.Gender;
import com.example.newCrud.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/details")
    public ResponseEntity<String> saveStudentDetails(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String fathersname,
            @RequestParam int age,
            @RequestParam String dob,
            @RequestParam String phnum,
            @RequestParam Gender gender) {

        Student student = new Student();
        student.setId(id);
        student.setName(name.toUpperCase());
        student.setFather(fathersname.toUpperCase());
        student.setAge(age);
        student.setDob(dob);
        student.setPhnumber(phnum);
        student.setGender(String.valueOf(gender));

        System.out.println("reached controller");
        String str = "same user exists";

        if (studentService.studentRegistration(student) != null) {
            str = "success";
            return new ResponseEntity<>(str, HttpStatus.OK);
        }
        return new ResponseEntity<>(str, HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/details")
    public ResponseEntity<String> updateStudentDetails(@RequestBody Student student) {

        System.out.println("reached controller");
        String str = "user not updated";

        if (studentService.studentUpdation(student) != null) {
            str = "successfully updated";
        }
        return ResponseEntity.ok(str);
    }

    @GetMapping("/details/All")
    public ResponseEntity<List<Student>> getAllAvailableStudents() {
        return new ResponseEntity<>(studentService.fullList(), HttpStatus.OK);
    }

    @GetMapping("/details/{name}/{fathersname}")
    public ResponseEntity<Student> getStudentDetails(@PathVariable  String name,
                                                     @PathVariable String fathersname){

        Student std = new Student();
        std = studentService.getStudentDetails(name,fathersname);
        if(std!=null)
        {
            return new ResponseEntity<>(std, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {


        String std = studentService.deleteStudentDetails(id);

        return new ResponseEntity<>(std, HttpStatus.OK);

    }
}
