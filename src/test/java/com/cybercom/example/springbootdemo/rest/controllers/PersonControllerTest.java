package com.cybercom.example.springbootdemo.rest.controllers;

import com.cybercom.example.springbootdemo.entities.PersonEntity;
import com.cybercom.example.springbootdemo.exceptions.PersonException;
import com.cybercom.example.springbootdemo.repos.PersonRepository;
import com.cybercom.example.springbootdemo.rest.responses.PersonResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@WebMvcTest
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private PersonController controller;
    @Mock
    private PersonRepository repository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAll() {
        when(repository.findAll()).thenReturn(getPersonResponseAll());
        List<PersonResponse> list = controller.getAll();

        assertFalse("List is not empty", list.isEmpty());
    }

    @Test
    public void getPersonByID() {
        when(repository.findById(anyInt())).thenReturn(Optional.of(createPersonEntity()));
        ResponseEntity<PersonResponse> e = controller.getPersonByID(1);
        assertEquals("Id does not match", "testuser", e.getBody().getUsername());
    }

    @Test
    public void getPersonByIDThrowsException() {
        when(repository.findById(anyInt())).thenReturn(Optional.empty());
        try{
            controller.getPersonByID(1);
        }catch (PersonException e){
            assertTrue("nope", e.getMessage().contains("Person not found"));
        }
    }

    @Test
    public void searchPersons() {
    }

    @Test
    public void getByRole() {
    }

    @Test
    public void getPersonCourses() {
    }

    @Test
    public void getPersonCoursesByPID() {
    }

    private List<PersonEntity> getPersonResponseAll(){
        return new ArrayList<PersonEntity>(){{
            add(new PersonEntity());
            add(new PersonEntity());
        }};
    }
    private PersonEntity createPersonEntity(){
        PersonEntity e = new PersonEntity();
        e.setId(1);
        e.setFullName("Test testsson");
        e.setUsername("testuser");
        return e;
    }
}