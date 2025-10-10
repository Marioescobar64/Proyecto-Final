package org.maridie.proyectoFinal.persistence;

import org.maridie.proyectoFinal.dominio.dto.DonadorDto;
import org.maridie.proyectoFinal.dominio.repository.DonadorRepository;
import org.maridie.proyectoFinal.persistence.crud.CrudDonadorRepository;
import org.maridie.proyectoFinal.persistence.entity.donadorEntity;
import org.maridie.proyectoFinal.persistence.mapper.donadorMapper;

import java.util.List;
import java.util.Optional;

public class DonadorEntityRepository implements DonadorRepository {
    @Override
    public List<DonadorDto> buscarPorIdTipoSangre(Integer idTipoSangre) {
        return List.of();
    }

    private final CrudDonadorRepository crudDonadorRepository;
    private final donadorMapper donadorMapper;

    public DonadorEntityRepository(CrudDonadorRepository crudDonadorRepository, donadorMapper donadorMapper) {
        this.crudDonadorRepository = crudDonadorRepository;
        this.donadorMapper = donadorMapper;
    }

    @Override
    public List<DonadorDto> obtenerTodo() {
        return this.donadorMapper.toDto(this.crudDonadorRepository.findAll());
    }

    @Override
    public DonadorDto buscarPorId(Integer id) {
        Optional<donadorEntity> donador = this.crudDonadorRepository.findById(id);
        return donador.map(donadorMapper::toDto).orElse(null);
    }

    @Override
    public DonadorDto guardar(DonadorDto donadorDto) {
        donadorEntity donador = this.donadorMapper.toEntity(donadorDto);
        return this.donadorMapper.toDto(this.crudDonadorRepository.save(donador));
    }

    @Override
    public void eliminar(Integer id) {
        this.crudDonadorRepository.deleteById(id);
    }

}
