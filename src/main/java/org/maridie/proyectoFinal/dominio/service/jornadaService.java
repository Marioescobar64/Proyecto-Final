package org.maridie.proyectoFinal.dominio.service;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.maridie.proyectoFinal.dominio.dto.JornadaDto;
import org.maridie.proyectoFinal.dominio.repository.JornadaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class jornadaService {
    private final JornadaRepository jornadaRepository;

    public jornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    public List<JornadaDto> obtenerTodo() {
        return this.jornadaRepository.obtenerTodo();
    }

    public JornadaDto buscarPorId(Integer id) {
        return this.jornadaRepository.buscarPorId(id);
    }

    public JornadaDto guardar(JornadaDto jornadaDto) {
        return this.jornadaRepository.guardar(jornadaDto);
    }

    @Transactional
    public void eliminar(Integer id) {
        this.jornadaRepository.eliminar(id);
    }
}
