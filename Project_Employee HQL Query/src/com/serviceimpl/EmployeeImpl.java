package com.serviceimpl;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dbutil.HibernateUtil;
import com.model.Employee;
import com.sevice.Employeeservice;

public class EmployeeImpl implements Employeeservice{
	
	Scanner sc=new Scanner(System.in);
	
	Session session= HibernateUtil.getSessionFactory().openSession();

	@Override
	public void addEmployeeInfo() 
	{
		
		System.out.println("Enter Employee ID :");
		int id=sc.nextInt();
		System.out.println("Enter Employee Name");
		String name=sc.next()+sc.nextLine();
		System.out.println("Enter Employee Address");
		String add=sc.next()+sc.nextLine();
		System.out.println("Enter Employee Mobile No");
		long mob=sc.nextLong();
		
		session.save(new Employee(id,name,add,mob));
		session.beginTransaction().commit();
		System.out.println("Employee Details Added Sucessfully");
	}

	@Override
	public void getSingleEmployeeInfo() {
		System.out.println("Enter Eid");
		int id=sc.nextInt();
		String getSingle="from Employee where eid=:id";
		Query<Employee> query = session.createQuery(getSingle);
		query.setInteger("id", id);
		Employee e = query.getSingleResult();
		System.out.println(e);
		
		
	}

	@Override
	public void getAllEmployeeInfo() 
	{
		String getAll="from Employee";
		Query query = session.createQuery(getAll);
		
		List<Employee> list = query.getResultList();
		for (Employee emp : list) {
		System.out.println(emp);	
		}
		
	}

	@Override
	public void updateEmployeeInfo() 
	{
		Transaction tx = session.beginTransaction();
		String update="update from Employee set ename=:name,eaddr=:addr where eid=:id";
		Query query = session.createQuery(update);
		System.out.println("Enter Id");
		int id=sc.nextInt();
		query.setInteger(2, id);
		System.out.println("Enter new Name");
		String name=sc.next()+sc.nextLine();
		query.setString(0, name);
		System.out.println("Enter New Address");
		String add=sc.next()+sc.nextLine();
		query.setString(1, add);
		
		query.executeUpdate();
		tx.commit();
		
		
	}

	@Override
	public void delteSingleEmoployeeInfo() 
	{
		Transaction tx = session.beginTransaction();
		String delete="delete from Employee where eid=:id";
		Query<Employee> query = session.createQuery(delete);
		System.out.println("Enter id to delete");
		int id=sc.nextInt();
		query.setInteger(0, id);
		
		query.executeUpdate();
		tx.commit();
		
	}

	@Override
	public void delteAllemplyeeInfo() {
		Transaction tx = session.beginTransaction();
		String deleteAll="delete from Employee";
		Query query = session.createQuery(deleteAll);
		
		query.executeUpdate();
		tx.commit();
	
		
		
	}

}
