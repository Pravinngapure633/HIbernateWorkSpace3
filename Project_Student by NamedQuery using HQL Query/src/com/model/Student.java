package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@NamedQueries({
	@NamedQuery(name="getSingleData",query = "from Student where studentRollno=:rollno"),
	@NamedQuery(name="getAllData",query = "from Student"),
	@NamedQuery(name="deleteSingleData",query = "delete from Student where studentRollno=:rollno"),
	@NamedQuery(name="deleteAllData",query = "delete from Student"),
	@NamedQuery(name="updateData",query = "update from Student set studentName=:name, studentAddr=:addr where studentRollno=:rollno"),
	
})

public class Student {
	
	@Id
	private int studentRollno;
	private String studentName;
	private String studentAddr;
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int studentRollno, String studentName, String studentAddr) {
		super();
		this.studentRollno = studentRollno;
		this.studentName = studentName;
		this.studentAddr = studentAddr;
	}
	public int getStudentRollno() {
		return studentRollno;
	}
	public void setStudentRollno(int studentRollno) {
		this.studentRollno = studentRollno;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAddr() {
		return studentAddr;
	}
	public void setStudentAddr(String studentAddr) {
		this.studentAddr = studentAddr;
	}
	@Override
	public String toString() {
		return "Studnet [studentRollno=" + studentRollno + ", studentName=" + studentName + ", studentAddr="
				+ studentAddr + "]";
	}
	
	
	

}
