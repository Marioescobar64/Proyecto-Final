package org.maridie.proyectoFinal.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.maridie.proyectoFinal.dominio.dto.JornadaDto;
import org.maridie.proyectoFinal.dominio.repository.JornadaRepository;
import org.maridie.proyectoFinal.persistence.crud.CrudJornadaRepository;
import org.maridie.proyectoFinal.persistence.entity.jornadaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class JornadaRepositoryImpl implements JornadaRepository {

    private final CrudJornadaRepository crudJornadaRepository;

    @Override
    public List<JornadaDto> obtenerTodo() {
        return ((List<jornadaEntity>) crudJornadaRepository.findAll())
                .stream()
                .map(this::convertirADto)
                .collect(Collectors.toList());
    }

    @Override
    public JornadaDto buscarPorId(Integer id) {
        return crudJornadaRepository.findById(id)
                .map(this::convertirADto)
                .orElse(null);
    }

    @Override
    public JornadaDto guardar(JornadaDto dto) {
        jornadaEntity entity = convertirAEntity(dto);
        jornadaEntity guardado = crudJornadaRepository.save(entity);
        return convertirADto(guardado);
    }

    @Override
    public void eliminar(Integer id) {
        crudJornadaRepository.deleteById(id);
    }

    // --- Conversión DTO <-> Entity ---
    private JornadaDto convertirADto(jornadaEntity entity) {
        JornadaDto dto = new JornadaDto();
        dto.setId(entity.getId());
        dto.setNombre_jornada(entity.getNombre_jornada());
        dto.setFecha_inicio(entity.getFecha_inicio());
        dto.setFecha_fin(entity.getFecha_fin());
        dto.setId_centro(entity.getId_centro());
        dto.setMeta_unidades(entity.getMeta_unidades());
        return dto;
    }

    private jornadaEntity convertirAEntity(JornadaDto dto) {
        jornadaEntity entity = new jornadaEntity();
        entity.setId(dto.getId());
        entity.setNombre_jornada(dto.getNombre_jornada());
        entity.setFecha_inicio(dto.getFecha_inicio());
        entity.setFecha_fin(dto.getFecha_fin());
        entity.setId_centro(dto.getId_centro());
        entity.setMeta_unidades(dto.getMeta_unidades());
        return entity;
    }
}
