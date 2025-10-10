package org.maridie.proyectoFinal.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "donador")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class donadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_donador")
    private Integer idDonador;

    @Column(name = "nombres", length = 100, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 100, nullable = false)
    private String apellidos;

    @Column(name = "dpi", length = 13, nullable = false, unique = true)
    private String dpi;



    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fecha_nacimiento;

    @Column(name = "genero", length = 10, nullable = false)
    private String genero;

    @Column(name = "telefono", length = 8)
    private String telefono;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_sangre", referencedColumnName = "id_tipo_sangre")
    private TipoDeSangreEntity tipoSangre;

    @Column(name = "fecha_ultima_donacion")
    private LocalDate fecha_ultima_donacion;

    @Column(name = "elegible", nullable = false)
    private Boolean elegible = true;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fecha_creacion;
}