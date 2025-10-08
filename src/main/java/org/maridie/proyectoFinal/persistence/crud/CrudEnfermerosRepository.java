package org.maridie.proyectoFinal.persistence.crud;

import org.maridie.proyectoFinal.persistence.entity.EnfermeroEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudEnfermerosRepository extends CrudRepository<EnfermeroEntity, Integer> {
}
