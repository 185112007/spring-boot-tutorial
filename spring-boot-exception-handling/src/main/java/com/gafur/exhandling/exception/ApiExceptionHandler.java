package com.gafur.exhandling.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler({Exception.class})
    public String globalEx(){
        return "There is an ex";
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public String entityNotFound(){
        return "Record not found";
    }
}
