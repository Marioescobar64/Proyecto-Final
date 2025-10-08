package org.maridie.proyectoFinal.repository;

import org.maridie.proyectoFinal.dominio.dto.DonadorDto;

import java.util.List;

public interface donadorRepository {
    List<DonadorDto> obtenerTodo();
    DonadorDto buscarPorId(Integer id);
    DonadorDto guardar(DonadorDto donador);
    void eliminar(Integer id);

    List<DonadorDto> buscarPorIdTipoSangre(Integer idTipoSangre);
}
