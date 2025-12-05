package Negocio;

import Modelo.Vehiculo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    ArrayList para buscar y recorrer
    los vehículos disponibles en la concesionaria.
*/

public class Concesionaria {
    
    private List<Vehiculo> inventario;
    private String nombreEmpresa;
    private String direccion;
    private String ubicacion;
    private String telefono;
    private String email;

    // Constructor
    public Concesionaria(String nombreEmpresa, String direccion, String ubicacion, String telefono, String email) {
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.email = email;
        this.inventario = new ArrayList<>();
    }

    // Constructor de prueba con datos por defecto
    public Concesionaria() {
        this.nombreEmpresa = "Concesionaria XYZ";
        this.direccion = "Monteagudo 123";
        this.ubicacion = "Ciudad Resistencia, Chaco";
        this.telefono = "+54 9 362-4567835";
        this.email = "xyz@gmail.com";
        this.inventario = new ArrayList<>();
    }


    // Método para agregar vehículos al inventario (CREATE)
    public void agregarVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            inventario.add(vehiculo);
            System.out.println("Vehículo agregado al inventario.");
        }
    }
    // Método para listar vehículos (READ)
    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }
        System.out.println("Inventario de la Concesionaria " + nombreEmpresa + " (ordenados por precio):");
        Collections.sort(inventario); // Ordena por precio ascendente(COMPARABLE). El método compareTo está en Vehículo.java
        for (Vehiculo vehiculo : inventario) {
            System.out.println(vehiculo.toString());
        }
    }
    // Método para buscar un vehículo por su modelo (READ)
    // Va a retornar una sublista de vehículos que coincidan con el modelo buscado (sirve para el menú)
    public List<Vehiculo> buscarVehiculoPorModelo(String modeloBusqueda) {
        List<Vehiculo> resultados = new ArrayList<>();
        // Paso a mayúsculas para evitar problemas de case sensitive
        String busqueda = modeloBusqueda.toUpperCase();

        for (Vehiculo vehiculo : inventario) {
            if (vehiculo.getModelo().equals(busqueda)){
                resultados.add(vehiculo);
            }
        }
        return resultados;
    }
    // Método para eliminar un vehículo del inventario (DELETE)
    public boolean eliminarVehiculo(Vehiculo vehiculo) {
        if (inventario.contains(vehiculo)) {
            inventario.remove(vehiculo);
            System.out.println("Vehículo eliminado del inventario.");
            return true;
        } else {
            System.out.println("El vehículo no se encuentra en el inventario.");
            return false;
        }
    }

    // Método para obtener información de contacto de la concesionaria
    public String obtenerInformacionContacto() {
        return "Concesionaria: " + nombreEmpresa + "\n" +
               "Dirección: " + direccion + " | Ubicación: " + ubicacion + "\n" +
               "Teléfono: " + telefono + "\n" +
               "Email: " + email;
    }

    // Getters y Setters
    public List<Vehiculo> getInventario() {
        return inventario;
    }
    public void setInventario(List<Vehiculo> inventario) {
        this.inventario = inventario;
    }

}
