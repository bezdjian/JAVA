package com.cybercom.example.springbootdemo.exceptions;

public class PersonException extends RuntimeException {
    public PersonException(String msg){
        super(msg);
    }
}