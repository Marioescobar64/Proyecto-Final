package org.maridie.proyectoFinal.persistence;

import org.maridie.proyectoFinal.dominio.dto.DonacionDto;

import org.maridie.proyectoFinal.dominio.repository.DonacionRepository;
import org.maridie.proyectoFinal.persistence.crud.CrudDonacionRepository;

import org.maridie.proyectoFinal.persistence.entity.DonacionEntity;

import org.maridie.proyectoFinal.persistence.mapper.donacionMapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DonacionEntityRepository implements DonacionRepository {


    private final CrudDonacionRepository crudDonacionRepository;
    private final donacionMapper donacionMapper;

    public DonacionEntityRepository(CrudDonacionRepository crudDonacionRepository, donacionMapper donacionMapper) {
        this.crudDonacionRepository = crudDonacionRepository;
        this.donacionMapper = donacionMapper;
    }

    @Override
    public List<DonacionDto> obtenerTodo() {
        return this.donacionMapper.toDto(this.crudDonacionRepository.findAll());
    }

    @Override
    public DonacionDto buscarPorId(Integer id) {
        Optional<DonacionEntity> donacion = this.crudDonacionRepository.findById(id);
        return donacion.map(donacionMapper::toDto).orElse(null);
    }

    @Override
    public DonacionDto guardar(DonacionDto donacionDto) {
        DonacionEntity donacion = this.donacionMapper.toEntity(donacionDto);
        return this.donacionMapper.toDto(this.crudDonacionRepository.save(donacion));
    }

    @Override
    public void eliminar(Integer id) {
        this.crudDonacionRepository.deleteById(id);
    }

    @Override
    public long contarPorEnfermero(Integer idEnfermero) {
        return crudDonacionRepository.contarPorEnfermero(idEnfermero);
    }


}