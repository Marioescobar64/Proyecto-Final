package org.maridie.proyectoFinal.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class donadorDto {
    @PositiveOrZero
    private Integer id_donador;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombres;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellidos;

    @NotBlank(message = "El DPI es obligatorio")
    private String dpi;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha_nacimiento;

    @NotBlank(message = "El género es obligatorio")
    private String genero;

    @NotBlank(message = "El número de teléfono es obligatorio")
    private String telefono;

    @NotBlank(message = "El email es obligatorio")
    private String email;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;

    @PositiveOrZero
    private Integer id_tipo_sangre;

    @NotNull(message = "La fecha de la última donación es obligatoria")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha_ultima_donacion;

    @NotNull(message = "Debe especificar si el donador es elegible o no")
    private Boolean elegible;

    private LocalDateTime fecha_creacion;
}
