package org.maridie.proyectoFinal.dominio.service;

import jakarta.transaction.Transactional;
import org.maridie.proyectoFinal.dominio.dto.jornadaDto;
import org.maridie.proyectoFinal.repository.jornadaRepository;

import java.util.List;

public class jornadaService {
    private final jornadaRepository jornadaRepository;

    public jornadaService(jornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    public List<jornadaDto> obtenerTodo() {
        return this.jornadaRepository.obtenerTodo();
    }

    public jornadaDto buscarPorId(Integer id) {
        return this.jornadaRepository.buscarPorId(id);
    }

    public jornadaDto guardar(jornadaDto jornadaDto) {
        return this.jornadaRepository.guardar(jornadaDto);
    }

    @Transactional
    public void eliminar(Integer id) {
        this.jornadaRepository.eliminar(id);
    }
}
