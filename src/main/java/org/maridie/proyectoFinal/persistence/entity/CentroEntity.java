package org.maridie.proyectoFinal.persistence.entity;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="centro")
@Data

public class CentroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_centro")
    private Integer id_centro;
    private String nombre;
    private String direccion;
    private String telefono;

}
