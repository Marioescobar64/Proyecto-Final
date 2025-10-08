package org.maridie.proyectoFinal.repository;

import org.maridie.proyectoFinal.dominio.dto.DonacionDto;

import java.util.List;

public interface donacionRepository {
    List<DonacionDto> obtenerTodo();
    DonacionDto buscarPorId(Integer id);
    DonacionDto guardar(DonacionDto donacion);
    void eliminar(Integer id);

    List<DonacionDto> buscarPorIdCita(Integer idCita);
}
