package com.cybercom.example.springbootdemo.repos.custom;

import com.cybercom.example.springbootdemo.entities.PersonEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepositoryCustom{
    List<PersonEntity> findByFirstnameAndOrLastname(String firstname, String lastname);
}
