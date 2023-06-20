
package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employee1 {

	@Id
	private int eid;
	private String ename;
	private String dept;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Laptop1> lap=new HashSet<Laptop1>();

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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Set<Laptop1> getLap() {
		return lap;
	}

	public void setLap(Set<Laptop1> lap) {
		this.lap = lap;
	}
	
	
}
