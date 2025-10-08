package org.maridie.proyectoFinal.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_sangre")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class tipoDeSangreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_sangre")
    private Integer id_tipo_sangre;

    @Column(name = "grupo_sanguineo", length = 3, nullable = false)
    private String grupo_sanguineo;

    @Column(name = "factor_rh", length = 1, nullable = false)
    private String factor_rh;
}
