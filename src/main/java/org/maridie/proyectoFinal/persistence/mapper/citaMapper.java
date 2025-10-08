package org.maridie.proyectoFinal.persistence.mapper;

import org.mapstruct.*;
import org.maridie.proyectoFinal.dominio.dto.citaDto;
import org.maridie.proyectoFinal.persistence.entity.citaEntitty;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface citaMapper {
    @Mapping(source = "id_cita", target = "id_cita")
    @Mapping(source = "fecha_cita", target = "fecha_cita")
    @Mapping(source = "hora", target = "hora")
    @Mapping(source = "estado", target = "estado")

    @Mapping(source = "donador.id_donador", target = "id_donador")
    @Mapping(source = "centro.id_centro", target = "id_centro")
    @Mapping(source = "jornada.id_jornada", target = "id_jornada")
    citaDto toDto(citaEntitty entity);

    List<citaDto> toDto(Iterable<citaEntitty> entities);

    citaEntitty toEntity(citaEntitty dto);

}
