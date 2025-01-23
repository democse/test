package com.pravin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pravin.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer>{

}
