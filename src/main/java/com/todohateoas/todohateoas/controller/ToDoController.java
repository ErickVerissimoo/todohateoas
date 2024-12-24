package com.todohateoas.todohateoas.controller;

import java.security.Principal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todohateoas.todohateoas.dto.TaskDto;
import com.todohateoas.todohateoas.model.Task;
import com.todohateoas.todohateoas.model.User;
import com.todohateoas.todohateoas.service.ToDoService;
import com.todohateoas.todohateoas.service.UserService;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class ToDoController {
    

    final private UserService service;
    private final ModelMapper mapper;
    private final ToDoService service2;
    @PostMapping
public String teste(@NotNull  Principal principal, @RequestBody TaskDto dto){
  
service.addTask(principal.getName(), mapper.map(dto, Task.class));
    return "Task adicionada";
}
@GetMapping
public ResponseEntity<List<Task>> getAll() {
    return ResponseEntity.ok(service2.getAll());
}
@GetMapping("/users")
public ResponseEntity<List<User>> users() {
    return ResponseEntity.ok(service.getAllUsers());
}


}
