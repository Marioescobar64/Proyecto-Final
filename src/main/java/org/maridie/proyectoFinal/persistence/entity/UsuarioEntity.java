package org.maridie.proyectoFinal.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Usuarios")
@Data

public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUsuario")
    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String password;




}

