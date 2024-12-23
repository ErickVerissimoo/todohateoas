package com.todohateoas.todohateoas.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class ToDoController {
    @GetMapping
public String teste(Principal principal){
return principal.getName();
}
}
