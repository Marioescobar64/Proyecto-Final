package org.maridie.proyectoFinal.persistence.crud;

import org.maridie.proyectoFinal.persistence.entity.DonacionEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudDonacionRepository extends CrudRepository<DonacionEntity,Integer> {
}
