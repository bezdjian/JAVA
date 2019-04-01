package com.cybercom.example.springbootdemo.repos;

import com.cybercom.example.springbootdemo.entities.PersoncourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonCourseRepository extends JpaRepository<PersoncourseEntity, Integer> {

    //@Query("select pc from PersoncourseEntity pc where pc.personid = :pid")
    List<PersoncourseEntity> findAllByPersonid(int pid);
}
