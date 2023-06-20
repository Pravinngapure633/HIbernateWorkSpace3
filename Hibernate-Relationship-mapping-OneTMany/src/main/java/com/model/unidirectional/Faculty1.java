package com.model.unidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Faculty1 {
	@Id
	private int fid;
	private String name;
	private String addr;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Department1> da=new ArrayList<Department1>();
	
	
	public Faculty1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Faculty1(int fid, String name, String addr, List<Department1> da) {
		super();
		this.fid = fid;
		this.name = name;
		this.addr = addr;
		this.da = da;
	}


	public List<Department1> getDa() {
		return da;
	}

	public void setDa(List<Department1> da) {
		this.da = da;
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



	@Override
	public String toString() {
		return "Faculty fid=" + fid + ", name=" + name + ", addr=" + addr;
	}
	
	

}
