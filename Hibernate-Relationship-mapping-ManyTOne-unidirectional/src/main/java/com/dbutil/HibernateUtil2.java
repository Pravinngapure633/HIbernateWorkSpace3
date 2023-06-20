package com.dbutil;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.model.One_Persion1;
import com.model.Vehicale1;










public class HibernateUtil2 {
	
private static SessionFactory factory;
	
	public static SessionFactory getSessionFactory()
	{
		if(factory==null || factory.isClosed())
		{
			Map<String, String> map=new HashMap<String, String>();
			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/relationshipmapping");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "root");
			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			map.put(Environment.HBM2DDL_AUTO, "update");
			map.put(Environment.SHOW_SQL,"true");
			map.put(Environment.FORMAT_SQL, "true");
			
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(map).build();
			
			MetadataSources mds = new MetadataSources(registry);
			
			mds.addAnnotatedClass(One_Persion1.class);
			mds.addAnnotatedClass(Vehicale1.class);
			
			Metadata md = mds.getMetadataBuilder().build();
			
			 factory = md.getSessionFactoryBuilder().build();
			return factory;
		}
		return factory;
	}

}
