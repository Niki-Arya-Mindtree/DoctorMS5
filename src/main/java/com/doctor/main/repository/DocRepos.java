package com.doctor.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.main.entities.DoctorEntity;

public interface DocRepos extends JpaRepository<DoctorEntity, Integer>{

}
