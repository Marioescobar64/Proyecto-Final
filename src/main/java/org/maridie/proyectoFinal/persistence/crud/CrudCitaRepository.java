package org.maridie.proyectoFinal.persistence.crud;

import org.maridie.proyectoFinal.persistence.entity.citaEntitty;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudCitaRepository extends CrudRepository<citaEntitty,Integer> {
    List<citaEntitty> findByDonador_IdDonador(Integer idDonador);
    List<citaEntitty> findByCentro_IdCentro(Integer idCentro);
    List<citaEntitty> findByJornada_IdJornada(Integer idJornada);
}