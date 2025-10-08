package org.maridie.proyectoFinal.dominio.repository;

import org.maridie.proyectoFinal.dominio.dto.citaDto;

import java.util.List;

public interface CitaRepository {
    List<citaDto> obtenerTodo();
    citaDto buscarPorId(Integer id);
    List<citaDto> buscarPorIdDonador(Integer id_donador);
    List<citaDto> buscarPorIdCentro(Integer id_centro);
    List<citaDto> buscarPorIdJornada(Integer id_jornada);
    citaDto guardar(citaDto cita);
    void eliminar(Integer id);
}