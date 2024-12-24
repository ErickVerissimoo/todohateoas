package com.todohateoas.todohateoas.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    @Email(message = "Email inválido")
    private String email;
    @Size(min = 8)
    private String password;
}
