package edu.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.sms.model.Student;
import edu.sms.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;


	@GetMapping("/")
	public String viewHome(Model model) {
	model.addAttribute("students", service.getAllStudents());
	return "index";
	}
	@GetMapping("/add")
	public String addStudentForm(Model model) {
	model.addAttribute("student", new Student());
	return "add-student";
	}


	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student student) {
	service.saveStudent(student);
	return "redirect:/";
	}
	}


