package org.maridie.proyectoFinal.persistence.mapper;

import org.maridie.proyectoFinal.dominio.dto.TipoDeSangreDto;
import org.maridie.proyectoFinal.persistence.entity.TipoDeSangreEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface tipoDeSangreMapper {
    @Mapping(source = "id_tipo_sangre", target = "id_tipo_sangre")
    @Mapping(source = "grupo_sanguineo", target = "grupo_sanguineo")
    @Mapping(source = "factor_rh", target = "factor_rh")
    TipoDeSangreDto toDto(TipoDeSangreEntity entity);

    List<TipoDeSangreDto> toDto(Iterable<TipoDeSangreEntity> entities);

    @InheritInverseConfiguration
    TipoDeSangreEntity toEntity(TipoDeSangreDto dto);
}
