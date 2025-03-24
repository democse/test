package com.pravin.reservationmodel;

import com.pravin.reservationentity.ReservationEntity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationModel {
	private Integer sn;
	private String fname;
	private String lname;
	private String bookingdate;
	private String uname;
	private String password;

}
