package Excepciones;

/*
    Excepción personalizada para la concesionaria.
    Se puede utilizar para manejar errores específicos
*/

public class ConcesionariaException extends Exception{

    public ConcesionariaException(String mensaje) {
        super(mensaje);
    }
    
}
