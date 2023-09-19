package org.generation.app.controller;

import org.generation.app.entity.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	Customer customer = new Customer();
	
	@GetMapping("api/customers")
	public Customer getCustomerById() {
		customer.setFirstName("Pato");
		customer.setLastName("Donald");
		customer.setEmail("pato@gmail.com");
		
		return customer;
	}
}
