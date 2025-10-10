package org.maridie.proyectoFinal.persistence.crud;

import org.maridie.proyectoFinal.persistence.entity.donadorEntity;
import org.springframework.data.repository.CrudRepository;


public interface CrudDonadorRepository extends CrudRepository<donadorEntity, Integer> {


}
