package com.cybercom.example.springbootdemo.repos;

import com.cybercom.example.springbootdemo.entities.PersoncourseEntity;
import com.cybercom.example.springbootdemo.rest.responses.PersonCoursesResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonCourseRepository extends JpaRepository<PersoncourseEntity, Integer> {

    //@Query("select pc from PersoncourseEntity pc where pc.personid = :pid")
    List<PersoncourseEntity> findAllByPersonid(int pid);

    @Query("select new com.cybercom.example.springbootdemo.rest.responses.PersonCoursesResponse" +
            "(p.username, p.firstname, p.lastname, c.coursename, c.description, c.idnumber) " +
            "from PersonEntity AS p " +
            "join PersoncourseEntity AS pc on pc.personid = p.id " +
            "join CourseEntity AS c on c.id = pc.courseid " +
            "where p.id = :pid")
    List<PersonCoursesResponse> findAllPersonCoursesbyPersonId(int pid);
}
