package com.example.accessingdatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		Customer newCustomer = customerRepository.save(customer);
		return newCustomer;
	}
	
}
