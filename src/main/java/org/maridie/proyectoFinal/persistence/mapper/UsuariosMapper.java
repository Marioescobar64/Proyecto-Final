package org.maridie.proyectoFinal.persistence.mapper;

import org.maridie.proyectoFinal.dominio.dto.UsuarioDto;

import org.maridie.proyectoFinal.persistence.entity.UsuarioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuariosMapper {
    @Mapping(source = "idUsuario", target = "idUsuario")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    UsuarioDto toDto(UsuarioEntity entity);
    List<UsuarioDto> toDto(Iterable<UsuarioEntity> entities);
    @InheritInverseConfiguration
    UsuarioEntity toEntity(UsuarioDto entity);

}
