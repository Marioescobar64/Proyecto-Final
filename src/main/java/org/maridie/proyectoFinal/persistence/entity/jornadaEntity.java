package org.maridie.proyectoFinal.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "jornada")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class jornadaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jornada")
    private Integer idJornada;

    @Column(name = "nombre_jornada", length = 200, nullable = false)
    private String nombre_jornada;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fecha_inicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fecha_fin;

    @Column(name = "id_centro")
    private Integer id_centro;

    @Column(name = "meta_unidades")
    private Integer meta_unidades;
}
