package org.maridie.proyectoFinal.controller;

import jakarta.validation.Valid;
import org.maridie.proyectoFinal.dominio.dto.UsuarioDto;

import org.maridie.proyectoFinal.dominio.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> obtenerTodos(){
        return new ResponseEntity<>(usuarioService.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> obtenerUsuarioPorId(@PathVariable Integer id){
        UsuarioDto usuario = usuarioService.buscarPorId(id);
        return usuario != null ?
                new ResponseEntity<>(usuario, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> guardarUsuario(@RequestBody @Valid UsuarioDto usuarioDto){
        UsuarioDto nuevoUsuario = usuarioService.guardar(usuarioDto);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> actualizarUsuario(@PathVariable Integer id, @Valid @RequestBody UsuarioDto usuarioDto){
        UsuarioDto UsuarioExistente = usuarioService.buscarPorId(id);
        if(UsuarioExistente != null){
            UsuarioDto UsuarioActualizado = usuarioService.guardar(new UsuarioDto(id, usuarioDto.getNombre(), usuarioDto.getApellido(), usuarioDto.getEmail(),  usuarioDto.getPassword()));
            return new ResponseEntity<>(UsuarioActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id){
        UsuarioDto usuario =  usuarioService.buscarPorId(id);
        if(usuario != null){
            usuarioService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
