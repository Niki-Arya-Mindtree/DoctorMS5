package com.doctor.main.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EmptyData.class)
	public ResponseEntity<Object> Excep1(Exception ex){
	
		ExcepMessg exx = new ExcepMessg(new Date(),ex.getMessage());
		
		return new ResponseEntity<Object>(exx,HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> Excep2(Exception ex){
	
		ExcepMessg exx = new ExcepMessg(new Date(),ex.getMessage());
		
		return new ResponseEntity<Object>(exx,HttpStatus.BAD_REQUEST);
	}

}
