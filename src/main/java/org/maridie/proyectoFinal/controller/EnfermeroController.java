package org.maridie.proyectoFinal.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.maridie.proyectoFinal.dominio.dto.EnfermeroDto;
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
    public ResponseEntity<List<EnfermeroDto>> obtenerTodos(){
        return new ResponseEntity<>(enfermeroService.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnfermeroDto> obtenerEnfermeroPorId(@PathVariable Integer id){
        EnfermeroDto enfermero = enfermeroService.buscarPorId(id);
        return enfermero != null ?
                new ResponseEntity<>(enfermero, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<EnfermeroDto> guardarEnfermero(@RequestBody @Valid EnfermeroDto enfermeroDto){
        EnfermeroDto nuevoEnfermero = enfermeroService.guardar(enfermeroDto);
        return new ResponseEntity<>(nuevoEnfermero, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnfermeroDto> actualizarEnfermero(@PathVariable Integer id, @Valid @RequestBody EnfermeroDto enfermeroDto){
        EnfermeroDto enfermeroExistente = enfermeroService.buscarPorId(id);
        if(enfermeroExistente != null){
            EnfermeroDto enfermeroActualizado = enfermeroService.guardar(new EnfermeroDto(id, enfermeroDto.getNombres(), enfermeroDto.getApellidos(), enfermeroDto.getColegiado(), enfermeroDto.getTelefono(), enfermeroDto.getEmail(), enfermeroDto.getId_centro(),enfermeroDto.getIdUsuario() ));
            return new ResponseEntity<>(enfermeroActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EnfermeroDto> eliminarEnfermero(@PathVariable Integer id){
        EnfermeroDto enfermero = enfermeroService.buscarPorId(id);
        if(enfermero != null){
            enfermeroService.eliminar(id);
            return new ResponseEntity<>(enfermero, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
