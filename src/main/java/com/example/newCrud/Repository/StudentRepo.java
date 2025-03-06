package com.example.newCrud.Repository;


import com.example.newCrud.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    @Query(value = "SELECT * FROM student WHERE student.name = ?1 and student.father=?2",nativeQuery = true)
    Student Studentdetails(String student,String father);
}
