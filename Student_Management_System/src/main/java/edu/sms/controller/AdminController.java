package edu.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sms.model.Student;
import edu.sms.service.StudentService;

@Controller
public class AdminController {

	@Autowired
	StudentService ss;
	
	@RequestMapping("/")
	public String preLogin()
	{
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password,Model m)
	{
		if(username.equals("admin")&& password.equals("admin"))
		{
			List<Student> list = ss.getAllStudents();
			m.addAttribute("data", list);
			return "adminscreen";
		}
		else {
			m.addAttribute("login_fail", "Enter valid login details...");
			return "login";
		}
	}
	
	@RequestMapping("enroll_student")
	public String saveStudent(@ModelAttribute Student student ,Model m)
	{
		ss.saveStudentDetail(student);
		List<Student> list = ss.getAllStudents();
		m.addAttribute("data", list);
		return "adminscreen";
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("rollno")int studentId,Model m)
	{
		ss.deleteStudent(studentId);
		List<Student> students = ss.getAllStudents();
		m.addAttribute("data", students);
		return "adminscreen";
	}
	
	@RequestMapping("/search")
	public String getBatchStudent(@RequestParam String batchNumber,Model m)
	{
		List<Student> result = ss.searchStudentByBatch(batchNumber);
		if(result.size()>0)
		{
			m.addAttribute("data", result);
		}
		else {
			
			List<Student> students = ss.getAllStudents();
			m.addAttribute("data", students);
			m.addAttribute("message", "no records are available for the batch"+batchNumber+"...");
		}
		return "adminscreen";
	}
	
		

	
}
