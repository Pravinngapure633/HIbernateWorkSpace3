package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Hibernate.util.HibernateUtil;

public class Test_Hibernetutil {
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session = factory.openSession();

		Student student = session.get(Student.class, 202);

		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("Record Not Found");
		}
		System.out.println("Done");
	}

}
