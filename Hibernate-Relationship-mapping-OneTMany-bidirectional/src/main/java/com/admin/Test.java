package com.admin;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.dbutil.HibernateUtil;
import com.model.unidirectional.Department;
import com.model.unidirectional.Faculty;


public class Test {
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
	
		
		Query query = session.createSQLQuery("select * from Department").addEntity(Department.class);
		List<Department> list = query.getResultList();
		for (Department department : list) {
			System.out.println(department.getId());
			System.out.println(department.getName());
			List<Faculty> fa = department.getFa();
			for (Faculty f : fa) {
				System.out.println(f.getFid());
				System.out.println(f.getName());
				System.out.println(f.getAddr());
			}
			
		}
		
		
	}

	public static void getSingleFaculty(Scanner sc, Session session) {
		System.out.println("Enter Fid");
		Faculty faculty = session.get(Faculty.class, sc.nextInt());
		System.out.println(faculty.getFid());
		System.out.println(faculty.getName());
		System.out.println(faculty.getAddr());
		Department dep = faculty.getDep();
		System.out.println(dep.getId());
		System.out.println(dep.getName());
	}

	public static void getSingleDepartment(Scanner sc, Session session) {
		System.out.println("Enter Dep Id");
		Department department = session.get(Department.class, sc.nextInt());
		System.out.println(department.getId());
		System.out.println(department.getName());
		
		List<Faculty> fa = department.getFa();
		for (Faculty faculty : fa) {
			System.out.println(faculty.getFid());
			System.out.println(faculty.getName());
			System.out.println(faculty.getAddr());
			
		}
	}

	public static void savedData(Session session) {
		Department d1=new Department();
		d1.setId(101);
		d1.setName("JAVA");
	
		Department d2=new Department();
		d2.setId(102);
		d2.setName("C++");
		
		Faculty f1=new Faculty();
		f1.setFid(1);
		f1.setName("Saurabh Sir");
		f1.setAddr("Pune");
		
		Faculty f2=new Faculty();
		f2.setFid(2);
		f2.setName("Hitesh Sir");
		f2.setAddr("Akurdi");
		
		Faculty f3=new Faculty();
		f3.setFid(3);
		f3.setName("Swpnil Sir");
		f3.setAddr("Pune");
		
		Faculty f4=new Faculty();
		f4.setFid(4);
		f4.setName("Vishal Sir");
		f4.setAddr("Nagpur");
		
		
		List<Faculty> l1=new ArrayList<Faculty>();
		l1.add(f1);
		l1.add(f2);
		l1.add(f3);
		
		List<Faculty> l2=new ArrayList<Faculty>();
		l2.add(f4);
		
		d1.setFa(l1);
		d2.setFa(l2);
		
		f1.setDep(d1);
		f2.setDep(d1);
		f3.setDep(d2);
		f4.setDep(d2);
		
		
		session.save(d1);
		session.save(d2);
		
		session.beginTransaction().commit();
		System.out.println("Done");
	}
}
