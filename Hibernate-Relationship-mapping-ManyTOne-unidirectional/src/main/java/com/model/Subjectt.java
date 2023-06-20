package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Subjectt {
	@Id
	private int sid;
	private String sname;
	@ManyToOne(cascade = CascadeType.ALL)
	private Teacher tec;
	
	public Subjectt() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Subjectt(int sid, String sname, Teacher tec) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.tec = tec;
	}

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

	public Teacher getTec() {
		return tec;
	}

	public void setTec(Teacher tec) {
		this.tec = tec;
	}

	@Override
	public String toString() {
		return "Subject [sid=" + sid + ", sname=" + sname + ", tec=" + tec + "]";
	}
	
	
	
}
