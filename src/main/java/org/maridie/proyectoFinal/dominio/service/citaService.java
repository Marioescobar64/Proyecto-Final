package org.maridie.proyectoFinal.dominio.service;

import lombok.Data;
import org.maridie.proyectoFinal.dominio.dto.*;
import org.maridie.proyectoFinal.dominio.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class citaService {
    private final CitaRepository citaRepository;
    private final DonadorRepository donadorRepository;
    private final CentroRepository centroRepository;
    private final JornadaRepository jornadaRepository;

    public List<citaDto>  obtenerTodo() { return this.citaRepository.obtenerTodo();}
    public citaDto buscarPorId(Integer id) { return this.citaRepository.buscarPorId(id);}
    public citaDto guardar(citaDto cita) { return this.citaRepository.guardar(cita);}
    public void eliminar(Integer id) {this.citaRepository.eliminar(id);}


    public List<citaDto> buscarPorIdDonador(Integer id_donador) {return citaRepository.buscarPorIdDonador(id_donador);}
    public List<citaDto> buscarPorIdCentro(Integer id_centro) {return citaRepository.buscarPorIdCentro(id_centro);}
    public List<citaDto> buscarPorIdJornada(Integer id_jornada) {return citaRepository.buscarPorIdJornada(id_jornada);}

}