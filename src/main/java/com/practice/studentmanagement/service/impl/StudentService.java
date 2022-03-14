package com.practice.studentmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.studentmanagement.entity.Student;
import com.practice.studentmanagement.respository.StudentRepository;
import com.practice.studentmanagement.service.IStudentService;


@Service
public class StudentService implements IStudentService{
	
	private StudentRepository studentRepository;

	//Constructor based dependency injection, no need to use @Autowired here

	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	
	
	
	
}
