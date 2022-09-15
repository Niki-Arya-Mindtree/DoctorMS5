package com.doctor.main.controld;

import java.awt.image.RescaleOp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.main.exception.EmptyData;
import com.doctor.main.exception.ExcepMessg;
import com.doctor.main.service.Services;

@RestController
public class DocControl {

	@Autowired
	private Services serv;
	
//	@GetMapping("/user")
//	public ResponseEntity<?> fullData(){
//	try {
//			return new ResponseEntity<>(ser.getAll(),HttpStatus.FOUND);
//		}
//	catch (com.student.main.exceptionns.EmptyData e) {
//		return new ResponseEntity<>(new com.student.main.exceptionns.ExcepMessg(e.getMessage()),HttpStatus.NO_CONTENT);
//	}
//	catch (Exception e) {
//			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
//		} 
//	}
	
	
	public ResponseEntity<?> fullData(){
		try {
			return new ResponseEntity<>(serv.getAll(),HttpStatus.FOUND);
		} 
		catch (EmptyData e) {
			return new ResponseEntity<>(new ExcepMessg(e.getMessage()),HttpStatus.NO_CONTENT);
		}
	}
	
}
