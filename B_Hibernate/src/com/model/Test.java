package com.model;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class Test {

	public static void main(String[] args) {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put(Environment.DRIVER, "(com.mysql.jdbc.Driver)");
		map.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatedemo");
		map.put(Environment.USER, "root");
		map.put(Environment.PASS, "root");
		map.put(Environment.DIALECT, "update");
		map.put(Environment.SHOW_SQL, true);

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(map).build();

		MetadataSources mds = new MetadataSources(registry);

		mds.addAnnotatedClass(Student.class);

		Metadata md = mds.getMetadataBuilder().build();

		SessionFactory factory = md.getSessionFactoryBuilder().build();

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
