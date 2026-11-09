package com.raj.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.dto.UserDto;
import com.raj.service.IUserservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user-api")
public class UserController {
	
	private IUserservice service;

	public UserController(IUserservice service) {
		super();
		this.service = service;
	}
	
	
	@PostMapping("/add")
	  public ResponseEntity<UserDto> addUser(@RequestBody @Valid UserDto dto) {
		 
		 UserDto user = service.addUser(dto);

		return  new ResponseEntity<UserDto>(user, HttpStatus.CREATED);
	}
	 
	 
	  @GetMapping("/findById/{id}")
		public ResponseEntity<UserDto> findById(@PathVariable Long id) {
			
		  UserDto byId = service.findById(id);
		 
		 return  new ResponseEntity<UserDto>( byId, HttpStatus.OK);
		}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<UserDto>> findAll() {
		 
		List<UserDto> all = service.findAll();
		
		return new ResponseEntity<List<UserDto>>( all, HttpStatus.OK);
	}
	 
	
	@PatchMapping("/villageUpdate/{id}/{newVillage}")
		public ResponseEntity<UserDto> parcialUpdate(@PathVariable Long id, @PathVariable String newVillage) {
		 
			UserDto parcialUpdate = service.parcialUpdate(id, newVillage);
			
			return  new ResponseEntity<UserDto>( parcialUpdate, HttpStatus.OK);
		}
	 
	  @PutMapping("/fullUpdate")
	    public  ResponseEntity<UserDto> fullUpdate(@RequestBody UserDto dto) {
	    	
	    	UserDto fullUpdate = service.fullUpdate(dto);
	    	
				
			return  new ResponseEntity<UserDto>( fullUpdate, HttpStatus.OK);
	 }
	
	 
	    @DeleteMapping("/delete/{id}")
		public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
		 
		 UserDto deleteUser = service.deleteUser(id);
		 
		 
		 return  new ResponseEntity<UserDto>( deleteUser, HttpStatus.OK); 
			 
		}
	
	

}
