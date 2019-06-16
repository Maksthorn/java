package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.springdemo.entity.Customer;

@Repository // so spring can find this to get data
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//@Transactional
	public List<Customer> getCustomers() {
		//Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//query
		//using HQL from Customer
		Query<Customer> theQuery = currentSession.createQuery("from Customer" , Customer.class);
		//run query
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

}
