package com.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Employee{
	
	@EmbeddedId
	private EmployeeId empId;
	private String empName;
	
	public EmployeeId getEmpId() {
		return empId;
	}
	public void setEmpId(EmployeeId empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
	
	

}
