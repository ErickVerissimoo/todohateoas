package com.todohateoas.todohateoas.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.todohateoas.todohateoas.model.Task;
import com.todohateoas.todohateoas.model.User;
import com.todohateoas.todohateoas.repository.UserRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
private final UserRepository repository;
private final PasswordEncoder encoder;
public void cadastro(User user) {
    if(repository.existsByEmail(user.getEmail())){
        throw new EntityExistsException("Entidade já existe");
    }
    user.setPassword(encoder.encode(user.getPassword()));
    repository.saveAndFlush(user);
}
public void addTask(String email, Task task){
User user = repository.findByEmail(email);
if(user == null){
throw new EntityNotFoundException();
}
user.getTasks().add(task);
repository.saveAndFlush(user);
}
public List<User> getAllUsers() {
    return repository.findAll();
}
}
