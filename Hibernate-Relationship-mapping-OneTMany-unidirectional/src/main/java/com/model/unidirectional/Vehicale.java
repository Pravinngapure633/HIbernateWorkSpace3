package com.model.unidirectional;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicale {

	@Id
	private int id;
	private String vname;
	private double price;
	private String color;
	public Vehicale() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicale(int id, String vname, double price, String color) {
		super();
		this.id = id;
		this.vname = vname;
		this.price = price;
		this.color = color;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Vehicale [id=" + id + ", vname=" + vname + ", price=" + price + ", color=" + color + "]";
	}
	
	
}
