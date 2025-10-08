package org.maridie.proyectoFinal.dominio.service;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.maridie.proyectoFinal.dominio.dto.TipoDeSangreDto;
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

    public List<TipoDeSangreDto> obtenerTodo() {
        return this.tipoDeSangreRepository.obtenerTodo();
    }

    public TipoDeSangreDto buscarPorId(Integer id) {
        return this.tipoDeSangreRepository.buscarPorId(id);
    }

    public TipoDeSangreDto guardar(TipoDeSangreDto tipoDeSangreDto) {
        return this.tipoDeSangreRepository.guardar(tipoDeSangreDto);
    }

    @Transactional
    public void eliminar(Integer id) {
        this.tipoDeSangreRepository.eliminar(id);
    }
}
