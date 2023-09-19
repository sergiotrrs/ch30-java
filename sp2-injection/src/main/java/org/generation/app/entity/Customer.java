package org.generation.app.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
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
