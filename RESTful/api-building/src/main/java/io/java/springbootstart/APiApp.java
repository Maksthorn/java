package io.java.springbootstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//tells the application that this is a spring application
@SpringBootApplication
public class APiApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creates a serverlet and hosts app here
		
		//arg1 spring application that is annotated with spring app
		//arg2 args that could have been passed to the class
		SpringApplication.run(APiApp.class, args);
		
		

	}

}
