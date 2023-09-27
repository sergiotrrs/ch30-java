package com.example.accessingdatajpa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.accessingdatajpa.entity.Customer;
import com.example.accessingdatajpa.repository.CustomerRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserDetailsServiceImpl implements UserDetailsService {

	//@Autowired
	// CustomerService customerService;  TODO crear capa de servicio
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.info("Find by email: " + email);
		Customer customer = customerRepository.findByEmail(email)
				.orElseThrow( ()-> new IllegalStateException("User not found with email: " + email));
		
		return new UserDetailsImpl( customer ); 
	}

}
