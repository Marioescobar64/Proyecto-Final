package org.maridie.proyectoFinal.persistence.mapper;

import org.maridie.proyectoFinal.dominio.dto.DonacionDto;
import org.maridie.proyectoFinal.persistence.entity.DonacionEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface donacionMapper {
    @Mapping(source = "id_donacion", target = "id_donacion")
    @Mapping(source = "id_cita", target = "id_cita")
    @Mapping(source = "id_enfermero", target = "id_enfermo")
    @Mapping(source = "fecha_donacion", target = "fecha_donacion")
    @Mapping(source = "volumen_ml", target = "volumen_ml")
    @Mapping(source = "resultado_serologia", target = "resultado_serologia")
    @Mapping(source = "codigo_unidad", target = "codigo_unidad")
    DonacionDto toDto(DonacionEntity entity);

    List<DonacionDto> toDto(Iterable<DonacionEntity> entities);

    @InheritInverseConfiguration
    DonacionEntity toEntity(DonacionDto dto);
}
