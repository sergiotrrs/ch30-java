package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.entity.Customer;

public interface CustomerService {
	
	Customer createCustomer(Customer Customer);
	
	Customer getCustomerById(Long id);

	Customer getCustomerByEmail(String email);

}
