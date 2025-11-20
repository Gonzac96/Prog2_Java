//Elaborar la función restar, multiplicar y dividir

import java.util.Scanner;

public class PrimerEjericicio {
    public static void main(String[] args) {
        int n1, n2, opcion;

        Scanner s = new Scanner(System.in);

        do {
            System.out.println("Ingrese lo que desea realizar \n1. Suma\n2. Resta\n3. Multiplicación\n4. División\n0. Salir");
            opcion = s.nextInt();

            if (opcion == 0){
                System.out.println("Termina el programa.");
            } else {
                System.out.println("Ingrese el primer número: ");
                n1 = s.nextInt();
                System.out.println("Ingrese el segundo número: ");
                n2 = s.nextInt();

                switch (opcion) {
                    case 1:
                        sumar(n1, n2);
                        break;
                    case 2:
                        restar(n1, n2);
                        break;
                    case 3:
                        multiplicar(n1, n2);
                        break;
                    case 4:
                        dividir(n1, n2);
                        break;
                    default:
                        break;
                }
            }

        } while (opcion != 0);

        s.close();
    }

    public static void sumar(int nro1, int nro2) {
        System.out.println("La suma de " + nro1 + " + " + nro2 + " = " + (nro1 + nro2));
    }
    //Solamente voy a hacer restas cuando el primer numero es mayor que el segundo
    //Esto lo hago para probar Operador Ternario
    public static void restar(int nro1, int nro2) {
        System.out.println("La resta de " + nro1 + " - " + nro2 + " = " + (nro1 - nro2));
    }
    public static void multiplicar(int nro1, int nro2) {
        System.out.println("La multiplicación de " + nro1 + " x " + nro2 + " = " + (nro1 * nro2));
    }
    public static void dividir(float nro1, float nro2) {
        if (nro1 == 0 && nro2 == 0) {
            System.out.println("Error: indeterminado");
        } else if (nro2 == 0) {
            System.out.println("Error: división por cero");
        } else {
            System.out.println("La división de " + nro1 + " / " + nro2 + " = " + (nro1 / nro2));
        }
    }

}
