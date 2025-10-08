package org.maridie.proyectoFinal.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.maridie.proyectoFinal.dominio.dto.tipoDeSangreDto;
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
    public ResponseEntity<List<tipoDeSangreDto>> obtenerTodos() {
        return new ResponseEntity<>(tipoDeSangreService.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<tipoDeSangreDto> obtenerTipoDeSangrePorId(@PathVariable Integer id) {
        tipoDeSangreDto tipoDeSangre = tipoDeSangreService.buscarPorId(id);
        return tipoDeSangre != null ?
                new ResponseEntity<>(tipoDeSangre, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<tipoDeSangreDto> guardarTipoDeSangre(@RequestBody @Valid tipoDeSangreDto tipoDeSangreDto) {
        tipoDeSangreDto nuevoTipo = tipoDeSangreService.guardar(tipoDeSangreDto);
        return new ResponseEntity<>(nuevoTipo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<tipoDeSangreDto> actualizarTipoDeSangre(@PathVariable Integer id, @Valid @RequestBody tipoDeSangreDto tipoDeSangreDto) {
        tipoDeSangreDto existente = tipoDeSangreService.buscarPorId(id);
        if (existente != null) {
            tipoDeSangreDto actualizado = tipoDeSangreService.guardar(
                    new tipoDeSangreDto(id, tipoDeSangreDto.getGrupo_sanguineo(), tipoDeSangreDto.getFactor_rh())
            );
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<tipoDeSangreDto> eliminarTipoDeSangre(@PathVariable Integer id) {
        tipoDeSangreDto tipoDeSangre = tipoDeSangreService.buscarPorId(id);
        if (tipoDeSangre != null) {
            tipoDeSangreService.eliminar(id);
            return new ResponseEntity<>(tipoDeSangre, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
