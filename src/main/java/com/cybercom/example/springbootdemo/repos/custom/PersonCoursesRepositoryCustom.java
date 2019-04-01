package com.cybercom.example.springbootdemo.repos.custom;

import com.cybercom.example.springbootdemo.rest.responses.PersonCoursesResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

//NOTE: Not using it anywhere, just lying here to see custom made query repos
@Repository
public interface PersonCoursesRepositoryCustom {
    List<PersonCoursesResponse> findPersonCoursesByPID(int pid);
}
