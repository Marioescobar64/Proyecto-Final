package org.maridie.proyectoFinal.controller;

import jakarta.validation.Valid;
import org.maridie.proyectoFinal.dominio.dto.CentroDto;
import org.maridie.proyectoFinal.dominio.service.CentroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/centro")
public class CentroController {
    private final CentroService centroService;

    public CentroController(CentroService centroService) {
        this.centroService = centroService;
    }

    @GetMapping
    public ResponseEntity<List<CentroDto>> obtenerTodos(){
        return new ResponseEntity<>(centroService.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CentroDto> obtenerCentroPorId(@PathVariable Integer id){
        CentroDto centro = centroService.buscarPorId(id);
        return centro != null ?
                new ResponseEntity<>(centro, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CentroDto> guardarCentro(@RequestBody @Valid CentroDto centroDto){
        CentroDto nuevoCentro = centroService.guardar(centroDto);
        return new ResponseEntity<>(nuevoCentro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CentroDto> actualizarCentro(@PathVariable Integer id, @Valid @RequestBody CentroDto centroDto){
        CentroDto centroExistente = centroService.buscarPorId(id);
        if(centroExistente != null){
            CentroDto centroActualizado = centroService.guardar(new CentroDto(id, centroDto.getNombre(), centroDto.getDireccion(), centroDto.getTelefono()));
            return new ResponseEntity<>(centroActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCentro(@PathVariable Integer id){
        CentroDto centro =  centroService.buscarPorId(id);
        if(centro != null){
            centroService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
