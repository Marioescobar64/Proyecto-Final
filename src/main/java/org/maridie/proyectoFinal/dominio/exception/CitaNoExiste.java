package org.maridie.proyectoFinal.dominio.exception;

public class CitaNoExiste extends RuntimeException {
    public CitaNoExiste(Long id_cita) {
        super("La cita con ID: " + id_cita + " no existe en el sistema");
    }
}
