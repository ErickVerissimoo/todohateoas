package com.todohateoas.todohateoas.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignUpDTO {
    @Valid
    private String email;
    @Size(min = 8)
    private String password;
}
