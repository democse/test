package com.pravin.dto;

import com.pravin.entity.AlumniDonationEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumniDonationDto {
	
	private String fullname;
	private String emailid;
	private String contactno;
	private String donationtype;

}
