package com.admin;

import java.util.Scanner;

import org.hibernate.Session;

import com.dbutil.HibernateUtil2;
import com.model.One_Persion1;
import com.model.Vehicale1;

public class Test_Vech_One {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Session session = HibernateUtil2.getSessionFactory().openSession();
		
		
	}

	public static void getSingleData(Scanner sc, Session session) {
		System.out.println("Enter Vehical reg no");
		Vehicale1 ve = session.get(Vehicale1.class, sc.nextInt());
		System.out.println(ve);
	}

	public static void savedData(Session session) {
		One_Persion1 o1=new One_Persion1("Pravin", 940545445, "Nagpur");
		One_Persion1 o2=new One_Persion1("Vishal", 88845445, "Pune");
		
		Vehicale1 v1=new Vehicale1(101, "Apachi", 18000, "White", o1);
		Vehicale1 v2=new Vehicale1(102, "Pulser", 16000, "Red", o2);
		Vehicale1 v3=new Vehicale1(103, "Activa", 1000, "Gray", o2);
		Vehicale1 v4=new Vehicale1(104, "Nexon", 1500000, "White", o1);
		Vehicale1 v5=new Vehicale1(105, "R15", 12000, "Blue", o2);
		
		
		session.save(v1);
		session.save(v2);
		session.save(v3);
		session.save(v4);
		session.save(v5);
		
		session.beginTransaction().commit();
		System.out.println("Done");
	}

}
