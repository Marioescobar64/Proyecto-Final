package org.maridie.proyectoFinal.persistence;


import org.maridie.proyectoFinal.dominio.dto.UsuarioDto;

import org.maridie.proyectoFinal.dominio.repository.UsuarioRepository;

import org.maridie.proyectoFinal.persistence.crud.CrudUsuariosRepository;

import org.maridie.proyectoFinal.persistence.entity.UsuarioEntity;

import org.maridie.proyectoFinal.persistence.mapper.UsuariosMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioEntityRepository implements UsuarioRepository {
    private final CrudUsuariosRepository crudUsuariosRepository;
    private final UsuariosMapper usuariosMapper;

    public UsuarioEntityRepository(CrudUsuariosRepository crudUsuariosRepository, UsuariosMapper usuariosMapper) {
        this.crudUsuariosRepository = crudUsuariosRepository;
        this.usuariosMapper = usuariosMapper;
    }
    @Override
    public List<UsuarioDto> obtenerTodo() {
        return this.usuariosMapper.toDto(this.crudUsuariosRepository.findAll());
    }

    @Override
    public UsuarioDto buscarPorId(Integer id) {
        Optional<UsuarioEntity> centro = this.crudUsuariosRepository.findById(id);
        return centro.map(usuariosMapper::toDto).orElse(null);
    }

    @Override
    public UsuarioDto guardar(UsuarioDto usuarioDto) {
        UsuarioEntity usuario = this.usuariosMapper.toEntity(usuarioDto);
        return this.usuariosMapper.toDto(this.crudUsuariosRepository.save(usuario));
    }

    @Override
    public void eliminar(Integer id) {
        this.crudUsuariosRepository.deleteById(id);
    }
}
