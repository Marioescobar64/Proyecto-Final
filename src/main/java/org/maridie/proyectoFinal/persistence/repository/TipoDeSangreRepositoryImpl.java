package org.maridie.proyectoFinal.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.maridie.proyectoFinal.dominio.dto.TipoDeSangreDto;
import org.maridie.proyectoFinal.dominio.repository.tipoDeSangreRepository;
import org.maridie.proyectoFinal.persistence.crud.CrudTipoDeSangreRepository;
import org.maridie.proyectoFinal.persistence.entity.TipoDeSangreEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TipoDeSangreRepositoryImpl implements tipoDeSangreRepository {

    private final CrudTipoDeSangreRepository crudTipoDeSangreRepository;

    @Override
    public List<TipoDeSangreDto> obtenerTodo() {
        return ((List<TipoDeSangreEntity>) crudTipoDeSangreRepository.findAll())
                .stream()
                .map(this::convertirADto)
                .collect(Collectors.toList());
    }

    @Override
    public TipoDeSangreDto buscarPorId(Integer id) {
        return crudTipoDeSangreRepository.findById(id)
                .map(this::convertirADto)
                .orElse(null);
    }

    @Override
    public TipoDeSangreDto guardar(TipoDeSangreDto dto) {
        TipoDeSangreEntity entity = convertirAEntity(dto);
        TipoDeSangreEntity guardado = crudTipoDeSangreRepository.save(entity);
        return convertirADto(guardado);
    }

    @Override
    public void eliminar(Integer id) {
        crudTipoDeSangreRepository.deleteById(id);
    }

    // --- Conversión DTO <-> Entity ---
    private TipoDeSangreDto convertirADto(TipoDeSangreEntity entity) {
        TipoDeSangreDto dto = new TipoDeSangreDto();
        dto.setId_tipo_sangre(entity.getId_tipo_sangre());
        dto.setGrupo_sanguineo(entity.getGrupo_sanguineo());
        dto.setFactor_rh(entity.getFactor_rh());
        return dto;
    }

    private TipoDeSangreEntity convertirAEntity(TipoDeSangreDto dto) {
        TipoDeSangreEntity entity = new TipoDeSangreEntity();
        entity.setId_tipo_sangre(dto.getId_tipo_sangre());
        entity.setGrupo_sanguineo(dto.getGrupo_sanguineo());
        entity.setFactor_rh(dto.getFactor_rh());
        return entity;
    }
}
