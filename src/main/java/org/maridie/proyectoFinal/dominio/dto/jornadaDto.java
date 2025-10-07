package org.maridie.proyectoFinal.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class jornadaDto {

    @PositiveOrZero
    private Integer id_jornada;

    @NotBlank(message = "El nombre de la jornada es obligatorio")
    private String nombre_jornada;

    @NotNull(message = "La fecha de inicio es obligatoria")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha_inicio;

    @NotNull(message = "La fecha de fin es obligatoria")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha_fin;

    @PositiveOrZero
    private Integer id_centro;

    @PositiveOrZero
    private Integer meta_unidades;
}