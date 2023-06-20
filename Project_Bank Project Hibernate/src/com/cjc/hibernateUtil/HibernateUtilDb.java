package com.cjc.hibernateUtil;




import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtilDb {

	private static SessionFactory factory;

	public static SessionFactory getSessionFactory()
	{
		if(factory==null || factory.isClosed())
		{
			Configuration cfg=new Configuration();
			
			cfg.configure("hibernate.cfg.xml");
			 factory = cfg.buildSessionFactory();
			 return factory;
		}
		else
		{
			return factory;
		}
	}
}
