package com.todohateoas.todohateoas.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String email;
private String password;
@JsonInclude(content = JsonInclude.Include.NON_NULL)
private Boolean enabled;

}