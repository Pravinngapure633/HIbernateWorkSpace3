package com.serviceimpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.hibernate.HibernateUtil;
import com.model.Student;
import com.service.StudentService;

public class StudentImpl implements StudentService {
	
	Scanner sc=new Scanner(System.in);
	Session session = HibernateUtil.getSessionFactory().openSession();
	

	@Override
	public void addStudentInfo() 
	{
		
		System.out.println("Enter Student RollNo");
		int rollno=sc.nextInt();
		System.out.println("Enter Student Name");
		String name=sc.next()+sc.nextLine();
		System.out.println("Enter Student Address");
		String add=sc.next()+sc.nextLine();
		System.out.println("Enter Student Age");
		int age=sc.nextInt();
		System.out.println("Enter Mobile No");
		long mob=sc.nextLong();
		//Session session = HibernateUtil.getSessionFactory().openSession();
	
		session.save(new Student(rollno,name,add,age,mob));
		
		Transaction tx = session.beginTransaction();
		tx.commit();
		System.out.println("***********DataAdded Sucessfully**********");
		
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void getSingleStudentInfo() {
		
		//Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter RollNo To Get Data");
		int rollno=sc.nextInt();
		String get="select * from Student where sRollno="+rollno+"";
		Query<Student> query = session.createSQLQuery(get).addEntity(Student.class);
		
		Student result = query.getSingleResult();
		System.out.println(result);
		
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void getAllStudentInfo() {
		
		//Session session = HibernateUtil.getSessionFactory().openSession();
		
		String getAll="Select * from Student";
		Query query = session.createSQLQuery(getAll).addEntity(Student.class);
		List<Student> list = query.getResultList();
		System.out.println(list);
		
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void udateStudentInfo() {
		
		//Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Enter Rollno to Udpadte Data");
		int rollno=sc.nextInt();
		System.out.println("Enter new Name ");
		String name=sc.next()+sc.nextLine();
		System.out.println("Enter new  Mobileno ");
		long mob=sc.nextLong();
		
		String update="update Student set sName='"+name+"',sMobNo="+mob+" where sRollno="+rollno+"";
		Query<Student> query = session.createSQLQuery(update).addEntity(Student.class);
		
		query.executeUpdate();
		tx.commit();
		System.out.println("*******Update Done******");
		
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteStudentInfo() {

		Transaction tx = session.beginTransaction();
		System.out.println("Enter RollNo To delete Specific RollNo Data");
		int rollno=sc.nextInt();
		String delete="delete from Student  where sRollno="+rollno+"";
		Query query = session.createSQLQuery(delete).addEntity(Student.class);
		query.executeUpdate();
		tx.commit();
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteAllStudentInfo() {
		
		Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery("delete from Student").addEntity(Student.class);
		
		query.executeUpdate();
		tx.commit();
		System.out.println("Delete All Done");
		
		
	}

}
