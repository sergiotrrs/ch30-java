package com.example.accessingdatajpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.accessingdatajpa.entity.Customer;
import com.example.accessingdatajpa.repository.CustomerRepository;
import com.example.accessingdatajpa.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer createCustomer(Customer Customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(Long id) {		
		return customerRepository.findById(  (long)id) ;
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		//
		return null;
	}

}
