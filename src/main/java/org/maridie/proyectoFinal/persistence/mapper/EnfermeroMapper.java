package org.maridie.proyectoFinal.persistence.mapper;

import org.maridie.proyectoFinal.dominio.dto.EnfermeroDto;
import org.maridie.proyectoFinal.persistence.entity.EnfermeroEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EnfermeroMapper {

    @Mapping(source = "id_enfermero", target = "id_enfermero")
    @Mapping(source = "nombres", target = "nombres")
    @Mapping(source = "apellidos", target = "apellidos")
    @Mapping(source = "colegiado", target = "colegiado")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "centro.id", target = "id_centro")
    EnfermeroDto toDto(EnfermeroEntity entity);

    List<EnfermeroDto> toDto(Iterable<EnfermeroEntity> entities);

    @InheritInverseConfiguration
    EnfermeroEntity toEntity(EnfermeroDto dto);
}
