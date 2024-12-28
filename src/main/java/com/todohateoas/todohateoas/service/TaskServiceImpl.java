package com.todohateoas.todohateoas.service;

import org.springframework.stereotype.Service;

import com.todohateoas.todohateoas.exceptions.TaskNotFoundException;
import com.todohateoas.todohateoas.model.Task;
import com.todohateoas.todohateoas.model.User;
import com.todohateoas.todohateoas.repository.TaskRepository;
import com.todohateoas.todohateoas.repository.UserRepository;
import com.todohateoas.todohateoas.utils.EntityUtils;


@Service
public class TaskServiceImpl implements TaskService{
    
    private TaskRepository repository;
    private UserRepository userRepository;
    @Override
    public User addTask(Task task, String userEmail) {
    var e = EntityUtils.findUserByEmail(userEmail);
    e.getTasks().add(task);
    task.setUser(e);
    userRepository.saveAndFlush(e);
    return e;
    }

    @Override
    public void updateTask(Task task) {
        repository.saveAndFlush(task);
    }

    @Override
    public Task deleteTask(Integer id) {
        var user = repository.findById(id).orElseThrow(TaskNotFoundException::new);
        repository.deleteById(id);
        return user;
    }

    @Override
    public Task findOne(Integer id) {
return repository.findById(id).orElseThrow(TaskNotFoundException::new);


    }

    
}
