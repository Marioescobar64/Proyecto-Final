package org.maridie.proyectoFinal.dominio.service;

import org.maridie.proyectoFinal.dominio.dto.citaDto;
import org.maridie.proyectoFinal.dominio.dto.ModcitaDto;
import org.maridie.proyectoFinal.dominio.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {


        private final CitaRepository citaRepository;

        public CitaService(CitaRepository citaRepository) {
            this.citaRepository = citaRepository;
        }

        // Obtener todos los eventos
        public List<citaDto> obtenerTodo() {
            return this.citaRepository.obtenerTodo();
        }

        // Buscar evento por ID
        public citaDto buscarPorId(Long id_cita) {
            return this.citaRepository.buscarPorId(id_cita);
        }

        // Guardar un nuevo evento
        public citaDto guardarCita(citaDto citaDto) {
            return this.citaRepository.guardarCita(citaDto);
        }

        // Modificar un evento existente
        public citaDto modificarCita(Long id_cita, ModcitaDto modCitaDto) {
            return this.citaRepository.modificarCita(id_cita, modCitaDto);
        }

        // Eliminar un evento
        public void eliminarCita(Long id_cita) {
            this.citaRepository.eliminarCita(id_cita);
        }

}