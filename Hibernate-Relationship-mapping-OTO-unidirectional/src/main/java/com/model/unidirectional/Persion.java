package com.model.unidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Persion {

	@Id
	private String name;
	private long mobileno;
	@OneToOne(cascade = CascadeType.ALL)
	private Passport pass;
	public Persion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Persion(String name, long mobileno, Passport pass) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.pass = pass;
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
	public Passport getPass() {
		return pass;
	}
	public void setPass(Passport pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Persion [name=" + name + ", mobileno=" + mobileno + ", pass=" + pass + "]";
	}
	
	
	
}
