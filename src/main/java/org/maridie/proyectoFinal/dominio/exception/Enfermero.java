package org.maridie.proyectoFinal.dominio.exception;

public class Enfermero extends RuntimeException {
    //Enfermero no realizado
    public Enfermero(Long codigo) {
        super("El Enfermero con codigo " + codigo + " no se ha realizado");
    }
    //Enfermero ya realizado
    public Enfermero(String mensaje) {
        super("El Enfermero  se ha realizado con exito" + mensaje);
    }
}
