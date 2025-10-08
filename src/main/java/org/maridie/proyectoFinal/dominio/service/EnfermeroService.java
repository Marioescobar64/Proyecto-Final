package org.maridie.proyectoFinal.dominio.service;

import lombok.Data;
import org.maridie.proyectoFinal.dominio.dto.EnfermeroDto;
import org.maridie.proyectoFinal.dominio.repository.EnfermeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
public class EnfermeroService {

    private final EnfermeroRepository enfermeroRepository;

    public List<EnfermeroDto> obtenerTodo() {
        return this.enfermeroRepository.obtenerTodo();
    }

    public EnfermeroDto buscarPorId(Integer id) {
        return this.enfermeroRepository.buscarPorId(id);
    }

    public EnfermeroDto guardar(EnfermeroDto centro) {
        return this.enfermeroRepository.guardar(centro);
    }

    public void eliminar(Integer id) {
        this.enfermeroRepository.eliminar(id);
    }

}
