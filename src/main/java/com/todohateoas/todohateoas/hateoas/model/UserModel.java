package com.todohateoas.todohateoas.hateoas.model;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class UserModel extends RepresentationModel<UserModel> {
private Integer id;
private String email;
private String password;
private List<TaskModel> tasks;
}
