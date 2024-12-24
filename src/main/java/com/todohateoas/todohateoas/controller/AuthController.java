package com.todohateoas.todohateoas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.todohateoas.todohateoas.dto.UserDto;
import com.todohateoas.todohateoas.dto.TaskDto;
import com.todohateoas.todohateoas.hateoas.assembler.UserModelAssembler;
import com.todohateoas.todohateoas.hateoas.model.UserModel;
import com.todohateoas.todohateoas.model.User;
import com.todohateoas.todohateoas.service.UserService;

import lombok.RequiredArgsConstructor;

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
    private final UserModelAssembler assembler;
@PostMapping("/cadastro")
public UserModel signup(@RequestBody UserDto entity) throws NoSuchMethodException, SecurityException {
return    assembler.toModel(service.cadastro(mapper.map(entity, User.class)));


}

}
