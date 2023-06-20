package com.admin;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.dbutil.HibernateUtil2;
import com.model.Passport;
import com.model.Persion;

public class Test_Persion_Passport {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Session session = HibernateUtil2.getSessionFactory().openSession();
		
		savedData(session);
	}

	//2 ni side ni kru shakto
	public static void getAll(Session session) {
		Query query = session.createSQLQuery("select * from Persion").addEntity(Persion.class);
		List<Persion> list = query.getResultList();
		for (Persion per : list) {
			System.out.println(per.getName());
			System.out.println(per.getMobileno());
			System.out.println(per.getPass().getFullname());
			System.out.println(per.getPass().getAddr());
			System.out.println(per.getPass().getBloodgroup());
				
		}
	}

	// 2 ni side ni kru shakto
	public static void getSingleData(Scanner sc, Session session) {
		System.out.println("Enter Name to get Information");
		Persion per = session.get(Persion.class, sc.next());
		System.out.println(per.getName());
		System.out.println(per.getMobileno());
		System.out.println(per.getPass().getFullname());
		System.out.println(per.getPass().getAddr());
		System.out.println(per.getPass().getBloodgroup());
	}
	

	public static void savedData(Session session) {
		Persion p1=new Persion();
		p1.setName("Virat");
		p1.setMobileno(9404305718l);
		
		Persion p2=new Persion();
		p2.setName("Rohit");
		p2.setMobileno(7074305718l);
		
		Persion p3=new Persion();
		p3.setName("Ms");
		p3.setMobileno(80305718l);
		
		
		Passport pas1=new Passport();
		pas1.setId(201);
		pas1.setFullname("Virath kohli");
		pas1.setBloodgroup("O+");
		pas1.setAddr("Mumbai");
		
		Passport pas2=new Passport();
		pas2.setId(202);
		pas2.setFullname("Rohit Sharama");
		pas2.setBloodgroup("OB+");
		pas2.setAddr("Nagpur");
		
		Passport pas3=new Passport();
		pas3.setId(203);
		pas3.setFullname("Ms Dhodni");
		pas3.setBloodgroup("B+");
		pas3.setAddr("Chenai");
		
		p1.setPass(pas1);
		p2.setPass(pas2);
		p3.setPass(pas3);
		pas1.setPer(p1);
		pas1.setPer(p2);
		pas1.setPer(p3);
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		
		session.beginTransaction().commit();
		System.out.println("Done");
	}

}
