package org.maridie.proyectoFinal.dominio.repository;

import org.maridie.proyectoFinal.dominio.dto.DonadorDto;


import java.util.List;

public interface DonadorRepository {
    List<DonadorDto> obtenerTodo();
    DonadorDto buscarPorId(Integer id);
    DonadorDto guardar(DonadorDto donador);
    void eliminar(Integer id);

}
