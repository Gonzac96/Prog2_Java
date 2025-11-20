public class Principal {
    public static void main(String[] args) {
        // Crear instancias de Ropa y Zapato
        Ropa camisa = new Ropa(1, 29.99, 100);
    Zapato zapatilla = new Zapato(2, 59.99, 50, "Cuero", "42");
    Zapato botin = new Zapato(3, 89.99, 30, "Cuero", "42");

        // Mostrar datos utilizando el método de la interfaz Sucursal
        System.out.println(Sucursal.mostrarDatos());
        System.out.println(camisa.mostrarDatos(1, 29.99, 100));
        System.out.println(zapatilla.mostrarDatos(2, 59.99, 50));
        System.out.println(Zapato.mostrarDatos());
        System.out.println(botin.mostrarDatos(3, 89.99, 30));
    }
}
