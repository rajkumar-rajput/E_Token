package com.raj.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUnilty {
	
	private String secreateKey = "hwejfcvricfwcvrtwcargdaHGWUIQhblufvbbvkgfugvkhvcjhEjwfxbvzhlusfgqirufgyjvlf";//3 part
	private Key key=Keys.hmacShaKeyFor(secreateKey.getBytes());
	
	public String generateJWTToken(String userData) {
		return Jwts.builder()//start to make jwt
				.setSubject(userData)//2 part
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*2))
				.signWith(key, SignatureAlgorithm.HS256)//it is 3 part
				.compact();
	}
	
	public String readToken(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	

}
