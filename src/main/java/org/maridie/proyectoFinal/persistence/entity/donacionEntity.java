package org.maridie.proyectoFinal.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "donacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class donacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_donacion")
    private Integer id_donacion;

    @Column(name = "id_cita")
    private Integer id_cita;

    @Column(name = "id_enfermero")
    private Integer id_enfermero;

    @Column(name = "fecha_donacion", nullable = false)
    private LocalDateTime fecha_donacion;

    @Column(name = "volumen_ml", nullable = false)
    private Integer volumen_ml;

    @Column(name = "resultado_serologia", length = 20)
    private String resultado_serologia;

    @Column(name = "codigo_unidad", length = 50, unique = true)
    private String codigo_unidad;
}
