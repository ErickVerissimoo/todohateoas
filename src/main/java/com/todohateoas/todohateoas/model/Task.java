package com.todohateoas.todohateoas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tarefa")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String title;
private String description;
@ManyToOne
@JoinColumn(name = "user_id")
    @JsonBackReference
private User user;
}
