package com.serviceimpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dbutil.HibernateUtil;
import com.model.Student;
import com.service.StudentSr;


public class Studentimpl implements StudentSr {
	
	Scanner sc=new Scanner(System.in);
	Session session=HibernateUtil.getSessionFactory().openSession();

	@Override
	public void addData() {
		
		System.out.println("Enter Student Rollno");
		int rollno=sc.nextInt();
		System.out.println("Enter Student Name");
		String name=sc.next()+sc.nextLine();
		System.out.println("Enter Student Address");
		String add=sc.next();
	
		session.save(new Student(rollno,name,add));
		session.beginTransaction().commit();;
		System.out.println("Added Sucessfully");
		
	}

	@Override
	public void getSingleData() {
		
		Query query = session.getNamedQuery("getSingleData");
		System.out.println("Enter RollNo");
		
		query.setInteger("rollno", sc.nextInt());
		Student stu = (Student) query.getSingleResult();
		System.out.println(stu);
		
		
		
	}

	@Override
	public void getAllData() {
		
		Query query = session.getNamedQuery("getAllData");
		List<Student> list = query.getResultList();
		for (Student student : list) {
			System.out.println(student);
		}
		
		
		
	}
	@Override
	public void updateData() {
		Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("updateData");
		System.out.println("Enter RollNo for Update");
		int rollno=sc.nextInt();
		query.setInteger("rollno", rollno);
		System.out.println("Enter New Name");
		query.setString("name", sc.next()+sc.nextLine());
		System.out.println("Enter New Address");
		query.setString("addr", sc.next());
		
		query.executeUpdate();
		tx.commit();
		
		
		
	}

	@Override
	public void deleteSingleData() {
		Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("deleteSingleData");
		System.out.println("Enter Rollno You Want To Delete");
		query.setInteger("rollno", sc.nextInt());
		
		query.executeUpdate();
		tx.commit();
		System.out.println("Deleted");
	}

	@Override
	public void deleteAAlldata() 
	{
		Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("deleteAllData");
		
		query.executeUpdate();
		tx.commit();
		
	}

}
