package org.maridie.proyectoFinal.dominio.repository;

import org.maridie.proyectoFinal.dominio.dto.CentroDto;

import java.util.List;

public interface CentroRepository {

    List<CentroDto> obtenerTodo();
    CentroDto buscarPorId(Integer id);
    CentroDto guardar(CentroDto centro);
    void eliminar(Integer id);
}
