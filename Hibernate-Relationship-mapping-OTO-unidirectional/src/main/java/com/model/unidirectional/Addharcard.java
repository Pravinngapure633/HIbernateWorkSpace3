package com.model.unidirectional;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Addharcard {
	@Id
	private long adharno;
	private String address;
	private String geder;
	
	
	public Addharcard() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Addharcard(long adharno, String address, String geder) {
		super();
		this.adharno = adharno;
		this.address = address;
		this.geder = geder;
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
