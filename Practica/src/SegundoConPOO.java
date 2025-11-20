import java.util.Scanner;

public class SegundoConPOO {
    public static void main(String[] args) {
        int nro1 = 0;
        int nro2 = 0;
        int opcion;
        Scanner entrada = new Scanner(System.in);
        Menu menuObjeto = new Menu();
        do {
            menuObjeto.mostrarMenu();
            opcion = entrada.nextInt();
            if (opcion != 0) {
                System.out.print("Ingrese el primer número: ");
                nro1 = entrada.nextInt();
                System.out.print("Ingrese el segundo número: ");
                nro2 = entrada.nextInt();
            }
            Calculadora calculadoraObjeto = new Calculadora(nro1, nro2);
            switch (opcion) {
                case 1:
                    System.out.println(calculadoraObjeto.getNro1() + " + " + calculadoraObjeto.getNro2() + " = " + calculadoraObjeto.sumar());
                    break;
                case 2:
                    System.out.println(calculadoraObjeto.getNro1() + " - " + calculadoraObjeto.getNro2() + " = " + calculadoraObjeto.restar());
                    break;
                case 3:
                    System.out.println(calculadoraObjeto.getNro1() + " x " + calculadoraObjeto.getNro2() + " = " + calculadoraObjeto.multiplicar());
                    break;
                case 4:
                    if (nro2 == 0){
                        calculadoraObjeto.dividir();
                        break;
                    } else {
                        System.out.println(calculadoraObjeto.getNro1() + " / " + calculadoraObjeto.getNro2() + " = " + calculadoraObjeto.dividir());
                        break;
                    }
                case 0:
                    System.out.println("FIN");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
        entrada.close();
    }





    static class Menu {
        public static void mostrarMenu() {
            System.out.println(
                    "\nSeleccione la operación a realizar\n 1. Sumar\n 2. Restar\n 3. Multiplicar\n 4. Dividir\n 0. Salir");
        }
    }

    static class Calculadora {

        private int nro1, nro2;

        public Calculadora(int nro1, int nro2) {
            this.nro1 = nro1;
            this.nro2 = nro2;
        }

        public int sumar() {
            return this.nro1 + this.nro2;
        }

//        public void restar() {
//            int resultado = this.nro1 - this.nro2;
//            String mensaje = (this.nro1 > this.nro2) ? ("Resultado:" + resultado) : "El resultado es negativo";
//            System.out.println(mensaje);
//        }
        public int restar(){
            return this.nro1 - this.nro2;
        }

        public int multiplicar(){
            return this.nro1 * this.nro2;
        }

        public double dividir() {
            if (this.nro1 == 0 && this.nro2 == 0) {
                System.out.println("El resultado es indeterminado\n");
                return 0;
            } else if (this.nro2 == 0) {
                    System.out.println("No se puede dividir por cero\n");
                    return 0;
            } else {
                    return (double) this.nro1 / this.nro2;
            }
        }

        public int getNro1() {
            return nro1;
        }

        public int getNro2() {
            return nro2;
        }

    }

}