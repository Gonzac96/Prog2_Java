public class Indumentaria extends Producto {
    public Indumentaria(int id, double precio, int stock, String talle) {
        super(id, precio, stock);
        this.talle = talle;
    }

    private String talle;

    
    
    public String getTalle() {
        return talle;
    }

    public static String mostrarDatos() {
        String datosSucursal = "Datos de la sucursal para Indumentaria";
        return datosSucursal;
    }

    public String mostrarDatos(int id, double precio, int stock) {
        return "ID: " + id + ", Precio: " + precio + ", Stock: " + stock + ", Talle: " + talle;
    }
}
