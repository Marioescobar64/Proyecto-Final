package org.maridie.proyectoFinal.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "cita")
@Data
public class citaEntitty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Integer id_cita;

    @Column(name = "fecha_cita", nullable = false)
    private LocalDate fecha_cita;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "estado", length = 100, nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_donador", nullable = false)
    private donadorEntity donador;

    @ManyToOne
    @JoinColumn(name = "id_centro", nullable = false)
    private CentroEntity centro;

    @ManyToOne
    @JoinColumn(name = "id_jornada", nullable = false)
    private jornadaEntity jornada;

    // Getter que Spring espera para JPA
    public Integer getId() {
        return id_cita;
    }

    public void setId(Integer id) {
        this.id_cita = id;
    }
}
