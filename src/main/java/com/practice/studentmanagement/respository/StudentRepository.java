package com.practice.studentmanagement.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.studentmanagement.entity.Student;

//No need of @Repository here, it would be necessary if it was custom DAO instead

public interface StudentRepository extends JpaRepository<Student, Long>{

}
