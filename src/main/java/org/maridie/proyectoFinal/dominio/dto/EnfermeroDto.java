package org.maridie.proyectoFinal.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EnfermeroDto {

    @PositiveOrZero
    Integer id_enfermero;

    @NotBlank(message = "Los nombre  es obligatorio")
    String nombres;

    @NotBlank(message = "Los apellidos es obligatorio")
    String apellidos;

    @NotBlank(message = "El colegiado es obligatorio")
    String colegiado;

    @NotBlank(message = "El telefono es obligatorio")
    String telefono;

    @NotBlank(message = "El email es obligatorio")
    String email;

    @NotNull(message = "El centro es obligatorio")
    Integer id_centro;

    @NotNull(message = "El centro es obligatorio")
    Integer idUsuario;

}
