package com.todohateoas.todohateoas.hateoas.model;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TaskModel extends RepresentationModel<TaskModel>{
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    private String title;
    private String description;
    private UserModel model;
}
