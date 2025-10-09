package org.maridie.proyectoFinal.dominio.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class citaDto {

    @PositiveOrZero
    private Integer id_cita;

    @NotNull(message = "La fecha es obligatoria")
    @FutureOrPresent(message = "La fecha de la cita debe ser hoy o futura")
    private LocalDate fecha_cita;

    @NotNull(message = "La Hora es obligatoria")
    private LocalTime hora;

    @NotNull(message = "El Estado es obligatorio")
    private String estado;

    @NotNull(message = "El id del donador es obligatorio")
    private Integer  id_donador;

    @NotNull(message = "El id del centro es obligatorio")
    private Integer  id_centro;

    @NotNull(message = "El id del jornada es obligatorio")
    private Integer  id_jornada;
}
