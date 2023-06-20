package com.admin;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dbutil.HibernateUtil;
import com.model.unidirectional.Department1;
import com.model.unidirectional.Faculty1;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Department1 d1 = new Department1();
		d1.setId(1);
		d1.setName("C");

		Department1 d2 = new Department1();
		d2.setId(2);
		d2.setName("CDAC");

		Department1 d3 = new Department1();
		d3.setId(3);
		d3.setName("JAVA");

		Faculty1 f1 = new Faculty1();
		f1.setFid(101);
		f1.setName("PRAVIN");
		f1.setAddr("PUNE");

		Faculty1 f2 = new Faculty1();
		f2.setFid(101);
		f2.setName("PRAVIN");
		f2.setAddr("PUNE");

		Faculty1 f3 = new Faculty1();
		f3.setFid(101);
		f3.setName("PRAVIN");
		f3.setAddr("PUNE");

		Faculty1 f4 = new Faculty1();
		f4.setFid(101);
		f4.setName("PRAVIN");
		f4.setAddr("PUNE");

	}

}
