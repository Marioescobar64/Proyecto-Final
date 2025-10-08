package org.maridie.proyectoFinal.controller.exception;

import org.maridie.proyectoFinal.dominio.exception.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;
import org.maridie.proyectoFinal.dominio.exception.*;


@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(Centro.class)
    public ResponseEntity<Error> handleException(Centro ex) {
        Error error = new Error("Centro error", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(cita.class)
    public ResponseEntity<Error> handleException(cita ex) {
        Error error = new Error("Cita error", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(donacion.class)
    public ResponseEntity<Error> handleException(donacion ex) {
        Error error = new Error("Donacion error", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(donador.class)
    public ResponseEntity<Error> handleException(donador ex) {
        Error error = new Error("Donador error", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Enfermero.class)
    public ResponseEntity<Error> handleException(Enfermero ex) {
        Error error = new Error("Enfermero error", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(jornada.class)
    public ResponseEntity<Error> handleException(jornada ex) {
        Error error = new Error("Jornada error", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleExceptions(MethodArgumentNotValidException ex) {
        List<Error> errores = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            errores.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handlerException(Exception ex){
        Error error = new Error("Error desconocido", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
