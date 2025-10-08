package org.maridie.proyectoFinal.dominio.service;

import lombok.Data;
// Importa los repositorios Crud directos
import org.maridie.proyectoFinal.persistence.crud.CrudCitaRepository;
import org.maridie.proyectoFinal.persistence.crud.CrudDonadorRepository;
import org.maridie.proyectoFinal.persistence.crud.CrudCentroRepository;
import org.maridie.proyectoFinal.persistence.crud.CrudJornadaRepository;
import org.maridie.proyectoFinal.dominio.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class citaService {
    private final CrudCitaRepository crudCitaRepository;
    private final CrudDonadorRepository crudDonadorRepository;
    private final CrudCentroRepository crudCentroRepository;
    private final CrudJornadaRepository crudJornadaRepository;
    public citaService(
            CrudCitaRepository crudCitaRepository,
            CrudDonadorRepository crudDonadorRepository,
            CrudCentroRepository crudCentroRepository,
            CrudJornadaRepository crudJornadaRepository)
    {
        this.crudCitaRepository = crudCitaRepository;
        this.crudDonadorRepository = crudDonadorRepository;
        this.crudCentroRepository = crudCentroRepository;
        this.crudJornadaRepository = crudJornadaRepository;
    }

    public List<citaDto> buscarPorIdDonador(Integer idDonador) {
    }
}