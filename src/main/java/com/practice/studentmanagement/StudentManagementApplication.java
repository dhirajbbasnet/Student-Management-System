package com.practice.studentmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.studentmanagement.entity.Student;
import com.practice.studentmanagement.respository.StudentRepository;

@SpringBootApplication
//pre populating data with commandLineRunner
public class StudentManagementApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	
//	Command Line Runner has a run() method that executed when the program starts
	@Override
	public void run(String... args) throws Exception {
	
	List<Student> optional = studentRepository.findAll();
	
	if(optional.isEmpty()) {
		
		Student student1 = new Student("Dhiraj", "Basnet", "dhiraj@gmail.com");
		studentRepository.save(student1);
		
		Student student2 = new Student("Simone", "Basnet", "simone@gmail.com");
		studentRepository.save(student2);
		
		Student student3 = new Student("Tony", "Stark", "tony@gmail.com");
		studentRepository.save(student3);
			
	}
	
	}
	

	
	
}