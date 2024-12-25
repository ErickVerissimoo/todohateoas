package com.todohateoas.todohateoas;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.simple.JdbcClient;
import com.todohateoas.todohateoas.model.Task;
import com.todohateoas.todohateoas.model.User;
import com.todohateoas.todohateoas.repository.TaskRepository;
import com.todohateoas.todohateoas.repository.UserRepository;

import jakarta.inject.Inject;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EntitiesTests {
    @Inject
    private JdbcClient client;
    @Inject private UserRepository repository;
    @Inject private TaskRepository taskRepository;
@Test
@Order(1)
void test(){
User user = new User();
user.setEmail("erickverissimodasilva144@gmail.com");
user.setPassword("erick12345");
Task task = new Task();
task.setUser(user);
repository.save(user);
taskRepository.save(task);
System.out.println("User salvado");
}

@Test
@Order(2)

void test2(){
    String email = client.sql("SELECT p.email FROM tarefa t INNER JOIN usuarios p ON t.user_id = p.id WHERE t.user_id = 1")
    .query(rs ->{
while (rs.next()) {
    return rs.getString("email");
}
return null;

    }  );
    System.out.println(email);
}
}
