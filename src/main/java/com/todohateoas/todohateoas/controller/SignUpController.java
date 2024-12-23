package com.todohateoas.todohateoas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todohateoas.todohateoas.dto.SignInDto;
import com.todohateoas.todohateoas.dto.SignUpDTO;
import com.todohateoas.todohateoas.model.User;
import com.todohateoas.todohateoas.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/public")
@Validated
@RequiredArgsConstructor
public class SignUpController {
    private final ModelMapper mapper;
    private final UserService service;

@PostMapping("/cadastro")
public ResponseEntity<User> signup(@RequestBody @Valid SignUpDTO entity) {
var e = mapper.map(entity, User.class);
    service.cadastro(e);
    
    return ResponseEntity.ok().body(e);
}

}
