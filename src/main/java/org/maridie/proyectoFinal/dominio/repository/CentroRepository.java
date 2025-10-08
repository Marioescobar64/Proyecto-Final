package org.maridie.proyectoFinal.dominio.repository;

import org.maridie.proyectoFinal.dominio.dto.centroDto;

import java.util.List;

public interface CentroRepository {

    List<centroDto> obtenerTodo();
    centroDto buscarPorId(Integer id);
    centroDto guardar(centroDto centro);
    void eliminar(Integer id);
}
