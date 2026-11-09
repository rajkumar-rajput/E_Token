package com.raj.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.raj.repository.UserRepository;

@Component
public class MyUserDetails implements UserDetailsService {
	
	private UserRepository repo;
	
	public MyUserDetails(UserRepository repo) {
		super();
		this.repo = repo;
	}



	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		com.raj.entity.User byEmail = repo.findByEmail(email);
		
		 if (byEmail == null) {
		        System.out.println("User not found in database");
		        throw new UsernameNotFoundException("User not found");
		    }

		
		  UserDetails userDetails = User.withUsername(byEmail.getEmail())
		                            .password(byEmail.getPassword())
		                            .roles(byEmail.getRole())
	                                .build();
		
		
		return userDetails;
	}

}
