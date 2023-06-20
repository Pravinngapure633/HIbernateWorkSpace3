package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

public class Contact_Info {
	
	@Id

	@SequenceGenerator(name = "id", sequenceName = "seq",initialValue = 500,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id")
	private int id;
		
	private String emailId;
	private String phoneNo;
		
		
		
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private User_Details user;


	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public User_Details getUser() 
	{
		return user;
	}

	public void setUser(User_Details user) 
	{
		this.user = user;
	}
		
		
	public String getEmailId() 
	{
		return emailId;
	}

	public void setEmailId(String emailId) 
	{
		this.emailId = emailId;
	}
		
	public String getPhoneNo() 
	{
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) 
	{
		this.phoneNo = phoneNo;
	}

}
