package com.admin.secondlevel;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dbutil.secondlevel.HibernateUtil;
import com.model.secondlevel.Employee;

public class Test {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session1 = factory.openSession();

		//second level cache madhe ekch da data bsese la hit hote mg kiti pan session create kra-
		//to data get cache memory nich honar
		//second level session factory sathi use hote 
		Employee emp1 = session1.get(Employee.class, 101);
		System.out.println(emp1); // hit data base query created

		System.out.println("=========");

		Employee emp2 = session1.get(Employee.class, 101);
		System.out.println(emp2); // get from cache memory
		
		
		System.out.println("=======");
		Session session2 = factory.openSession();		
		Employee emp3 = session2.get(Employee.class, 101);
		System.out.println(emp3); // get from cache memory
		System.out.println("=======");
		
		Employee emp4 = session2.get(Employee.class, 101);
		System.out.println(emp4);// get from cache memory
		
		
		System.out.println("*******************");
		SessionFactory factory2 = HibernateUtil.getSessionFactory();
		Session session3 = factory2.openSession();


		Employee emp5 = session3.get(Employee.class, 101);
		System.out.println(emp1); // hit data base query created

		System.out.println("=========");

		Employee emp6 = session3.get(Employee.class, 101);
		System.out.println(emp2); // get from cache memory
		
		
		System.out.println("=======");
		Session session4 = factory2.openSession();		
		Employee emp7 = session4.get(Employee.class, 101);
		System.out.println(emp3); // get from cache memory
		System.out.println("=======");
		
		Employee emp8 = session4.get(Employee.class, 101);
		System.out.println(emp4);// get from cache memory
		
		

	}

	public static void saveData(SessionFactory factory) {
		Session session1 = factory.openSession();

		Employee emp = new Employee();
		emp.setId(102);
		emp.setName("PQR");
		emp.setDesg("Developer");
		emp.setSalary(20000);

		session1.save(emp);
		session1.beginTransaction().commit();
		System.out.println("Done");
	}

}
