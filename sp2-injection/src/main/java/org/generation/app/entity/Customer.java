package org.generation.app.entity;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Component
@Qualifier("customer")
public class Customer {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private static int counter;
	
	{
		this.id = ++counter;
		System.out.println("Se inicializa el customer id: " + id);
	}
	
	

}
