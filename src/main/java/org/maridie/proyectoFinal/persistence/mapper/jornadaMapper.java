package org.maridie.proyectoFinal.persistence.mapper;

import org.maridie.proyectoFinal.dominio.dto.JornadaDto;
import org.maridie.proyectoFinal.persistence.entity.jornadaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface jornadaMapper {

    // De entidad a DTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre_jornada", target = "nombre_jornada")
    @Mapping(source = "fecha_inicio", target = "fecha_inicio")
    @Mapping(source = "fecha_fin", target = "fecha_fin")
    @Mapping(source = "id_centro", target = "id_centro")
    @Mapping(source = "meta_unidades", target = "meta_unidades")
    JornadaDto toDto(jornadaEntity entity);

    List<JornadaDto> toDto(Iterable<jornadaEntity> entities);

    // De DTO a entidad
    @InheritInverseConfiguration
    jornadaEntity toEntity(JornadaDto dto);
}
