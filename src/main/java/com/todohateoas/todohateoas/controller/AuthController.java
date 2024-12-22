package com.todohateoas.todohateoas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todohateoas.todohateoas.dto.SignInDto;
import com.todohateoas.todohateoas.model.User;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
@PostMapping("/auth")
public EntityModel<User> auth(@RequestBody SignInDto entity) {
    
    
    return null;
}

}
