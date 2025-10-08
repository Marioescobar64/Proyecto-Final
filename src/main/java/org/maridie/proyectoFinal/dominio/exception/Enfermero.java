package org.maridie.proyectoFinal.dominio.exception;

public class Enfermero extends RuntimeException {
    //Pago no realizado
    public Enfermero(Long codigo) {
        super("El pago de la multa con codigo " + codigo + " no se ha realizado");
    }
    //Pago ya realizado
    public Enfermero(String mensaje) {
        super("El pago de la multa se ha realizado con exito" + mensaje);
    }
}
