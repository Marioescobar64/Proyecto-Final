package org.maridie.proyectoFinal.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


import org.maridie.proyectoFinal.dominio.dto.citaDto;
import org.maridie.proyectoFinal.dominio.dto.ModcitaDto;
import org.maridie.proyectoFinal.persistence.entity.citaEntitty;

import java.util.List;


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


    @InheritInverseConfiguration
    citaEntitty toEntity(citaDto dto);


    @Mapping(source = "fecha_cita", target = "fecha_cita")
    @Mapping(source = "hora", target = "hora")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "id_donador", target = "donador.id_donador")
    @Mapping(source = "id_centro", target = "centro.id_centro")
    @Mapping(source = "id_jornada", target = "jornada.id_jornada")
    void modificarEntityFromDto(ModcitaDto mod, @MappingTarget citaEntitty entity);
}
