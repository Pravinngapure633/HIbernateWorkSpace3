package com.serviceimpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.DBUtil.HibernateUtil;
import com.model.Product;
import com.service.Service;

public class ProductService  implements Service{

	Scanner sc = new Scanner(System.in);
	@Override
	public void addProduct()
	{
		Product pr = new Product();
		System.out.println("Enter Product Name");
		pr.setProuductName(sc.next()+sc.nextLine());
		System.out.println("Enter Product Price");
		double price=sc.nextDouble();
		pr.setPrice(price);
		System.out.println("Enter Product Colour");
		pr.setColour(sc.next()+sc.nextLine());
		System.out.println("Enter Product Brand");
		pr.setBrand(sc.next()+sc.nextLine());
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.save(pr);
		session.beginTransaction().commit();
		System.out.println("*********PRODUCT ADDED SUCESFULLY********");
		
	}

	@Override
	public void getProduct() 
	{
		System.out.println("************PRODUCT INFORMATION*******");
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter ID To Get Details");
		Product pr = session.get(Product.class, sc.nextInt());
		System.out.println(pr.toString());
		System.out.println("****************************");
	}

	@Override
	public void deleteProduct() 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter Product ID To Delect");
		Product pr = session.get(Product.class, sc.nextInt());
		Transaction tx = session.beginTransaction();
		session.delete(pr);
		tx.commit();
		System.out.println("*****Delect Successfully*******");
		
		
	}

	@Override
	public void updateProduct() 
	{
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter Product Id To Update Data");
		Product pr = session.get(Product.class, sc.nextInt());
		System.out.println("Enter 1 for Update Name");
		System.out.println("Enter 2 for Update Price");
		System.out.println("Enter 3 for Update Color");
		System.out.println("Enter 4 for Exit Update");
		
		
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1: 
				System.out.println("Enter New Product Name");
				pr.setProuductName(sc.next()+sc.nextLine());
			break;
			
		case 2: 
				System.out.println("Enter New Product Price");
				pr.setPrice(sc.nextDouble());
				break;
		case 3: 
			System.out.println("Enter New Product Colour");
			pr.setColour(sc.next()+sc.nextLine());
			break;
		case 4: 
			System.out.println("Enter for Exit");
			System.exit(0);
			break;
		}
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(pr);
		tx.commit();
		System.out.println("Update Sucess");
	}

}
