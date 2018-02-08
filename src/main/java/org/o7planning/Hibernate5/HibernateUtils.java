package org.o7planning.Hibernate5;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	// Hibernate 5
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the ServiceRegistry from hibernate.cfg.xml
			ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			
			// Create metadata sources using the specified service registry
			Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
			
			return metadata.getSessionFactoryBuilder().build();
		}catch (Throwable ex) {
			System.err.println("Initial Sessionfactory creation failed. " + ex.getMessage());
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutDown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
