package org.maridie.proyectoFinal.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.maridie.proyectoFinal.dominio.dto.DonadorDto;
import org.maridie.proyectoFinal.dominio.repository.DonadorRepository;
import org.maridie.proyectoFinal.persistence.crud.CrudDonadorRepository;
import org.maridie.proyectoFinal.persistence.entity.TipoDeSangreEntity;
import org.maridie.proyectoFinal.persistence.entity.donadorEntity;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DonadorRepositoryImpl implements DonadorRepository {

    private final CrudDonadorRepository crudDonadorRepository;

    @Override
    public List<DonadorDto> obtenerTodo() {
        return ((List<donadorEntity>) crudDonadorRepository.findAll())
                .stream()
                .map(this::convertirADto)
                .collect(Collectors.toList());
    }

    @Override
    public DonadorDto buscarPorId(Integer id) {
        return crudDonadorRepository.findById(id)
                .map(this::convertirADto)
                .orElse(null);
    }

    @Override
    public DonadorDto guardar(DonadorDto dto) {
        donadorEntity entity = convertirAEntity(dto);
        donadorEntity guardado = crudDonadorRepository.save(entity);
        return convertirADto(guardado);
    }

    @Override
    public void eliminar(Integer id) {
        crudDonadorRepository.deleteById(id);
    }

    @Override
    public List<DonadorDto> buscarPorIdTipoSangre(Integer idTipoSangre) {
        return obtenerTodo().stream()
                .filter(d -> d.getId_tipo_sangre().equals(idTipoSangre))
                .collect(Collectors.toList());
    }

    // 🔄 Conversión Entity -> DTO
    private DonadorDto convertirADto(donadorEntity entity) {
        DonadorDto dto = new DonadorDto();
        dto.setId_donador(entity.getIdDonador());
        dto.setNombres(entity.getNombres());
        dto.setApellidos(entity.getApellidos());
        dto.setDpi(entity.getDpi());
        dto.setFecha_nacimiento(entity.getFecha_nacimiento());
        dto.setGenero(entity.getGenero());
        dto.setTelefono(entity.getTelefono());
        dto.setEmail(entity.getEmail());
        dto.setDireccion(entity.getDireccion());
        // Convertir relación ManyToOne a id
        dto.setId_tipo_sangre(entity.getTipoSangre() != null ? entity.getTipoSangre().getId_tipo_sangre() : null);
        dto.setFecha_ultima_donacion(entity.getFecha_ultima_donacion());
        dto.setElegible(entity.getElegible());
        dto.setFecha_creacion(entity.getFecha_creacion());
        return dto;
    }

    // 🔄 Conversión DTO -> Entity
    private donadorEntity convertirAEntity(DonadorDto dto) {
        donadorEntity entity = new donadorEntity();
        entity.setIdDonador(dto.getId_donador());
        entity.setNombres(dto.getNombres());
        entity.setApellidos(dto.getApellidos());
        entity.setDpi(dto.getDpi());
        entity.setFecha_nacimiento(dto.getFecha_nacimiento());
        entity.setGenero(dto.getGenero());
        entity.setTelefono(dto.getTelefono());
        entity.setEmail(dto.getEmail());
        entity.setDireccion(dto.getDireccion());

        // Convertir id a objeto TipoSangreEntity
        if (dto.getId_tipo_sangre() != null) {
            TipoDeSangreEntity tipoSangreEntity = new TipoDeSangreEntity();
            tipoSangreEntity.setId_tipo_sangre(dto.getId_tipo_sangre());
            entity.setTipoSangre(tipoSangreEntity);
        } else {
            entity.setTipoSangre(null);
        }

        entity.setFecha_ultima_donacion(dto.getFecha_ultima_donacion());
        entity.setElegible(dto.getElegible());
        entity.setFecha_creacion(dto.getFecha_creacion());
        return entity;
    }
}
