package com.admin;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.dbutil.HibernateUtil2;
import com.model.unidirectional.Passport;
import com.model.unidirectional.Persion;

public class Test_Persion_Passport {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Session session = HibernateUtil2.getSessionFactory().openSession();
		
		getAllData(session);
	}

	public static void getAllData(Session session) {
		Query query = session.createSQLQuery("select * from Persion").addEntity(Persion.class);
		List<Persion> l = query.getResultList();
		for (Persion persion : l) {
			System.out.println(persion);
		}
	}

	public static void getSingleData(Scanner sc, Session session) {
		System.out.println("Enter Name to Get Information");
		Persion persion = session.get(Persion.class, sc.next());
		System.out.println(persion);
		
		System.out.println("Enter passport Id to get infromation");
		Passport passport = session.get(Passport.class, sc.nextInt());
		System.out.println(passport);
	}

	public static void savedData(Session session) {
		Passport pss1=new Passport(101, "Pravin Nagpure", "O+", "Bhandara");
		Passport pss2=new Passport(102, "Vishal koma", "B+", "Talodi");
		Passport pss3=new Passport(103, "Saurabh Nimje", "A+", "Nagpur");
		
		
		Persion p1=new Persion("Pravin", 9404305718l,pss1 );
		Persion p2=new Persion("Vishal", 707005718l,pss2);
		Persion p3=new Persion("Saurabh", 80804305718l,pss3 );
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		
		session.beginTransaction().commit();
		System.out.println("Done");
	}

}
