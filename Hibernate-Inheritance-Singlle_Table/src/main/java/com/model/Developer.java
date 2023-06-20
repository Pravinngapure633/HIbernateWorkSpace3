package com.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Develpoer_Instance")
public class Developer extends Employee{

	private double salary;
	private String projectClient_Dev;
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getProjectClient_Dev() {
		return projectClient_Dev;
	}
	public void setProjectClient(String projectClient) {
		this.projectClient_Dev = projectClient;
	}
	
	
}
