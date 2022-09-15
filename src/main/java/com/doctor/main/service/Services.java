package com.doctor.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.main.entities.DoctorEntity;
import com.doctor.main.exception.EmptyData;
import com.doctor.main.repository.DocRepos;

@Service
public class Services {
	
	@Autowired
	private DocRepos drepo;
	
	public List<DoctorEntity> getAll() throws EmptyData
	{
		
		
		try {
			if(drepo.findAll().size()==0)
				throw new Exception();
		} catch (Exception e) {
			throw new EmptyData("Empty DataBase");
		}
		
		return drepo.findAll();
	
	}

	public DoctorEntity oneData(int Id) throws EmptyData
	{
		try {
			drepo.findById(Id);
		} catch (Exception e) {
			throw new EmptyData("Wrong Id");
		}
		return drepo.findById(Id).get();
	}
	
	public void saveData(DoctorEntity dent) throws EmptyData
	{
		try {
			if(drepo.findById(dent.getId())!=null)
				throw new Exception();
		} catch (Exception e) {
			throw new EmptyData("The Id is already Repeated plz check the data");
		}
		drepo.saveAndFlush(dent);
	
	}
	
	
}
