package Vista;

import java.util.Scanner;
import java.util.InputMismatchException;

/*
    Clase para mostrar el menú principal
    y encargada de la interacción con el usuario.
*/

public class Menu {

    private Scanner sc;

    public Menu() {
        this.sc = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        System.out.println("\n" + "=".repeat(54));
        System.out.println("\tSISTEMA DE GESTIÓN DE LA CONCESIONARIA");
        System.out.println("=".repeat(54));
        System.out.println("┌──────────────────────────────────────────────┐");
        System.out.println("│  1 │  Agregar nuevo vehículo                 │");
        System.out.println("│  2 │  Ver inventario completo                │");
        System.out.println("│  3 │  Buscar vehículos por Marca             │");
        System.out.println("│  4 │  Ingresar vehículo usado al Taller      │");
        System.out.println("│  5 │  Procesar siguiente vehículo en Taller  │");
        System.out.println("│  0 │  Salir                                  │");
        System.out.println("└──────────────────────────────────────────────┘");
        System.out.println("(Seleccione cualquier letra para finalizar)");
        System.out.print("---> Seleccione una opción: ");
    }

    // Método para leer la opción del usuario con manejo de excepciones
    public int leerOpcion() {
        int opcion = -1;
        try {
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
        } catch (InputMismatchException e) {
            System.out.println("Opción inválida. Por favor, ingrese un número válido.");
            sc.nextLine(); // Limpiar el buffer en caso de error
        }
        return opcion;
    }

    // Método para validar doubles positivos
    public double leerDoublePositivo(String mensaje) {
        
        double valor = -1;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.println(mensaje + ": ");
                valor = Double.parseDouble(sc.nextLine());
                if (valor < 0) {
                    System.out.println("Por favor, ingrese un número positivo.");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
            }
        }
        return valor;
    }

    // Método para cerrar el Scanner
    public void cerrarScanner() {
        sc.close();
    }


    
}
