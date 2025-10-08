package org.maridie.proyectoFinal.persistence;

import org.maridie.proyectoFinal.dominio.dto.CentroDto;
import org.maridie.proyectoFinal.dominio.repository.CentroRepository;
import org.maridie.proyectoFinal.persistence.crud.CrudCentroRepository;
import org.maridie.proyectoFinal.persistence.entity.CentroEntity;
import org.maridie.proyectoFinal.persistence.mapper.CentroMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CentroEntityRepository implements CentroRepository {
    private final CrudCentroRepository crudCentroRepository;
    private final CentroMapper centroMapper;

    public CentroEntityRepository(CrudCentroRepository crudCentroRepository, CentroMapper centroMapper) {
        this.crudCentroRepository = crudCentroRepository;
        this.centroMapper = centroMapper;
    }
    @Override
    public List<CentroDto> obtenerTodo() {
        return this.centroMapper.toDto(this.crudCentroRepository.findAll());
    }

    @Override
    public CentroDto buscarPorId(Integer id) {
        Optional<CentroEntity> centro = this.crudCentroRepository.findById(id);
        return centro.map(centroMapper::toDto).orElse(null);
    }

    @Override
    public CentroDto guardar(CentroDto centroDto) {
        CentroEntity centro = this.centroMapper.toEntity(centroDto);
        return this.centroMapper.toDto(this.crudCentroRepository.save(centro));
    }

    @Override
    public void eliminar(Integer id) {
        this.crudCentroRepository.deleteById(id);
    }
}

