package org.maridie.proyectoFinal.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioDto {
    @PositiveOrZero
    Integer idUsuario;
    @NotBlank(message = "El Nombre es Obligatorio")
    String nombre;
    @NotBlank(message = "La apellido es Obligatorio")
    String apellido;
    @NotBlank(message = "El email es Obligatoria")
    String email;
    @NotBlank(message = "El password es Obligatoria")
    String password;

}
