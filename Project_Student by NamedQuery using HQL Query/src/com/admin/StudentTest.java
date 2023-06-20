package com.admin;

import java.util.Scanner;

import com.service.StudentSr;
import com.serviceimpl.Studentimpl;

public class StudentTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentSr stu = new Studentimpl();

		boolean flag = true;
		while (flag) {
			System.out.println("Enter 1 For Add Student Information");
			System.out.println("Enter 2 For GetSingle Information From Student");
			System.out.println("Enter 3 For GetAll Information From Student");
			System.out.println("Enter 4 For Update Information From Student");
			System.out.println("Enter 5 For DeleteSingle Information From Student");
			System.out.println("Enter 6 For DeleteAll Information From Student");
			System.out.println("Enter 7 For Exit From Application");

			int ch = sc.nextInt();
			switch (ch) {
			case 1:
					stu.addData();
				break;
			case 2:
					stu.getSingleData();
				break;
			case 3:
					stu.getAllData();
				break;
			case 4:
					stu.updateData();
				break;
			case 5:
					stu.deleteSingleData();
				break;
			case 6:
					stu.deleteAAlldata();
				break;

			case 7:
					System.out.println("Thank You");
					System.exit(0);
				break;

			default:
				System.err.println("Please Enter Valid O/P");
				break;
			}
		}
	}

}
