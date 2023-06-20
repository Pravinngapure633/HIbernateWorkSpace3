package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "PRODUCT_INFORMATION")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private int productId;
	@Column(name = "PRODUCT_NAME")
	private String prouductName;
	@Column(name = "PRODUCT_PRICE")
	private double price;
	@Column(name = "PRODUCT_COLOUR")
	private String colour;
	@Column(name = "PRODUCT_BRAND")
	private String brand;
	
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProuductName() {
		return prouductName;
	}
	public void setProuductName(String prouductName) {
		this.prouductName = prouductName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Product Id :" + productId + "\n Prouduct Name :" + prouductName + "\nProduct Price :" + price + "\nProduct Colour :"
				+ colour + "\nProduct Brand :" + brand;
	}
	
	
	

}
