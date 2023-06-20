package com.model;

public class Account {

	private String userId;
	private String password;
	private long acNo;
	private String acName;
	private String address;
	private long mobileNo;
	private long adharNo;
	private String panNo;
	private double balance;
	private String gender;

	
	public double getAcNo() {
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
		return "Account holder Account No :" + acNo + "\nAccount holder Address :" + address
				+ "\nAccount holder Mobileno :" + mobileNo + "\nAccount holder Adhar No :" + adharNo
				+ "\nAccount holder Pan No :" + panNo + "\nAccount holder Balance :" + balance + "\nAccount holder Gender :"
				+ gender+"\nAccount holder userId :" + userId + "\nAccount holder Password :" + password;
	}
}
