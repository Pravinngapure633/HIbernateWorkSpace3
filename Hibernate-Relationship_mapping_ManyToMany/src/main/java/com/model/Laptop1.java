package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Laptop1 {

		@Id
		private int lid;
		private String lname;
		private double price;
		@ManyToMany
		private Set<Employee1> emp=new HashSet<Employee1>();
		public int getLid() {
			return lid;
		}
		public void setLid(int lid) {
			this.lid = lid;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public Set<Employee1> getEmp() {
			return emp;
		}
		public void setEmp(Set<Employee1> emp) {
			this.emp = emp;
		}
		
		
}
