package com.admin;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.dbutil.HibernateUtil;
import com.model.Addharcard;
import com.model.Student;


public class Test {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		saveData(session);
		
	}

	public static void updateData(Scanner sc, Session session) {
		Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery("update Student set name=? where rollno=?").addEntity(Student.class);
		System.out.println("Enter New Name");
		query.setString(0, sc.next());
		System.out.println("Enter Roll no");
		query.setInteger(1, sc.nextInt());
		
		query.executeUpdate();
		tx.commit();
		System.out.println("Done");
	}

	public static void getAllData(Session session) {
		Query query = session.createSQLQuery("select * from Student").addEntity(Student.class);
		List<Student> list = query.getResultList();
		for (Student stu : list) {
			//or get method
			System.out.println(stu);
		}
	}

	public static void getSingleDatafromAdharacard(Scanner sc, Session session) {
		System.out.println("Enter Adhr No");
		Addharcard ad = session.get(Addharcard.class, sc.nextLong());
		System.out.println(ad.getAdharno());
		System.out.println(ad.getAddress());
		System.out.println(ad.getGeder());
		System.out.println(ad.getStu().getRollno());
		System.out.println(ad.getStu().getName());
		
		session.beginTransaction().commit();
	}

	public static void getSingleDataFromStudent(Scanner sc, Session session) {
		System.out.println("Enter Rollno");
		Student stu = session.get(Student.class, sc.nextInt());
		System.out.println(stu.getRollno());
		System.out.println(stu.getName());
			Addharcard addr = stu.getAddr();
		System.out.println(addr.getAdharno());
		System.out.println(addr.getAddress());
		System.out.println(addr.getGeder());
		
		session.beginTransaction().commit();
	}

	public static void saveData(Session session) {
		Student stu1=new Student();
		stu1.setRollno(1);
		stu1.setName("Rohit");
		
		Student stu2=new Student();
		stu2.setRollno(2);
		stu2.setName("Virat");
		
		Addharcard ad1=new Addharcard();
		ad1.setAdharno(123);
		ad1.setAddress("pune");
		ad1.setGeder("Male");
		
		Addharcard ad2=new Addharcard();
		ad2.setAdharno(456);
		ad2.setAddress("Mumbai");
		ad2.setGeder("Male");
		
		stu1.setAddr(ad1);
		stu2.setAddr(ad2);
		ad1.setStu(stu1);
		ad2.setStu(stu2);
		
	
		session.save(stu1);
		session.save(stu2);
		
		session.beginTransaction().commit();
		System.out.println("Done");
	}

}
