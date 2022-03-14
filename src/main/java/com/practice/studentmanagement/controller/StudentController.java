package com.practice.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.studentmanagement.entity.Student;
import com.practice.studentmanagement.service.IStudentService;

@Controller
public class StudentController {


	private IStudentService studentService;

	// using constructor based dependency injection
	// there is only one constructor so we can omit @Autowired

	public StudentController(IStudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// handler method to handle list students and return mode and view

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students"; // returning a view in html
	}
	

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		//create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute() Student student) {
		studentService.saveStudent(student);
		return "redirect:/students"; //redirecting to the getmapping students above
	}
	
	@GetMapping("/students/edit/{id}")
//	PathVariable is used to store the if that we get, this is not a form submission, so cannot use @RequestParam, this is different
	public String editStudent(@PathVariable long id, Model model) {
		model.addAttribute("student",studentService.getStudentByID(id));
		return "edit_student";
	}
	
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable long id, @ModelAttribute Student student, Model model)
	{
		Student existingStudent = studentService.getStudentByID(id);
		existingStudent.setId(id);
		existingStudent.setEmail(student.getEmail());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}

}
