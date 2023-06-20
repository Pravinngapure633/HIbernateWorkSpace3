package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "Product_Info")
public class Product {
	
	@Id
	@Column(name = "Product_Id")
	private int pid;
	@Column(name = "Product_Name")
	private String pname;
	@Column(name = "Product_Color")
	private String pcolor;
	@Column(name = "Product_Price")
	private double price;
	@Column(name = "Product_Brand")
	private String pbrand;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int pid, String pname, String pcolor, double price, String pbrand) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcolor = pcolor;
		this.price = price;
		this.pbrand = pbrand;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcolor() {
		return pcolor;
	}

	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPbrand() {
		return pbrand;
	}

	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pcolor=" + pcolor + ", price=" + price + ", pbrand="
				+ pbrand + "]";
	}
	
	
	
	

}
