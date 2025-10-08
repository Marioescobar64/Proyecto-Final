package org.maridie.proyectoFinal.repository;

import org.maridie.proyectoFinal.dominio.dto.tipoDeSangreDto;
import org.maridie.proyectoFinal.dominio.dto.donadorDto;

import java.util.List;

public interface donadorRepository {
    List<donadorDto> obtenerTodo();
    donadorDto buscarPorId(Integer id);
    donadorDto guardar(donadorDto donador);
    void eliminar(Integer id);
}
