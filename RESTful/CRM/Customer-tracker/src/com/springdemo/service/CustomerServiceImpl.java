package com.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;

//mark as service for spring
@Service
public class CustomerServiceImpl implements CustomerService {
	
	//inject
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		//delegates to DAO
		return customerDAO.getCustomers();
	}

}