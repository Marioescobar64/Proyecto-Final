package org.maridie.proyectoFinal.persistence.mapper;

import org.maridie.proyectoFinal.dominio.dto.citaDto;
import org.maridie.proyectoFinal.persistence.entity.citaEntitty;
import org.maridie.proyectoFinal.persistence.entity.donadorEntity;
import org.maridie.proyectoFinal.persistence.entity.CentroEntity;
import org.maridie.proyectoFinal.persistence.entity.jornadaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface citaMapper {

    // De entidad a DTO
    @Mapping(source = "donador.idDonador", target = "id_donador")
    @Mapping(source = "centro.id", target = "id_centro")
    @Mapping(source = "jornada.id", target = "id_jornada")
    citaDto toDto(citaEntitty entity);

    List<citaDto> toDto(Iterable<citaEntitty> entities);

    // De DTO a entidad
    @InheritInverseConfiguration
    citaEntitty toEntity(citaDto dto);

    // Métodos auxiliares para MapStruct
    default Integer mapDonadorId(donadorEntity donador) {
        return donador != null ? donador.getIdDonador() : null;
    }

    default donadorEntity mapDonadorEntity(Integer idDonador) {
        if (idDonador == null) return null;
        donadorEntity d = new donadorEntity();
        d.setIdDonador(idDonador);
        return d;
    }

    default Integer mapCentroId(CentroEntity centro) {
        return centro != null ? centro.getId() : null;
    }

    default CentroEntity mapCentroEntity(Integer id) {
        if (id == null) return null;
        CentroEntity c = new CentroEntity();
        c.setId(id);
        return c;
    }
    default Integer mapJornadaId(jornadaEntity jornada) {
        return jornada != null ? jornada.getId() : null;
    }

    default jornadaEntity mapJornadaEntity(Integer id_jornada) {
        if (id_jornada == null) return null;
        jornadaEntity j = new jornadaEntity();
        j.setId(id_jornada);
        return j;
    }
}
