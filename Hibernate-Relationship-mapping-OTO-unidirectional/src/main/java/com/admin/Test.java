package com.admin;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.dbutil.HibernateUtil;
import com.model.unidirectional.Addharcard;
import com.model.unidirectional.Student;

public class Test {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		savedData(session);
		
	}

	public static void updateData(Scanner sc, Session session) {
		Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery("update  Student set name=:nm where rollno=:rn").addEntity(Student.class);
		System.out.println("Enter Updated Name");
		query.setString("nm", sc.next());
		System.out.println("Enter RollNo");
		query.setInteger("rn", sc.nextInt());
		
		Query query2 = session.createSQLQuery("update Addharcard set address=? where adharno=?").addEntity(Addharcard.class);
		System.out.println("Enter New Address");
		query2.setString(0, sc.next());
		System.out.println("Enter Addar No");
		query2.setInteger(1, sc.nextInt());
		
		query.executeUpdate();
		query2.executeUpdate();
		tx.commit();
		System.out.println("***********Updated**********");
	}

	public static void getAll(Session session) {
		Query query = session.createSQLQuery("select * from Student").addEntity(Student.class);
		List<Student> l = query.getResultList();
		for (Student student : l) {
			System.out.println(student);
		}
	}

	public static void getSingle(Session session) {
		Student student = session.get(Student.class, 1);
		System.out.println(student);
	}

	public static void savedData(Session session) {
		Addharcard ad=new Addharcard(123, "Pune", "Male");
		
		Addharcard ad1=new Addharcard(456, "Nagpur", "Male");
		
		session.save(new Student(1, "Pravin", ad));
		session.save(new Student(2, "Vishal", ad1));
		
		session.beginTransaction().commit();
		System.out.println("Done");
	}

}
