package com.pravin.reservationrepo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pravin.reservationentity.ReservationEntity;

public interface  ReservationRepo extends JpaRepository<ReservationEntity, Integer> {
	
	long  countByBookingdate(String bookingdate );

}
