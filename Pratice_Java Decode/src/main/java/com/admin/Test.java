package com.admin;

import org.hibernate.Session;

import com.dbutil.HibernateUtil;
import com.model.Contact_Info;
import com.model.User_Details;

public class Test {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		User_Details user1 = new User_Details();
		user1.setFirstName("First");
		user1.setLastName("User");

		Contact_Info contact1 = new Contact_Info();
		contact1.setEmailId("email1-firstuser@email.com");
		contact1.setPhoneNo("11111111");

		user1.setContact(contact1);

		contact1.setUser(user1);
		
		User_Details user2 = new User_Details();
		user2.setFirstName("Second");
		user2.setLastName("User");
			
		Contact_Info contact2 = new Contact_Info();
		contact2.setEmailId("email2-firstuser@email.com");
		contact2.setPhoneNo("22222222");
		
		user2.setContact(contact2);
	
		contact2.setUser(user2);
		
		session.save(user1);
		session.save(user2);
		session.beginTransaction().commit();
		
	}

}
