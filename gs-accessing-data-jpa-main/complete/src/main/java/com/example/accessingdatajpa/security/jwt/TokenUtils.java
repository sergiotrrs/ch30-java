package com.example.accessingdatajpa.security.jwt;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {
	
	private final static String ACCESS_TOKEN_SECRET = "crR/lggroR-o6?qFOpAuTTRkt!aGW49wsys5mwkJP9YnLNVPuuJ2Z!jXiJGGzULqmIgWltkfcYQD/twTzCo/zb/wt=jVP/2NjFd2aVc!uKpdNiDB48-lNFRNTZ7i2L36ZCEhUWUDYtkGjG3BDZcA5SSJzRYClKvAZjLGGUx5MW8ZZUj7iSVv!3eA4BcayMr6IdjxPZqIU7h0?JcsI3mohEFlFHb2MCRJRvNDsey3mHMbcQfH5ChVz!FzJjIlMsVY";
	private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 300L;
	
	public static String createToken(
			String name, 
			String email,  
			Collection<? extends GrantedAuthority> authorities ) {
		
		long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
		Date expirationDate = new Date( System.currentTimeMillis() + expirationTime );
		
		Map< String, Object> extra = new HashMap<>();
		extra.put("name", name );
		extra.put("authorities", authorities );
		
		return  Jwts
					.builder()
					.setSubject(email)
					.setExpiration(expirationDate)
					.addClaims(extra)
					.signWith( Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes() ) )
					.compact();
	}
	

}
