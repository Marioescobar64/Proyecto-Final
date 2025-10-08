package org.maridie.proyectoFinal.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.maridie.proyectoFinal.dominio.service.citaService;
import org.maridie.proyectoFinal.dominio.dto.citaDto;


import java.util.List;

@RestController
@RequestMapping("/v1/cita")
public class CitaController {
    private final citaService citaService;

    public CitaController(citaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public ResponseEntity<List<citaDto>> obtenerTodos(){
        return new ResponseEntity<>(citaService.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<citaDto> obtenerMultaPorId(@PathVariable Integer id){
        citaDto cita = citaService.buscarPorId(id);
        return cita != null ?
                new ResponseEntity<>(cita, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<citaDto> guardarCita(@RequestBody @Valid citaDto citaDto){
        citaDto nuevaCita = citaService.guardar(citaDto);
        return new ResponseEntity<>(nuevaCita, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<citaDto> actualizarMulta(@PathVariable Integer id, @Valid @RequestBody citaDto citaDto){
        citaDto citaExistente = citaService.buscarPorId(id);
        if(citaExistente != null){
            citaDto citaActializada = citaService.guardar(new citaDto(id, citaDto.getFecha_cita(), citaDto.getHora(), citaDto.getEstado(), citaDto.getId_donador(), citaDto.getId_centro(), citaDto.getId_jornada()));
            return new ResponseEntity<>(citaActializada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<citaDto> eliminarCita(@PathVariable Integer id){
        citaDto cita = citaService.buscarPorId(id);
        if(cita != null){
            citaService.eliminar(id);
            return new ResponseEntity<>(cita, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/por-id_centro/{id_centro}")
    public ResponseEntity<List<citaDto>> buscarPorIdDonador(@PathVariable Integer id_donador) {
        List<citaDto> citas = citaService.buscarPorIdDonador(id_donador);
        if (citas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @GetMapping("/por-id_centro/{id_centro}")
    public ResponseEntity<List<citaDto>> obtenerCitasPorIdCentro(@PathVariable Integer id_centro) {
        List<citaDto> citas = citaService.buscarPorIdCentro(id_centro);
        if (citas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @GetMapping("/por-id_jornada/{id_jornada}")
    public ResponseEntity<List<citaDto>> obtenerCitasPorIdJornada(@PathVariable Integer id_jornada) {
        List<citaDto> citas = citaService.buscarPorIdJornada(id_jornada);
        if (citas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }
}
