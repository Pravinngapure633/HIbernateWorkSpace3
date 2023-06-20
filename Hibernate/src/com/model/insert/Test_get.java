package com.model.insert;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test_get {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session= factory.openSession();
		
		Student student=session.get(Student.class, 102);
		
		System.out.println("-----------------");
		
		if(student!=null)
		{
			System.out.println(student);
		}
		else
		{
			System.out.println("Record not found");
		}
		System.out.println("Done");
	}

}
