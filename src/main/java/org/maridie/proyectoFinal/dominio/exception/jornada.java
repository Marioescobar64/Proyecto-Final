package org.maridie.proyectoFinal.dominio.exception;

public class jornada extends RuntimeException {
    public jornada(Long codigo) {
        super("La jornada con el codigo de" + codigo + "No existe");
    }

    public jornada(String nombre){
        super("La jornada con el nombre de" + nombre + "Ya existe");
    }
}
