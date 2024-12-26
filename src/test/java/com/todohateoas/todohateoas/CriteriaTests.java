package com.todohateoas.todohateoas;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.todohateoas.todohateoas.model.Task;
import com.todohateoas.todohateoas.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CriteriaTests {
   @PersistenceContext private  EntityManager manager;

@Test
void teste(){
    CriteriaBuilder cb = manager.getCriteriaBuilder();
    CriteriaQuery<User> cq = cb.createQuery(User.class);
    Root<Task> task = cq.from(Task.class);
    Join<Task, User> userJoin = task.join("user", JoinType.INNER);
    cq.select(userJoin).where(cb.equal(task.get("id"), 14));
    TypedQuery<User> typedQuery = manager.createQuery(cq);
    var e = typedQuery.getSingleResult();
    System.out.println(e.getEmail());
}
@Test
void testetwo(){
        Query query = manager.createQuery("select p from User p where p.email=:email").setParameter("email", "erickverissimoteste@gmail.com");
    User user =(User) query.getSingleResult() ;
    Assertions.assertThat(user!=null);
    System.out.println(user.getPassword());
}
}
