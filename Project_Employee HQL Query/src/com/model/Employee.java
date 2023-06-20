package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Employee {

	@Id
	private int eid;
	private String ename;
	private String eaddr;
	private long emobno;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Employee(int eid, String ename, String eaddr, long emobno) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eaddr = eaddr;
		this.emobno = emobno;
	}



	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEaddr() {
		return eaddr;
	}
	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}
	public long getEmobno() {
		return emobno;
	}
	public void setEmobno(long emobno) {
		this.emobno = emobno;
	}



	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddr=" + eaddr + ", emobno=" + emobno + "]";
	}
	
	

}
