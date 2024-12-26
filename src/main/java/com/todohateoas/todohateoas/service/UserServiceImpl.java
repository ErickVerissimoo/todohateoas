package com.todohateoas.todohateoas.service;

import org.springframework.data.domain.Example;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.todohateoas.todohateoas.dto.TaskDto;
import com.todohateoas.todohateoas.exceptions.TaskExistsException;
import com.todohateoas.todohateoas.model.Task;
import com.todohateoas.todohateoas.model.User;
import com.todohateoas.todohateoas.repository.TaskRepository;
import com.todohateoas.todohateoas.repository.UserRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService  {
 

private final UserRepository repository;
private final PasswordEncoder encoder;
private final TaskRepository taskRepository;

@Override
public User findOne(Integer id) {
return repository.findById(id).orElseThrow(EntityNotFoundException::new);    

}
@Override
public void deleteOne(Integer id) {
repository.deleteById(id);    

}
@Override
public User updateOne(User user) {
Example<User> example = Example.of(user);
User e = repository.findOne(example).orElseThrow(EntityNotFoundException::new);
repository.saveAndFlush(e);
return e;


}
@Override
public User addOne(User user) {
    if(repository.existsByEmail(user.getEmail())){
        throw new EntityExistsException();
    }
    user.setPassword(encoder.encode(user.getPassword()));
    repository.saveAndFlush(user);
    return user;
}}



