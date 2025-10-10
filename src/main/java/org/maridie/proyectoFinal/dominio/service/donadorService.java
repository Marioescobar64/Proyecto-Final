package org.maridie.proyectoFinal.dominio.service;

import lombok.Data;
import org.maridie.proyectoFinal.dominio.dto.DonadorDto;
import org.maridie.proyectoFinal.dominio.repository.DonadorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
public class donadorService {
    private final DonadorRepository donadorRepository;

    public donadorService(DonadorRepository donadorRepository) {
        this.donadorRepository = donadorRepository;
    }

    public List<DonadorDto> obtenerTodo() {
        return this.donadorRepository.obtenerTodo();
    }

    public DonadorDto buscarPorId(Integer id) {
        return this.donadorRepository.buscarPorId(id);
    }

    public DonadorDto guardar(DonadorDto donadorDto) {
        return this.donadorRepository.guardar(donadorDto);
    }

    @Transactional
    public void eliminar(Integer id) {
        this.donadorRepository.eliminar(id);
    }

    public List<DonadorDto> buscarPorIdTipoSangre(Integer idTipoSangre) {
        return this.donadorRepository.buscarPorIdTipoSangre(idTipoSangre);
    }

}
