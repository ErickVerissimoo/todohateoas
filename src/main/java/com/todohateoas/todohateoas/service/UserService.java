package com.todohateoas.todohateoas.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.todohateoas.todohateoas.model.Task;
import com.todohateoas.todohateoas.model.User;
import com.todohateoas.todohateoas.repository.TaskRepository;
import com.todohateoas.todohateoas.repository.UserRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
private final UserRepository repository;
private final PasswordEncoder encoder;
private final TaskRepository taskRepository;
public User cadastro(User user) {
    if(repository.existsByEmail(user.getEmail())){
        throw new EntityExistsException();
    }
    user.setPassword(encoder.encode(user.getPassword()));
    repository.saveAndFlush(user);
    return user;
}
public User addTask(String email, Task task){
User user = repository.findByEmail(email);
if(user == null){
throw new EntityNotFoundException();
}
if(taskRepository.existsByTitle(task.getTitle())){

}
task.setUser(user);
user.getTasks().add(task);
repository.save(user);
return user;
}

public Task delete(Task task) {
Task task2 = taskRepository.findByTitle(task.getTitle());
taskRepository.deleteById(task2.getId());
 return task2;   
}

public List<User> getAllUsers() {
    return repository.findAll();
}
}
