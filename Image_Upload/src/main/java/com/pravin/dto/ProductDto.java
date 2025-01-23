package com.pravin.dto;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	private Integer sn;
	private String productname;
	private String productcost;
	@Lob
	private byte[] image;

}
