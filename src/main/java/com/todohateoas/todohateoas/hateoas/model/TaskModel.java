package com.todohateoas.todohateoas.hateoas.model;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TaskModel extends RepresentationModel<TaskModel>{
    private String title;
    private String description;
}
