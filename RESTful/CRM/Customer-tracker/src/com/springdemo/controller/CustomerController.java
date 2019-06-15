package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject DAO to controller
	@Autowired
	private CustomerDAO customerDAO; //spring will look for class that implements the CustomerDAO and injects here
	
	
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		// get data from customers 
		List <Customer> theCustomers = customerDAO.getCustomers();
		//add data to model
		model.addAttribute("customers",theCustomers);
		
		
		return "list-customers";
	}
	
	
}
