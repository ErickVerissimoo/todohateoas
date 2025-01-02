package com.todohateoas.todohateoas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todohateoas.todohateoas.hateoas.assembler.TaskModelAssembler;
import com.todohateoas.todohateoas.service.TaskService;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users/tasks")
public class TaskController {
private final TaskModelAssembler assembler;
private final TaskService service;


}
