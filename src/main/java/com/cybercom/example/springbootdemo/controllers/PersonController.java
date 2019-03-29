package com.cybercom.example.springbootdemo.controllers;

import com.cybercom.example.springbootdemo.entities.PersonEntity;
import com.cybercom.example.springbootdemo.exceptions.PersonException;
import com.cybercom.example.springbootdemo.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<PersonEntity> getAll(){
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public PersonEntity getPerson(@PathVariable int id){
        Optional<PersonEntity> optionalPersonEntity = personRepository.findById(id);
        if(optionalPersonEntity.isPresent()){
            return optionalPersonEntity.get();
        }
        throw new PersonException("Person not found with ID " + id);
    }

    @GetMapping("/search/{firstname}/{lastname}")
    public List<PersonEntity> searchPersons(@PathVariable String firstname, @PathVariable String lastname){
        List<PersonEntity> personEntities = personRepository.findByFirstnameAndLastnameCustom(firstname, lastname);
        if(personEntities.isEmpty()){
            throw new PersonException("Persons not found with firstname " + firstname + " and lastname " + lastname);
        }
        return personEntities;

    }

    @GetMapping("/withrole/{role}")
    public List<PersonEntity> getByRole(@PathVariable String role){
        List<PersonEntity> personEntities = personRepository.findByRole(role);
        return personEntities;
    }
}
