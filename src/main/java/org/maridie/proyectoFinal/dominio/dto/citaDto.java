package org.maridie.proyectoFinal.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class citaDto {
    @PositiveOrZero
    Integer id_cita;
    @NotBlank (message = "La fecha de infracción es obligatoria")

   @NotBlank(message = "La fecha es obligartoria")
    @DateTimeFormat(pattern = "dd/MM/yyyy")

    private LocalDate fecha_cita;

    @NotNull(message = "La hora es obligatoria")
    LocalTime hora;

    @NotBlank(message = "El estado es obligatorio")
    String estado;

    @NotNull(message = "El donador es obligatorio")
    Integer id_donador;

    @NotNull(message = "El centro es obligatorio")
    Integer id_centro;

    @NotNull(message = "El jornada es obligatorio")
    Integer id_jornada;




}


