package com.admin;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.dbutil.HibernateUtil;
import com.model.Student;

public class Test {
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Student");
		query.setFirstResult(3);
		query.setMaxResults(7);
		List<Student> list = query.list();
		for (Student student : list) {
			System.out.println(student.toString());
		}
		
	}

	public static void count(Session session) {
		Query query = session.createQuery("select count(*) from Student");
		Object object = query.getSingleResult();
		System.out.println(object);
	}

	public static void avg(Session session) {
		Query query = session.createQuery("select avg(mark) from Student");
		Object object = query.getSingleResult();
		System.out.println(object);
	}

	public static void sum(Session session) {
		Query query = session.createQuery("select sum(mark) from Student");
		Double f = (Double)query.getSingleResult();
		System.out.println(f);
	}

	public static void max(Session session) {
		Query query = session.createSQLQuery("select max(mark) from Student");
		Float d =(Float) query.getSingleResult();
		System.out.println(d);
	}

	public static void MinimumMark(Session session) {
		Query query = session.createQuery("select min(mark) from Student");
		Object o = query.getSingleResult();
	
		System.out.println(o);
	}

	public static void saveData(Session session) {
		Student stu1=new Student(1, "Pravin", 78f, 23, 9404350554l);
		Student stu2=new Student(2, "Vishal", 90f, 25, 8804350l);
		Student stu3=new Student(3, "Saurabh", 77f, 28, 7804350554l);
		Student stu4=new Student(4, "Swpnil", 55f, 25, 944350554l);
		Student stu5=new Student(5, "Shital", 60f, 27, 77704350554l);
		Student stu6=new Student(6, "Shubham", 95f, 30, 999350554l);
		Student stu7=new Student(7, "Sachin", 90f, 29, 78784350554l);
		Student stu8=new Student(8, "Pradip", 78f, 25, 808065554l);
			
		session.save(stu1);
		session.save(stu2);
		session.save(stu3);
		session.save(stu4);
		session.save(stu5);
		session.save(stu6);
		session.save(stu7);
		session.save(stu8);
		
		session.beginTransaction().commit();
	}

}
