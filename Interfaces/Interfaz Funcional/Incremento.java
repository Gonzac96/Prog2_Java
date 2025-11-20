public class Incremento {
    public static void main(String[] args) {
        int contador = 5;
        System.out.println("Linea 1: " + contador++);
        System.out.println("Linea 2: " + ++contador);
        System.out.println("Linea 1: " + contador);

        int resultado = 10;
        resultado = contador-- * resultado;
        System.out.println("Linea 4: " + contador);
        System.out.println("Linea 5: " + resultado);
    }
}
