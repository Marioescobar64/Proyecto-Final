package org.maridie.proyectoFinal.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.maridie.proyectoFinal.dominio.dto.EnfermeroDto;
import org.maridie.proyectoFinal.dominio.repository.EnfermeroRepository;
import org.maridie.proyectoFinal.persistence.crud.CrudEnfermerosRepository;
import org.maridie.proyectoFinal.persistence.entity.EnfermeroEntity;
import org.maridie.proyectoFinal.persistence.entity.CentroEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class EnfermeroRepositoryImpl implements EnfermeroRepository {

    private final CrudEnfermerosRepository crudEnfermerosRepository;

    @Override
    public List<EnfermeroDto> obtenerTodo() {
        return ((List<EnfermeroEntity>) crudEnfermerosRepository.findAll())
                .stream()
                .map(this::convertirADto)
                .collect(Collectors.toList());
    }

    @Override
    public EnfermeroDto buscarPorId(Integer id) {
        return crudEnfermerosRepository.findById(id)
                .map(this::convertirADto)
                .orElse(null);
    }

    @Override
    public EnfermeroDto guardar(EnfermeroDto dto) {
        EnfermeroEntity entity = convertirAEntity(dto);
        EnfermeroEntity guardado = crudEnfermerosRepository.save(entity);
        return convertirADto(guardado);
    }

    @Override
    public void eliminar(Integer id) {
        crudEnfermerosRepository.deleteById(id);
    }

    // Conversión Entity <-> DTO
    private EnfermeroDto convertirADto(EnfermeroEntity entity) {
        EnfermeroDto dto = new EnfermeroDto();
        dto.setId_enfermero(entity.getId_enfermero());
        dto.setNombres(entity.getNombres());
        dto.setApellidos(entity.getApellidos());
        dto.setColegiado(entity.getColegiado());
        dto.setTelefono(entity.getTelefono());
        dto.setEmail(entity.getEmail());
        dto.setId_centro(entity.getCentro() != null ? entity.getCentro().getId() : null);
        return dto;
    }

    private EnfermeroEntity convertirAEntity(EnfermeroDto dto) {
        EnfermeroEntity entity = new EnfermeroEntity();
        entity.setId_enfermero(dto.getId_enfermero());
        entity.setNombres(dto.getNombres());
        entity.setApellidos(dto.getApellidos());
        entity.setColegiado(dto.getColegiado());
        entity.setTelefono(dto.getTelefono());
        entity.setEmail(dto.getEmail());

        // Relación ManyToOne con Centro
        if (dto.getId_centro() != null) {
            CentroEntity centro = new CentroEntity();
            centro.setId(dto.getId_centro());
            entity.setCentro(centro);
        } else {
            entity.setCentro(null);
        }

        return entity;
    }
}
