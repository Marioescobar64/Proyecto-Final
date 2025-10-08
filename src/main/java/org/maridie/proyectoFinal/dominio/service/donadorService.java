package org.maridie.proyectoFinal.dominio.service;

import lombok.Data;
import org.maridie.proyectoFinal.dominio.dto.donadorDto;
import org.maridie.proyectoFinal.repository.donadorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
public class donadorService {
    private final donadorRepository donadorRepository;

    public donadorService(donadorRepository donadorRepository) {
        this.donadorRepository = donadorRepository;
    }

    public List<donadorDto> obtenerTodo() {
        return this.donadorRepository.obtenerTodo();
    }

    public donadorDto buscarPorId(Integer id) {
        return this.donadorRepository.buscarPorId(id);
    }

    public donadorDto guardar(donadorDto donadorDto) {
        return this.donadorRepository.guardar(donadorDto);
    }

    @Transactional
    public void eliminar(Integer id) {
        this.donadorRepository.eliminar(id);
    }
}
