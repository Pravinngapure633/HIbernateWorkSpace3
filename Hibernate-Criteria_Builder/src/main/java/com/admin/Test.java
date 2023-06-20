package com.admin;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dbutil.HibernateUtil;
import com.model.Product;

public class Test {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//st-1 create criteria builder object
		CriteriaBuilder cb = session.getCriteriaBuilder();
		//st-2 create criteria query object
		CriteriaQuery<Product> cr = cb.createQuery(Product.class);
		//st-3 create root oj=bject
		Root<Product> root = cr.from(Product.class);
		cr.where(cb.equal(root.get("pname"),"Tv"));
		
		session.c
		
	}

	public static void getAll(Session session) {
		//st-1 Create criteria builder object
		CriteriaBuilder cb = session.getCriteriaBuilder();
		//st-2 create criteria query object
		CriteriaQuery<Product> cr = cb.createQuery(Product.class);
		//st-3 create root object
		Root<Product> root = cr.from(Product.class);
		cr.select(root);
		
		Query<Product> query = session.createQuery(cr);
		
		List<Product> list = query.getResultList();
		for (Product product : list) {
			System.out.println(product);
		}
	}

	public static void saveData(Session session) {
		Product p1=new Product(1, "Laptop", 45000, "Asus", "Black");
		Product p2=new Product(2, "Shoes", 8000, "Nike", "White");
		Product p3=new Product(3, "Tv", 4500, "Mi", "Black");
		Product p4=new Product(4, "Mobile", 10000, "Moto", "Blue");
		Product p5=new Product(5, "RS", 180, "RS","Red");
		Product p6=new Product(6, "Bottel", 80, "Bislary", "White");
		Product p7=new Product(7, "Headphone", 700, "OnePLus", "Blak");
		Product p8=new Product(8, "Chrarger", 1200, "MI", "Black");
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		session.save(p5);
		session.save(p6);
		session.save(p7);
		session.save(p8);
		
		session.beginTransaction().commit();
	}

}
