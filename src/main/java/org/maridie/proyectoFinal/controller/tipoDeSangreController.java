package org.maridie.proyectoFinal.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.maridie.proyectoFinal.dominio.dto.TipoDeSangreDto;
import org.maridie.proyectoFinal.dominio.service.tipoDeSangreService;

import java.util.List;

@RestController
@RequestMapping("/v1/tipoDeSangre")
public class tipoDeSangreController {
    private final tipoDeSangreService tipoDeSangreService;

    public tipoDeSangreController(tipoDeSangreService tipoDeSangreService) {
        this.tipoDeSangreService = tipoDeSangreService;
    }

    @GetMapping
    public ResponseEntity<List<TipoDeSangreDto>> obtenerTodos() {
        return new ResponseEntity<>(tipoDeSangreService.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDeSangreDto> obtenerTipoDeSangrePorId(@PathVariable Integer id) {
        TipoDeSangreDto tipoDeSangre = tipoDeSangreService.buscarPorId(id);
        return tipoDeSangre != null ?
                new ResponseEntity<>(tipoDeSangre, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<TipoDeSangreDto> guardarTipoDeSangre(@RequestBody @Valid TipoDeSangreDto tipoDeSangreDto) {
        TipoDeSangreDto nuevoTipo = tipoDeSangreService.guardar(tipoDeSangreDto);
        return new ResponseEntity<>(nuevoTipo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDeSangreDto> actualizarTipoDeSangre(@PathVariable Integer id, @Valid @RequestBody TipoDeSangreDto tipoDeSangreDto) {
        TipoDeSangreDto existente = tipoDeSangreService.buscarPorId(id);
        if (existente != null) {
            TipoDeSangreDto actualizado = tipoDeSangreService.guardar(
                    new TipoDeSangreDto(id, tipoDeSangreDto.getGrupo_sanguineo(), tipoDeSangreDto.getFactor_rh())
            );
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoDeSangreDto> eliminarTipoDeSangre(@PathVariable Integer id) {
        TipoDeSangreDto tipoDeSangre = tipoDeSangreService.buscarPorId(id);
        if (tipoDeSangre != null) {
            tipoDeSangreService.eliminar(id);
            return new ResponseEntity<>(tipoDeSangre, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
