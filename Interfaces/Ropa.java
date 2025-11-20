public class Ropa extends Indumentaria {
    public Ropa(int id, double precio, int stock) {
        super(id, precio, stock, "M"); // talles por defecto (por ejemplo M)
    }

    private String tipo; // Ejemplo: "Camisa", "Pantalón", etc.
    
    // Método para mostrar datos compatible con la interfaz Sucursal/Indumentaria
    public String mostrarDatos(int id, double precio, int stock) {
        return "ID: " + id + ", Precio: " + precio + ", Stock: " + stock + ", Talle: " + getTalle();
    }
    
}
