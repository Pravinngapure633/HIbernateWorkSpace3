package com.admin;

import org.hibernate.Session;

import com.dbutil.HibernateUtil;
import com.model.Employee;
import com.model.EmployeeId;

public class Test {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Employee emp=new Employee();
		emp.setEmpName("Pravin");
		
		EmployeeId e=new EmployeeId();
		e.setEid(102);
		e.setMobileNo(9404305184l);
		
		emp.setEmpId(e);
		
		session.save(emp);
		session.beginTransaction().commit();
		System.out.println("Done");
	}
}
//mysql> desc employee;
//+----------+--------------+------+-----+---------+-------+
//| Field    | Type         | Null | Key | Default | Extra |
//+----------+--------------+------+-----+---------+-------+
//| eid      | int(11)      | NO   | PRI |         |       |
//| mobileNo | bigint(20)   | NO   | PRI |         |       |
//| empName  | varchar(255) | YES  |     | NULL    |       |
//+----------+--------------+------+-----+---------+-------+