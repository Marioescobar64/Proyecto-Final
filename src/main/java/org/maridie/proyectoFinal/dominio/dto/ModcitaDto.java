package org.maridie.proyectoFinal.dominio.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record ModcitaDto(

        @NotNull(message = "La fecha es obligatoria")
        @FutureOrPresent(message = "La fecha de la cita debe ser hoy o futura")
        LocalDate fecha_cita,

        @NotNull(message = "La Hora es obligatoria")
        LocalTime hora,

        @NotNull(message = "El Estado es obligatorio")
        String estado,


        @NotNull(message = "El id del recurso es obligatorio")
        Long id_donador,

        @NotNull(message = "El id del recurso es obligatorio")
        Long id_centro,

        @NotNull(message = "El id del recurso es obligatorio")
        Long id_jornada


) {
}
