package Modelo;

import Dato.Color;
import Dato.Marca;
import java.io.Serializable;

/*
    Clase abstracta que representa un Vehículo genérico.
    Cumple con requerimentos básicos del patrón JavaBean.
    También hace que las clases hijas (Auto, Moto, Camioneta) hereden sus atributos y métodos comunes,
    y por lo tanto, estas cumplen con el patrón JavaBean también.
*/
public abstract class Vehiculo implements Serializable, Comparable<Vehiculo>, Mantenimiento {
    
    // 1. Atributos Privados (Encapsulamiento)
    private Marca marca;
    private String modelo;
    private int anio;
    private Color color; // Enum
    private boolean esUsado;
    private double precio;
    private boolean mantenimiento; // agrego este atributo para saber si el vehículo está en mantenimiento(Taller)
    private boolean enTaller; // para saber si el vehículo está actualmente en el taller

    // 2. Constructor vacío (JavaBean)
    protected Vehiculo() {
    }

    // Constructor
    protected Vehiculo(Marca marca, String modelo, int anio, Color color, boolean esUsado, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.esUsado = esUsado;
        this.precio = precio;
        this.mantenimiento = !esUsado;  // Si NO es usado, el mantenimiento se considera hecho (true)
    }                                   // Si es usado, el mantenimiento está pendiente (false)

    // 3. Getters y Setters (JavaBean)

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isEsUsado() {
        return esUsado;
    }

    public void setEsUsado(boolean esUsado) {
        this.esUsado = esUsado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        // Validación (Lógica de Negocio básica en el modelo)
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }
    public boolean isMantenimiento() {
        return mantenimiento;
    }
    public void setMantenimiento(boolean mantenimiento) {
        this.mantenimiento = mantenimiento;
    }
    public boolean isEnTaller() {
        return enTaller;
    }
    public void setEnTaller(boolean enTaller) {
        this.enTaller = enTaller;
    }


    // Método toString para mostrar la info básica del vehículo
    @Override
    public String toString() {
        return "Marca: " + marca + " | Modelo: " + modelo + " | Año: " + anio + 
        " | Color: " + color + " | Usado: " + (esUsado ? "Sí" : "No") + " | Precio: $" + precio +
        " | Tiene Mantenimiento: " + (mantenimiento ? "Sí" : "No") + " | En Taller: " + (enTaller ? "Sí" : "No");
    }

    // Implementación de Comparable para ordenar vehículos por precio
    @Override
    public int compareTo(Vehiculo otroVehiculo) {
        return Double.compare(this.precio, otroVehiculo.precio);
    }

    // Implementación de métodos de la interfaz Mantenimiento
    // (no tiene que implementar ningún método porque la clase es abstracta, pero se hace para que las subclases lo hereden)
    @Override
    public void realizarServicioTecnico() {
        if (this.esUsado) {
            System.out.println("Realizando servicio técnico al vehículo: " + this.modelo + " | Marca " + this.marca + " | Año " + this.anio);
            // Ahora cambio el estado de mantenimiento a true
            this.mantenimiento = true;
        } else {
            System.out.println("El vehículo es 0km, no requiere servicio técnico.");
            this.mantenimiento = true;
        }
    }
    @Override
    public void lavarVehiculo() {
        System.out.println("Lavando el vehículo: " + this.modelo + " | Marca " + this.marca + " | Año " + this.anio);
    }

}