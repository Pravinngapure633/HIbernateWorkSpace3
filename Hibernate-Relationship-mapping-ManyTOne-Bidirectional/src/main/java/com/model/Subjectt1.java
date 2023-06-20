package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Subjectt1 {
	@Id
	private int sid;
	private String sname;
	@ManyToOne(cascade = CascadeType.ALL)
	private Teacher1 tec;
	
	

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Teacher1 getTec() {
		return tec;
	}

	public void setTec(Teacher1 tec) {
		this.tec = tec;
	}

	
	
	
}
