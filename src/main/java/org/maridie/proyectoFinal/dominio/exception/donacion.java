package org.maridie.proyectoFinal.dominio.exception;

public class donacion extends RuntimeException {
    public donacion(Long codigo) {
        super("La donacion del codigo" + codigo + "No existe");
    }

    public donacion(String nombre){
        super("La donacion con el nombre" + nombre + "Ya existe");
    }
}
