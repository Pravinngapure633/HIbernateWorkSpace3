package com.model.unidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	private int rollno;
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	private Addharcard addr;
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(int rollno, String name, Addharcard addr) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.addr = addr;
	}


	public int getRollno() {
		return rollno;
	}


	public void setRollno(int rollno) {
		this.rollno = rollno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Addharcard getAddr() {
		return addr;
	}


	public void setAddr(Addharcard addr) {
		this.addr = addr;
	}


	@Override
	public String toString() {
		return "Student rollno=" + rollno + ", name=" + name + ", addr=" + addr ;
	}


}
