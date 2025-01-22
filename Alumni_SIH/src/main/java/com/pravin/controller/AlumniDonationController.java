package com.pravin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pravin.dto.AlumniDonationDto;
import com.pravin.service.AlumniDonationService;
@Controller
public class AlumniDonationController {
	@Autowired
	AlumniDonationService alumnidonationservice;
	

	@GetMapping("/donation")
	public String homePageDonation() {
	return "Donation";
	}
	@PostMapping("/donationdata")
	public String addDonationToDb(@ModelAttribute AlumniDonationDto alumnidonationdto) throws Exception {
		alumnidonationservice.addDonationToDb(alumnidonationdto);
		return "redirect:/ls";	
	}
}
