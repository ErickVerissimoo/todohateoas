package com.todohateoas.todohateoas.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class SignInDto {
private Integer id;
private String email;
private String password;
}
