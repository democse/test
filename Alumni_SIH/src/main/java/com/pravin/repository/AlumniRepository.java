package com.pravin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pravin.dto.AlumniDto;
import com.pravin.entity.AlumniEntity;

public interface AlumniRepository extends JpaRepository<AlumniEntity, Integer> {
	
	AlumniEntity findByUnameAndPassword(String uname,String password);

}
