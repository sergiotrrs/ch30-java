package com.example.accessingdatajpa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.example.accessingdatajpa.security.jwt.JWTAuthenticationFilter;
import com.example.accessingdatajpa.security.jwt.JWTAuthorizationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

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
	
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	JWTAuthorizationFilter jwtAutorizationFilter;
	
	
	// STEP 1 Deshabilitar la seguridad en filter chain	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager ) throws Exception {
		
		JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
		jwtAuthenticationFilter.setAuthenticationManager( authManager );
		jwtAuthenticationFilter.setFilterProcessesUrl("/login");
		
		
		http.authorizeHttpRequests( authorize -> authorize
				// STEP 2.1 configurar las reglas de autorización para las solicitudes HTTP
				.requestMatchers( "/api/v1/products" ).permitAll()
				.requestMatchers( "/api/v1/orders/**" ).hasRole("ADMIN")
				.requestMatchers( "/api/v1/users/**" ).hasAnyRole("ADMIN", "CUSTOMER", "SAYAJIN")	
				.anyRequest().authenticated() )
			.addFilter(jwtAuthenticationFilter)
			.addFilterBefore( jwtAutorizationFilter  , UsernamePasswordAuthenticationFilter.class )
			.csrf(csrf -> csrf.disable()) // deshabilitando lka protección Cross-Site Request Forgery
			.cors( cors -> cors.disable() ) 
			.httpBasic( withDefaults() ); // habilitando la autenticación básica http
		return http.build();
	}
	
	
	
	
	
	
	
	
	// STEP 2 Autenticación basada en usuarios en memoria
	/*
	@Bean
	UserDetailsService userDetailsService() {
		
		UserDetails edwin = User.builder()
				.username("edwin@ninja.com")
				.password( passwordEncoder().encode("123")   )
				.roles("ADMIN")
				.build();
				
		UserDetails lalo = User.builder()
				.username("eduardo")
				//.password("{noop}456")
				.password( passwordEncoder().encode("456")   )
				.roles("CUSTOMER", "SAYAJIN") // "ROLE_CUSTOMER"
				.build();
		
		return new InMemoryUserDetailsManager( edwin, lalo)  ;
	}*/
	
	// STEP 3 Leer usuarios de la DB
	@Bean
	AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
		
		AuthenticationManagerBuilder authManagerBuilder = http
				.getSharedObject( AuthenticationManagerBuilder.class);
		
		authManagerBuilder
			.userDetailsService( userDetailsService ) 
			.passwordEncoder( passwordEncoder );
		
		return authManagerBuilder.build();
	}
	
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	public static void main(String[] args) {
//		System.out.println("Password: " +  new BCryptPasswordEncoder().encode("123") );
//	}
	
	

}
