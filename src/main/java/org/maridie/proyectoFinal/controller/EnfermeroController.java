package org.maridie.proyectoFinal.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.maridie.proyectoFinal.dominio.dto.enfermeroDto;
import org.maridie.proyectoFinal.dominio.service.EnfermeroService;

import java.util.List;

@RestController
@RequestMapping("/v1/enfermero")
public class EnfermeroController {
    private final EnfermeroService enfermeroService;

    public EnfermeroController(EnfermeroService enfermeroService) {
        this.enfermeroService = enfermeroService;
    }

    @GetMapping
    public ResponseEntity<List<enfermeroDto>> obtenerTodos(){
        return new ResponseEntity<>(enfermeroService.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<enfermeroDto> obtenerEnfermeroPorId(@PathVariable Integer id){
        enfermeroDto enfermero = enfermeroService.buscarPorId(id);
        return enfermero != null ?
                new ResponseEntity<>(enfermero, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<enfermeroDto> guardarEnfermero(@RequestBody @Valid enfermeroDto enfermeroDto){
        enfermeroDto nuevoEnfermero = enfermeroService.guardar(enfermeroDto);
        return new ResponseEntity<>(nuevoEnfermero, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<enfermeroDto> actualizarEnfermero(@PathVariable Integer id, @Valid @RequestBody enfermeroDto enfermeroDto){
        enfermeroDto enfermeroExistente = enfermeroService.buscarPorId(id);
        if(enfermeroExistente != null){
            enfermeroDto enfermeroActualizado = enfermeroService.guardar(new enfermeroDto(id, enfermeroDto.getNombres(), enfermeroDto.getApellidos(), enfermeroDto.getColegiado(), enfermeroDto.getTelefono(), enfermeroDto.getEmail(), enfermeroDto.getId_centro()));
            return new ResponseEntity<>(enfermeroActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<enfermeroDto> eliminarEnfermero(@PathVariable Integer id){
        enfermeroDto enfermero = enfermeroService.buscarPorId(id);
        if(enfermero != null){
            enfermeroService.eliminar(id);
            return new ResponseEntity<>(enfermero, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
