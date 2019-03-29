package com.cybercom.example.springbootdemo.repos.impl;

import com.cybercom.example.springbootdemo.entities.PersonEntity;
import com.cybercom.example.springbootdemo.repos.custom.PersonRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {


    //NOTE: Leave it here to know how to use EM in custom repos.
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PersonEntity> findByFirstnameAndOrLastname(String firstname, String lastname) {

        em.getProperties().entrySet().stream().forEach(System.out::println);

        return em.createQuery(
                "select p from PersonEntity p where p.firstname like :firstname and p.lastname like :lastname")
                .setParameter("firstname", firstname).setParameter("lastname", lastname)
                .getResultList();
    }
}
