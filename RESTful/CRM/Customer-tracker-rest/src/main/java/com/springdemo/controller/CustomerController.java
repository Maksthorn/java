package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@PostMapping("/saveCustomer")
	//this links ot the form code here
	//<form:form action="saveCustomer" modelAttribute="customer" method="POST">
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		//use service to save data
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
		
		
		Customer theCustomer = customerService.getCustomer(theId);
		
		theModel.addAttribute("customer",theCustomer);
		
		
		
		return "customer-form";
	}
	
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName")String theSearchName,Model theModel) {
		 // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";   
		
	}
	
}
