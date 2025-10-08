package org.maridie.proyectoFinal.repository;

import org.maridie.proyectoFinal.dominio.dto.donacionDto;

import java.util.List;

public interface donacionRepository {
    List<donacionDto> obtenerTodo();
    donacionDto buscarPorId(Integer id);
    donacionDto guardar(donacionDto donacion);
    void eliminar(Integer id);

    List<donacionDto> buscarPorIdCita(Integer idCita);
}
