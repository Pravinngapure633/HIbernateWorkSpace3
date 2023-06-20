package com.model.unidirectional;

import java.util.ArrayList;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Department1 {
	@Id
	private int id;
	private String name;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Faculty1> fa=new ArrayList<Faculty1>();
	
	public Department1() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Department1(int id, String name, List<Faculty1> fa) {
		super();
		this.id = id;
		this.name = name;
		this.fa = fa;
	}


	public List<Faculty1> getFa() {
		return fa;
	}


	public void setFa(List<Faculty1> fa) {
		this.fa = fa;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", fa=" + fa + "]";
	}


	

	
	

}
