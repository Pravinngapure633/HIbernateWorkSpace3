package com.model.unidirectional;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Faculty {
	@Id
	private int fid;
	private String name;
	private String addr;

	
	
	
	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Faculty(int fid, String name, String add) {
		super();
		this.fid = fid;
		this.name = name;
		this.addr = add;
	}



	public int getFid() {
		return fid;
	}



	public void setFid(int fid) {
		this.fid = fid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddr() {
		return addr;
	}



	public void setAddr(String add) {
		this.addr = add;
	}



	@Override
	public String toString() {
		return "Faculty fid=" + fid + ", name=" + name + ", addr=" + addr;
	}
	
	

}
