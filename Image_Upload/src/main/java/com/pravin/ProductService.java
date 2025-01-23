package com.pravin;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pravin.entity.ProductEntity;
import com.pravin.repo.ProductRepo;

@Service
public class ProductService {
	@Autowired
	public ProductRepo productrepo;
	
	
	
	
	public List<ProductEntity> showAllEnquires() {
		return productrepo.findAll();
	}

}
