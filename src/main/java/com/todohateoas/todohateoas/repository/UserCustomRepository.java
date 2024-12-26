package com.todohateoas.todohateoas.repository;


import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import com.todohateoas.todohateoas.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@Repository
public class UserCustomRepository {
   @PersistenceContext private EntityManager manager;

public User findUserByTaskId(Integer taskId) {
    CriteriaBuilder cb = manager.getCriteriaBuilder();
    CriteriaQuery<User> cq = cb.createQuery(User.class);
    Root<Task> task = cq.from(Task.class);
    Join<Task, User> userJoin = task.join("user", JoinType.INNER);
    cq.select(userJoin).where(cb.equal(task.get("id"), taskId));
    TypedQuery<User> typedQuery = manager.createQuery(cq);
    return typedQuery.getSingleResult();
}


}


