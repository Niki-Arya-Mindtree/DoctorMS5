package com.doctor.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.main.entities.DoctorEntity;
import com.doctor.main.repository.DocRepos;

@Service
public class Services {
	
	@Autowired
	private DocRepos drepo;
	
	public List<DoctorEntity> getAll() 
	{
		
		return drepo.findAll();
	
	}

	public DoctorEntity oneData(int Id)
	{
		drepo.findById(Id);
		return drepo.findById(Id).get();
	}
	
	public void saveData(DoctorEntity dent) 
	{		
		drepo.saveAndFlush(dent);
	}
	
	
}
