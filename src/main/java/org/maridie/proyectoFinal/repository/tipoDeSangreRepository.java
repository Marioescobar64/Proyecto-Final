package org.maridie.proyectoFinal.repository;

import org.maridie.proyectoFinal.dominio.dto.tipoDeSangreDto;

import java.util.List;

public interface tipoDeSangreRepository {
    List<tipoDeSangreDto> obtenerTodo();
    tipoDeSangreDto buscarPorId(Integer id);
    tipoDeSangreDto guardar(tipoDeSangreDto tipoDeSangre);
    void eliminar(Integer id);
}
