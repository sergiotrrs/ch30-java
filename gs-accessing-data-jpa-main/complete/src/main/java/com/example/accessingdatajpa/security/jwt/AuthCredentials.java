package com.example.accessingdatajpa.security.jwt;

import lombok.Data;

@Data
public class AuthCredentials {
	private String email;
	private String password;

}
