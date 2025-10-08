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

    public List<donadorDto> obtenerDonador() { return donadorRepository.obtenerTodo(); }
    public List<centroDto> obtenerCentro() { return centroRepository.obtenerTodo(); }
    public List<jornadaDto> obtenerJornadas() { return jornadaRepository.obtenerTodo(); }

    public List<citaDto> buscarPorIdDonador(Integer id_donador) {return citaRepository.buscarPorIdDonador(id_donador);}
}