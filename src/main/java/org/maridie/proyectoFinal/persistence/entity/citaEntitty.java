package org.maridie.proyectoFinal.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "cita")
@Data
public class citaEntitty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Integer id_cita;

    @Column(name = "nombreEvento", length = 100, nullable = false)
    private String nombreEvento;

    @Column(name = "fecha_cita", nullable = false)
    private LocalDate fecha_cita;

    @Column(name = "lugar", length = 100, nullable = false)
    private String lugar;


    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @ManyToOne
    @JoinColumn(name = "id_donador", nullable = false)
    private donadorEntity id_donador;

    @ManyToOne
    @JoinColumn(name = "id_centro", nullable = false)
    private CentroEntity id_centro;

    @ManyToOne
    @JoinColumn(name = "id_jornada", nullable = false)
    private jornadaEntity id_jornada;


}
