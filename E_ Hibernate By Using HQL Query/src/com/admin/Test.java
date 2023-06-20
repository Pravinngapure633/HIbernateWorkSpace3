package com.admin;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.DBUtil.HibernateUtil;
import com.model.Product;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Session session = HibernateUtil.getSessionFactory().openSession();

	}

	public static void deleteAll(Session session) {
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete Product");

		query.executeUpdate();
		tx.commit();
	}

	public static void updateData(Scanner sc, Session session) {
		Transaction tx = session.beginTransaction();

//	String update="update Product set pname=:name,pcolor=:color,price=:pri where pid=:id";
//	Query<Product> query = session.createQuery(update);
//	System.out.println("Enter Prodct Id Whose Data You Want To Update");
//	int pid=sc.nextInt();
//	query.setInteger("id", pid);
//	System.out.println("Enter New Product Name ");
//	String name=sc.next();
//	query.setString("name", name);
//	System.out.println("Enter New Product Price ");
//	double price=sc.nextDouble();
//	query.setDouble("pri", price);
//	System.out.println("Enter New Product Color ");
//	String color=sc.next();
//	query.setString("color", color);
//	
//	
		String update = "update Product set pname=?,pcolor=?,price=? where pid=?";
		Query<Product> query = session.createQuery(update);
		System.out.println("Enter Prodct Id Whose Data You Want To Update");
		int pid = sc.nextInt();
		query.setInteger(3, pid);
		System.out.println("Enter New Product Name ");
		String name = sc.next();
		query.setString(0, name);
		System.out.println("Enter New Product Price ");
		double price = sc.nextDouble();
		query.setDouble(2, price);
		System.out.println("Enter New Product Color ");
		String color = sc.next();
		query.setString(1, color);

		query.executeUpdate();
		tx.commit();
	}

	public static void deleteSingleData(Scanner sc, Session session, Transaction tx) {

		Transaction tr = session.beginTransaction();
		Query<Product> query = session.createQuery("delete Product where pid=:pid");
		System.out.println("Enter Pid");
		int pid = sc.nextInt();
		query.setInteger("pid", pid);

//		System.out.println("Enter Pid");
//		int pid=sc.nextInt();
//		Query<Product> query = session.createQuery("delete Product where pid=?");
//		query.setInteger(0, pid);

		query.executeUpdate();
		tr.commit();
		System.out.println("Deleted");
	}

	public static void singleDataGet(Scanner sc, Session session) {
		// 1st- Name parameter
//	Query<Product>  query= session.createQuery("from Product where pid=:pid");
//	System.out.println("Enter Pid");
//	int pid=sc.nextInt();
//	query.setInteger("pid", pid);
//	
//	Or 2nd- positional parameter
		System.out.println("Enter Pid");
		int pid = sc.nextInt();
		Query<Product> query = session.createQuery("from Product where pid=?");
		query.setInteger(0, pid);

		Product pr = query.getSingleResult();

		System.out.println(pr);
	}

//hql madhe only class name pahije table name nahi
	public static void getAllData(Session session) {
		Query query = session.createQuery("from Product");

		List<Product> list = query.getResultList();

		for (Product p : list) {
			System.out.println(p);
		}
	}

	// HQL madhe saved ani insert hot nahi
//public static void saveData(Session session) {
//	session.save(new Product(101,"Shoes","White",2500,"Nike"));
//	session.save(new Product(102,"Laptop","Silver",80000,"Asus"));
//	session.save(new Product(103,"Mobile","White",150000,"IPhone"));
//	session.save(new Product(104,"Tv","Blach",22000,"Realmi"));
//	session.save(new Product(105,"Headphone","White",1800,"OnePlus"));
//	
//	session.beginTransaction().commit();
//	System.out.println("Data Saved");
//}
}
