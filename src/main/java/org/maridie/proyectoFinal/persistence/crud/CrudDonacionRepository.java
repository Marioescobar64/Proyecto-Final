package org.maridie.proyectoFinal.persistence.crud;

import org.maridie.proyectoFinal.persistence.entity.DonacionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CrudDonacionRepository extends CrudRepository<DonacionEntity,Integer> {

    @Query("SELECT COUNT(d) FROM DonacionEntity d WHERE d.id_enfermero = :idEnfermero")
    long contarPorEnfermero(@Param("idEnfermero") Integer idEnfermero);
}


