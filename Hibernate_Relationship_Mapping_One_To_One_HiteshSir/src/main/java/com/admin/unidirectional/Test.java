package com.admin.unidirectional;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.dbutil.unidirectionl.HibernateUtil;
import com.model.unidirectional.Employee;
import com.model.unidirectional.Laptop;

public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		

	}

	public static void getAllData(Session session) {
		Query query = session.createSQLQuery("select * from employee").addEntity(Employee.class);

		List<Employee> list = query.getResultList();

		for (Employee emp : list) {
			System.out.println(emp);
		}
	}

	public static void getSingleData(Session session) {
		Employee employee = session.get(Employee.class, 101);
		System.out.println(employee);
		System.out.println("======");
		Laptop laptop = session.get(Laptop.class, 1);
		System.out.println(laptop);
	}

	public static void savedData(SessionFactory factory) {
		Employee emp = new Employee();
		emp.setEid(101);
		emp.setEname("Pravin");
		emp.setDesgi("Developer");
		emp.setSalary(200000);

		Employee emp1 = new Employee();
		emp1.setEid(102);
		emp1.setEname("Vishal");
		emp1.setDesgi("Tester");
		emp1.setSalary(100000);

		Laptop lp = new Laptop();
		lp.setLid(1);
		lp.setLname("HP");
		lp.setPrice(45000);

		Laptop lp1 = new Laptop();
		lp1.setLid(2);
		lp1.setLname("ASUS");
		lp1.setPrice(55000);

		emp.setLaptop(lp);
		emp1.setLaptop(lp1);

		Session session = factory.openSession();
		session.save(emp);
		session.save(emp1);

		session.beginTransaction().commit();
		System.out.println("Data saved");
	}

}
