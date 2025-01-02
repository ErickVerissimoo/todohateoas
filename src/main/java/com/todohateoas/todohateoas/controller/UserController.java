package com.todohateoas.todohateoas.controller;

import java.security.Principal;
import java.time.Duration;

import org.modelmapper.ModelMapper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.todohateoas.todohateoas.dto.TaskDto;
import com.todohateoas.todohateoas.hateoas.assembler.UserModelAssembler;
import com.todohateoas.todohateoas.hateoas.model.UserModel;
import com.todohateoas.todohateoas.model.Task;
import com.todohateoas.todohateoas.service.TaskServiceImpl;
import com.todohateoas.todohateoas.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

private final UserServiceImpl service;
private final UserModelAssembler assembler;
private final ThreadPoolTaskExecutor executor;
private final TaskServiceImpl impl;
private final ModelMapper mapper;
@PostMapping
public DeferredResult<UserModel> addTask(Principal Principal, TaskDto dto){
    DeferredResult<UserModel> model = new DeferredResult<>();
    executor.submit(()-> {
        var e= impl.addTask(mapper.map(dto, Task.class), Principal.getName());
        model.setResult( assembler.toModel(e));

    });
    
    return model;
}
@DeleteMapping("/{id}")
public DeferredResult<UserModel> deleteTask(@PathVariable String id, Principal principal){
    DeferredResult<UserModel> model = new DeferredResult<>(Duration.ofSeconds(3).toSeconds());  
    executor.submit(() -> {
        var task = impl.deleteTask(Integer.parseInt(id));
  model.setResult(         assembler.toModel( service.findByEmail(task.getUser().getEmail())));
    });
return model;
}
@PutMapping
public DeferredResult<UserModel> put( @RequestBody TaskDto entity, Principal principal) {
    DeferredResult<UserModel> model = new DeferredResult<>(Duration.ofSeconds(2).toSeconds());
    executor.submit(() -> {
        impl.updateTask(mapper.map(model, Task.class));
    });    
    return model;
}
}
