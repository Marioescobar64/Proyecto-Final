package org.maridie.proyectoFinal.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.maridie.proyectoFinal.dominio.service.jornadaService;
import org.maridie.proyectoFinal.dominio.dto.JornadaDto;

import java.util.List;

@RestController
@RequestMapping("/v1/jornada")
public class jornadaController {
    private final jornadaService jornadaService;

    public jornadaController(jornadaService jornadaService) {
        this.jornadaService = jornadaService;
    }

    @GetMapping
    public ResponseEntity<List<JornadaDto>> obtenerTodos() {
        return new ResponseEntity<>(jornadaService.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JornadaDto> obtenerJornadaPorId(@PathVariable Integer id) {
        JornadaDto jornada = jornadaService.buscarPorId(id);
        return jornada != null
                ? new ResponseEntity<>(jornada, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JornadaDto> guardarJornada(@RequestBody @Valid JornadaDto jornadaDto) {
        JornadaDto nuevaJornada = jornadaService.guardar(jornadaDto);
        return new ResponseEntity<>(nuevaJornada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JornadaDto> actualizarJornada(@PathVariable Integer id, @Valid @RequestBody JornadaDto jornadaDto) {
        JornadaDto jornadaExistente = jornadaService.buscarPorId(id);
        if (jornadaExistente != null) {
            JornadaDto jornadaActualizada = jornadaService.guardar(
                    new JornadaDto(
                            id,
                            jornadaDto.getNombre_jornada(),
                            jornadaDto.getFecha_inicio(),
                            jornadaDto.getFecha_fin(),
                            jornadaDto.getId_centro(),
                            jornadaDto.getMeta_unidades()
                    )
            );
            return new ResponseEntity<>(jornadaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JornadaDto> eliminarJornada(@PathVariable Integer id) {
        JornadaDto jornada = jornadaService.buscarPorId(id);
        if (jornada != null) {
            jornadaService.eliminar(id);
            return new ResponseEntity<>(jornada, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
