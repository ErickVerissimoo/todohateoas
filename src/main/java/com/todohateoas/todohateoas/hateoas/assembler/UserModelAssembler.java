package com.todohateoas.todohateoas.hateoas.assembler;

import java.lang.reflect.Method;
import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpMethod;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import com.todohateoas.todohateoas.controller.UserController;
import com.todohateoas.todohateoas.dto.TaskDto;
import com.todohateoas.todohateoas.hateoas.model.UserModel;
import com.todohateoas.todohateoas.model.User;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, UserModel>{
    private final ModelMapper mapper;
    @Override
    @NonNull
    public UserModel toModel( @NonNull User entity) {
        
        var model = mapper.map(entity, UserModel.class);
         Method method = ClassUtils.getMethod(UserController.class, "add", Principal.class, TaskDto.class);
        model.add(linkTo(method).withRel("create").withType(HttpMethod.POST.name()));
     //  model.add(linkTo(method2).withRel("delete").withType(HttpMethod.DELETE.name()));
        return  model;   
  


    }

}
