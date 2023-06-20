package com.model.unidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Faculty {
	@Id
	private int fid;
	private String name;
	private String addr;
	@ManyToOne(cascade = CascadeType.ALL)
	private Department dep;
	
	


	public Department getDep() {
		return dep;
	}



	public void setDep(Department dep) {
		this.dep = dep;
	}



	public int getFid() {
		return fid;
	}



	public void setFid(int fid) {
		this.fid = fid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddr() {
		return addr;
	}



	public void setAddr(String add) {
		this.addr = add;
	}



	
	

}
