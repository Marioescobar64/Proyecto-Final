package org.maridie.proyectoFinal.dominio.dto;

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
public class donacionDto {

    @PositiveOrZero
    private Integer id_donacion;

    @PositiveOrZero
    private Integer id_cita;

    @PositiveOrZero
    private Integer id_enfermo;

    @NotNull(message = "La fecha de su donacion es obligatoria")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha_donacion;

    @PositiveOrZero
    private Integer volumen_ml;

    @NotNull(message = "El resultado de su serologia es obligatorio")
    private String resultado_serologia;

    @NotNull(message = "El codigo de su unidad es obligatorio")
    private String codigo_unidad;
}
