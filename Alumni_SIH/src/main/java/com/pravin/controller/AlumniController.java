package com.pravin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
/*
	@PutMapping( "/{uname}")
	public String editenquiryDetails(@PathVariable String Uname,@RequestBody AlumniEntity updateuser,ModelMap modelmap) {
		System.out.println(updateuser.getUname());
		//AlumniEntity editEnquiryDetails = alumniservice.getalumnibyuname(uname);
		//System.out.println(editEnquiryDetails.getSn()); 
		////System.out.println(editEnquiryDetails.getFname());
		//System.out.println(editEnquiryDetails.getLname());
		//modelmap.addAttribute("enquiryDetails", editEnquiryDetails);
		return"edit_enquiry";
		}
	*/
	@GetMapping("/edit")
	public String homeEdit() {
	return "Edit";
	}
/*
	@GetMapping("/editUser") 
	public String getUserByUsername(@RequestParam("username") String username, Model model) { 
		AlumniEntity user = alumniservice.getUserByUsername(username); 
	if (user != null) { 
	model.addAttribute("user", user); 
	return "editUser"; 
	} 
	model.addAttribute("error", "User not found"); 
	return "error"; 
	} 
	*/
	// Handle form submission to update user details 
	@PostMapping("/update/{uname}") 
	public String updateUser(@RequestParam("uname") String uname ,ModelMap modelmap) { 
		System.out.println(uname);
		AlumniEntity updatedUser = alumniservice.getUserByUsername(uname);
		System.out.println(updatedUser.getSn());
		System.out.println(updatedUser.getFname());
		System.out.println(updatedUser.getLname());
		
	modelmap.addAttribute("user", updatedUser); 
	return "edit_enquiry"; 
	// Show updated user details 
	} 
	@PostMapping("/update")
	public String updatedetails(@ModelAttribute("user") AlumniEntity alumnientity) {
		AlumniEntity status = alumniservice.saveupdateddata(alumnientity);
		return"redirect:/ls";
	}
	
}
