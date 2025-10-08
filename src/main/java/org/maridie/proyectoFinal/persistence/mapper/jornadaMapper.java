package org.maridie.proyectoFinal.persistence.mapper;

import org.maridie.proyectoFinal.dominio.dto.jornadaDto;
import org.maridie.proyectoFinal.persistence.entity.jornadaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface jornadaMapper {
    @Mapping(source = "id_jornada", target = "id_jornada")
    @Mapping(source = "nombre_jornada", target = "nombre_jornada")
    @Mapping(source = "fecha_inicio", target = "fecha_inicio")
    @Mapping(source = "fecha_fin", target = "fecha_fin")
    @Mapping(source = "id_centro", target = "id_centro")
    @Mapping(source = "meta_unidades", target = "meta_unidades")
    jornadaDto toDto(jornadaEntity entity);

    List<jornadaDto> toDto(Iterable<jornadaEntity> entities);

    @InheritInverseConfiguration
    jornadaEntity toEntity(jornadaDto dto);
}
