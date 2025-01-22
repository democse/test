package com.pravin.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pravin.dto.AlumniDto;
import com.pravin.dto.AlumniLogin;

import com.pravin.entity.AlumniEntity;
import com.pravin.repository.AlumniRepository;

@Service
public class AlumniService {
	@Autowired
	public AlumniRepository alumnirepository;

	public String  addAlumniToDb(AlumniDto alumnidto) {
		
		AlumniEntity entity = new AlumniEntity();
		entity.setFname(alumnidto.getFname());
		entity.setLname(alumnidto.getLname());
		entity.setUname(alumnidto.getUname());
		entity.setPassword(alumnidto.getPassword());
		alumnirepository.save(entity);
		return "Data Saved Sucessfully";
	
		
	}

	public AlumniDto userlogin(AlumniLogin alumnilogin) {
		AlumniEntity userdata  = alumnirepository.findByUnameAndPassword(alumnilogin.getUname(), alumnilogin.getPassword());
		AlumniDto alumnidto=null;
		if(userdata != null) {
			 alumnidto = new AlumniDto();
			alumnidto.setUname(userdata.getUname());
			alumnidto.setPassword(userdata.getPassword());	
		}
		return alumnidto;
		
	}
	
	public List<AlumniEntity> showAllEnquires() {
		return alumnirepository.findAll();
	}

}
