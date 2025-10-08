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
    @Mapping(source = "donador.id_donador", target = "id_donador")
    @Mapping(source = "centro.id_centro", target = "id_centro")
    @Mapping(source = "jornada.id_jornada", target = "id_jornada")
    citaDto toDto(citaEntitty entity);

    List<citaDto> toDto(Iterable<citaEntitty> entities);

    // De DTO a entidad
    @InheritInverseConfiguration
    citaEntitty toEntity(citaDto dto);

    // Métodos auxiliares para MapStruct
    default Integer mapDonadorId(donadorEntity donador) {
        return donador != null ? donador.getId_donador() != null ? donador.getId_donador().intValue() : null : null;
    }

    default donadorEntity mapDonadorEntity(Integer id) {
        if (id == null) return null;
        donadorEntity d = new donadorEntity();
        d.setId_donador((int) id.longValue()); // <- conversión segura Integer -> Long
        return d;
    }

    default Integer mapCentroId(CentroEntity centro) {
        return centro != null ? centro.getId_centro() != null ? centro.getId_centro().intValue() : null : null;
    }

    default CentroEntity mapCentroEntity(Integer id) {
        if (id == null) return null;
        CentroEntity c = new CentroEntity();
        c.setId_centro((int) id.longValue());
        return c;
    }

    default Integer mapJornadaId(jornadaEntity jornada) {
        return jornada != null ? jornada.getId_jornada() != null ? jornada.getId_jornada().intValue() : null : null;
    }

    default jornadaEntity mapJornadaEntity(Integer id) {
        if (id == null) return null;
        jornadaEntity j = new jornadaEntity();
        j.setId_jornada((int) id.longValue());
        return j;
    }
}

