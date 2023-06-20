package com.mo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	private int RollNo;
	private String Name;
	private long MobileNo;
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int rollNo, String name, long mobileNo) {
		super();
		RollNo = rollNo;
		Name = name;
		MobileNo = mobileNo;
	}
	public int getRollNo() {
		return RollNo;
	}
	public void setRollNo(int rollNo) {
		RollNo = rollNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getMonileNo() {
		return MobileNo;
	}
	public void setMonileNo(long mobileNo) {
		MobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "Student [RollNo=" + RollNo + ", Name=" + Name + ", MonileNo=" + MobileNo + "]";
	}
	
	
	
	
	
	

}
