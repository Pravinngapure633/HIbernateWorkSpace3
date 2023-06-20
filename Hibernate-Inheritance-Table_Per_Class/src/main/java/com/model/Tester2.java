package com.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Tester_Instance")
public class Tester2 extends Employee2 {

		private double salary;
		private String projectClient_Tes;
		
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public String getProjectClient_Tes() {
			return projectClient_Tes;
		}
		public void setProjectClient(String projectClient) {
			this.projectClient_Tes = projectClient;
		}
		
		
	
}
