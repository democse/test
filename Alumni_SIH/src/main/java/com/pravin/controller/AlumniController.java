package com.pravin.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pravin.dto.AlumniDto;
import com.pravin.dto.AlumniLogin;

import com.pravin.entity.AlumniEntity;
import com.pravin.service.AlumniService;

@Controller
public class AlumniController {
	@Autowired
	public AlumniService alumniservice;
	
	@GetMapping("/")
	public String homePage() {
	return "Welcome";
	}
	@PostMapping("/savedata")
	public String addAlumniToDb(@ModelAttribute AlumniDto alumnidto) {
		alumniservice.addAlumniToDb(alumnidto);
		return "redirect:/";	
	}
	
	@GetMapping("/loginpage")
	public String  homePage1() {
		return "login";
	}
	
	@PostMapping("/checkvaliduser")
	public String  userlogin(@ModelAttribute AlumniLogin alumnilogin) {
		
		AlumniDto userdata = alumniservice.userlogin(alumnilogin);
		if(userdata !=null) {	
		
			return "redirect:/ls";	
		}else
			
		return "redirect:/lns";
	}
	@GetMapping("/ls")
	public String  homePage2() {
		return "ls";
	}
	
	@GetMapping("/lns")
	public String  homePage3() {
		return "lns";
	}
	
	@GetMapping(value = "/allalumni")
	public String getHomePage(ModelMap modelmap) {
		System.out.println("I am in contyroller class");
		
		modelmap.addAttribute("enquiry",new AlumniEntity());
		modelmap.addAttribute("enquires",alumniservice.showAllEnquires());
		modelmap.addAttribute("title","Welcome to Alumni Portal of JJMCOE ");
        return "enquires";		
	}	
	

}
