package com.example.accessingdatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.accessingdatajpa.entity.Customer;
import com.example.accessingdatajpa.repository.CustomerRepository;

import lombok.extern.log4j.Log4j2;

@RestController // @Controller @ResponseBody
@RequestMapping("api/v1/customers") // localhost:8080/api/vi/customers
@Log4j2
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping // localhost:8080/api/vi/customers
	public List<Customer> getAllCustomers(){
		log.info("Solicitud get para todos los Customers");
		List<Customer> customers = (List<Customer>) customerRepository.findAll();
		return customers;
	}
	
	@GetMapping("{id}") // localhost:8080/api/vi/customers/2
	public Customer getCustomerById(@PathVariable long id) {
		Customer customer = customerRepository.findById(id);
		return customer;
	}
	
	@PostMapping  // localhost:8080/api/vi/customers
	public Customer setCustomer(@RequestBody Customer customer) {
		log.info("Solicitud post, agregar nuevo cliente");
		customer.setId(null);
		Customer newCustomer = customerRepository.save(customer);
		return newCustomer;
	}
	
	@PutMapping("{id}")  // localhost:8080/api/vi/customers/2
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable long id) {
		log.info("Solicitud put, actualizar cliente");
		
		Customer existingCustomer = customerRepository.findById( id );
		
		if( existingCustomer == null ) {
			throw new IllegalStateException("User does not exist");
		}
		
		existingCustomer.setFirstName( customer.getFirstName() );
		existingCustomer.setLastName( customer.getLastName() );
		
		
		return customerRepository.save(existingCustomer);
	}
	
	
	
	
}
