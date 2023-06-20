package com.serimpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.dbu.HibernateU;
import com.mo.Student;
import com.ser.StudentService;

public class StudentImpl implements StudentService {
	Scanner sc=new Scanner(System.in);
	Session session=HibernateU.getSessionFactory().openSession();
	

	@SuppressWarnings("deprecation")
	@Override
	public void insertData() 
	{
		Transaction tx = session.beginTransaction();
		Query query = session.getNamedNativeQuery("insertData");
		System.out.println("Enter RollNo");
		query.setInteger(0, sc.nextInt());
		System.out.println("Enter Name");
		query.setString(2, sc.next()+sc.nextLine());
		System.out.println("Enter MobileNo");
		query.setLong(1, sc.nextLong());
		
		query.executeUpdate();
		tx.commit();
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void getSingleData()
	{
		Query query = session.getNamedNativeQuery("getSingleData");
		System.out.println("Enter RollNo");
		query.setInteger(0, sc.nextInt());
		Student stu = (Student) query.getSingleResult();
		System.out.println(stu);
	}

	@Override
	public void getAllData() 
	{
		Query query = session.getNamedNativeQuery("getAllData");
		List<Student> list = query.getResultList();
		for (Student student : list) {
			System.out.println(student);
		}
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void updateData() 
	{
		Transaction tx = session.beginTransaction();
		Query query = session.getNamedNativeQuery("updateData");
		System.out.println("Enter new Name");
		query.setString(0, sc.next()+sc.nextLine());
		System.out.println("Enter new Mobile no");
		query.setLong(1, sc.nextLong());
		System.out.println("Enter Rollno");
		query.setInteger(2, sc.nextInt());
		
		query.executeUpdate();
		tx.commit();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteSingleData() 
	{
		Transaction tx = session.beginTransaction();
		Query query = session.getNamedNativeQuery("deleteSingle");
		System.out.println("Enter rollno");
		query.setInteger(0, sc.nextInt());
		query.executeUpdate();
		tx.commit();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteAllData() 
	{
		Transaction tx = session.beginTransaction();
		Query query = session.getNamedNativeQuery("deleteAll");
		query.executeUpdate();
		tx.commit();
		
				
	}

}
