package org.maridie.proyectoFinal.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.maridie.proyectoFinal.dominio.dto.citaDto;
import org.maridie.proyectoFinal.dominio.dto.ModcitaDto;
import org.maridie.proyectoFinal.dominio.service.CitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/v1/cita")
@Tag(name = "cita", description = "Operaciones CRUD sobre los cita")
public class CitaController {

        private final CitaService citaService;

        public CitaController(CitaService citaService) {
            this.citaService = citaService;
        }

        @GetMapping
        @Operation(
                summary = "Obtener todos los eventos",
                description = "Retorna la lista completa de eventos registrados"
        )
        public ResponseEntity<List<citaDto>> obtenerCitas() {
            return ResponseEntity.ok(this.citaService.obtenerTodo());
        }

        @GetMapping("{id}")
        @Operation(
                summary = "Obtener un evento por su identificador",
                description = "Retorna el evento que coincida con el identificador dado",
                responses = {
                        @ApiResponse(responseCode = "200", description = "Evento encontrado"),
                        @ApiResponse(responseCode = "404", description = "Evento no encontrado", content = @Content)
                }
        )
        public ResponseEntity<citaDto> buscarPorId(
                @Parameter(description = "Identificador del evento", example = "1")
                @PathVariable Long id) {
            return ResponseEntity.ok(this.citaService.buscarPorId(id));
        }

        @PostMapping
        @Operation(
                summary = "Registrar un nuevo evento",
                description = "Crea un nuevo evento en el sistema",
                responses = {
                        @ApiResponse(responseCode = "201", description = "Evento creado exitosamente"),
                        @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content)
                }
        )
        public ResponseEntity<citaDto> guardarCita(@RequestBody @Valid citaDto citaDto) {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.citaService.guardarCita(citaDto));
        }

        @PutMapping("{id}")
        @Operation(
                summary = "Modificar un evento existente",
                description = "Permite actualizar los datos de un evento existente"
        )
        public ResponseEntity<citaDto> modificarCita(
                @PathVariable Long id,
                @RequestBody @Valid ModcitaDto modCitaDto) {
            return ResponseEntity.ok(this.citaService.modificarCita(id, modCitaDto));
        }

        @DeleteMapping("{id}")
        @Operation(
                summary = "Eliminar un evento",
                description = "Elimina un evento por su identificador"
        )
        public ResponseEntity<Void> eliminarCita(@PathVariable Long id) {
            this.citaService.eliminarCita(id);
            return ResponseEntity.ok().build();
        }
    }

