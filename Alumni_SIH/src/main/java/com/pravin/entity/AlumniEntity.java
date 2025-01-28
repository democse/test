package com.pravin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "CSE_ALUMNI")
@Entity
public class AlumniEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sn;
	private String fname;
	private String lname;
	private String uname;
	private String password;
	public Integer getSn() {
		return sn;
	}
	public void setSn(Integer sn) {
		this.sn = sn;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AlumniEntity(Integer sn, String fname, String lname, String uname, String password) {
		super();
		this.sn = sn;
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.password = password;
	}
	public AlumniEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AlumniEntity [sn=" + sn + ", fname=" + fname + ", lname=" + lname + ", uname=" + uname + ", password="
				+ password + "]";
	}
	
	

}
