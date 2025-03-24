package com.pravin.reservationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pravin.reservationmodel.ReservationModel;
import com.pravin.reservationrepo.ReservationRepo;
import  com.pravin.reservationentity.*;

@Service
public class ReservationService {
	@Autowired
	public  ReservationRepo reservationrepo;
	
	public long maxenteries=10;
	public long currententeries;
	
public String  addAlumniToDb(ReservationModel  reservationmodel) {
		
	ReservationEntity entity1 = new ReservationEntity();
		entity1.setFname( reservationmodel.getFname());
		entity1.setLname( reservationmodel.getLname());
		entity1.setUname( reservationmodel.getUname());
		entity1.setPassword( reservationmodel.getPassword());
		entity1.setBookingdate(reservationmodel.getBookingdate());
		reservationrepo.save(entity1);
	
		return "Data Saved Sucessfully";
	
		
	}
public void getondate(String bookingdate) {
	long count1=reservationrepo.countByBookingdate(bookingdate);
	this.currententeries=count1;
	
}

}
