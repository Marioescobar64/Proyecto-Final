package org.maridie.proyectoFinal.dominio.repository;


import org.maridie.proyectoFinal.dominio.dto.UsuarioDto;

import java.util.List;

public interface UsuarioRepository {
    List<UsuarioDto> obtenerTodo();
    UsuarioDto buscarPorId(Integer id);
    UsuarioDto guardar(UsuarioDto usuario);
    void eliminar(Integer id);
}
