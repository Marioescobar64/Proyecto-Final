package org.maridie.proyectoFinal.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CentroDto {
    @PositiveOrZero
     Integer id_centro;
    @NotBlank(message = "El Nombre es Obligatorio")
    String nombre;
    @NotBlank(message = "La direccion es Obligatorio")
    String direccion;
    @NotBlank(message = "El telefono es Obligatoria")
    String telefono;

}
