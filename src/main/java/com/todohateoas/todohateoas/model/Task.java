package com.todohateoas.todohateoas.model;

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
private String titlse;
private String description;
@ManyToOne
@JoinColumn(name = "user_id")
private User user;
}
