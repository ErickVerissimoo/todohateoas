package com.todohateoas.todohateoas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todohateoas.todohateoas.dto.SignUpDTO;
import com.todohateoas.todohateoas.model.User;
import com.todohateoas.todohateoas.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/public")
@Validated
@RequiredArgsConstructor
public class AuthController {
    private final ModelMapper mapper;
    private final UserService service;

@PostMapping("/cadastro")
public EntityModel<User> signup(@RequestBody SignUpDTO entity) {
    EntityModel<User> user = EntityModel.of(mapper.map(entity, User.class));
    service.cadastro(user.getContent());
    
    return user;
}

}
