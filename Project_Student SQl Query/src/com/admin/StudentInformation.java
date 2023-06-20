package com.admin;

import java.util.Scanner;

import com.service.StudentService;
import com.serviceimpl.StudentImpl;

public class StudentInformation {
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		StudentService ss=new StudentImpl();
		
		boolean flag=true;
		
		while(flag)
		{
			System.out.println("*********Welcome To Student Application*********");
			System.out.println("Enter 1 For Add Student Information");
			System.out.println("Enter 2 For Get Student Single Data");
			System.out.println("Enter 3 For Get Student All Data");
			System.out.println("Enter 4 For Update Student Information");
			System.out.println("Enter 5 For Delete Student Information");
			System.out.println("Enter 6 For Delete Student All Information");
			System.out.println("Enter 7 For Exit Student Application");
			
			int ch=sc.nextInt();
			switch (ch) {
			case 1:
					ss.addStudentInfo();
				break;
			case 2:
					ss.getSingleStudentInfo();
				break;
			case 3:
					ss.getAllStudentInfo();
				break;
			case 4:
					ss.udateStudentInfo();
				break;
			case 5:
					ss.deleteStudentInfo();
				break;
			case 6:
					ss.deleteAllStudentInfo();
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
