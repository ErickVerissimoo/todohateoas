package com.todohateoas.todohateoas.service;

import org.springframework.stereotype.Service;

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
    public Task updateTask(Task task, String userEmail) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTask'");
    }

    @Override
    public void deleteTask(Integer id, String userEmail) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTask'");
    }

    @Override
    public Task findOne(Integer id, String userEmail) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    
}
