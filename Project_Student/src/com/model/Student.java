package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity

public class Student {
	
	@Id
	private int sRollno;
	
	private String sName;
	
	private String sAddr;

	private int sAge;

	private long sMobNo;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int sRollno, String sName, String sAddr, int sAge, long sMobNo) {
		super();
		this.sRollno = sRollno;
		this.sName = sName;
		this.sAddr = sAddr;
		this.sAge = sAge;
		this.sMobNo = sMobNo;
	}
	
	public int getsRollno() {
		return sRollno;
	}
	public void setsRollno(int sRollno) {
		this.sRollno = sRollno;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsAddr() {
		return sAddr;
	}
	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}
	public int getsAge() {
		return sAge;
	}
	public void setsAge(int sAge) {
		this.sAge = sAge;
	}
	public long getsMobNo() {
		return sMobNo;
	}
	public void setsMobNo(long sMobNo) {
		this.sMobNo = sMobNo;
	}
	@Override
	public String toString() {
		return "Student [sRollno=" + sRollno + ", sName=" + sName + ", sAddr=" + sAddr + ", sAge=" + sAge + ", sMobNo="
				+ sMobNo + "]";
	}
	
	
	
}
