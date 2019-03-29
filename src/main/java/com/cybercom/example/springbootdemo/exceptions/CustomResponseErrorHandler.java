package com.cybercom.example.springbootdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomResponseErrorHandler extends ResponseEntityExceptionHandler{

    //For custom exceptions
    @ExceptionHandler(PersonException.class)
    public final ResponseEntity<ErrorDetails> handlePersonException(PersonException pe, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), pe.getMessage(),
                request.getDescription(false), HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    //For MethodArgumentTypeMismatchException exceptions
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public final ResponseEntity<ErrorDetails> handleArgumentMismatchException(Exception pe, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), pe.getMessage(),
                request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR.toString());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }


    //For all exceptions
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception pe, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), pe.getMessage(),
                request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR.toString());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
