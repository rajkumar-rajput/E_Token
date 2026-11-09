package com.raj.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20, nullable = false)
	private String farmerName;
	
	@Column(length = 20, nullable = false)
	private String village;
	
	@Column(length = 20, nullable = false)
	private String fertilizerType;
	
	@Column(length = 20, nullable = false)
	private String mobile;
	
	private Integer count;
	
	@Column(length = 20, nullable = false)
	private String email;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	@Column(length = 20, nullable = false)
	private String role;
	
}
