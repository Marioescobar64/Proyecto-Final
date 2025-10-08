package org.maridie.proyectoFinal.dominio.exception;

public class cita extends RuntimeException {
    //cita no realizado
    public cita(Long codigo) {
        super("La cita con codigo " + codigo + " no se ha realizado");
    }
    //cita ya realizado
    public cita(String mensaje) {
        super("La cita  se ha realizado con exito" + mensaje);
    }
}
