package com.todohateoas.todohateoas.service;

import com.todohateoas.todohateoas.model.Task;
import com.todohateoas.todohateoas.model.User;

public interface TaskService {
User addTask(Task task, String userEmail);
void updateTask(Task task);
void deleteTask(Integer id, String userEmail);
Task findOne(Integer id);
}
