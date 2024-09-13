package com.bistrocontrol.bistro_control.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record RegisterUserForm(
    @NotEmpty @Size(min = 5, max = 30, message = "O nome deve possuir entre 5 e 30 caracteres") String name,
    @NotEmpty @Email String email,
    @NotEmpty @Size(min = 8, max = 35, message = "A senha deve possuir entre 8 e 35 caracteres") String password,
    @NotEmpty String role) {
    
}
