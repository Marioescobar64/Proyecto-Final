package org.maridie.proyectoFinal.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "enfermero")
@Data
public class EnfermeroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_enfermero;
    private String nombres;
    private String apellidos;
    private String colegiado;
    private String telefono;
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_centro")
    private CentroEntity centro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUsuario")
    private UsuarioEntity usuario;



}

