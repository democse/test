package com.pravin.reservationcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pravin.reservationmodel.ReservationBetween;
import com.pravin.reservationmodel.ReservationModel;
import com.pravin.reservationservice.ReservationService;



@Controller
public class ReservationController {
	
	
	@Autowired
	public ReservationService reservationservice;
	@GetMapping("/")
	public String homePage() {
	return "Welcome";
	}
	@PostMapping("/savedata")
	public String addAlumniToDb(@ModelAttribute ReservationModel resrvationmodel) {
		reservationservice.addAlumniToDb(resrvationmodel);
		return "redirect:/";	
	}
	
	@GetMapping("/getdata")
	public String homePage4() {
	return "Welcome1";
	}
	
	@GetMapping("/rf")
	public String homePage5() {
	return "rf";
	}
	@GetMapping("/rnf2")
	public String homePage6() {
	return "rnf2";
	}
	
	@PostMapping("/between")
	public String getdatabetween(@RequestParam("bookingdate")String bookingdate) {
		reservationservice.getondate(bookingdate);
		if(reservationservice.currententeries>reservationservice.maxenteries) {
			return "redirect:/rf";
		}else
		return "redirect:/";
	}
	
	
	
	

}
