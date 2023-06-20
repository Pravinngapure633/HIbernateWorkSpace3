package com.model.unidirectional;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passport {
	
	@Id
	private int id;
	private String fullname;
	private String bloodgroup;
	private String addr;
	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passport(int id, String fullname, String bloodgroup, String addr) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.bloodgroup = bloodgroup;
		this.addr = addr;
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
	@Override
	public String toString() {
		return "Passport [id=" + id + ", fullname=" + fullname + ", bloodgroup=" + bloodgroup + ", addr=" + addr + "]";
	}

	
	
	

}
