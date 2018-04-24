package com.example.jerseyapi.services;

import com.example.jerseyapi.HibernateUtils;
import com.example.jerseyapi.doa.PersonDao;
import com.example.jerseyapi.entities.PersonEntity;
import com.example.jerseyapi.entities.PersoncourseEntity;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by bezdj on 22/04/2018.
 */
public class PersonDaoService implements PersonDao {

    private static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    private static Session session = sessionFactory.getCurrentSession();

    public PersonEntity getPersonById(int personid) {
        // Transacion begin
        if(!session.getTransaction().isActive() && session.getTransaction().getStatus() != TransactionStatus.COMMITTED){
            session.getTransaction().begin();
        }

        // Select the Person by ID
        String getPersonSql = "SELECT p FROM " + PersonEntity.class.getName() + " p WHERE p.id =:personid";

        // Create Query object
        Query query = session.createQuery(getPersonSql);
        query.setParameter("personid", personid);

        // Set the resultList
        List<PersonEntity> personsList = query.getResultList();

        //Return the user
        try{
            if(personsList.get(0) != null){
                //echo
                System.err.println("------- Person with ID : " + personid + " is found!");
                // Commit data.
                //session.getTransaction().commit();
                return personsList.get(0);
            }else{
                //Send empty person entity to manage with if in the post function
                return new PersonEntity();
            }
        }catch (IndexOutOfBoundsException e){
            System.err.println("------- Person with ID : " + personid + " not found! -- " + e.getMessage());
            // Rollback incase of error
            //session.getTransaction().rollback();
            return new PersonEntity();
            //throw new ExceptionInInitializerError(e);
        }finally {
            //HibernateUtils.shutSessionFactoryDown();
            //session.close();
        }
    }

    public PersoncourseEntity getPersonCoursesByPersonId(int personid) {
        return null;
    }
}
