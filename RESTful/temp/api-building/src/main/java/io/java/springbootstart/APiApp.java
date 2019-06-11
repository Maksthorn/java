package io.java.springbootstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//tells the application that this is a spring application
//alternatively use spring initializr @  https://start.spring.io/
//to configure a spring app , download it and import to maven
@SpringBootApplication
public class APiApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creates a serverlet and hosts APP here
		
		//arg1 spring application that is annotated with spring APP
		//arg2 args that could have been passed to the class
		SpringApplication.run(APiApp.class, args);
		
		

	}

}
