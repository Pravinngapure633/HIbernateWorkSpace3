package com.admin;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.dbutil.HibernateUtil;
import com.model.unidirectional.Department;
import com.model.unidirectional.Faculty;


public class Test {
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		getSingle(session, sc);
		
		
		
	
	}

	public static void updateData(Scanner sc, Session session) {
		Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery("update faculty set name=:nm where fid=:id").addEntity(Faculty.class);
		System.out.println("Enter Fid to update data");
		query.setInteger("id", sc.nextInt());
		System.out.println("Enter new Name");
		query.setString("nm", sc.next());
		
		query.executeUpdate();
		tx.commit();
		System.out.println("Done");
	}

	public static void getAll(Session session) {
		Query query = session.createSQLQuery("select * from department").addEntity(Department.class);
		
		List<Department> list = query.getResultList();
		for (Department department : list) {
			System.out.println(department);//or getter 
		}
	}

	public static void getSingle(Session session,Scanner sc) {
		System.out.println("Enter ID");
		Department department = session.get(Department.class, sc.nextInt());
		System.out.println(department);
	}

	public static void savedData(Session session) {
		Department d1=new Department();
		d1.setId(1);
		d1.setName("IT");
		
		Department d2=new Department();
		d2.setId(2);
		d2.setName("MECH");
		
		
		Faculty f1=new Faculty();
		f1.setFid(101);
		f1.setName("Saurabh");
		f1.setAddr("Pune");
		
		Faculty f2=new Faculty();
		f2.setFid(102);
		f2.setName("Virat");
		f2.setAddr("Napur");
		
		Faculty f3=new Faculty();
		f3.setFid(103);
		f3.setName("Rohit");
		f3.setAddr("Napur");
		
		Faculty f4=new Faculty();
		f4.setFid(104);
		f4.setName("Dhoni");
		f4.setAddr("mumbai");
			
		List<Faculty> l1=new ArrayList<Faculty>();
		l1.add(f1);
		l1.add(f2);
	
		List<Faculty> l2=new ArrayList<Faculty>();
		l2.add(f3);
		l2.add(f4);
	
		d1.setFa(l1);
		d2.setFa(l2);
		
		
		session.save(d1);
		session.save(d2);
		session.save(f1);
		session.save(f2);
		session.save(f3);
		session.save(f4);
		
		
		session.beginTransaction().commit();
		System.out.println("Done");
	}

}
