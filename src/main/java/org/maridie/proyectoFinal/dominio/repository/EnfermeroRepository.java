package org.maridie.proyectoFinal.dominio.repository;

import org.maridie.proyectoFinal.dominio.dto.EnfermeroDto;
import java.util.List;

public interface EnfermeroRepository {
    List<EnfermeroDto> obtenerTodo();
    EnfermeroDto buscarPorId(Integer id);
    EnfermeroDto guardar(EnfermeroDto enfermero);
    void eliminar(Integer id);

}
