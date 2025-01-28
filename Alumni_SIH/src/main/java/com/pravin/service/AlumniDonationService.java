package com.pravin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pravin.dto.AlumniDonationDto;
import com.pravin.dto.AlumniDto;
import com.pravin.entity.AlumniDonationEntity;
import com.pravin.entity.AlumniEntity;
import com.pravin.repository.AlumniDonationRepository;

@Service
public class AlumniDonationService {
	@Autowired
	public AlumniDonationRepository alumnidonationrepository;
	@Autowired
	public AlumniEmailService  alumniemailservice;

	public String addDonationToDb(AlumniDonationDto alumnidonationdto)  throws Exception{
		AlumniDonationEntity ade= new AlumniDonationEntity();
		ade.setFullname(alumnidonationdto.getFullname());
		ade.setEmailid(alumnidonationdto.getEmailid());
		ade.setContactno(alumnidonationdto.getContactno());
		ade.setDonationtype(alumnidonationdto.getDonationtype());
		alumnidonationrepository.save(ade);
		alumniemailservice.sendEmail("Spring Boot test Mail", "Good morning to all",new String[] {"ambupe2019@gmail.com","pravinece320@gmail.com","pravin.ambupe@jjmcoe.ac.in"});
		
		return"Donation Details added to database";
		
		
	}

	

	

}
