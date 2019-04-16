package com.cybercom.example.springbootdemo.repos.impl;

import com.cybercom.example.springbootdemo.repos.custom.PersonCoursesRepositoryCustom;
import com.cybercom.example.springbootdemo.rest.responses.PersonCoursesResponse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PersonCoursesRepositoryCustomImpl implements PersonCoursesRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PersonCoursesResponse> findPersonCoursesByPID(int pid) {
        em.getProperties().entrySet().stream().forEach(System.out::println);
        //p.username, p.firstname, p.lastname, c.coursename, c.description, c.idnumber
        String query = "select new com.cybercom.example.springbootdemo.rest.responses.PersonCoursesResponse" +
                "(p.username, p.firstname, p.lastname, c.coursename, c.description, c.idnumber) " +
                "from PersonEntity AS p " +
                "join PersoncourseEntity AS pc on pc.personid = p.id " +
                "join CourseEntity AS c on c.id = pc.courseid " +
                "where p.id = :pid";
        TypedQuery<PersonCoursesResponse> response =
                em.createQuery(query, PersonCoursesResponse.class)
                .setParameter("pid", pid);
        return response.getResultList();

    }
}
