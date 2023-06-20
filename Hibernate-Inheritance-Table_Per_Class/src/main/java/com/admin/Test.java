package com.admin;

import java.util.Scanner;

import org.hibernate.Session;

import com.dbutil.HibernateUtil;
import com.model.Developer2;
import com.model.Employee2;
import com.model.Tester2;

public class Test {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Employee2 emp=new Employee2();
		
		emp.setEname("Pravin");
		
		Tester2 tes=new Tester2();
		tes.setEname("Vishal");
		tes.setSalary(50000);
		tes.setProjectClient("HCl");
		
		Developer2 dev=new Developer2();
		dev.setEname("Saurabh");
		dev.setSalary(30000);
		dev.setProjectClient("TCS");
		
		session.save(emp);
		session.save(dev);
		session.save(tes);
		
		session.beginTransaction().commit();
		System.out.println("Done");
				
		
	}

}
//mysql> select * from Employee2;
//+-----+--------+
//| eid | ename  |
//+-----+--------+
//|   1 | Pravin |
//+-----+--------+
//1 row in set (0.00 sec)
//
//mysql> select * from developer2;
//+-----+---------+-------------------+--------+
//| eid | ename   | projectClient_Dev | salary |
//+-----+---------+-------------------+--------+
//|   2 | Saurabh | TCS               |  30000 |
//+-----+---------+-------------------+--------+
//1 row in set (0.00 sec)
//
//mysql> select * from tester2;
//+-----+--------+-------------------+--------+
//| eid | ename  | projectClient_Tes | salary |
//+-----+--------+-------------------+--------+
//|   3 | Vishal | HCl               |  50000 |
//+-----+--------+-------------------+--------+