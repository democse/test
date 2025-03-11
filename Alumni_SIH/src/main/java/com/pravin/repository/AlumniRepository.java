package com.pravin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pravin.entity.AlumniEntity;

public interface AlumniRepository extends JpaRepository<AlumniEntity, Integer> {
	
AlumniEntity findByUnameAndPassword(String uname,String password);
AlumniEntity findByUname(String uname);

	
	

}
