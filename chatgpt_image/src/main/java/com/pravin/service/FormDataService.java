package com.pravin.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pravin.entity.FormData;
import com.pravin.repo.FormDataRepository;

@Service
public class FormDataService {
	@Autowired
    private FormDataRepository formDataRepository;

    public void saveFormData(String name, String email, String conducteddate, MultipartFile file) throws IOException {
        FormData formData = new FormData();
        formData.setName(name);
        formData.setEmail(email);
        formData.setConductedDate(conducteddate);
        formData.setImageData(file.getBytes());
        formDataRepository.save(formData);
    }

    public List<FormData> getAllFormData() {
        return formDataRepository.findAll();
    }

    public FormData getEnquiryById(Long id) {
		return formDataRepository.findById(id).get();
	}
}
