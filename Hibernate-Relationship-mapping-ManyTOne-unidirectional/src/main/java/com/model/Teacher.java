package com.model;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Teacher {
	@Id
	private int tid;
	private String tname;
	private double salary;
	private String addr;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int tid, String tname, double salary, String addr) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.salary = salary;
		this.addr = addr;
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
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", salary=" + salary + ", addr=" + addr + "]";
	}
	
	
}
