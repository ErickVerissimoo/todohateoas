package com.todohateoas.todohateoas.service;

import java.util.Objects;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todohateoas.todohateoas.model.User;
import com.todohateoas.todohateoas.repository.UserRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
private final UserRepository repository;

@Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = repository.findByEmail(email);
    if(Objects.isNull(user)){
throw new UsernameNotFoundException("Usuário não encontrado");
    }
    return org.springframework.security.core.userdetails.User.withUsername(user.getEmail()).password(user.getPassword()).roles("USER").build();
}
}
