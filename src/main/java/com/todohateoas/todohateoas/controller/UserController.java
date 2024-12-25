package com.todohateoas.todohateoas.controller;

import java.security.Principal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todohateoas.todohateoas.dto.TaskDto;
import com.todohateoas.todohateoas.hateoas.assembler.UserModelAssembler;
import com.todohateoas.todohateoas.hateoas.model.UserModel;
import com.todohateoas.todohateoas.model.Task;
import com.todohateoas.todohateoas.model.User;
import com.todohateoas.todohateoas.service.UserService;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    

    final private UserService service;
    private final ModelMapper mapper;
    private final UserModelAssembler assembler;
    @PostMapping
public UserModel add(@NotNull  Principal principal, @RequestBody TaskDto dto){

var user =     service.addTask(principal.getName(), mapper.map(dto, Task.class));
return assembler.toModel(user);
}
@DeleteMapping
public UserModel deleteTask(@RequestBody TaskDto dto){
    var task = service.delete(mapper.map(dto, Task.class));
    return null;
}

@GetMapping("/users")
public ResponseEntity<List<User>> users() {
    return ResponseEntity.ok(service.getAllUsers());
}


}
