package com.admin;

import java.util.Scanner;

import org.hibernate.Session;

import com.dbutil.HibernateUtil;
import com.model.Developer1;
import com.model.Employee1;
import com.model.Tester1;

public class Test {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Employee1 emp=new Employee1();
		
		emp.setEname("Pravin");
		
		Tester1 tes=new Tester1();
		tes.setEname("Vishal");
		tes.setSalary(50000);
		tes.setProjectClient("HCl");
		
		Developer1 dev=new Developer1();
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
//mysql> select * from employee1;
						//pk
//+--------------------+-----+---------+
//| Instance           | eid | ename   |
//+--------------------+-----+---------+
//| Employee1          |   1 | Pravin  |
//| Develpoer_Instance |   2 | Saurabh |
//| Tester_Instance    |   3 | Vishal  |
//+--------------------+-----+---------+

//mysql> select * from developer1;
								//fk
//+-------------------+--------+-----+
//| projectClient_Dev | salary | eid |
//+-------------------+--------+-----+
//| TCS               |  30000 |   2 |
//+-------------------+--------+-----+

//
//mysql> select * from tester1;
								//fk
//+-------------------+--------+-----+
//| projectClient_Tes | salary | eid |
//+-------------------+--------+-----+
//| HCl               |  50000 |   3 |
//+-------------------+--------+-----+