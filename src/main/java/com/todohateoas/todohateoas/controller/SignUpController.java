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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/public/auth")
@Validated
@RequiredArgsConstructor
public class SignUpController {
    private final ModelMapper mapper;
    private final UserService service;

@PostMapping("/cadastro")
public EntityModel<User> signup(@RequestBody @Valid SignUpDTO entity) {

    EntityModel<User> user = EntityModel.of(mapper.map(entity, User.class));
    service.cadastro(user.getContent());
    
    user.add(linkTo(methodOn(AuthController.class).auth(mapper.map(entity, SignInDto.class))).withSelfRel().withType(HttpMethod.POST.name()) );
    return user;
}

}
