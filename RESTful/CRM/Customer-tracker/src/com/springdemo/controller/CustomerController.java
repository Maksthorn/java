package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject DAO to controller
	//@Autowired
	//private CustomerDAO customerDAO; //spring will look for class that implements the CustomerDAO and injects here
	//now injecting service instead
	@Autowired
	private CustomerService customerService;
	
	
	//@RequestMapping("/list")
	@GetMapping("/list") //only responds to get requests
	public String listCustomers(Model model) {
		// get data from customers 
		List <Customer> theCustomers = customerService.getCustomers(); //now delegates calls to service class
		//add data to model
		model.addAttribute("customers",theCustomers);
		
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		//new model to bidn data
		
		Customer theCustomer = new Customer();
		model.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	
	
}
