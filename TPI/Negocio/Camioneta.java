package Negocio;

import Dato.Color;
import Dato.Marca;
import Dato.TipoCarroceria;
import Modelo.Vehiculo;

public class Camioneta extends Vehiculo{

    private TipoCarroceria carroceria;
    private double capacidadCarga; // en kilogramos
    private int capacidadPersonas;
    private String traccion;

    // Constructor vacío
    public Camioneta() {
        super();
    }

    // Constructor con parámetros
    public Camioneta(Marca marca, String modelo, int anio, Color color, boolean esUsado, double precio, TipoCarroceria carroceria, double capacidadCarga, int capacidadPersonas, String traccion) {
        super(marca, modelo, anio, color, esUsado, precio);
        this.carroceria = carroceria;
        this.capacidadCarga = capacidadCarga;
        this.capacidadPersonas = capacidadPersonas;
        this.traccion = traccion;
    }

    // Getters y Setters
    public TipoCarroceria getCarroceria() {
        return carroceria;
    }
    public void setCarroceria(TipoCarroceria carroceria) {
        this.carroceria = carroceria;
    }
    public double getCapacidadCarga() {
        return capacidadCarga;
    }
    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }
    public void setCapacidadPersonas(int capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }
    public String getTraccion() {
        return traccion;
    }
    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Camioneta | Carrocería: " + carroceria + " | Capacidad de Carga: " + capacidadCarga + " kg | Capacidad de Personas: " + capacidadPersonas + " | Tracción: " + traccion;
    }
    
}
