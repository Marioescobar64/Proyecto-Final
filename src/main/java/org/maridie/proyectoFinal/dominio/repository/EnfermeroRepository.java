package org.maridie.proyectoFinal.dominio.repository;

import org.maridie.proyectoFinal.dominio.dto.enfermeroDto;
import java.util.List;

public interface EnfermeroRepository {
    List<enfermeroDto> obtenerTodo();
    enfermeroDto buscarPorId(Integer id);
    enfermeroDto guardar(enfermeroDto enfermero);
    void eliminar(Integer id);

}
