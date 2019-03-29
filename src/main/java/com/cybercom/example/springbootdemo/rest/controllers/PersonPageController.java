package com.cybercom.example.springbootdemo.rest.controllers;

import com.cybercom.example.springbootdemo.entities.PersonEntity;
import com.cybercom.example.springbootdemo.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonPageController {


    @Autowired
    private PersonRepository personRepository;

    @GetMapping(value = "/home")
    public String showAllPersons(Model model){
        List<PersonEntity> persons = personRepository.findAll();
        model.addAttribute("personlist", persons);
        model.addAttribute("module", "home");
        return "persons";
    }
}
