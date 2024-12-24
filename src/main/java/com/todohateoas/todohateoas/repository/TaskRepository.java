package com.todohateoas.todohateoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.todohateoas.todohateoas.model.Task;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
Task findByTitle(String title);
boolean existsByTitle(String title);
}
