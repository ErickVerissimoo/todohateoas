package com.todohateoas.todohateoas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todohateoas.todohateoas.model.Task;
import com.todohateoas.todohateoas.repository.TaskRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@RequiredArgsConstructor
@Service
@Log4j2
public class ToDoService {
private final TaskRepository repository;
public List<Task> getAll() {
    
    return repository.findAll();
}
}
