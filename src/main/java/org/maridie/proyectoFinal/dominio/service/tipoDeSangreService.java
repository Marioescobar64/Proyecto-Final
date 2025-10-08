package org.maridie.proyectoFinal.dominio.service;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.maridie.proyectoFinal.dominio.dto.tipoDeSangreDto;
import org.springframework.stereotype.Service;
import org.maridie.proyectoFinal.repository.tipoDeSangreRepository;

import java.util.List;

@Service
@Data
public class tipoDeSangreService {
    private final tipoDeSangreRepository tipoDeSangreRepository;

    public tipoDeSangreService(tipoDeSangreRepository tipoDeSangreRepository) {
        this.tipoDeSangreRepository = tipoDeSangreRepository;
    }

    public List<tipoDeSangreDto> obtenerTodo() {
        return this.tipoDeSangreRepository.obtenerTodo();
    }

    public tipoDeSangreDto buscarPorId(Integer id) {
        return this.tipoDeSangreRepository.buscarPorId(id);
    }

    public tipoDeSangreDto guardar(tipoDeSangreDto tipoDeSangreDto) {
        return this.tipoDeSangreRepository.guardar(tipoDeSangreDto);
    }

    @Transactional
    public void eliminar(Integer id) {
        this.tipoDeSangreRepository.eliminar(id);
    }
}
