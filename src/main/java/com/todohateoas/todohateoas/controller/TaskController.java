package com.todohateoas.todohateoas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import com.todohateoas.todohateoas.hateoas.assembler.TaskModelAssembler;
import com.todohateoas.todohateoas.hateoas.model.TaskModel;
import com.todohateoas.todohateoas.service.TaskService;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.ForkJoinPool;

import org.springframework.web.bind.annotation.DeleteMapping;
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
    return assembler.toModel(service.findOne(Integer.parseInt(id)));
}

@DeleteMapping("/{id}")
public DeferredResult<TaskModel> deleteTask(@PathVariable String id) {
    DeferredResult<TaskModel> deferred = new DeferredResult<>();
    ForkJoinPool.commonPool().submit(() ->         deferred.setResult(assembler.toModel(service.deleteTask(Integer.parseInt(id)))));
return deferred;

    }


}
