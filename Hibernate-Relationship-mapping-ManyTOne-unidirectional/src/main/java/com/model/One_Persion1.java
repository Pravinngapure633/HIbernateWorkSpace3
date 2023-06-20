package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class One_Persion1 {
	@Id
	private String name;
	private long mobileno;
	private String addr;
	public One_Persion1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public One_Persion1(String name, long mobileno, String addr) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "One_Persion1 [name=" + name + ", mobileno=" + mobileno + ", addr=" + addr + "]";
	}
	
}
