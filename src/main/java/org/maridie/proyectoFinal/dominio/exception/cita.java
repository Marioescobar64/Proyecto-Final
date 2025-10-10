package org.maridie.proyectoFinal.dominio.exception;

public class cita extends RuntimeException {
    //cita ya realizado
    public cita(String mensaje) {
        super("La cita  se ha realizado con exito" + mensaje);
    }
}
