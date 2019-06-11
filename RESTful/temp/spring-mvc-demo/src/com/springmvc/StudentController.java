package com.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		//create student obj
		Student student = new Student();
		
		//add obj to model
		theModel.addAttribute("student",student);
		
		return "student-form";
	}
	
	
	@RequestMapping("processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		
		System.out.println("Student " +student.getFirstName() +" "+ student.getLastName() +" is from "+ student.getCountry());
		return "student-confirmation";
	}
	
	
	
}
