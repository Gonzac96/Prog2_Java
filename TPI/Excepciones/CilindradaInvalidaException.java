package Excepciones;

public class CilindradaInvalidaException extends Exception{

    public CilindradaInvalidaException(String mensaje) {
        super(mensaje);
    }

    public CilindradaInvalidaException() {
        super("Error: La cilindrada de la moto no es válida.");
    }
    
}
