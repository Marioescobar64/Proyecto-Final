package org.maridie.proyectoFinal.persistence.crud;

import org.maridie.proyectoFinal.persistence.entity.citaEntitty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudCitaRepository extends JpaRepository<citaEntitty, Integer> {
    List<citaEntitty> findByDonador_IdDonador(Integer idDonador);
    List<citaEntitty> findByCentro_Id_centro(Integer id_centro); //
    List<citaEntitty> findByJornada_Id(Integer id);
}
