package com.cjc.serviceimpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cjc.hibernateUtil.HibernateUtilDb;
import com.cjc.model.Account;
import com.cjc.service.RBI;

public class SBI implements RBI {

	Account ac = new Account();
	static Scanner sc = new Scanner(System.in);

	@Override
	public void createAccount() {
		System.out.println("Enter Account Holeder No :");
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
		System.out.println("Enter Email Id :");
		ac.setMailId(sc.next());
		System.out.println("Enter Account Holder Gender :");
		ac.setGender(sc.next());
		System.out.println("Enter Account UserId :");
		ac.setUserId(sc.next());
		System.out.println("Enter Account Password :");
		ac.setPassword(sc.next());
		SessionFactory sf = HibernateUtilDb.getSessionFactory();
		Session session = sf.openSession();
		session.save(ac);
		session.beginTransaction().commit();
		System.out.println("============================================");
	}

	@Override
	public void viewDetails() {
		SessionFactory sf = HibernateUtilDb.getSessionFactory();
		Session session = sf.openSession();
		System.out.println("Enter Account No :");
		Account ac = session.get(Account.class, sc.nextLong());
		System.out.println("Enter User Id");
		String userId = sc.next();
		System.out.println("Enter User Password :");
		String pass = sc.next();
		if (userId.equals(ac.getUserId()) && pass.equals(ac.getPassword())) 
		{
			System.out.println(ac.toString());
		} 
		else 
		{
			System.err.println("**********Please Insert Correct Id Password**********");
		}
	}

	@Override
	public void updateDetails() {
		Session session = HibernateUtilDb.getSessionFactory().openSession();
		System.out.println("Enter Account No :");
		Account ac = session.get(Account.class, sc.nextLong());
		System.out.println("Enter User Id");
		String userId = sc.next();
		System.out.println("Enter User Password :");
		String pass = sc.next();
		if (userId.equals(ac.getUserId()) && pass.equals(ac.getPassword())) 
		{
			boolean flag = true;
			while (flag) 
			{
				System.out.println("Enter 1 for Update Mobile No");
				System.out.println("Enter 2 for Update Address");
				System.out.println("Enter 3 for Update Password");
				System.out.println("Enter 4 for Update E-mail ID");
				System.out.println("Enter 5 for Exit Update");
				int ch = sc.nextInt();
				switch (ch) 
				{
				case 1:
					System.out.println("Enter Your New Mobile No");
					long newMobileNo = sc.nextLong();
					ac.setMobileNo(newMobileNo);
					System.out.println("Your Mobile No Updated");
					break;
				case 2:
					System.out.println("Enter Your New Address");
					String newAddress = sc.next();
					ac.setAddress(newAddress);
					System.out.println("Your Address Is Updated");
					break;
				case 3:
					System.out.println("Enter Your New Password");
					String newPassword = sc.next();
					ac.setPassword(newPassword);
					System.out.println("Your Password Is Updated");
					break;
				case 4:
					System.out.println("Enter Your New E-mail Id");
					String newmail = sc.next();
					ac.setMailId(newmail);
					System.out.println("Your E-mail Id Is Updated");
					break;
				case 5:
					System.out.println("Thank You For Banking");
					flag = false;
					break;
				default:
					System.err.println("!!!!!!!!!!!WRONG INPUT PROVIDED!!!!!!!!!!");

				}
			}
		}
		else 
		{
			System.err.println("**********Please Insert Correct Id Password**********");
		}
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(ac);
		tx.commit();
		System.out.println("**********Update Sucessfully**********");
	}

	@Override
	public void depositMoney() 
	{
		Session session = HibernateUtilDb.getSessionFactory().openSession();
		System.out.println("Enter Account No :");
		Account ac = session.get(Account.class, sc.nextLong());
		System.out.println("Enter User Id");
		String userId = sc.next();
		System.out.println("Enter User Password :");
		String pass = sc.next();
		if (userId.equals(ac.getUserId()) && pass.equals(ac.getPassword())) 
		{
			System.out.println("Enter Amount to Deposite :");
			long userAmount = sc.nextLong();
			if (userAmount >= 100) 
			{
				if(userAmount<=49999)
				{
					double newbalance = ac.getBalance() + userAmount;
					ac.setBalance(newbalance);
					System.out.println("Amount Deposite Succefully :" + userAmount);
					System.out.println("Available Balance Is :" + ac.getBalance());
					System.out.println("============================================");
				}
				else if(userAmount>=5000)
				{
					System.out.println("Enter Pan Card No:");
					String pan=sc.next();
					if(pan.equals(ac.getPanNo()))
					{
						double newbalance = ac.getBalance() + userAmount;
						ac.setBalance(newbalance);
						System.out.println("Amount Deposite Succefully :" + userAmount);
						System.out.println("Available Balance Is :" + ac.getBalance());
						System.out.println("============================================");
					}
					else {
						System.err.println("Please Enter Correct Pan No");
					}
					
					
					
				}
				
			}
				
			else 
			{
				System.err.println("Please Enter Amount Greater Than 100rs");
			}

		} 
		else 
		{
			System.err.println("**********Please Insert Correct Id Password**********");
		}
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(ac);
		tx.commit();
		System.out.println("***********Update Sucessfully************");
	}

	@Override
	public void withdrawlMoney() {
		Session session = HibernateUtilDb.getSessionFactory().openSession();
		System.out.println("Enter Account No :");
		Account ac = session.get(Account.class, sc.nextLong());
		System.out.println("Enter User Id");
		String userId = sc.next();
		System.out.println("Enter User Password :");
		String pass = sc.next();
		if (userId.equals(ac.getUserId()) && pass.equals(ac.getPassword())) {
			System.out.println("Enter Amount To Withdrawl :");
			long userAmount = sc.nextLong();
			if (userAmount >= 100) {
				if (userAmount <= ac.getBalance()) {
					double newBalance = ac.getBalance() - userAmount;
					ac.setBalance(newBalance);
					System.out.println("Amount Withdrawl Sucessfully" + userAmount);
					System.out.println("Available Balance Is :" + ac.getBalance());
					System.out.println("===========================================");
				} else {
					System.err.println("!!!!!!!!!!!Insfficient Balance!!!!!!!!!!!");
				}

			} else {
				System.err.println("Please Enter Amount Greater Than 100 Rs.");
			}

		} else {
			System.out.println("**********Please Insert Correct Id Password**********");
		}
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(ac);
		tx.commit();
		System.out.println("***********Update Sucessfully************");
	}

	@Override
	public void transferMoney() {
		Session session = HibernateUtilDb.getSessionFactory().openSession();
		System.out.println("Enter Account No :");
		Account ac1 = session.get(Account.class, sc.nextLong());
		System.out.println("Enter User Id");
		String userId = sc.next();
		System.out.println("Enter User Password :");
		String pass = sc.next();
	 	if (userId.equals(ac1.getUserId()) && pass.equals(ac1.getPassword())) {
			System.out.println("Enter Amount To transfer");
			long userAmount = sc.nextLong();
			double newBalance = ac1.getBalance() - userAmount;
				if (userAmount >= 100) 
				{
					Session session1 = HibernateUtilDb.getSessionFactory().openSession();
					System.out.println("Enter Account No To Transfer :");
					Account ac2 = session1.get(Account.class, sc.nextLong());
					double newBal = ac2.getBalance() + userAmount;
					ac2.setBalance(newBal);
					ac1.setBalance(newBalance);
					Transaction tx = session1.beginTransaction();
					session1.saveOrUpdate(ac2);
					tx.commit();
					System.out.println("***********Transfer Sucessfully************");

				}
				else 
				{
					System.err.println("*****Please Enter Amount Greather Than 100*****");
				}
	 			}	
	 	else 
	 		{
	 			System.err.println("*****Please Enter Correct Id And Pass*****");
	 		}

		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(ac1);
		tx.commit();
		// System.out.println("***********Update Sucessfully************");

	}

	@Override
	public void checkBalance() {
		SessionFactory sf = HibernateUtilDb.getSessionFactory();
		Session session = sf.openSession();
		System.out.println("Enter Account No :");
		Account ac = session.get(Account.class, sc.nextLong());
		System.out.println("Enter User Id");
		String userId = sc.next();
		System.out.println("Enter User Password :");
		String pass = sc.next();
		if (userId.equals(ac.getUserId()) && pass.equals(ac.getPassword())) {
			System.out.println("Your Balance Is :" + ac.getBalance());
			System.out.println("=========================================");
		} else {
			System.err.println("**********Please Insert Correct Id Password**********");
		}
	}

	public static void deleteAccount() {
		Session session = HibernateUtilDb.getSessionFactory().openSession();
		System.out.println("Enter Account No :");
		Account ac = session.get(Account.class, sc.nextLong());
		System.out.println("Enter User Id");
		String userId = sc.next();
		System.out.println("Enter User Password :");
		String pass = sc.next();
		if (userId.equals(ac.getUserId()) && pass.equals(ac.getPassword())) {
			Transaction tx = session.beginTransaction();
			session.delete(ac);
			tx.commit();
			System.out.println("Your Account Will Be Deleted");
		} else {
			System.err.println("**********Please Insert Correct Id Password**********");
		}
	}

}
