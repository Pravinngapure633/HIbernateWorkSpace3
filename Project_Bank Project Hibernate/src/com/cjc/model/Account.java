package com.cjc.model;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
@Entity
@DynamicUpdate
//@Table(name="ACCOUNT_DETAIL'S")
public class Account {
	
	@Column(unique = true)
	private String userId;
	//@Column(name ="User Password")
	private String password;
	@Column(unique = true)
	@Id
	private long acNo;
	//@Column(name ="Name")
	private String acName;
	//@Column(name ="Address")
	private String address;
	//@Column(name ="Mobile")
	private long mobileNo;
	@Column(unique = true)
	private long adharNo;
	@Column(unique = true)
	private String panNo;
	//@Column(name ="Balance")
	private double balance;
	//@Column(name ="Gender")
	private String gender;
	//@Column(name ="E-mail ID")
	private String emailId;
	
	public String getMailId() {
		return emailId;
	}
	public void setMailId(String emailId) {
		this.emailId = emailId;
	}
	public long getAcNo() {
		return acNo;
	}
	public void setAcNo(long acNo) {
		this.acNo = acNo;
	}
	public String getAcName() {
		return acName;
	}
	public void setAcName(String acName) {
		this.acName = acName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public long getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "*****Account Detail's*****"
				+"\nAccount holder Account No  :" + acNo 
				+"\nAccount Holder Name        :"+acName
				+"\nAccount holder Address     :" + address
				+"\nAccount holder Mobileno    :" + mobileNo 
				+"\nAccount holder Adhar No    :" + adharNo
				+"\nAccount holder Pan No      :" + panNo 
				+"\nAccount Holder Email Id    :"+ emailId
				+"\nAccount holder Balance     :" + balance 
				+"\nAccount holder Gender      :"+ gender
				+"\nAccount holder userId      :" + userId 
				+"\nAccount holder Password    :" + password;
	}
	
	

}
