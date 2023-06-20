package com.admin.bidrectional;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import com.dbutil.bidrectional.HibernateUtil;
import com.model.bidrectional.Employee;
import com.model.bidrectional.Laptop;

public class Test {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session = factory.openSession();
		
		
		
	}
	public static void getAllData(Session session) {
		Query query = session.createSQLQuery("select * from employee").addEntity(Employee.class);
		
		List<Employee> list = query.getResultList();
		for (Employee employee : list) {
			System.out.println(employee.getEid());
			System.out.println(employee.getEname());
			System.out.println(employee.getDesgi());
			System.out.println(employee.getSalary());
			System.out.println(employee.getLaptop().getLid());
			System.out.println(employee.getLaptop().getLname());
			System.out.println(employee.getLaptop().getPrice());
		}
	}

	// get for laptop
	public static void getSingleDataLaptop(Session session) {
		Laptop laptop = session.get(Laptop.class, 1);
		
		System.out.println(laptop.getLid());
		System.out.println(laptop.getLname());
		System.out.println(laptop.getPrice());
		System.out.println(laptop.getEmployee().getEid());
		System.out.println(laptop.getEmployee().getEname());
		System.out.println(laptop.getEmployee().getDesgi());
		System.out.println(laptop.getEmployee().getSalary());
	}
	
	

	// get by employee
	public static void getSingleDataEmployee(Session session) {
		
		Employee employee = session.get(Employee.class, 201);
		System.out.println(employee);
		System.out.println(employee.getEid());
		System.out.println(employee.getEname());
		System.out.println(employee.getDesgi());
		System.out.println(employee.getSalary());
		System.out.println(employee.getLaptop().getLid());
		System.out.println(employee.getLaptop().getLname());
		System.out.println(employee.getLaptop().getPrice());
	}

	public static void savedData(SessionFactory factory) {
		Employee emp1=new Employee();
		emp1.setEid(201);
		emp1.setEname("Saurabh");
		emp1.setDesgi("Dev");
		emp1.setSalary(4500);
		
		Employee emp2=new Employee();
		emp2.setEid(202);
		emp2.setEname("Vishal");
		emp2.setDesgi("Langlang");
		emp2.setSalary(500);
		
		Laptop lp1=new Laptop();
		lp1.setLid(1);
		lp1.setLname("HP");
		lp1.setPrice(45000);
	
		Laptop lp2=new Laptop();
		lp2.setLid(2);
		lp2.setLname("ASUS");
		lp2.setPrice(55000);
		
		emp1.setLaptop(lp1);
		emp2.setLaptop(lp2);
		lp1.setEmployee(emp1);
		lp2.setEmployee(emp2);
		
		Session session = factory.openSession();
		
		session.save(emp1);
		session.save(emp2);
		
		session.beginTransaction().commit();
		System.out.println("Done");
	}

}
