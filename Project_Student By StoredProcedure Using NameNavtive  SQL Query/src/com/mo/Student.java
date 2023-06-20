package com.mo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name = "insertData",query ="{call insertData(?,?,?)}",resultClass = Student.class ),
	@NamedNativeQuery(name = "getSingleData",query ="{call getSingleData(?)}",resultClass = Student.class ),
	@NamedNativeQuery(name = "getAllData",query ="{call getAllData()}",resultClass = Student.class ),
	@NamedNativeQuery(name = "updateData",query ="{call updateData(?,?,?)}",resultClass = Student.class ),
	@NamedNativeQuery(name = "deleteSingle",query ="{call deleteSingleData(?)}",resultClass = Student.class ),
	@NamedNativeQuery(name = "deleteAll",query ="{call deleteAll()}",resultClass = Student.class ),
	
})
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
