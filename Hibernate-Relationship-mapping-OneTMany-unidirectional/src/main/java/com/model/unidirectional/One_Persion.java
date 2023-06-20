package com.model.unidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class One_Persion {
	@Id
	private String name;
	private long mobileno;
	private String addr;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Vehicale> l=new ArrayList<Vehicale>();
	public One_Persion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public One_Persion(String name, long mobileno, String addr, List<Vehicale> l) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.addr = addr;
		this.l = l;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public List<Vehicale> getL() {
		return l;
	}
	public void setL(List<Vehicale> l) {
		this.l = l;
	}
	@Override
	public String toString() {
		return "One_Persion [name=" + name + ", mobileno=" + mobileno + ", addr=" + addr + ", l=" + l + "]";
	}
	
	

}
