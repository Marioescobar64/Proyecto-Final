package org.maridie.proyectoFinal.dominio.exception;

public class donador extends RuntimeException {
    public donador(Long codigo) {
        super("El donador de codigo" + codigo + "No existe");
    }

    public donador(String nombre){
        super("El donador de nombre" + nombre + "Ya existe");
    }
}
