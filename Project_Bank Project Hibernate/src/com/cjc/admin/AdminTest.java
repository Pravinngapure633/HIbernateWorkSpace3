package com.cjc.admin;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cjc.hibernateUtil.HibernateUtilDb;
import com.cjc.model.Account;
import com.cjc.service.RBI;
import com.cjc.serviceimpl.SBI;

public class AdminTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		RBI rbi = new SBI();

		boolean f = true;
		while (f) {
			System.out.println("Enter 1 For LogIn\nEnter 2 For SignUp\nEnter 3 For Exit App");

			int choise = sc.nextInt();
			switch (choise) {
			case 1:
				SessionFactory sf = HibernateUtilDb.getSessionFactory();
				Session session = sf.openSession();
				System.out.println("Enter Account No");
				long acno = sc.nextLong();
				Account ac = session.get(Account.class, acno);
				long acNo2 = ac.getAcNo();
				if(acno==acNo2)
				{
					System.out.println("Enter User Id");
					String userId = sc.next();
					System.out.println("Enter Password");
					String pass = sc.next();
					if (userId.equals(ac.getUserId()) && pass.equals(ac.getPassword())) 
					{
						boolean flag = true;
							while (flag)
							{
								System.out.println("**********Welcome To The SBI Bank Application**********");
								System.out.println("Enter 1 for View Details");
								System.out.println("Enter 2 For Update Details");
								System.out.println("Enter 3 For Deposite Money");
								System.out.println("Enter 4 For Withdrawl Money");
								System.out.println("Enter 5 For Check Balance");
								System.out.println("Enter 6 For Transfer Money");
								System.out.println("Enter 7 For Delete Account");
								System.out.println("Enter 8 For Home Page");
								System.out.println("*******************************************************");
								int ch = sc.nextInt();
								switch (ch) 
								{
									case 1:
										rbi.viewDetails();
									break;
									case 2:
										rbi.updateDetails();
									break;
									case 3:
										rbi.depositMoney();
									break;
									case 4:
										rbi.withdrawlMoney();
									break;
									case 5:
										rbi.checkBalance();
									break;
									case 6: 
										rbi.transferMoney();
									break;
									case 7:
										SBI.deleteAccount();
										break;
									case 8:
										System.err.println("**********THANK YOU FOR BANKING WITH US***********");
										flag = false;
										break;
									default:
										System.out.println("!!!!!!!!!!!WRONG INPUT PROVIDED!!!!!!!!!!");
										break;
								}
							}
						}
						else
						{
							System.err.println("**********Please Insert Correct Id Password**********");
						}
				}
				else
				{
					System.out.println("Account No Is Wrong");
				}
				

				break;

			case 2:
				System.out.println("Welcome To SBI Bank");
				rbi.createAccount();

				break;
			case 3:
				System.out.println("Thank You For Banking Us");
				System.exit(0);

				break;

			default:
				System.err.println("!!!!!!!!!!!WRONG INPUT PROVIDED!!!!!!!!!!");
				break;
			}

		}

	}

}
