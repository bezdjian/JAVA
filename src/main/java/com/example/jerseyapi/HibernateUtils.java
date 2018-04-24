package com.example.jerseyapi;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by bezdj on 22/04/2018.
 */
public class HibernateUtils {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory(){
        try{
            // Create the ServiceRegistry from hibernate.cfg.xml
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

            // Create metadata sources using the specified service registry.
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        }catch (Throwable t){
            System.err.println("SessionFactory creation failed! - " + t.getMessage());
            throw new ExceptionInInitializerError(t);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutSessionFactoryDown(){
        getSessionFactory().close();
    }
}
