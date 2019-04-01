package com.cybercom.example.springbootdemo.repos.impl;

import com.cybercom.example.springbootdemo.repos.custom.PersonCoursesRepositoryCustom;
import com.cybercom.example.springbootdemo.rest.responses.PersonCoursesResponse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonCoursesRepositoryCustomImpl implements PersonCoursesRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PersonCoursesResponse> findPersonCoursesByPID(int pid) {
        em.getProperties().entrySet().stream().forEach(System.out::println);

        return em.createQuery(
                "select p.username, p.firstname, p.lastname, c.coursename, c.description, c.idnumber from PersonEntity p " +
                        "join PersoncourseEntity pc on pc.personid = p.id " +
                        "join CourseEntity c on c.id = pc.courseid " +
                        "where p.id = :pid")
                .setParameter("pid", pid)
                .getResultList();

    }
}
