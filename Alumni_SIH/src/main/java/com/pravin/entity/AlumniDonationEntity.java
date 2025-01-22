package com.pravin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AlumniDonationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sn;
	private String fullname;
	private String emailid;
	private String contactno;
	private String donationtype;

}
