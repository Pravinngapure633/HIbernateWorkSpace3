package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicale1 {

	@Id
	private int regno;
	private String vname;
	private double price;
	private String color;
	@ManyToOne(cascade = CascadeType.ALL)
	private One_Persion1 persion;
	public Vehicale1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicale1(int regno, String vname, double price, String color, One_Persion1 persion) {
		super();
		this.regno = regno;
		this.vname = vname;
		this.price = price;
		this.color = color;
		this.persion = persion;
	}
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public One_Persion1 getPersion() {
		return persion;
	}
	public void setPersion(One_Persion1 persion) {
		this.persion = persion;
	}
	@Override
	public String toString() {
		return "Vehicale1 [regno=" + regno + ", vname=" + vname + ", price=" + price + ", color=" + color + ", persion="
				+ persion + "]";
	}
	
	
	
	
	
	
}
