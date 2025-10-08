package org.maridie.proyectoFinal.dominio.repository;

import org.maridie.proyectoFinal.dominio.dto.donadorDto;


import java.util.List;

public interface DonadorRepository {
    List<donadorDto> obtenerTodo();
    donadorDto buscarPorId(Integer id);
    donadorDto guardar(donadorDto donador);
    void eliminar(Integer id);

}
