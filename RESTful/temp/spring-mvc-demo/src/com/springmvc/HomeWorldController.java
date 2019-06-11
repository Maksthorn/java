package com.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeWorldController {
	
	
	@RequestMapping("/showForm")
	public String showPage() {
		//name without the .jsp extension
		return "helloworld-form";
	}
	
	//controller method to process the html form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}	
	
	
	@RequestMapping("/processFormVersionTwo")
	public String touppercase(HttpServletRequest request , Model model) {
	
		
		//read request param form html form
		String theName = request.getParameter("studentName");
		
		// Perform transformation on data
		theName = theName.toUpperCase();
		//create message
		String result = "hey " + theName;
		//add message to model the "message" key matches the form key to map result to that param
		//like an id
		model.addAttribute("message" , result);
		
		
		
		return "helloworld";
	}
	
	//binding param over serverletrequest
	@RequestMapping("/processFormVersionThree")
	public String touppercaseversiontwo(@RequestParam("studentName") String theName , Model model) {
		// Perform transformation on data
		theName = theName.toUpperCase();
		//create message
		String result = "hey from touppercase version two " + theName;
		//add message to model the "message" key matches the form key to map result to that param
		//like an id
		model.addAttribute("message" , result);
		
		return "helloworld";
	}
	
	
	
}
