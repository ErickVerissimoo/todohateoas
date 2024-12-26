package com.todohateoas.todohateoas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todohateoas.todohateoas.hateoas.assembler.TaskModelAssembler;
import com.todohateoas.todohateoas.hateoas.model.TaskModel;
import com.todohateoas.todohateoas.repository.TaskRepository;
import com.todohateoas.todohateoas.service.TaskService;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users/tasks")
public class TaskController {
private final TaskModelAssembler assembler;
private final TaskService service;

@GetMapping("/{id}")
public TaskModel findTask(@PathVariable String id) {
    return assembler.toModel(service.getById(id));
}

}
