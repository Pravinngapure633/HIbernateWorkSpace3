package com.admin;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;

import com.dbutil.HibernateUtil;
import com.model.Employee1;
import com.model.Laptop1;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		

	}

	public static void getSingle(Scanner sc, Session session) {
		System.out.println("Enter Emp Id");
		Employee1 emp = session.get(Employee1.class, sc.nextInt());

		System.out.println(emp.getEid() + "  " + emp.getEname() + "  " + emp.getDept());
		Set<Laptop1> lap = emp.getLap();
		for (Laptop1 l : lap) {
			System.out.println(l.getLid() + "  " + l.getLname() + "  " + l.getPrice());
		}
	}

	public static void savedData(Session session) {
		Employee1 e1 = new Employee1();
		e1.setEid(101);
		e1.setEname("Vishal");
		e1.setDept("Java");

		Employee1 e2 = new Employee1();
		e2.setEid(102);
		e2.setEname("Pravin");
		e2.setDept("IT");

		Employee1 e3 = new Employee1();
		e3.setEid(103);
		e3.setEname("Saurabh");
		e3.setDept("DDD");

		Employee1 e4 = new Employee1();
		e4.setEid(104);
		e4.setEname("Bhupesh");
		e4.setDept("llll");

		Laptop1 l1 = new Laptop1();
		l1.setLid(1);
		l1.setLname("HP");
		l1.setPrice(50000);

		Laptop1 l2 = new Laptop1();
		l2.setLid(2);
		l2.setLname("Dell");
		l2.setPrice(40000);

		Laptop1 l3 = new Laptop1();
		l3.setLid(3);
		l3.setLname("Asus");
		l3.setPrice(60000);

		Laptop1 l4 = new Laptop1();
		l4.setLid(4);
		l4.setLname("Lenovo");
		l4.setPrice(45000);

		Laptop1 l5 = new Laptop1();
		l5.setLid(5);
		l5.setLname("Macbook");
		l5.setPrice(100000);

		Laptop1 l6 = new Laptop1();
		l6.setLid(6);
		l6.setLname("XYZ");
		l6.setPrice(55000);

		Set<Employee1> el1 = new HashSet<Employee1>();
		el1.add(e1);
		el1.add(e2);
		el1.add(e3);
	

		Set<Employee1> el2=new HashSet<Employee1>();
		el2.add(e4);

		Set<Laptop1> ll1 = new HashSet<Laptop1>();
		ll1.add(l1);
		ll1.add(l2);
		ll1.add(l3);
		
		Set<Laptop1> ll2=new HashSet<Laptop1>();
		ll2.add(l4);
		ll2.add(l5);
		ll2.add(l6);
		
		e1.setLap(ll1);
		e2.setLap(ll2);
		e3.setLap(ll1);
		e4.setLap(ll2);

		l1.setEmp(el1);
		l2.setEmp(el1);
		l3.setEmp(el2);
		l4.setEmp(el2);
		l5.setEmp(el1);
		l6.setEmp(el2);

		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);

		session.beginTransaction().commit();
		System.out.println("Done");
	}

}
