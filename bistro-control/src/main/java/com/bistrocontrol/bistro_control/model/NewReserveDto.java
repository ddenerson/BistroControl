package com.bistrocontrol.bistro_control.model;


import jakarta.validation.constraints.NotEmpty;

public record NewReserveDto(
    @NotEmpty(message = "É obrigatório informar a quantidade de lugares, no minímo 2.")
    String seats,
    @NotEmpty(message = "A hora deve ser informada.")
    String time,
    @NotEmpty(message = "A data deve ser informada.")
    String date
    ) {
    
}
