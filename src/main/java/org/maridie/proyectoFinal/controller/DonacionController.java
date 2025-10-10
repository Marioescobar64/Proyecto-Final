package org.maridie.proyectoFinal.controller;

import jakarta.validation.Valid;
import org.maridie.proyectoFinal.dominio.dto.DonacionDto;
import org.maridie.proyectoFinal.dominio.service.donacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/donacion")
public class DonacionController {
    private final donacionService donacionService;

    public DonacionController(donacionService donacionService) {
        this.donacionService = donacionService;
    }

    // Obtener todas las donaciones
    @GetMapping
    public ResponseEntity<List<DonacionDto>> obtenerTodas() {
        List<DonacionDto> donaciones = donacionService.obtenerTodo();
        return new ResponseEntity<>(donaciones, HttpStatus.OK);
    }

    // Obtener donación por ID
    @GetMapping("/{id}")
    public ResponseEntity<DonacionDto> obtenerPorId(@PathVariable Integer id) {
        DonacionDto donacion = donacionService.buscarPorId(id);
        return donacion != null ?
                new ResponseEntity<>(donacion, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Guardar nueva donación
    @PostMapping
    public ResponseEntity<DonacionDto> guardar(@RequestBody @Valid DonacionDto donacionDto) {
        DonacionDto nuevaDonacion = donacionService.guardar(donacionDto);
        return new ResponseEntity<>(nuevaDonacion, HttpStatus.CREATED);
    }

    // Actualizar donación existente
    @PutMapping("/{id}")
    public ResponseEntity<DonacionDto> actualizar(@PathVariable Integer id, @RequestBody @Valid DonacionDto donacionDto) {
        DonacionDto donacionExistente = donacionService.buscarPorId(id);
        if (donacionExistente != null) {
            DonacionDto donacionActualizada = donacionService.guardar(
                    new DonacionDto(
                            id,
                            donacionDto.getId_cita(),
                            donacionDto.getId_enfermo(),
                            donacionDto.getFecha_donacion(),
                            donacionDto.getVolumen_ml(),
                            donacionDto.getResultado_serologia(),
                            donacionDto.getCodigo_unidad()
                    )
            );
            return new ResponseEntity<>(donacionActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar donación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        DonacionDto donacion = donacionService.buscarPorId(id);
        if (donacion != null) {
            donacionService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/conteo/enfermero/{id}")
    public ResponseEntity<String> contarDonacionesPorEnfermero(@PathVariable("id") Integer id_enfermero) {
        long cantidad = donacionService.contarDonacionesPorEnfermero(id_enfermero);
        return new ResponseEntity<>("El enfermero con ID " + id_enfermero + " tiene " + cantidad + " donaciones.", HttpStatus.OK);
    }

}
