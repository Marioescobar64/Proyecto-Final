package org.maridie.proyectoFinal.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class tipoDeSangreDto {
    @PositiveOrZero
    private Integer id_tipo_sangre;
    @NotBlank(message = "El grupo sanguineo es obligatorio")
    private String grupo_sanguineo;
    @NotBlank(message = "El factor rh es obligatorio")
    private String factor_rh;
}
