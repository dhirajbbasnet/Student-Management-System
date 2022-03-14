package com.practice.studentmanagement.service;

import java.util.List;

import com.practice.studentmanagement.entity.Student;

public interface IStudentService {
		
	List<Student> getAllStudents();

	void saveStudent(Student student);
	
}
