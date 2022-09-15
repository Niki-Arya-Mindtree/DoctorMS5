package com.doctor.main.controld;

import java.awt.image.RescaleOp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.main.exception.EmptyData;
import com.doctor.main.exception.ExcepMessg;
import com.doctor.main.service.Services;

@RestController
public class DocControl {

	@Autowired
	private Services serv;
	
	@GetMapping("/Doctor_data")
	public ResponseEntity<?> getFullData(){
		try {
			return new ResponseEntity<>(serv.getAll(),HttpStatus.FOUND);
		} 
		catch (EmptyData e) {
			return new ResponseEntity<>(new ExcepMessg(e.getLocalizedMessage()),HttpStatus.NO_CONTENT);
		}
	}
	
	
	@GetMapping("/Doctor_data/{Id}")
	public ResponseEntity<?> getOneData(@PathVariable int Id){
		try {
			return new ResponseEntity<>(serv.oneData(Id),HttpStatus.FOUND);
		} 
		catch (EmptyData e) {
			return new ResponseEntity<>(new ExcepMessg("No ID"),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/Doctor_data")
	public ResponseEntity<?> saveOneData(@RequestBody int Id){
		try {
			return new ResponseEntity<>(serv.getAll(),HttpStatus.ACCEPTED);
		} 
		catch (EmptyData e) {
			return new ResponseEntity<>(new ExcepMessg(e.getMessage()),HttpStatus.FOUND);
		}
	}
	
}
