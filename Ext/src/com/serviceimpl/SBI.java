package com.serviceimpl;

import java.util.Scanner;

import com.model.Account;
import com.service.RBI;

public class SBI implements RBI {

	Account ac = new Account();

	Scanner sc = new Scanner(System.in);
	

	@Override
	public void createAccount() {

		System.out.println("Enter Account Holder No :");
		ac.setAcNo(sc.nextLong());

		System.out.println("Enter Account Holder Name :");
		ac.setAcName(sc.next() + sc.nextLine());

		System.out.println("Enter Accound Holder Address :");
		ac.setAddress(sc.next() + sc.nextLine());

		System.out.println("Enter Account Holder MobileNo : ");
		ac.setMobileNo(sc.nextLong());

		System.out.println("Enter Account Holder AdharNo :");
		ac.setAdharNo(sc.nextLong());

		System.out.println("Enter Account Holder PanNo :");
		ac.setPanNo(sc.next());

		System.out.println("Enter Account Holder Balance :");
		ac.setBalance(sc.nextDouble());

		System.out.println("Enter Account Holder Gender :");
		ac.setGender(sc.next());
		
		System.out.println("Enter For Create ID");
		ac.setUserId(sc.next());
		
		System.out.println("Enter For Password");
		ac.setPassword(sc.next());
		

		

		System.out.println("============================================");
	}


	@Override
	public void viewDetails() {
		System.out.println("Enter User ID");
		String uid = sc.next();
		System.out.println("Enter User Password");
		String pass = sc.next();
		
	if(uid.equals(ac.getUserId()) && pass.equals(ac.getPassword())){
			System.out.println(ac.toString());
//			ac.getAcNo();
//			ac.getAcName();
//			ac.getAddress();
//			ac.getMobileNo();
//			ac.getAdharNo();
//			ac.getPanNo();
//			ac.getBalance();
//			ac.getGender();
//			ac.getUserId();
//			ac.getPassword();
		} else {
			System.out.println("Wrong Id and Pass");
		}
		System.out.println("============================================");
	}

	@Override
	public void updateDetails() 
	{
		System.out.println("Enter User ID");
		String uid = sc.next();
		System.out.println("Enter User Password");
		String pass = sc.next();
		boolean flag=true;
	if(uid.equals(ac.getUserId()) && pass.equals(ac.getPassword()))
		{
		while(flag) 
		{
		System.out.println("Enter 1 for Update Mobile No");
		System.out.println("Enter 2 for Update Address");
		System.out.println("Enter 3 for Exit Update ");
		
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1: System.out.println("Enter your new mobile no");
				long newmobno=sc.nextLong();
				ac.setMobileNo(newmobno);
				System.out.println("Your Profile will be Updated");
			break;
			
		case 2: System.out.println("Enter your new Address");
				String newAddress=sc.next()+sc.nextLine();
				ac.setAddress(newAddress);
				System.out.println("Your Profile will be Updated");
				
			break;
				
		case 3:
				flag=false;
				System.out.println("Thank you for banking");
				break;
				
			default: System.out.println("Wrong input Provided");
					
		}
		}}
		else
		{
			System.out.println("Wrong id pass");
		}	
	}

	@Override
	public void depositeMoney() 
	{
		System.out.println("Enter User ID");
		String uid = sc.next();
		System.out.println("Enter User Password");
		String pass = sc.next();
		
	if(uid.equals(ac.getUserId()) && pass.equals(ac.getPassword()))
		{
			System.out.println("Enter Amount to deposite :");
			int useramount=sc.nextInt();
		
			if(useramount >=100)
			{
			double newbalance=ac.getBalance()+useramount;
			ac.setBalance(newbalance);
			System.out.println("Amount Deoposite Successfully : "+useramount);
			System.out.println("Available Balance Is :"+ac.getBalance());
			}
			else
			{
				System.out.println("Please Enter Amount Greater Than 100 Rs.");
			}
		
		System.out.println("============================================");
		}
		
	}

	@Override
	public void withdrawlMoney() {
		System.out.println("Enter Amount to Withdrawl");

		int useramount = sc.nextInt();
		if (useramount >= 100) {
			if (useramount <= ac.getBalance()) {
				double newbalance = ac.getBalance() - useramount;
				ac.setBalance(newbalance);
				System.out.println("Amount Withdrawl Sucessfully  " + useramount);
				System.out.println("Available Balance Is :" + ac.getBalance());
			} else {
				System.out.println("!!!!!!!!!!Your Have Insfficient Fund!!!!!!!!!!" + ac.getBalance());
			}
		} else {
			System.out.println("Please Enter Amount Greater than 100 Rs.");
		}

		System.out.println("============================================");
	}

	@Override
	public void checkBalance() {
		System.out.println("Your Balance Is :" + ac.getBalance());
		System.out.println("============================================");
	}

	
	

}
