package org.maridie.proyectoFinal.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.maridie.proyectoFinal.dominio.dto.DonacionDto;
import org.maridie.proyectoFinal.dominio.repository.DonacionRepository;
import org.maridie.proyectoFinal.persistence.crud.CrudDonacionRepository;
import org.maridie.proyectoFinal.persistence.entity.DonacionEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DonacionRepositoryImpl implements DonacionRepository {

    private final CrudDonacionRepository crudDonacionRepository;

    @Override
    public List<DonacionDto> obtenerTodo() {
        return ((List<DonacionEntity>) crudDonacionRepository.findAll())
                .stream()
                .map(this::convertirADto)
                .collect(Collectors.toList());
    }

    @Override
    public DonacionDto buscarPorId(Integer id) {
        return crudDonacionRepository.findById(id)
                .map(this::convertirADto)
                .orElse(null);
    }

    @Override
    public DonacionDto guardar(DonacionDto donacion) {
        DonacionEntity entity = convertirAEntity(donacion);
        DonacionEntity guardada = crudDonacionRepository.save(entity);
        return convertirADto(guardada);
    }

    @Override
    public void eliminar(Integer id) {
        crudDonacionRepository.deleteById(id);
    }

    @Override
    public List<DonacionDto> buscarPorIdCita(Integer idCita) {
        return obtenerTodo().stream()
                .filter(d -> d.getId_cita() != null && d.getId_cita().equals(idCita))
                .collect(Collectors.toList());
    }

    // 🔄 Conversión entre Entity y DTO
    private DonacionDto convertirADto(DonacionEntity entity) {
        DonacionDto dto = new DonacionDto();
        dto.setId_donacion(entity.getId_donacion());
        dto.setId_cita(entity.getId_cita());
        dto.setId_enfermo(entity.getId_enfermero());
        dto.setFecha_donacion(LocalDate.from(entity.getFecha_donacion()));
        dto.setVolumen_ml(entity.getVolumen_ml());
        dto.setResultado_serologia(entity.getResultado_serologia());
        dto.setCodigo_unidad(entity.getCodigo_unidad());
        return dto;
    }

    private DonacionEntity convertirAEntity(DonacionDto dto) {
        DonacionEntity entity = new DonacionEntity();
        entity.setId_donacion(dto.getId_donacion());
        entity.setId_cita(dto.getId_cita());
        entity.setId_enfermero(dto.getId_enfermo());
        entity.setFecha_donacion(dto.getFecha_donacion().atStartOfDay());
        entity.setVolumen_ml(dto.getVolumen_ml());
        entity.setResultado_serologia(dto.getResultado_serologia());
        entity.setCodigo_unidad(dto.getCodigo_unidad());
        return entity;
    }
}
