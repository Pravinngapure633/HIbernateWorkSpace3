package com.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Teacher1 {
	@Id
	private int tid;
	private String tname;
	private double salary;
	private String addr;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Subjectt1> sub=new HashSet<Subjectt1>();
	
	public Set<Subjectt1> getSub() {
		return sub;
	}
	public void setSub(Set<Subjectt1> sub) {
		this.sub = sub;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
