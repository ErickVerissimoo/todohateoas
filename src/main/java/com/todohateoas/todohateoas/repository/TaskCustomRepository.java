package com.todohateoas.todohateoas.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.todohateoas.todohateoas.model.Task;
import com.todohateoas.todohateoas.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TaskCustomRepository {
@PersistenceContext private EntityManager manager;




    


}
