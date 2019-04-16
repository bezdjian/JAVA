package com.cybercom.example.springbootdemo.repos.custom;

import com.cybercom.example.springbootdemo.rest.responses.PersonCoursesResponse;
import org.springframework.stereotype.Repository;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface PersonCoursesRepositoryCustom {
    List<PersonCoursesResponse> findPersonCoursesByPID(int pid) throws NamingException, SQLException;
}
