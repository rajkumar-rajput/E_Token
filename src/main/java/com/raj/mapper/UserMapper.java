package com.raj.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.raj.dto.UserDto;
import com.raj.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	User toEntity(UserDto dto);
	UserDto toDto(User entity);
	
	List<User> toEntityList(List<UserDto> dto);
	List<UserDto> toDtoList(List<User> entity);
	
	

}
