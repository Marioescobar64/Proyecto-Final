package org.maridie.proyectoFinal.dominio.repository;


import org.maridie.proyectoFinal.dominio.dto.jornadaDto;

import java.util.List;

public interface JornadaRepository {

    List<jornadaDto> obtenerTodo();
    jornadaDto buscarPorId(Integer id);
    jornadaDto guardar(jornadaDto jornada);
    void eliminar(Integer id);
}
