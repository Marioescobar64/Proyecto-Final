package org.maridie.proyectoFinal.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class donadorDto {
    @PositiveOrZero
    Integer id_donador;
    @NotBlank(message = "El nombre es obligatorio")
    String nombres;
    @NotBlank(message = "El apellido es obligatorio")
    String apellidos;
    @NotBlank(message = "El dpi es obligatorio")
    String dpi;
    @NotBlank(message = "Su fecha de nacimiento es obligatoria")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha_nacimiento;
    @NotBlank(message = "El genero es obligatorio")
    String genero;
    @NotBlank(message = "El numero de telefono es obligatorio")
    String telefono;
    @NotBlank(message = "El email es obligatorio")
    String email;
    @NotBlank(message = "Su direccion es obligatoria")
    String direccion;
    @PositiveOrZero
    Integer id_tipo_sangre;
    @NotBlank(message = "La fecha de la ultima donacion es obligatoria")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha_ultima_donacion;
    
}
