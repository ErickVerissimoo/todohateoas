package com.todohateoas.todohateoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todohateoas.todohateoas.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
Boolean existsByEmail(String email);
User findByEmail(String email);
}
