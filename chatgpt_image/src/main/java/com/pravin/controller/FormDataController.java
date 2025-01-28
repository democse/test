package com.pravin.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pravin.entity.FormData;
import com.pravin.service.FormDataService;

@Controller
public class FormDataController {
	@Autowired
    private FormDataService formDataService;

    // Display the form
    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    // Handle form submission (text + image)
    @PostMapping("/submit")
    public String submitForm(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("image") MultipartFile image) throws IOException {
        formDataService.saveFormData(name, email, image);
        return "redirect:/form-data";
    }

    // Display all form data along with images
    @GetMapping("/form-data")
    public String showFormData(Model model) {
        List<FormData> formDataList = formDataService.getAllFormData();
        model.addAttribute("formDataList", formDataList);
        return "form-data";
    }

}
