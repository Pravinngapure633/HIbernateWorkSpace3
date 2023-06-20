  package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name="getSingleData",query = "select * from Employee where empId=?",resultClass = Employee.class),
	@NamedNativeQuery(name="getAllData",query = "select * from Employee",resultClass = Employee.class),
	@NamedNativeQuery(name = "updateData",query = "update  Employee set empName=?,empSalary=? where empId=?",resultClass = Employee.class),
	@NamedNativeQuery(name = "deleteSingle",query = "delete from Employee where empId=:id",resultClass = Employee.class),
	@NamedNativeQuery(name = "deleteAll",query = "delete from Employee ",resultClass = Employee.class),
	@NamedNativeQuery(name = "insertData",query = "insert into Employee(empId,empName,empSalary) values (?,?,?)", resultClass = Employee.class)
	
})
public class Employee {
	
	@Id
	private int empId;
	private String empName;
	private double empSalary;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String empName, double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}
	
	
	

}
