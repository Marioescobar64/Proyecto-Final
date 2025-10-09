package org.maridie.proyectoFinal.controller;

import jakarta.validation.Valid;
import org.maridie.proyectoFinal.dominio.dto.TipoDeSangreDto;
import org.maridie.proyectoFinal.dominio.service.tipoDeSangreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tipoDeSangre")
public class tipoDeSangreController {
    private final tipoDeSangreService tipoDeSangreService;

    public tipoDeSangreController(tipoDeSangreService tipoDeSangreService) {
        this.tipoDeSangreService = tipoDeSangreService;
    }

    // 🔹 Obtener todos los tipos de sangre
    @GetMapping
    public ResponseEntity<List<TipoDeSangreDto>> obtenerTodos() {
        return new ResponseEntity<>(tipoDeSangreService.obtenerTodo(), HttpStatus.OK);
    }

    // 🔹 Obtener tipo de sangre por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoDeSangreDto> obtenerPorId(@PathVariable Integer id) {
        TipoDeSangreDto tipo = tipoDeSangreService.buscarPorId(id);
        return tipo != null
                ? new ResponseEntity<>(tipo, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // 🔹 Crear nuevo tipo de sangre
    @PostMapping
    public ResponseEntity<TipoDeSangreDto> guardar(@RequestBody @Valid TipoDeSangreDto tipoDto) {
        TipoDeSangreDto nuevoTipo = tipoDeSangreService.guardar(tipoDto);
        return new ResponseEntity<>(nuevoTipo, HttpStatus.CREATED);
    }

    // 🔹 Actualizar tipo de sangre existente
    @PutMapping("/{id}")
    public ResponseEntity<TipoDeSangreDto> actualizar(@PathVariable Integer id,
                                                      @Valid @RequestBody TipoDeSangreDto tipoDto) {
        TipoDeSangreDto existente = tipoDeSangreService.buscarPorId(id);
        if (existente != null) {
            TipoDeSangreDto actualizado = tipoDeSangreService.guardar(
                    new TipoDeSangreDto(id, tipoDto.getGrupo_sanguineo(), tipoDto.getFactor_rh())
            );
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 🔹 Eliminar tipo de sangre
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        TipoDeSangreDto tipo = tipoDeSangreService.buscarPorId(id);
        if (tipo != null) {
            tipoDeSangreService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
