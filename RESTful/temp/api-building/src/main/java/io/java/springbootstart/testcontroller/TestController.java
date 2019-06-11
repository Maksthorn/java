package io.java.springbootstart.testcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//put this annotation to make a class a controller
@RestController
public class TestController {
	
	//package extension should match /web-page extension
	//URL that method maps to
	@RequestMapping("/controller")
	public String response() {
		
		return "server response";
	}
	
}
