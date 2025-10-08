package org.maridie.proyectoFinal.dominio.exception;

public class tipoDeSangre extends RuntimeException {
    public tipoDeSangre(Long codigo) {
        super("El tipo de sangre con el codigo" + codigo + "No existe");
    }

    public tipoDeSangre(String nombre){
        super("El tipo de sangre con el nombre" + nombre + "Ya existe");
    }
}
