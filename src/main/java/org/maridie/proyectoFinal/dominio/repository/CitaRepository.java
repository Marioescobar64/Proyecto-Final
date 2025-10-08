package org.maridie.proyectoFinal.dominio.repository;

import org.maridie.proyectoFinal.dominio.dto.citaDto;
import org.maridie.proyectoFinal.dominio.dto.ModcitaDto;

import java.util.List;

public interface CitaRepository {

    List<citaDto> obtenerTodo();


    citaDto buscarPorId(Long id_cita);


    citaDto guardarCita(citaDto citaDto);


    citaDto modificarCita(Long id_cita, ModcitaDto modCitaDto);

    // Eliminar un evento por ID
    void eliminarCita(Long id_cita);
}