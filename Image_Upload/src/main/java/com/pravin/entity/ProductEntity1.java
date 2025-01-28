package com.pravin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductEntity1 {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sn;
    
    private String name;
    
    @Lob
    private byte[] data; // Storing the image as byte array

}
