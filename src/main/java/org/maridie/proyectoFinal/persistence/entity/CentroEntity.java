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
    @Column(name = "id_centro")
    private Integer id_centro;

    private String nombre;
    private String direccion;
    private String telefono;

    // Spring Data JPA espera este getter
    public Integer getId() {
        return id_centro;
    }

    public void setId(Integer id) {
        this.id_centro = id;
    }
}
