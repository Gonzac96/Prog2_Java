package Modelo;

import Dato.Color;
import Dato.Marca;
import java.io.Serializable;

/*
    Clase abstracta que representa un Vehículo genérico.
    Cumple con el patrón JavaBean.
*/
public abstract class Vehiculo implements Serializable {
    
    // 1. Atributos Privados (Encapsulamiento)
    private Marca marca;
    private String modelo;
    private int anio;
    private Color color; // Enum
    private boolean esUsado;
    private double precio;

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
    }

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
        // Ejemplo de validación (Lógica de Negocio básica en el modelo)
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

    // Método toString para mostrar la info básica del vehículo
    @Override
    public String toString() {
        return "Marca: " + marca + " | Modelo: " + modelo + " | Año: " + anio + 
               " | Color: " + color + " | Usado: " + (esUsado ? "Sí" : "No") + 
               " | Precio: $" + precio;
    }
    
    // Método abstracto (opcional): Si quisieras obligar a los hijos a tener un comportamiento específico
    // public abstract void mostrarDetallesTecnicos();
}