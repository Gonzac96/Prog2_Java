package Modelo;

import Dato.Color;
import Dato.Marca;
import Dato.TipoCarroceria;

public class Auto extends Vehiculo {

    private TipoCarroceria carroceria;

    // Constructor vacío
    public Auto() {
        super();
    }

    // Constructor con parámetros
    public Auto(Marca marca, String modelo, int anio, Color color, boolean esUsado, double precio, TipoCarroceria carroceria) {
        super(marca, modelo, anio, color, esUsado, precio);
        this.carroceria = carroceria;
    }

    // Getters y Setters
    public TipoCarroceria getCarroceria() {
        return carroceria;
    }
    public void setCarroceria(TipoCarroceria carroceria) {
        this.carroceria = carroceria;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Auto | Carrocería: " + carroceria;
    }
    
}
