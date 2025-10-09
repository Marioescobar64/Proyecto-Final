package org.maridie.proyectoFinal.persistence;

import org.maridie.proyectoFinal.dominio.dto.TipoDeSangreDto;
import org.maridie.proyectoFinal.dominio.repository.tipoDeSangreRepository;
import org.maridie.proyectoFinal.persistence.crud.CrudTipoDeSangreRepository;
import org.maridie.proyectoFinal.persistence.entity.TipoDeSangreEntity;
import org.maridie.proyectoFinal.persistence.mapper.tipoDeSangreMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public class TipoDeSangreEntityRepository implements tipoDeSangreRepository {

    private final CrudTipoDeSangreRepository crudTipoDeSangreRepository;
    private final tipoDeSangreMapper tipoDeSangreMapper;

    public TipoDeSangreEntityRepository(CrudTipoDeSangreRepository crudTipoDeSangreRepository,
                                        tipoDeSangreMapper tipoDeSangreMapper) {
        this.crudTipoDeSangreRepository = crudTipoDeSangreRepository;
        this.tipoDeSangreMapper = tipoDeSangreMapper;
    }

    @Override
    public List<TipoDeSangreDto> obtenerTodo() {
        return this.tipoDeSangreMapper.toDto(this.crudTipoDeSangreRepository.findAll());
    }

    @Override
    public TipoDeSangreDto buscarPorId(Integer id) {
        Optional<TipoDeSangreEntity> tipoSangre = this.crudTipoDeSangreRepository.findById(id);
        return tipoSangre.map(tipoDeSangreMapper::toDto).orElse(null);
    }

    @Override
    public TipoDeSangreDto guardar(TipoDeSangreDto tipoDeSangre) {
        TipoDeSangreEntity entity = this.tipoDeSangreMapper.toEntity(tipoDeSangre);
        return this.tipoDeSangreMapper.toDto(this.crudTipoDeSangreRepository.save(entity));
    }

    @Override
    public void eliminar(Integer id) {
        this.crudTipoDeSangreRepository.deleteById(id);
    }
}

