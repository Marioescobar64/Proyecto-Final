package org.maridie.proyectoFinal.dominio.service;
import lombok.Data;
import org.maridie.proyectoFinal.dominio.dto.DonacionDto;
import org.maridie.proyectoFinal.dominio.repository.DonacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
public class donacionService {
    private final DonacionRepository donacionRepository;

    public donacionService(DonacionRepository donacionRepository) {
        this.donacionRepository = donacionRepository;
    }

    public List<DonacionDto> obtenerTodo() {
        return this.donacionRepository.obtenerTodo();
    }

    public DonacionDto buscarPorId(Integer id) {
        return this.donacionRepository.buscarPorId(id);
    }

    public DonacionDto guardar(DonacionDto donacionDto) {
        return this.donacionRepository.guardar(donacionDto);
    }

    @Transactional
    public void eliminar(Integer id) {
        this.donacionRepository.eliminar(id);
    }

    public List<DonacionDto> buscarPorIdCita(Integer idCita) {
        return donacionRepository.buscarPorIdCita(idCita);
    }
}
