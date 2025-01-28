package com.pravin.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pravin.ProductService;
import com.pravin.entity.ProductEntity;
import com.pravin.repo.ProductRepo;

@Controller
public class ProductController {
	@Autowired
	public ProductService productservice;
	
	@Autowired
	public ProductRepo productrepo;
	//	@Autowired
	//public ProductService ps;
	
	@GetMapping("/form")
    public String showForm() {
        return "uploadForm"; // Thymeleaf form
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam("name") String name,
                             @RequestParam("image") MultipartFile image,
                             Model model) throws IOException {
        // Convert the image to byte array
        byte[] imageBytes = image.getBytes();

        // Create User entity and set values
        ProductEntity user = new ProductEntity ();
        user.setName(name);
        user.setData(imageBytes);
        
        // Save the user to the database
        productrepo.save(user);

        model.addAttribute("message", "User created successfully with image!");

        return "result"; // Return a view showing success message
    }
    
    @GetMapping(value = "/allalumni" )
	public String getHomePage(ModelMap modelmap) {
		System.out.println("I am in contyroller class");
		
		modelmap.addAttribute("enquiry",new ProductEntity());
		modelmap.addAttribute("enquires",showAllEnquires());
		modelmap.addAttribute("title","Welcome to Alumni Portal of JJMCOE ");
        return "enquires";		
	}	
    /*
    
    @GetMapping("/form-data")
    public String showFormData(Model model) {
        List<ProductEntity> formDataList = showAllEnquires() ;
        System.out.println(formDataList);
        model.addAttribute("formDataList", formDataList);
        return "form-data";
    }
	*/
    public List<ProductEntity> showAllEnquires() {
		return productrepo.findAll();
	}
    
    

}
    /*
	System.out.println("I am in contyroller class");
	productrepo.findAll();
	
	modelmap.addAttribute("enquiry",new ProductEntity());
	modelmap.addAttribute("enquires",showAllEnquires());
	modelmap.addAttribute("title","Welcome to Alumni Portal of JJMCOE ");
    return "enquires";		
    */
