package com.example.jerseyapi.doa;

import com.example.jerseyapi.entities.PersonEntity;
import com.example.jerseyapi.entities.PersoncourseEntity;

/**
 * Created by bezdj on 22/04/2018.
 */
public interface PersonDao {

    public PersonEntity getPersonById(int personid);
    public PersoncourseEntity getPersonCoursesByPersonId(int personid);
}
