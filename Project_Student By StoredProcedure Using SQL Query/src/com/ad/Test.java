package com.ad;

import java.util.Scanner;

import com.ser.StudentService;
import com.serimpl.StudentImpl;

public class Test {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		StudentService stu=new StudentImpl();
		
		
		boolean flag=true;
		
		while(flag)
		{
			System.out.println("*********Welcome To Student Application*********");
			System.out.println("Enter 1 For Insert Student Information");
			System.out.println("Enter 2 For Get Student Single Data");
			System.out.println("Enter 3 For Get Student All Data");
			System.out.println("Enter 4 For Update Student Information");
			System.out.println("Enter 5 For Delete Student Information");
			System.out.println("Enter 6 For Delete Student All Information");
			System.out.println("Enter 7 For Exit Student Application");
			
			int ch=sc.nextInt();
			switch (ch) {
			case 1:
					stu.insertData();
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
					stu.deleteAllData();
				break;
			case 7:
					System.out.println("**********Thank You**********");
					flag=false;
				break;
			default:
				System.err.println("***********Please Correct OutPut**********");
				break;
			}
			
		}
	}

	}


