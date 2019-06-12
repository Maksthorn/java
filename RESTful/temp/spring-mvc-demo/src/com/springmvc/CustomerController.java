package com.springmvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.org.apache.xpath.internal.operations.String;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		//remove whitespaces leading and tailing
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/showForm")
	public java.lang.String showForm(Model theModel) {
		
		theModel.addAttribute("customer",new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public java.lang.String processForm( 
		@Valid @ModelAttribute("customer") Customer theCustomer, 
		BindingResult theBindingResult){
		
		if(theBindingResult.hasErrors()) {
			return "customer-form";
			
			}else{
			
			return "customer-confirmation";
		
			}
	}
	
}
