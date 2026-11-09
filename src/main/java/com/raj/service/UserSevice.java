package com.raj.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.raj.dto.UserDto;
import com.raj.entity.User;
import com.raj.exception.UserResouseNotFound;
import com.raj.mapper.UserMapper;
import com.raj.repository.UserRepository;

@Service
public class UserSevice implements IUserservice {
	
	private final UserRepository repo;
	
	private final UserMapper mapper;
	
	private PasswordEncoder encoder;
	

	 public UserSevice(UserRepository repo, UserMapper mapper, PasswordEncoder encoder) {
		super();
		this.repo = repo;
		this.mapper = mapper;
		this.encoder = encoder;
	}


	@Override
	  public UserDto addUser(UserDto dto) {
		 
		 User entity = mapper.toEntity(dto);
		 
		 entity.setRole("USER");
		 entity.setPassword(encoder.encode(entity.getPassword()));
		 
		 User save = repo.save(entity);

		return  mapper.toDto(save);
	}
	 
	 
	 @Override
		public UserDto findById(Long id) {
			
		 User byId = repo.findById(id).orElseThrow(()-> new UserResouseNotFound("Useris not Found"));
		 
			return mapper.toDto(byId);
		}
	
	 @Override
	public List<UserDto> findAll() {
		 
		 List<User> all = repo.findAll();
		 
		
		return mapper.toDtoList(all);
	}
	 
	 @Override
		public UserDto parcialUpdate(Long id, String newVillage) {
		 
		 User user = repo.findById(id).orElseThrow(()-> new UserResouseNotFound("Useris not Found"));
			user.setVillage(newVillage);
			
			User save = repo.save(user);
			
			
			return mapper.toDto(save);
		}
	 
	    @Override
	    public UserDto fullUpdate( UserDto dto) {
	    	
			 User user = repo.findById(dto.getId()).orElseThrow(()-> new UserResouseNotFound("Useris not Found"));

	    	user.setFarmerName(dto.getFarmerName());
	    	user.setVillage(dto.getVillage());
	    	user.setMobile(dto.getMobile());
	    	user.setCount(dto.getCount());
	    	
			
			User save = repo.save(user);
			
		
		return mapper.toDto(save);
	 }
	
	 
	 @Override
		public UserDto deleteUser(Long id) {
		 User user = repo.findById(id).orElseThrow(()-> new UserResouseNotFound("Useris not Found"));

		 
		 repo.delete(user);
		 
		 return mapper.toDto(user); 
			 
		}
	
	

}
