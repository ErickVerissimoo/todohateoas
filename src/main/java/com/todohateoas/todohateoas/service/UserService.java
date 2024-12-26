package com.todohateoas.todohateoas.service;

import com.todohateoas.todohateoas.model.Task;
import com.todohateoas.todohateoas.model.User;

public interface UserService {
    User findOne(Integer id);
    void deleteOne(Integer id);
    User updateOne(User user);
    User addOne(User user);

    
}
