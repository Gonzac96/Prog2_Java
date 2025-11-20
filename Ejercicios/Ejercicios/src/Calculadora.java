import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("\nElija una opción: ");
            opcion = s.nextInt();

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("\nIngrese el primer número: ");
                double num1 = s.nextDouble();
                System.out.print("Ingrese el segundo número: ");
                double num2 = s.nextDouble();

                double resultado = 0;

                System.out.print("\n");

                switch (opcion) {
                    // 3- Llamada a las funciones según la opción elegida
                    case 1:
                        resultado = suma(num1, num2);
                        break;
                    case 2:
                        resultado = resta(num1, num2);
                        break;
                    case 3:
                        resultado = multiplicacion(num1, num2);
                        break;
                    case 4:
                        if (num2 != 0) {
                            resultado = division(num1, num2);
                        } else if (num1 == 0 && num2 == 0) {
                            System.out.println("Error: La división 0/0 es indeterminada.");
                            continue;
                        } else {
                            System.out.println("Error: No se puede dividir por cero.");
                            continue;
                        }
                        break;
                }

                System.out.println("Resultado: " + resultado);
            } else if (opcion != 0) {
                System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);

        System.out.println("Calculadora finalizada.");
        s.close();
    }

    // 1- Procedimiento para mostrar el menú
    public static void mostrarMenu() {
        System.out.println("\n===== CALCULADORA =====");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("0. Salir");
    }

    // 2- Funciones para las distintas operaciones
    public static double suma(double a, double b) {
        return a + b;
    }

    public static double resta(double a, double b) {
        return a - b;
    }

    public static double multiplicacion(double a, double b) {
        return a * b;
    }

    public static double division(double a, double b) {
        return a / b;
    }
}
