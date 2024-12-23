package com.todohateoas.todohateoas.config;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionGlobalHandler {
    @ExceptionHandler(exception = EntityExistsException.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
public Map<String, String> entityExists(EntityExistsException e){
    return Map.of("message", "Usuário já existe");

}
@ExceptionHandler(exception =  EntityNotFoundException.class)
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public Map<String, String> entityNotFound(EntityNotFoundException ex){
    return Map.of("message", "Usuário não encontrado");

}
}
