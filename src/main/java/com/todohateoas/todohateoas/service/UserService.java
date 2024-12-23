package com.todohateoas.todohateoas.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
}
