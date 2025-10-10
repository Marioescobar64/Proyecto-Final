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

    // Obtener todos los donadores
    @GetMapping
    public ResponseEntity<List<DonadorDto>> obtenerTodos() {
        return new ResponseEntity<>(donadorService.obtenerTodo(), HttpStatus.OK);
    }

    // Obtener un donador por ID
    @GetMapping("/{id}")
    public ResponseEntity<DonadorDto> obtenerDonadorPorId(@PathVariable Integer id) {
        DonadorDto donador = donadorService.buscarPorId(id);
        return donador != null ?
                new ResponseEntity<>(donador, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Crear un nuevo donador
    @PostMapping
    public ResponseEntity<DonadorDto> guardarDonador(@RequestBody @Valid DonadorDto donadorDto) {
        DonadorDto nuevoDonador = donadorService.guardar(donadorDto);
        return new ResponseEntity<>(nuevoDonador, HttpStatus.CREATED);
    }

    // Actualizar un donador existente
    @PutMapping("/{id}")
    public ResponseEntity<DonadorDto> actualizarDonador(@PathVariable Integer id, @Valid @RequestBody DonadorDto donadorDto) {
        DonadorDto donadorExistente = donadorService.buscarPorId(id);
        if (donadorExistente != null) {
            // Creamos un nuevo DTO usando el servicio directamente, siguiendo tu ejemplo
            DonadorDto donadorActualizado = donadorService.guardar(new DonadorDto(
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
                    donadorDto.getFecha_creacion()
            ));
            return new ResponseEntity<>(donadorActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Eliminar un donador por ID
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


}
