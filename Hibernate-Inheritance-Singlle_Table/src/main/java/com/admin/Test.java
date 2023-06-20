package com.admin;

import java.util.Scanner;

import org.hibernate.Session;

import com.dbutil.HibernateUtil;
import com.model.Developer;
import com.model.Employee;
import com.model.Tester;

public class Test {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Employee emp=new Employee();
		
		emp.setEname("Pravin");
		
		Tester tes=new Tester();
		tes.setEname("Vishal");
		tes.setSalary(50000);
		tes.setProjectClient("HCl");
		
		Developer dev=new Developer();
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
//+--------------------+-----+---------+-------------------+--------+-------------------+
//| Instance           | eid | ename   | projectClient_Tes | salary | projectClient_Dev |
//+--------------------+-----+---------+-------------------+--------+-------------------+
//| Employee           |   1 | Pravin  | NULL              |   NULL | NULL              |
//| Develpoer_Instance |   2 | Saurabh | NULL              |  30000 | TCS               |
//| Tester_Instance    |   3 | Vishal  | HCl               |  50000 | NULL              |
//+--------------------+-----+---------+-------------------+--------+-------------------+