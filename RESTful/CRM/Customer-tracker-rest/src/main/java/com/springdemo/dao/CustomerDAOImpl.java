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
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName" , Customer.class);
		//run query
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//save data
		//currentSession.save(theCustomer);
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
		
	}

	@Override
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<?> theQuery = currentSession.createQuery("delete from Customer where id=:thecustomerId");
		theQuery.setParameter("customerID", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		// get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query<Customer> theQuery = null;
        
        // only search by name if theSearchName is not empty
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty  so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
                
        // return the results        
        return customers;
	}
	
	

}
