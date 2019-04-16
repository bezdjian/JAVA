package com.cybercom.example.springbootdemo.repos;

import com.cybercom.example.springbootdemo.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    List<PersonEntity> findByRole(String role);

    @Query("select p from PersonEntity p where p.firstname like %?1% and p.lastname like %?2%")
    List<PersonEntity> findByFirstnameAndLastnameCustom(String firstname, String lastname);

    /*@Query("select new com.cybercom.example.springbootdemo.rest.responses.PersonCoursesResponse() p.username, p.firstname, p.lastname, c.coursename, c.description, c.idnumber from PersonEntity p " +
            "join PersoncourseEntity pc on pc.personid = p.id " +
            "join CourseEntity c on c.id = pc.courseid " +
            "where p.id = :pid")
    List<PersonCoursesResponse> findAllPersonCoursesbyPersonId(int pid);*/
}