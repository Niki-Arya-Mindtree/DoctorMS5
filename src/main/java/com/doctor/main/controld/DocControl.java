package com.doctor.main.controld;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.main.entities.DoctorEntity;
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
		catch (Exception e) {
			return new ResponseEntity<>("Empty DataBase",HttpStatus.NO_CONTENT);
		}
	}
	
	
	@GetMapping("/Doctor_data/{Id}")
	public ResponseEntity<?> getOneData(@PathVariable int Id){
		try {
			return new ResponseEntity<>(serv.oneData(Id),HttpStatus.FOUND);
		} 
		catch (Exception e) {
			return new ResponseEntity<>("No Data With this respective Id",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/Doctor_data")
	public ResponseEntity<?> saveOneData(@RequestBody DoctorEntity de){
			serv.saveData(de);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
