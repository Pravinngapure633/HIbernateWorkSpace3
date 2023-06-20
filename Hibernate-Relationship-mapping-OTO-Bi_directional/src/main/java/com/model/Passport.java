package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	
	@Id
	private int id;
	private String fullname;
	private String bloodgroup;
	private String addr;
	@OneToOne(cascade = CascadeType.ALL)
	private Persion per;
	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passport(int id, String fullname, String bloodgroup, String addr, Persion per) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.bloodgroup = bloodgroup;
		this.addr = addr;
		this.per = per;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Persion getPer() {
		return per;
	}
	public void setPer(Persion per) {
		this.per = per;
	}
	
	
	
	

}
