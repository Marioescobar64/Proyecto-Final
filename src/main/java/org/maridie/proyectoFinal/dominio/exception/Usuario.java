package org.maridie.proyectoFinal.dominio.exception;

public class Usuario extends RuntimeException {
    //Usuario no realizado
    public Usuario(Long codigo) {
        super("El Usuario con codigo " + codigo + " no se ha realizado");
    }

    //cita ya realizado
    public Usuario(String mensaje) {
        super("El Usuario  se ha realizado con exito" + mensaje);
    }
}
