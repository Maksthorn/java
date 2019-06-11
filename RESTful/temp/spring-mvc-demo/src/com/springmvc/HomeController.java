package com.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	//controller method to process the html form
	@RequestMapping("/")
	public String processForm() {
		return "main-menu";
	}	
	
	
}
