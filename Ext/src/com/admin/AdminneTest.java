package com.admin;

import java.util.Scanner;

import com.model.Account;
import com.service.RBI;
import com.serviceimpl.SBI;

public class AdminneTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		

		RBI rbi = new SBI();

		boolean flag = true;

		

			while (flag) 
			{
				System.out.println("**********Welcome To The SBI Bank Application**********");
				System.out.println("Enter 1 For Create Account");
				System.out.println("Enter 2 for View Details");
				System.out.println("Enter 3 For Update Details");
				System.out.println("Enter 4 For Deposite Money");
				System.out.println("Enter 5 For Withdrawl Money");
				System.out.println("Enter 6 For Check Balance");
				System.out.println("Enter 7 For Exit Application");
				System.out.println("*******************************************************");
				int ch = sc.nextInt();
				switch (ch) {
				
				case 1:
					rbi.createAccount();
					break;
				case 2:
					rbi.viewDetails();
					break;
				case 3:
					rbi.updateDetails();
					break;
				case 4:
					rbi.depositeMoney();
					break;
				case 5:
					rbi.withdrawlMoney();
					break;
				case 6:
					rbi.checkBalance();
					break;
				case 7:
					System.err.println("**********THANK YOU FOR BANKING WITH US***********");
					flag = false;
					break;
				default:
					System.out.println("!!!!!!!!!!!WRONG INPUT PROVIDED!!!!!!!!!!");
				}

			}

		}
}
