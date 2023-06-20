package com.admin;

import java.util.Scanner;

import com.service.EmployeeSr;
import com.serviceimpl.Employeeimpl;

public class EmployeeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeSr emp = new Employeeimpl();
		boolean flag = true;
		while (flag) {
			System.out.println("Enter 1 For Add Student Information");
			System.out.println("Enter 2 For GetSingle Information From Student");
			System.out.println("Enter 3 For GetAll Information From Student");
			System.out.println("Enter 4 For Update Information From Student");
			System.out.println("Enter 5 For DeleteSingle Information From Student");
			System.out.println("Enter 6 For DeleteAll Information From Student");
			System.out.println("Enter 7 For Insert Student Data");
			System.out.println("Enter 8 For Exit Application");

			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				emp.addData();
				break;
			case 2:
				emp.getSingleData();
				break;
			case 3:
				emp.getAllData();
				break;
			case 4:
				emp.updateData();
				break;
			case 5:
				emp.deleteSingleData();
				break;
			case 6:
				emp.deleteAlldata();
				break;

			case 7:
				emp.insertData();

				break;

			case 8:
				System.out.println("Thank You");
				flag = false;
				break;
			default:
				System.err.println("Please Enter Valid O/P");
				break;
			}
		}
	}

}
