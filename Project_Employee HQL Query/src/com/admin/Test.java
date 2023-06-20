package com.admin;

import java.util.Scanner;

import com.serviceimpl.EmployeeImpl;
import com.sevice.Employeeservice;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Employeeservice emp = new EmployeeImpl();

		boolean flag = true;
		while (flag) {
			System.out.println("Enter 1 For Add Employee Information");
			System.out.println("Enter 2 For Get Single Employee Information");
			System.out.println("Enter 3 For Get All Employee Information");
			System.out.println("Enter 4 For Update Employee Information");
			System.out.println("Enter 5 For Delete Single Employee Information");
			System.out.println("Enter 6 For Delete All Employee Information");
			System.out.println("Enter 7 For Exit Employee Application");

			int ch = sc.nextInt();
			switch (ch) {
			case 1:
					emp.addEmployeeInfo();
				break;
			case 2:
					emp.getSingleEmployeeInfo();
				break;
			case 3:
					emp.getAllEmployeeInfo();
				break;
			case 4:
					emp.updateEmployeeInfo();
				break;
			case 5:
					emp.delteSingleEmoployeeInfo();
				break;
			case 6:
					emp.delteAllemplyeeInfo();
				break;
			case 7:
					System.out.println("******Thank You*******");
					System.exit(0);
				break;

			default:
					System.err.println("Enter Correct O/P");
				break;
			}
		}
	}
}
