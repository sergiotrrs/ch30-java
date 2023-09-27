package com.example.accessingdatajpa.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.accessingdatajpa.entity.Customer;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Customer customer;
	
	public UserDetailsImpl( Customer customer) {
		this.customer = customer;		
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		log.info("Agregando roles");
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		//authorities.add(  new SimpleGrantedAuthority( "ROLE_"+this.customer.getRole() )); // TODO leer ROLE de Customer
		authorities.add(  new SimpleGrantedAuthority( "ROLE_CUSTOMER" ));
		
		if( this.customer.getFirstName().toLowerCase().charAt(0) == 'a' ) {
			authorities.add(  new SimpleGrantedAuthority( "ROLE_ADMIN" ));			
		}
		
		return authorities ;
	}

	@Override
	public String getPassword() {
		return this.customer.getPassword();
	}

	@Override
	public String getUsername() {		
		return this.customer.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.customer.getActive();	
	}
	
	public String FullName() {
		return this.customer.getFirstName()+ " " + this.customer.getLastName();
	}

}
