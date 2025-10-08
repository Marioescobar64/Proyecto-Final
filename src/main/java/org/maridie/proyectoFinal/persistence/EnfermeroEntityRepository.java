package org.maridie.proyectoFinal.persistence;

import org.maridie.proyectoFinal.dominio.dto.enfermeroDto;
import org.maridie.proyectoFinal.dominio.repository.EnfermeroRepository;
import org.maridie.proyectoFinal.persistence.crud.CrudEnfermerosRepository;
import org.maridie.proyectoFinal.persistence.entity.EnfermeroEntity;
import org.maridie.proyectoFinal.persistence.mapper.EnfermeroMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public class EnfermeroEntityRepository implements EnfermeroRepository {
    private final CrudEnfermerosRepository crudEnfermerosRepository;
    private final EnfermeroMapper enfermeroMapper;

    public EnfermeroEntityRepository(CrudEnfermerosRepository crudEnfermerosRepository, EnfermeroMapper enfermeroMapper) {
        this.crudEnfermerosRepository = crudEnfermerosRepository;
        this.enfermeroMapper = enfermeroMapper;
    }

    @Override
    public List<enfermeroDto> obtenerTodo() {
        return this.enfermeroMapper.toDto(this.crudEnfermerosRepository.findAll());
    }

    @Override
    public enfermeroDto buscarPorId(Integer id) {
        Optional<EnfermeroEntity> enfermero = this.crudEnfermerosRepository.findById(id);
        return enfermero.map(enfermeroMapper::toDto).orElse(null);
    }

    @Override
    public enfermeroDto guardar(enfermeroDto enfermeroDto) {
        EnfermeroEntity enfermero = this.enfermeroMapper.toEntity(enfermeroDto);
        return this.enfermeroMapper.toDto(this.crudEnfermerosRepository.save(enfermero));
    }

    @Override
    public void eliminar(Integer id) {
        this.crudEnfermerosRepository.deleteById(id);
    }
}
