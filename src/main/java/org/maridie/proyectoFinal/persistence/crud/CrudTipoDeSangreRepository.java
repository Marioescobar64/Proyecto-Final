package org.maridie.proyectoFinal.persistence.crud;

import org.maridie.proyectoFinal.persistence.entity.tipoDeSangreEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudTipoDeSangreRepository extends CrudRepository<tipoDeSangreEntity, Integer> {
}
