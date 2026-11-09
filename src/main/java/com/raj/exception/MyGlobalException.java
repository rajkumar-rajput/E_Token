package com.raj.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyGlobalException {

	
	@ExceptionHandler(UserResouseNotFound.class)
	public ResponseEntity<ErrorPage> customException(UserResouseNotFound e){
		
		ErrorPage errorPage =new ErrorPage(e.getMessage(),LocalDateTime.now(),HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<ErrorPage> (errorPage,HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorPage> internalException(Exception e){
		
		ErrorPage errorPage =new ErrorPage(e.getMessage(),LocalDateTime.now(),HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return new ResponseEntity<ErrorPage> (errorPage,HttpStatus.OK);
	}
}
