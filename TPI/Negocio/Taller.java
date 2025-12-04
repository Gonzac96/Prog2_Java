package Negocio;

import Modelo.Mantenimiento;
import java.util.LinkedList;
import java.util.Queue;

/*
    Clase genérica que representa al Taller.
    <T> es el tipo de objeto que va a ingresar al taller,
    y debe implementar la interfaz Mantenimiento.
    En teoría, se le podría dar Mantenimiento a cualquier clase
    que implemente dicha interfaz.
*/

public class Taller<T extends Mantenimiento> {
    
    // Utilizo una Queue (Cola) para gestionar el orden de ingreso al taller con LinkedList
    // FIFO: First In, First Out (como para ordenar los turnos)

    private Queue<T> colaMantenimiento; // Queue es una interfaz, concepto abstracto de una cola

    // Constructor
    public Taller() {
        this.colaMantenimiento = new LinkedList<>(); // LinkedList implementa la interfaz Queue, es la clase concreta
    }

    // Método para ingresar un vehículo al taller
    public void ingresarVehiculo(T vehiculo) {
        colaMantenimiento.offer(vehiculo); // Agrega al final de la cola
        System.out.println("Vehículo ingresado a la cola para mantenimiento.");
    }

    // Método para atender el siguiente vehículo
    public void atenderSiguienteVehiculo() {
        if (colaMantenimiento.isEmpty()) {
            System.out.println("No hay vehículos en la cola de mantenimiento.");
        } else {
            T vehiculo = colaMantenimiento.poll(); // Obtiene y remueve el primer vehículo de la cola
            System.out.println("El vehículo está ingresando a mantenimiento");
            System.out.println("------------------------------------------------");
            vehiculo.ingresoMantenimiento();
            vehiculo.realizarServicioTecnico();
            vehiculo.lavarVehiculo();
            System.out.println("Mantenimiento completado para el vehículo.");
        }
    }

    // Método para contar cuántos vehículos hay en cola
    public int contarVehiculosEnCola() {
        return colaMantenimiento.size();
    }


}
