package org.maridie.proyectoFinal.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.maridie.proyectoFinal.dominio.service.donacionService;
import org.maridie.proyectoFinal.dominio.dto.donacionDto;

import java.util.List;

@RestController
@RequestMapping("/v1/donacion")
public class donacionController {
    private final donacionService donacionService;

    public donacionController(donacionService donacionService) {
        this.donacionService = donacionService;
    }

    @GetMapping
    public ResponseEntity<List<donacionDto>> obtenerTodos() {
        return new ResponseEntity<>(donacionService.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<donacionDto> obtenerDonacionPorId(@PathVariable Integer id) {
        donacionDto donacion = donacionService.buscarPorId(id);
        return donacion != null
                ? new ResponseEntity<>(donacion, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<donacionDto> guardarDonacion(@RequestBody @Valid donacionDto donacionDto) {
        donacionDto nuevaDonacion = donacionService.guardar(donacionDto);
        return new ResponseEntity<>(nuevaDonacion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<donacionDto> actualizarDonacion(@PathVariable Integer id, @Valid @RequestBody donacionDto donacionDto) {
        donacionDto donacionExistente = donacionService.buscarPorId(id);
        if (donacionExistente != null) {
            donacionDto donacionActualizada = donacionService.guardar(
                    new donacionDto(
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

    @DeleteMapping("/{id}")
    public ResponseEntity<donacionDto> eliminarDonacion(@PathVariable Integer id) {
        donacionDto donacion = donacionService.buscarPorId(id);
        if (donacion != null) {
            donacionService.eliminar(id);
            return new ResponseEntity<>(donacion, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/por-id_cita/{id_cita}")
    public ResponseEntity<List<donacionDto>> obtenerDonacionesPorCita(@PathVariable Integer id_cita) {
        List<donacionDto> donaciones = donacionService.buscarPorIdCita(id_cita);
        if (donaciones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(donaciones, HttpStatus.OK);
    }
}
