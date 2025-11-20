import java.util.Scanner;

public class Duplicador {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Ingreso de número para duplicar
        System.out.print("Ingrese un número: ");
        int numero = s.nextInt();

        System.out.println("\nNúmero original: " + numero);
        duplicarNumero(numero); // Paso por valor
        System.out.println("Número después de llamar a duplicarNumero: " + numero);

        // Ingreso del arreglo para duplicar
        System.out.print("\nIngrese el tamaño del arreglo: ");
        int tamaño = s.nextInt();

        int[] arreglo = new int[tamaño];

        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < tamaño; i++) {
            System.out.print("Elemento [" + i + "]: ");
            arreglo[i] = s.nextInt();
        }

        System.out.print("\nArreglo original: ");
        mostrarArreglo(arreglo);

        duplicarArreglo(arreglo); // Paso por referencia
        System.out.print("Arreglo después de llamar a duplicarArreglo: ");
        mostrarArreglo(arreglo);

        s.close();
    }

    // 1- Función que intenta duplicar el valor de un número
    public static void duplicarNumero(int x) {
        x = x * 2;
        System.out.println("[Dentro de la función, el número vale = " + x + "]");
    }

    // 2- Función que duplica cada elemento del arreglo
    public static void duplicarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2;
        }
    }

    // Función auxiliar para mostrar el arreglo
    public static void mostrarArreglo(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
