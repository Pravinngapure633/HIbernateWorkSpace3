package com.admin;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dbutil.HibernateUtil;
import com.model.Subjectt;
import com.model.Teacher;

public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.createSQLQuery("select * from subjectt").addEntity(Subjectt.class);
		List<Subjectt> list = query.getResultList();
		for (Subjectt subjectt : list) {
			System.out.println(subjectt);
		}
	}

	public static void getSingleDataSubject(Scanner sc, Session session) {
		System.out.println("Enter Sid");
			Subjectt subjectt = session.get(Subjectt.class, sc.nextInt());
			System.out.println(subjectt);
			session.beginTransaction().commit();
	}

	public static void getSingleDataTeacher(Scanner sc, Session session) {
		System.out.println("Enter Subject ID");
		 Teacher teacher = session.get(Teacher.class, sc.nextInt());
		System.out.println(teacher);
		session.beginTransaction().commit();
	}

	public static void savedData(Session session) {
		Teacher t1=new Teacher(101, "VISHAL", 500, "PUNE");
		Teacher t2=new Teacher(102, "Saurabh", 600, "Mumbai");
		//Teacher t3=new Teacher(103, "PRAVIN", 60000, "NAgpur");
		
		Subjectt s1=new Subjectt(1, "JAVA", t1);
		Subjectt s2=new Subjectt(2, "SQL", t2);
		Subjectt s3=new Subjectt(3, "Python", t1);
		Subjectt s4=new Subjectt(4, "C++", t2);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		
	
		session.beginTransaction().commit();
		
		System.out.println("Done");
	}

}
