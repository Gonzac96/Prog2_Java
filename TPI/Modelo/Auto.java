package Modelo;

import Dato.Color;
import Dato.Marca;
import Dato.TipoCarroceria;
import Excepciones.AutoCantPuertasException;

public class Auto extends Vehiculo {

    private TipoCarroceria carroceria;
    private int cantidadPuertas;

    // Constructor vacío
    public Auto() {
        super();
    }

    // Constructor con parámetros
    public Auto(Marca marca, String modelo, int anio, Color color, boolean esUsado, double precio, TipoCarroceria carroceria, int cantidadPuertas) 
    throws AutoCantPuertasException {
        super(marca, modelo, anio, color, esUsado, precio);
        this.carroceria = carroceria;

        if (cantidadPuertas < 3) {
            throw new AutoCantPuertasException("Error: Un auto debe tener al menos 3 puertas. Puertas ingresadas: " + cantidadPuertas);
        }
        this.cantidadPuertas = cantidadPuertas;
    }

    // Getters y Setters
    public TipoCarroceria getCarroceria() {
        return carroceria;
    }
    public void setCarroceria(TipoCarroceria carroceria) {
        this.carroceria = carroceria;
    }
    public int getCantidadPuertas() {
        return cantidadPuertas;
    }
    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Auto | Carrocería: " + carroceria + " | Puertas: " + cantidadPuertas;
    }
    
}
