import java.util.Scanner;

// Definimos una clase pública llamada Exception2
public class Exception2 {

    // Definimos una clase estática interna que extiende Exception (una excepción personalizada)
    public static class ProgramadorException extends Exception {
        // Constructor que recibe un mensaje y lo pasa a la superclase Exception
        public ProgramadorException(String message) {
            super(message);
        }
    }

    // Método principal donde inicia la ejecución del programa
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Ingrese nombre del programador: ");
        String nombre = s.nextLine();
        s.close();

        try {


            // Intentamos validar el nombre ingresado por teclado
            validarProgramador(nombre);
            // Intentamos validar un nombre vacío, lo que causará una excepción
            validarProgramador(null);
        } catch (ProgramadorException e) {
            // Si ocurre una ProgramadorException, mostramos el mensaje de error
            System.out.println("Excepción atrapada: " + e.getMessage());
        }
    }

    // Método que valida el nombre del programador
    // Puede lanzar una ProgramadorException si el nombre no es válido
    public static void validarProgramador(String nombre) throws ProgramadorException {
        // Si el nombre es nulo o está vacío, lanzamos una excepción personalizada
        if (nombre == null) {
            throw new ProgramadorException("El nombre del programador no puede ser nulo.");
        } else if (nombre.isEmpty()){
            throw new ProgramadorException("El nombre del programador no puede estar vacío.");
        } else {
            // Si el nombre es válido, lo mostramos por pantalla
            System.out.println("Programador válido: " + nombre);
        }
    }
}