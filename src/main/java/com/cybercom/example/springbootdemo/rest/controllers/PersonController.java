package com.cybercom.example.springbootdemo.rest.controllers;

import com.cybercom.example.springbootdemo.entities.PersonEntity;
import com.cybercom.example.springbootdemo.entities.PersoncourseEntity;
import com.cybercom.example.springbootdemo.exceptions.PersonException;
import com.cybercom.example.springbootdemo.repos.PersonCourseRepository;
import com.cybercom.example.springbootdemo.repos.PersonRepository;
import com.cybercom.example.springbootdemo.repos.impl.PersonCoursesRepositoryCustomImpl;
import com.cybercom.example.springbootdemo.rest.responses.PersonCoursesResponse;
import com.cybercom.example.springbootdemo.rest.responses.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/person", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class PersonController {

    private static String PERSON_NOT_FOUND_WITH = "Person not found with ";

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonCourseRepository personCourseRepository;
    @Autowired
    private PersonCoursesRepositoryCustomImpl personCoursesRepositoryCustom;

    @RequestMapping(value = "/all")
    @ResponseBody
    public List<PersonResponse> getAll(){
        return personRepository.findAll()
                .stream().map(PersonResponse::new).collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<PersonResponse> getPersonByID(@PathVariable int id){
        Optional<PersonEntity> optionalPersonEntity = personRepository.findById(id);
        if(optionalPersonEntity.isPresent()){
            PersonEntity p = optionalPersonEntity.get();
            return new ResponseEntity<>(new PersonResponse(p), HttpStatus.OK);
        }
        throw new PersonException("Person not found with ID " + id);
    }

    @GetMapping("/search/{firstname}/{lastname}")
    public List<PersonEntity> searchPersons(@PathVariable String firstname, @PathVariable String lastname){
        List<PersonEntity> personEntities = personRepository.findByFirstnameAndLastnameCustom(firstname, lastname);
        if(personEntities.isEmpty()){
            throw new PersonException(PERSON_NOT_FOUND_WITH + " firstname " + firstname + " and lastname " + lastname);
        }
        return personEntities;

    }

    @GetMapping("/withrole/{role}")
    public List<PersonResponse> getByRole(@PathVariable String role){
        List<PersonEntity> personEntities = personRepository.findByRole(role);
        if(personEntities.isEmpty()) throw new PersonException(PERSON_NOT_FOUND_WITH + "role " + role);
        return personEntities.stream().map(PersonResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/courses/{pid}") // Spring boot way!!!
    public List<PersonCoursesResponse> getPersonCourses(@PathVariable String pid){
        int id = Integer.valueOf(pid);
        List<PersonCoursesResponse> pce = personRepository.findAllPersonCoursesbyPersonId(id);
        if(pce.isEmpty()) throw new PersonException("No courses were found for person with ID " + id);
        return pce;
    }

    @GetMapping("/coursesv2/{id}")
    public List<PersonCoursesResponse> getPersonCoursesByPID(@PathVariable String id){
        int pid = Integer.valueOf(id);
        List<PersonCoursesResponse> pce = personCoursesRepositoryCustom.findPersonCoursesByPID(pid);
        if(pce.isEmpty()) throw new PersonException("No courses were found for person with ID " + id);
        return pce;
    }
}
