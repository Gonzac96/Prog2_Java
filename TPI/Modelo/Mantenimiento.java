package Modelo;
/*
    Esta interfaz será implementada por la clase Vehiculo
    para definir el comportamiento de los mismos que 
    puedan ingresar al taller.
*/

public interface Mantenimiento {

    void realizarServicioTecnico();

    void lavarVehiculo();

    default void ingresoMantenimiento() {
        System.out.println("El vehículo ha ingresado al mantenimiento.");
    }
    
}
