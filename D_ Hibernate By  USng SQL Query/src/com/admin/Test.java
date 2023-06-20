package com.admin;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.DBUtil.HibernateUtil;
import com.model.Product;

public class Test {
	
	public static void main(String[] args) 
	{		
		Scanner sc=new Scanner(System.in);
		Session session = HibernateUtil.getSessionFactory().openSession();	
		
		
	}

	public static void deleteAll(Session session) 
	{
		Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery("delete from product_info");
		query.executeUpdate();
		tx.commit();
		System.out.println("Data Deleted");
	}
	public static void insertNewData(Scanner sc, Session session) {
		Transaction tx = session.beginTransaction();
		System.out.println("Enter Product Id Whose Data You Want To Store");
		int pid=sc.nextInt();
		System.out.println("Enter Product Name");
		String name=sc.next()+sc.nextLine();
		System.out.println("Enter  Product Price");
		double price=sc.nextDouble();
		System.out.println("Entere Prodcut Color");
		String color=sc.next()+sc.nextLine();
		System.out.println("Entere Prodcut Brand");
		String brand=sc.next()+sc.nextLine();
		
String insert="insert into product_Info values("+pid+",'"+brand+"','"+color+"','"+name+"',"+price+")";
		
		Query query = session.createSQLQuery(insert);
		
		query.executeUpdate();
		tx.commit();
		System.out.println("Data Saved");
	}

	public static void updateData(Scanner sc, Session session) {
		Transaction tx = session.beginTransaction();
		System.out.println("Enter Prodct Id Whose Data You Want To Update");
		int pid=sc.nextInt();
		System.out.println("Enter New Product Name ");
		String name=sc.next();
		System.out.println("Enter New Product Price ");
		double price=sc.nextDouble();
		System.out.println("Enter New Product Color ");
		String color=sc.next();
		
		String update="update Product_Info set Product_Name='"+name+"', Product_Price="+price+", Product_Color='"+color+"' where Product_Id="+pid+"";
				
		Query query = session.createSQLQuery(update).addEntity(Product.class);
		
		query.executeUpdate();
		tx.commit();
	}

	public static void deleteSingleData(Session session) {
		Transaction tx = session.beginTransaction();
		int pid=105;
		
		Query<Product> query = session.createSQLQuery("delete from Product_Info where Product_Id="+pid+"").addEntity(Product.class);
		
		query.executeUpdate();
		tx.commit();
		System.out.println("Done");
	}

	public static void getSingleData(Session session) {
		System.out.println("Enter Id to Get");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		Query<Product> query = session.createSQLQuery("select * from Product_info where Product_Id="+id+"").addEntity(Product.class);
		
		Product pr = query.getSingleResult();
		
		System.out.println(pr);
		
		
	}

	public static void getAllData(Session session) {
		Query query = session.createSQLQuery("Select * from Product_info").addEntity(Product.class);
		
		List<Product> list = query.getResultList();
		
		for(Product p:list)
		{
			System.out.println(p.toString());
		}
	}

	public static void saveData(Session session) {
		session.save(new Product(101,"Shoes","White",2500,"Nike"));
		session.save(new Product(102,"Laptop","Silver",80000,"Asus"));
		session.save(new Product(103,"Mobile","White",150000,"IPhone"));
		session.save(new Product(104,"Tv","Blach",22000,"Realmi"));
		session.save(new Product(105,"Headphone","White",1800,"OnePlus"));
		
		session.beginTransaction().commit();
		System.out.println("Data Saved");
	}

}
