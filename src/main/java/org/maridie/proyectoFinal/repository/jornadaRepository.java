package org.maridie.proyectoFinal.repository;

import org.maridie.proyectoFinal.dominio.dto.jornadaDto;

import java.util.List;

public interface jornadaRepository {
    List<jornadaDto> obtenerTodo();
    jornadaDto buscarPorId(Integer id);
    jornadaDto guardar(jornadaDto jornada);
    void eliminar(Integer id);
}
