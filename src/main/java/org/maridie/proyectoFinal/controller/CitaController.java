package org.maridie.proyectoFinal.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.maridie.proyectoFinal.dominio.service.citaService;
import org.maridie.proyectoFinal.dominio.dto.citaDto;


import java.util.List;

@RestController
@RequestMapping("/v1/cita")
public class CitaController {

    private final citaService citaService;

    // Inyección por Constructor (Método preferido)
    public CitaController(citaService citaService) {
        this.citaService = citaService;
    }

    // GET /v1/cita
    @GetMapping
    public ResponseEntity<List<citaDto>> obtenerTodos(){
        return new ResponseEntity<>(citaService.obtenerTodo(), HttpStatus.OK);
    }

    // GET /v1/cita/{id}
    @GetMapping("/{id}")
    public ResponseEntity<citaDto> obtenerCitaPorId(@PathVariable Integer id){
        citaDto cita = citaService.buscarPorId(id);
        return cita != null ?
                new ResponseEntity<>(cita, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // POST /v1/cita
    @PostMapping
    public ResponseEntity<citaDto> guardarCita(@RequestBody @Valid citaDto citaDto){
        citaDto nuevaCita = citaService.guardar(citaDto);
        return new ResponseEntity<>(nuevaCita, HttpStatus.CREATED);
    }

    // PUT /v1/cita/{id}
    @PutMapping("/{id}")
    public ResponseEntity<citaDto> actualizarCita(@PathVariable Integer id, @Valid @RequestBody citaDto citaDto){
        // No es necesario buscar y luego crear un nuevo DTO, simplemente usamos el ID en el DTO recibido
        citaDto citaExistente = citaService.buscarPorId(id);
        if(citaExistente != null){
            // Asignar el ID al DTO y llamar a guardar, asumiendo que 'guardar' maneja la lógica de actualización.
            // Si tu DTO no tiene constructor con todos los campos, usa setters o Lombok.
            citaDto.setId(id);
            citaDto citaActializada = citaService.guardar(citaDto);
            return new ResponseEntity<>(citaActializada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE /v1/cita/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Se recomienda usar @ResponseStatus para DELETE exitoso sin cuerpo
    public void eliminarCita(@PathVariable Integer id){
        // Lo ideal es dejar que el Service o la capa superior maneje la excepción
        // si el ID no existe y no devolver 200/204 si no se encontró nada.
        // Aquí se llama al servicio; si no se encuentra, el servicio debe manejarlo (o no hacer nada).
        citaService.eliminar(id);
    }

    // GET /v1/cita/donador/{id_donador}
    @GetMapping("/donador/{id_donador}") // Cambiado el path para evitar duplicación
    public ResponseEntity<List<citaDto>> obtenerCitasPorIdDonador(@PathVariable Integer idDonador) {
        List<citaDto> citas = citaService.buscarPorIdDonador(idDonador);
        if (citas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    // GET /v1/cita/centro/{id_centro}
    @GetMapping("/centro/{id_centro}") // Cambiado el path para evitar duplicación
    public ResponseEntity<List<citaDto>> obtenerCitasPorIdCentro(@PathVariable Integer id_centro) {
        List<citaDto> citas = citaService.buscarPorIdCentro(id_centro);
        if (citas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    // GET /v1/cita/jornada/{id_jornada}
    @GetMapping("/jornada/{id_jornada}") // Cambiado el path para evitar duplicación
    public ResponseEntity<List<citaDto>> obtenerCitasPorIdJornada(@PathVariable Integer id_jornada) {
        List<citaDto> citas = citaService.buscarPorIdJornada(id_jornada);
        if (citas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }
}