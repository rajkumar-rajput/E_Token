package com.raj.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityFilter {
	
	private MyUserDetails myUserDetails;
	
	private JwtFilter filter;
	
	
	public SecurityFilter(MyUserDetails myUserDetails, JwtFilter filter) {
		super();
		this.myUserDetails = myUserDetails;
		this.filter = filter;
	}

	@Bean
	public SecurityFilterChain myChain(HttpSecurity http) {
		
		http.authorizeHttpRequests(auth->auth
				
				.requestMatchers("/user-api/add"
						         ,"/login-api/**"
						        ,"/user-api/findAll"
						      ,"/user-api/findById/**"
						).permitAll()
				.requestMatchers("/user-api/delete/**"
						        ,"/user-api/villageUpdate/**"
						        ,"/user-api/fullUpdate/"
						         ).hasRole("ADMIN")
				.anyRequest().authenticated()
				
				);
		

		http.csrf(csrf->csrf.disable());
		http.formLogin(formLogin->formLogin.disable());
		http.userDetailsService(myUserDetails);
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		http.sessionManagement(sesson->sesson.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.httpBasic(basic->basic.disable());
		
		return http.build();
		
	}
	
	
	@Bean
	public PasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager manager(AuthenticationConfiguration config) {
		
		return config.getAuthenticationManager();
		
	}

}
