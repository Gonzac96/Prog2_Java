package Excepciones;

/*
    Excepción personalizada para Auto.
*/

public class AutoCantPuertasException extends Exception{

    public AutoCantPuertasException(String mensaje) {
        super(mensaje);
    }

    public AutoCantPuertasException() {
        super("Error: Un auto debe tener al menos 3 puertas.");
    }
    
}
