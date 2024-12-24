package com.todohateoas.todohateoas.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String email;
private String password;
    @JsonManagedReference
@OneToMany(mappedBy = "user", fetch = FetchType.EAGER,cascade = {CascadeType.ALL}, orphanRemoval = true)
private List<Task> tasks;

}
