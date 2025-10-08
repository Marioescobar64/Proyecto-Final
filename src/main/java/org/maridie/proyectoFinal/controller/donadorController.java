package org.maridie.proyectoFinal.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.maridie.proyectoFinal.dominio.dto.donadorDto;
import org.maridie.proyectoFinal.dominio.service.donadorService;

import java.util.List;

@RestController
@RequestMapping("/v1/donador")
public class donadorController {

    private final donadorService donadorService;

    public donadorController(donadorService donadorService) {
        this.donadorService = donadorService;
    }

    @GetMapping
    public ResponseEntity<List<donadorDto>> obtenerTodos() {
        return new ResponseEntity<>(donadorService.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<donadorDto> obtenerDonadorPorId(@PathVariable Integer id) {
        donadorDto donador = donadorService.buscarPorId(id);
        return donador != null
                ? new ResponseEntity<>(donador, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<donadorDto> guardarDonador(@RequestBody @Valid donadorDto donadorDto) {
        donadorDto nuevoDonador = donadorService.guardar(donadorDto);
        return new ResponseEntity<>(nuevoDonador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<donadorDto> actualizarDonador(@PathVariable Integer id, @Valid @RequestBody donadorDto donadorDto) {
        donadorDto donadorExistente = donadorService.buscarPorId(id);
        if (donadorExistente != null) {
            donadorDto donadorActualizado = donadorService.guardar(
                    new donadorDto(
                            id,
                            donadorDto.getNombres(),
                            donadorDto.getApellidos(),
                            donadorDto.getDpi(),
                            donadorDto.getFecha_nacimiento(),
                            donadorDto.getGenero(),
                            donadorDto.getTelefono(),
                            donadorDto.getEmail(),
                            donadorDto.getDireccion(),
                            donadorDto.getId_tipo_sangre(),
                            donadorDto.getFecha_ultima_donacion(),
                            donadorDto.getElegible(),
                            donadorExistente.getFecha_creacion() // no se cambia la fecha de creación
                    )
            );
            return new ResponseEntity<>(donadorActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<donadorDto> eliminarDonador(@PathVariable Integer id) {
        donadorDto donador = donadorService.buscarPorId(id);
        if (donador != null) {
            donadorService.eliminar(id);
            return new ResponseEntity<>(donador, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/por-id_tipo_sangre/{id_tipo_sangre}")
    public ResponseEntity<List<donadorDto>> obtenerDonadoresPorIdTipoSangre(@PathVariable Integer id_tipo_sangre) {
        List<donadorDto> donadores = donadorService.buscarPorIdTipoSangre(id_tipo_sangre);
        if (donadores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(donadores, HttpStatus.OK);
    }
}
