package org.maridie.proyectoFinal.persistence.crud;

import org.maridie.proyectoFinal.persistence.entity.citaEntitty;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudCitaRepository extends CrudRepository<citaEntitty,Integer> {
    List<citaEntitty> findByVDonador_id_donador(Integer id_donador);
    List<citaEntitty> findByVCentro_id_centro(Integer id_centro);
    List<citaEntitty> findByJornada_id_jornada(Integer id_jornada);
}
