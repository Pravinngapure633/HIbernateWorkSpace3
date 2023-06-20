package com.admin.firstlevel;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dbutil.firstlevel.HibernateUtil;
import com.model.firstlevel.Employee;

public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session1 = factory.openSession();
		//single level cache madhe 1st check cache memory data is not present then go to cache memory to data bases(hit)
		//and same  time same session get same data then value will get cache memory. data base not hit
	
		
		System.out.println("Enter Id");
		Employee emp1 = session1.get(Employee.class, sc.nextInt());
		System.out.println(emp1);  // hit data base query created
		
		System.out.println("=========");
		System.out.println("Enter Id");
		Employee emp2 = session1.get(Employee.class, sc.nextInt());
		System.out.println(emp2);  //get from cache memory query not create
	
		System.out.println("=======");
		Session session2 = factory.openSession();
		
		
		//single level cache will be based on session to session
		System.out.println("Enter Id");
		Employee emp3 = session2.get(Employee.class, sc.nextInt());
		System.out.println(emp3); //hit database
		System.out.println("=======");
		System.out.println("Enter Id");
		Employee emp4 = session2.get(Employee.class, sc.nextInt());
		System.out.println(emp4);//get from cache memory
		

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
