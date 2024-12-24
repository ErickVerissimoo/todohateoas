package com.todohateoas.todohateoas.hateoas.model;

import org.springframework.hateoas.RepresentationModel;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserModel extends RepresentationModel<UserModel> {
private Integer id;
private String email;
private String password;
}
