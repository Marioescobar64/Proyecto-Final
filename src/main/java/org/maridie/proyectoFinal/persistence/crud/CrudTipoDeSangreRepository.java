package org.maridie.proyectoFinal.persistence.crud;

import org.maridie.proyectoFinal.persistence.entity.TipoDeSangreEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudTipoDeSangreRepository extends CrudRepository<TipoDeSangreEntity, Integer> {
}
