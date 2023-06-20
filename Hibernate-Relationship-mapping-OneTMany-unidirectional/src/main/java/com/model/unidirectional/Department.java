package com.model.unidirectional;

import java.util.ArrayList;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Department {
	@Id
	private int id;
	private String name;
	@OneToMany
	private List<Faculty> fa=new ArrayList<Faculty>();
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Department(int id, String name, List<Faculty> fa) {
		super();
		this.id = id;
		this.name = name;
		this.fa = fa;
	}


	public List<Faculty> getFa() {
		return fa;
	}


	public void setFa(List<Faculty> fa) {
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
