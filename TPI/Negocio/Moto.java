package Negocio;

import Dato.Color;
import Dato.Marca;
import Dato.TipoMoto;
import Modelo.Vehiculo;

public class Moto extends Vehiculo {

    private TipoMoto tipo;
    private int cilindrada;

    // Constructor vacío
    public Moto() {
        super();
    }

    // Constructor con parámetros
    public Moto(Marca marca, String modelo, int anio, Color color, boolean esUsado, double precio, TipoMoto tipo, int cilindrada) {
        super(marca, modelo, anio, color, esUsado, precio);
        this.tipo = tipo;
        this.cilindrada = cilindrada;
    }

    // Getters y Setters
    public TipoMoto getTipo() {
        return tipo;
    }
    public void setTipo(TipoMoto tipo) {
        this.tipo = tipo;
    }
    public int getCilindrada() {
        return cilindrada;
    }
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Moto | Estilo: " + tipo + " | Cilindrada: " + cilindrada + " cc";
    }


    
}
