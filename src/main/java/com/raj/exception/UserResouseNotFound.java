package com.raj.exception;

public class UserResouseNotFound extends RuntimeException{
	
	public UserResouseNotFound() {
		
	}

   public UserResouseNotFound(String message) {
		super(message);
	}

}
