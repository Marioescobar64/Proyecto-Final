package org.maridie.proyectoFinal.persistence.crud;

import org.maridie.proyectoFinal.persistence.entity.donacionEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudDonacionRepository extends CrudRepository<donacionEntity,Integer> {
}
