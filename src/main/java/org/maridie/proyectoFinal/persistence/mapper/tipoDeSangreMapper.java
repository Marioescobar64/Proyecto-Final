package org.maridie.proyectoFinal.persistence.mapper;

import org.maridie.proyectoFinal.dominio.dto.tipoDeSangreDto;
import org.maridie.proyectoFinal.persistence.entity.tipoDeSangreEntity;
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
    tipoDeSangreDto toDto(tipoDeSangreEntity entity);

    List<tipoDeSangreDto> toDto(Iterable<tipoDeSangreEntity> entities);

    @InheritInverseConfiguration
    tipoDeSangreEntity toEntity(tipoDeSangreDto dto);
}
