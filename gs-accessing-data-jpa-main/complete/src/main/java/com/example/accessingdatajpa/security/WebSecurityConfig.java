package com.example.accessingdatajpa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

/*
 *  @Configuration indica que una clase es una configuración de Spring.
 *  la clase se puede utilizar para definir y configurar beans de Spring, 
 *  así como para realizar otras configuraciones necesarias en una aplicación de Spring. 
 *  Puede contener métodos anotados con @Bean que devuelven objetos que se registran 
 *  como beans de Spring en el contexto de la aplicación.
 *  
 *  @EnableWebSecurity es una anotación que se utiliza para habilitar la seguridad web 
 *  en una aplicación de Spring y permite personalizar la configuración de seguridad 
 *  mediante una clase de configuración personalizada.
 *  Esta clase personalizada puede contener métodos anotados con @Override para configurar 
 *  aspectos específicos de la seguridad, como la autenticación de usuarios, la autorización 
 *  de accesos, la configuración de proveedores de autenticación, entre otros.
 *  
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	
	// STEP 1 Deshabilitar la seguridad en filter chain	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http ) throws Exception {
		http.authorizeHttpRequests( authorize -> authorize.anyRequest().permitAll() )
			.csrf(csrf -> csrf.disable())
			.httpBasic( withDefaults() );
		return http.build();
	}
	
	
	
	

}
