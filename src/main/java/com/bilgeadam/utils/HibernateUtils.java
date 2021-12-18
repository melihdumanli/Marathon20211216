package com.bilgeadam.utils;

import com.bilgeadam.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtils {
	private static final SessionFactory sf = sessionFactory();
	
	private static SessionFactory sessionFactory() {
		
		try {
			Configuration configuration = new Configuration();
			//entity's will be added to annotatedClasses below this line
			configuration.addAnnotatedClass(AdminEntity.class);
			configuration.addAnnotatedClass(ArtistEntity.class);
			configuration.addAnnotatedClass(CDEntity.class);
			configuration.addAnnotatedClass(DVDEntity.class);
			configuration.addAnnotatedClass(VinylEntity.class);
			configuration.addAnnotatedClass(CustomerEntity.class);
			configuration.addAnnotatedClass(OrderEntity.class);


			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
		} catch (Exception e) {
			
		}
		return null;
	}
	
	public static SessionFactory getSessionfactory() {
		return sf;
	}
	
}
