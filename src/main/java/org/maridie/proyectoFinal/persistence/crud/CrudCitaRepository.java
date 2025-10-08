package org.maridie.proyectoFinal.persistence.crud;

import org.maridie.proyectoFinal.persistence.entity.citaEntitty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudCitaRepository extends JpaRepository<citaEntitty, Integer> {
    List<citaEntitty> findByDonador_id_donador(Integer idDonador);
    List<citaEntitty> findByCentro_id_centro(Integer id_centro); //
    List<citaEntitty> findByJornada_id_jornada(Integer id_jornada);
}
