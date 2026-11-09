package com.raj.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	private JwtUnilty jwtUnilty;
	
	private MyUserDetails myUserDetails;
	
	
	public JwtFilter(JwtUnilty jwtUnilty, MyUserDetails myUserDetails) {
		super();
		this.jwtUnilty = jwtUnilty;
		this.myUserDetails = myUserDetails;
	}



	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		
		String header = req.getHeader("Authorization");
		
		if( header !=null && header.startsWith("Bearer ")){
			String token = header.substring(7);
			
			String userEmail = jwtUnilty.readToken(token);
			UserDetails userByUsername = myUserDetails.loadUserByUsername(userEmail);
			
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = //we can createAuthenticaion
					new UsernamePasswordAuthenticationToken(userByUsername, null, userByUsername.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);//it is hold the authentication object
			
	
		}
		filterChain.doFilter(req, res);
		
		
	}

}
