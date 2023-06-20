package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test_Insert {
	
public static void main(String[] args) {
		
		StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure().build();
		
		MetadataSources mds=new MetadataSources(registry);
		
		Metadata md=mds.getMetadataBuilder().build();
		
		SessionFactory factory=md.getSessionFactoryBuilder().build();
		
		Session session=factory.openSession();
		
		Student stu = new Student();
		stu.setRollno(202);
		stu.setName("XYZ");
		stu.setAddress("Nagpur");
		
		session.save(stu);
		session.beginTransaction().commit();
		System.out.println("Student saved");
	}


}
