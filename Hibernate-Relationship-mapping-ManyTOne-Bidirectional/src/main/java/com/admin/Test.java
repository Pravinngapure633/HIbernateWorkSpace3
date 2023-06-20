package com.admin;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.dbutil.HibernateUtil;
import com.model.Subjectt1;
import com.model.Teacher1;

public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query query = session.createSQLQuery("Select * from subjectt1").addEntity(Subjectt1.class);
		List<Subjectt1> list = query.getResultList();
		for (Subjectt1 s : list) {
			System.out.println(s.getSid()+" "+s.getSname());
			Teacher1 tec = s.getTec();
			System.out.println(tec.getTid()+" "+tec.getTname()+" "+tec.getSalary()+" "+tec.getAddr());
		}
	}

	public static void getSingleSubject(Scanner sc, Session session) {
		System.out.println("Enter SID");
		Subjectt1 s = session.get(Subjectt1.class,sc.nextInt());
		System.out.println(s.getSid()+" "+s.getSname()+" "+s.getTec().getTid()+" "+s.getTec().getTname()+" "+s.getTec().getSalary()+" "+s.getTec().getAddr());
	}

	public static void getSingDataTeacher(Scanner sc, Session session) {
		System.out.println("Enter TID");
		Teacher1 t = session.get(Teacher1.class, sc.nextInt());
		System.out.println(t.getTid()+" "+t.getTname()+" "+t.getSalary()+" "+t.getAddr());
		Set<Subjectt1> sub = t.getSub();
		for (Subjectt1 s : sub) {
			System.out.println(s.getSid()+" "+s.getSname());
		}
	}

	public static void savedData(Session session) {
		Subjectt1 s1 = new Subjectt1();
		s1.setSid(1);
		s1.setSname("English");

		Subjectt1 s2 = new Subjectt1();
		s2.setSid(2);
		s2.setSname("Marathi");

		Subjectt1 s3 = new Subjectt1();
		s3.setSid(3);
		s3.setSname("Hindi");

		Subjectt1 s4 = new Subjectt1();
		s4.setSid(4);
		s4.setSname("Java");

		Subjectt1 s5 = new Subjectt1();
		s5.setSid(5);
		s5.setSname("Sql");

		Set<Subjectt1> s = new HashSet<Subjectt1>();
		s.add(s1);
		s.add(s2);

		Set<Subjectt1> ss = new HashSet<Subjectt1>();
		ss.add(s4);
		ss.add(s5);

		Set<Subjectt1> sss = new HashSet<Subjectt1>();
		sss.add(s3);

		Teacher1 t1 = new Teacher1();
		t1.setTid(101);
		t1.setTname("Saurabh");
		t1.setSalary(525545);
		t1.setAddr("Pune");

		Teacher1 t2 = new Teacher1();
		t2.setTid(102);
		t2.setTname("rabh");
		t2.setSalary(25545);
		t2.setAddr("Akrudi");

		Teacher1 t3 = new Teacher1();
		t3.setTid(103);
		t3.setTname("bihakd");
		t3.setSalary(400);
		t3.setAddr("adaad");

		s1.setTec(t1);
		s2.setTec(t1);
		s3.setTec(t2);
		s4.setTec(t3);
		s5.setTec(t3);

		t1.setSub(s);
		t2.setSub(ss);
		t3.setSub(sss);

		session.save(t1);
		session.save(t2);
		session.save(t3);

		session.beginTransaction().commit();
		System.out.println("Dones");
	}
}
