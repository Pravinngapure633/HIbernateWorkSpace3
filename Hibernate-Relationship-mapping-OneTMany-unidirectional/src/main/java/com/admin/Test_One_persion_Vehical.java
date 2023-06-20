package com.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.dbutil.HibernateUtil2;
import com.model.unidirectional.One_Persion;
import com.model.unidirectional.Vehicale;

public class Test_One_persion_Vehical {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Session session = HibernateUtil2.getSessionFactory().openSession();
		
		
	}

	public static void getAll(Session session) {
		Query query = session.createSQLQuery("select * from  One_persion").addEntity(One_Persion.class);
		
		List<One_Persion> list = query.getResultList();
		
		for (One_Persion p: list) {
			System.out.println(p);
		}
	}

	public static void getSingeData(Scanner sc, Session session) {
		System.out.println("Enter persion name to get vehicale imformtation");
		One_Persion persion = session.get(One_Persion.class, sc.next()+sc.nextLine());
		System.out.println(persion);
	}

	public static void saveData(Session session) {
		Vehicale v1=new Vehicale(78, "Apachi", 12000, "Black");
		Vehicale v2=new Vehicale(45, "Pulser", 15000, "Blue");
		Vehicale v3=new Vehicale(12, "Activa", 10000, "White");
		Vehicale v4=new Vehicale(89, "Jupitae", 11000, "Gray");
		Vehicale v5=new Vehicale(56, "R15", 22000, "Red");
		
		List<Vehicale> l1=new ArrayList<Vehicale>();
		l1.add(v1);
		l1.add(v2);
		l1.add(v3);
		List<Vehicale> l2=new ArrayList<Vehicale>();
		l2.add(v4);
		l2.add(v5);
		
		One_Persion o1=new One_Persion("Pravin Nagpure", 9404305718l, "Nagpur", l1);
		
		One_Persion o2=new One_Persion("Vishal Bhakare", 8545966556l, "Pune", l2);
		
		session.save(o1);
		session.save(o2);
		session.beginTransaction().commit();
	}

}
