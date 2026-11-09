package com.raj.service;

import java.util.List;

import com.raj.dto.UserDto;

public interface IUserservice {
	
	UserDto addUser(UserDto dto);
	UserDto findById(Long id);
	List<UserDto> findAll();
	UserDto  parcialUpdate(Long id, String newVillage);
	UserDto fullUpdate( UserDto dto);
	UserDto deleteUser(Long id);

}
