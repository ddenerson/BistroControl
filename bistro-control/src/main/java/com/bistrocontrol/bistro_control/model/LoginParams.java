package com.bistrocontrol.bistro_control.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record LoginParams(
    @NotEmpty @Email String email, 
    @NotEmpty @Size(min = 8, max = 35) String password) {
}
