package org.maridie.proyectoFinal.persistence.mapper;

import org.maridie.proyectoFinal.dominio.dto.donadorDto;
import org.maridie.proyectoFinal.persistence.entity.donadorEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface donadorMapper {
    @Mapping(source = "id_donador", target = "id_donador")
    @Mapping(source = "nombres", target = "nombres")
    @Mapping(source = "apellidos", target = "apellidos")
    @Mapping(source = "dpi", target = "dpi")
    @Mapping(source = "fecha_nacimiento", target = "fecha_nacimiento")
    @Mapping(source = "genero", target = "genero")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "tipoSangre.id_tipo_sangre", target = "id_tipo_sangre")
    @Mapping(source = "fecha_ultima_donacion", target = "fecha_ultima_donacion")
    @Mapping(source = "elegible", target = "elegible")
    @Mapping(source = "fecha_creacion", target = "fecha_creacion")
    donadorDto toDto(donadorEntity entity);

    List<donadorDto> toDto(Iterable<donadorEntity> entities);

    @InheritInverseConfiguration
    donadorEntity toEntity(donadorDto dto);
}
