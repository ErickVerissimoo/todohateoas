package com.todohateoas.todohateoas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/users/tasks")
public class TaskController {
@GetMapping("path")
public String getMethodName(@RequestParam String param) {
    return new String();
}

}
