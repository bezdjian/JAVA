package com.cybercom.example.springbootdemo.rest.controllers;

import com.cybercom.example.springbootdemo.repos.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

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
        when(repository.findAll()).thenReturn(Collections.emptyList());
    }

    @Test
    public void getPersonByID() {
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
}