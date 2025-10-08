package org.maridie.proyectoFinal.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.maridie.proyectoFinal.dominio.dto.DonadorDto;
import org.maridie.proyectoFinal.dominio.service.donadorService;

import java.util.List;

@RestController
@RequestMapping("/v1/donador")
public class DonadorController {

    private final donadorService donadorService;

    public DonadorController(donadorService donadorService) {
        this.donadorService = donadorService;
    }

    @GetMapping
    public ResponseEntity<List<DonadorDto>> obtenerTodos() {
        return new ResponseEntity<>(donadorService.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonadorDto> obtenerDonadorPorId(@PathVariable Integer id) {
        DonadorDto donador = donadorService.buscarPorId(id);
        return donador != null
                ? new ResponseEntity<>(donador, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<DonadorDto> guardarDonador(@RequestBody @Valid DonadorDto donadorDto) {
        DonadorDto nuevoDonador = donadorService.guardar(donadorDto);
        return new ResponseEntity<>(nuevoDonador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonadorDto> actualizarDonador(@PathVariable Integer id, @Valid @RequestBody DonadorDto donadorDto) {
        DonadorDto donadorExistente = donadorService.buscarPorId(id);
        if (donadorExistente != null) {
            DonadorDto donadorActualizado = donadorService.guardar(
                    new DonadorDto(
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
    public ResponseEntity<DonadorDto> eliminarDonador(@PathVariable Integer id) {
        DonadorDto donador = donadorService.buscarPorId(id);
        if (donador != null) {
            donadorService.eliminar(id);
            return new ResponseEntity<>(donador, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/por-id_tipo_sangre/{id_tipo_sangre}")
    public ResponseEntity<List<DonadorDto>> obtenerDonadoresPorIdTipoSangre(@PathVariable Integer id_tipo_sangre) {
        List<DonadorDto> donadores = donadorService.buscarPorIdTipoSangre(id_tipo_sangre);
        if (donadores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(donadores, HttpStatus.OK);
    }
}
