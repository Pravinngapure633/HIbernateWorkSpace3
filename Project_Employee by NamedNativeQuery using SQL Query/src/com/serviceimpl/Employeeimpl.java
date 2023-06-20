package com.serviceimpl;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.dbutil.HibernateUtil;
import com.model.Employee;
import com.service.EmployeeSr;

public class Employeeimpl implements EmployeeSr {

	Scanner sc = new Scanner(System.in);
	Session session=HibernateUtil.getSessionFactory().openSession();
	@Override
	public void addData() {
		System.out.println("Enter Employee Id");
		int id=sc.nextInt();
		System.out.println("Enter employee Name");
		String name=sc.next()+sc.nextLine();
		System.out.println("Enter Employee Salary");
		double salary=sc.nextDouble();
		
		session.save(new Employee(id,name,salary));
		
		session.beginTransaction().commit();
		System.out.println("Added");
	}

	@Override
	public void getSingleData() 
	{
		Query<Employee> query = session.getNamedNativeQuery("getSingleData");
		System.out.println("Enter Id");
		query.setInteger(0, sc.nextInt());
		Employee employee = query.getSingleResult();
		System.out.println(employee);
	}

	@Override
	public void getAllData() {
		Query<Employee> query = session.getNamedNativeQuery("getAllData");
		List<Employee> list = query.getResultList();

		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	@Override
	public void updateData() 
	{
		Transaction tx = session.beginTransaction();
		Query query = session.getNamedNativeQuery("updateData");
		System.out.println("Enter Id");
		query.setInteger(2, sc.nextInt());
		System.out.println("Enter Name");
		query.setString(0, sc.next()+sc.nextLine());
		System.out.println("Enter Salary");
		query.setDouble(1, sc.nextDouble());
		
		query.executeUpdate();
		tx.commit();
		
	}

	@Override
	public void deleteSingleData() {
	
		Transaction tx = session.beginTransaction();
		Query query = session.getNamedNativeQuery("deleteSingle");
		System.out.println("Enter Id To Delete");
		query.setInteger("id", sc.nextInt());
		
		query.executeUpdate();
		tx.commit();
	}

	@Override
	public void deleteAlldata() {
		Transaction tx = session.beginTransaction();
		Query query = session.getNamedNativeQuery("deleteAll");
		query.executeUpdate();
		tx.commit();
	}

	@Override
	public void insertData() {
	
		Transaction tx = session.beginTransaction();
		Query query = session.getNamedNativeQuery("insertData");
		
		System.out.println("Enter Id ");
		query.setInteger(0, sc.nextInt());
		System.out.println("Enter Name");
		query.setString(1, sc.next()+sc.nextLine());
		System.out.println("Enter Salary");
		query.setDouble(2, sc.nextDouble());
		
		
		query.executeUpdate();
		tx.commit();
		
	}

}
