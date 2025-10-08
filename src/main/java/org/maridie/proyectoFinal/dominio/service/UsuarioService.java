package org.maridie.proyectoFinal.dominio.service;

import lombok.Data;
import org.maridie.proyectoFinal.dominio.dto.UsuarioDto;


import org.maridie.proyectoFinal.dominio.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Data
    public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDto> obtenerTodo() {
        return this.usuarioRepository.obtenerTodo();
    }

    public UsuarioDto buscarPorId(Integer id) {
        return this.usuarioRepository.buscarPorId(id);
    }

    public UsuarioDto guardar(UsuarioDto usuarioDto) {
        return this.usuarioRepository.guardar(usuarioDto);
    }

    @Transactional
    public void eliminar(Integer id) {
        this.usuarioRepository.eliminar(id);
    }
    }
