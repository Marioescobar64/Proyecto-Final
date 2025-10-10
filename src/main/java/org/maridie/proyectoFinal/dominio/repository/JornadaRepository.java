package org.maridie.proyectoFinal.dominio.repository;


import org.maridie.proyectoFinal.dominio.dto.JornadaDto;

import java.util.List;

public interface JornadaRepository {

    List<JornadaDto> obtenerTodo();
    JornadaDto buscarPorId(Integer id);
    JornadaDto guardar(JornadaDto jornada);
    void eliminar(Integer id);
}
