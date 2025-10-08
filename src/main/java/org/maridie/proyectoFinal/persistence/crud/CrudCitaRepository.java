package org.maridie.proyectoFinal.persistence.crud;

import org.maridie.proyectoFinal.persistence.entity.citaEntitty;
import org.springframework.data.repository.CrudRepository;

public interface CrudCitaRepository extends CrudRepository<citaEntitty,Integer> {
}
