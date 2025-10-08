package org.maridie.proyectoFinal.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import lombok.Data;
import org.maridie.proyectoFinal.dominio.dto.centroDto;
import org.maridie.proyectoFinal.dominio.dto.donadorDto;
import org.maridie.proyectoFinal.dominio.dto.jornadaDto;

import java.time.LocalDate;

@Entity
@Table(name = "cita")
@Data
public class citaEntitty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long id_cita;

    @Column(name = "fecha_cita", nullable = false)
    private LocalDate fecha_cita;


    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "estado", length = 100, nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_donador")
    private donadorDto id_donador;

    @ManyToOne
    @JoinColumn(name = "id_centro", nullable = false)
    private centroDto id_centro;

    @ManyToOne
    @JoinColumn(name = "id_jornada", nullable = false)
    private jornadaDto id_jornada;


}
