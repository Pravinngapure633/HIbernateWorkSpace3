package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Addharcard {
	@Id
	private long adharno;
	private String address;
	private String geder;
	@OneToOne(cascade = CascadeType.ALL)
	private Student stu;


	public Student getStu() {
		return stu;
	}


	public void setStu(Student stu) {
		this.stu = stu;
	}


	public long getAdharno() {
		return adharno;
	}


	public void setAdharno(long adharno) {
		this.adharno = adharno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getGeder() {
		return geder;
	}


	public void setGeder(String geder) {
		this.geder = geder;
	}


	@Override
	public String toString() {
		return "Adharno=" + adharno + ", Address=" + address + ", Geder=" + geder ;
	}
	
	
	
	

}
