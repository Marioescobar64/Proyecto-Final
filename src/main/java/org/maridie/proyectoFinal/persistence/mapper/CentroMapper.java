package org.maridie.proyectoFinal.persistence.mapper;

import org.maridie.proyectoFinal.dominio.dto.centroDto;
import org.maridie.proyectoFinal.persistence.entity.CentroEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CentroMapper {
    @Mapping(source = "id_centro", target = "id_centro")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "telefono", target = "telefono")
    centroDto toDto(CentroEntity entity);
    List<centroDto> toDto(Iterable<CentroEntity> entities);
    @InheritInverseConfiguration
    CentroEntity toEntity(centroDto entity);
}
