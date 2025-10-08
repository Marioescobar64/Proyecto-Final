package org.maridie.proyectoFinal.persistence;

import org.maridie.proyectoFinal.dominio.dto.citaDto;
import org.maridie.proyectoFinal.dominio.repository.CitaRepository;
import org.maridie.proyectoFinal.persistence.crud.CrudCitaRepository;
import org.maridie.proyectoFinal.persistence.entity.citaEntitty;
import org.maridie.proyectoFinal.persistence.mapper.citaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CitaEntityRepository implements CitaRepository {
    private final CrudCitaRepository crudCitaRepository;
    private final citaMapper citaMapper;

    public CitaEntityRepository(CrudCitaRepository crudCitaRepository, citaMapper citaMapper) {
        this.crudCitaRepository = crudCitaRepository;
        this.citaMapper = citaMapper;
    }

    @Override
    public List<citaDto> obtenerTodo() {
        return this.citaMapper.toDto(this.crudCitaRepository.findAll());
    }

    @Override
    public citaDto buscarPorId(Integer id) {
        Optional<citaEntitty> cita = this.crudCitaRepository.findById(id);
        return cita.map(citaMapper::toDto).orElse(null);
    }
    @Override
    public List<citaDto> buscarPorIdDonador(Integer idDonador) {
        List<citaEntitty> citas = crudCitaRepository.findByDonador_id_donador(idDonador);
        return citaMapper.toDto(citas);
    }

    @Override
    public List<citaDto> buscarPorIdCentro(Integer id_centro) {
        List<citaEntitty> citas = crudCitaRepository.findByCentro_id_centro(id_centro);
        return citaMapper.toDto(citas);
    }

    @Override
    public List<citaDto> buscarPorIdJornada(Integer id_jornada) {
        List<citaEntitty> citas = crudCitaRepository.findByJornada_id_jornada(id_jornada);
        return citaMapper.toDto(citas);
    }

    @Override
    public citaDto guardar(citaDto citaDto) {
        citaEntitty cita = this.citaMapper.toEntity(citaDto);
        return this.citaMapper.toDto(this.crudCitaRepository.save(cita));
    }

    @Override
    public void eliminar(Integer id) {
        this.crudCitaRepository.deleteById(id);
    }
}
