package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class User_Details {

	@Id
	@GeneratedValue
	private int id;
	private String firstName;

	private String lastName;

	@OneToOne(cascade = { CascadeType.ALL }, mappedBy = "user")
	private Contact_Info contact;

	public Contact_Info getContact() {
		return contact;
	}

	public void setContact(Contact_Info contact) {
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
