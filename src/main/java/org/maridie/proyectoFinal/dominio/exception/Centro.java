package org.maridie.proyectoFinal.dominio.exception;

public class Centro extends RuntimeException {
    //Departamento no existente
    public Centro(Long codigo) {
        super("El Centro con el codigo " + codigo + " no existe");
    }
    //Departamento ya existente
    public Centro(String nombre) {
        super("El Centro con el nombre " + nombre + " ya existe");
    }
}
