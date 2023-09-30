package com.example.accessingdatajpa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.accessingdatajpa.entity.Customer;
import com.example.accessingdatajpa.repository.CustomerRepository;
import com.example.accessingdatajpa.service.impl.CustomerServiceImpl;

/*
 *  Mockito es una biblioteca de pruebas unitarias
 *  que se utiliza para simular objetos y comportamiento
 *  de pruebas unitarias.
 *  
 *  Proporciona una forma sencilla y flexible de crear objetos
 *  simulados(mocks) que se utilizan como sustitutos de los objetos
 *  reales en las pruebas.
 *  
 *  En este ejercicio se simulará el objeto customerRepository
 *  Para que entregue el valor que necesita el servicio de getCustomerById
 *  de las clase CustomerService.
 */

//Lo siguiente inicializará automáticamente los objetos mock y
//las anotaciones de Mockito en la clase prueba
@ExtendWith(MockitoExtension.class)
public class CustomerServiceClass {

	// Inyectar automáticamente los objetos mocks en la clase bajo prueba.
	@InjectMocks
	private CustomerServiceImpl customerService;
	
	// Crea un objeto mock de una clase o interfaz determinada.
	// Este objeto mock puede ser utilizado para simular el
	// comportamiento de la clase o interfaz durante
	// la ejecución de la prueba unitaria.
	@Mock
	private CustomerRepository customerRepository;
	
	private Customer customer;
	
	// El método debe ejecutarse antes de cada prueba unitaria.
	@BeforeEach
	public void init() {
//		customer = new Customer();
//		customer.setFirstName("Chistomer");
//		customer.setLastName("Robin");
		customer = Customer.builder()
				.id(100L)
				.firstName("Chistofer")
				.lastName("Robin")
				.email("robin")
				.password("engañoaunoso")
				.active(true)
				.build();
		
	}
	
	@Test
	void getCustomerByIdTest() {
		// Definir el comportamiento esperado de un mock
		// ¿Qué va a realizar el objeto simulado?
		Mockito.when( customerRepository.findById(100L) ).thenReturn(  customer   );
		
		// Invocamos el método a probar
		Customer existingCustomer = customerService.getCustomerById(100L);
		
		// Realziar comparaciones
		assertEquals( 100L, existingCustomer.getId(), "Verificar ID" );
		// TODO agregar el resto de comparaciones.
				
	}
	
	
}
