package org.maridie.proyectoFinal.persistence;

import org.maridie.proyectoFinal.dominio.dto.citaDto;
import org.maridie.proyectoFinal.dominio.dto.ModcitaDto;
import org.maridie.proyectoFinal.dominio.exception.CitaNoExiste;
import org.maridie.proyectoFinal.dominio.exception.cita;
import org.maridie.proyectoFinal.persistence.crud.CrudCitaRepository;
import org.maridie.proyectoFinal.dominio.repository.CitaRepository;
import  org.maridie.proyectoFinal.persistence.mapper.citaMapper;
import org.maridie.proyectoFinal.persistence.entity.citaEntitty;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CitaEntityRepository implements CitaRepository {
    private final CrudCitaRepository crudCitaRepository;
    private final citaMapper citaMapper;

    public CitaEntityRepository(CrudCitaRepository crudCitaRepository, citaMapper citaMapper) {
        this.crudCitaRepository = crudCitaRepository;
        this.citaMapper = citaMapper;
    }

    @Override
    public List<citaDto> obtenerTodo() {
        return this.citaMapper.toDto(this.crudCitaRepository.findAll());
    }

    @Override
    public citaDto buscarPorId(Long id_cita) {
        return this.citaMapper.toDto(this.crudCitaRepository.findById(id_cita).orElse(null));
    }

    @Override
    public citaDto guardarCita(citaDto citaDto) {
        if (this.crudCitaRepository.findFirstByestado(citaDto.estado()) != null) {
            throw new cita(citaDto.estado());
        }

        // Convertimos DTO a Entity
        citaEntitty cita = this.citaMapper.toEntity(citaDto);

        // Guardamos en la base de datos
        this.crudCitaRepository.save(cita);

        // Retornamos como DTO
        return this.citaMapper.toDto(cita);
    }

    @Override
    public citaDto modificarCita(Long id_cita, ModcitaDto modCita) {
       citaEntitty cita = this.crudCitaRepository.findById(id_cita).orElse(null);

        if (cita == null) {
            throw new CitaNoExiste(id_cita);
        }

        // Actualizamos entidad con datos del DTO
        this.citaMapper.modificarEntityFromDto(modCita, cita);

        return this.citaMapper.toDto(this.crudCitaRepository.save(cita));
    }

    @Override
    public void eliminarCita(Long id_cita) {
        citaEntitty cita = this.crudCitaRepository.findById(id_cita).orElse(null);

        if (cita == null) {
            throw new CitaNoExiste(id_cita);
        }

        this.crudCitaRepository.delete(cita);
    }
}
