package org.maridie.proyectoFinal.repository;

import org.maridie.proyectoFinal.dominio.dto.TipoDeSangreDto;

import java.util.List;

public interface tipoDeSangreRepository {
    List<TipoDeSangreDto> obtenerTodo();
    TipoDeSangreDto buscarPorId(Integer id);
    TipoDeSangreDto guardar(TipoDeSangreDto tipoDeSangre);
    void eliminar(Integer id);
}
