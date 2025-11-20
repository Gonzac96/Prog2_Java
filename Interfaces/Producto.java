public abstract class Producto implements Sucursal {
    private int id;
    private double precio;
    private int stock;

    public Producto(int id, double precio, int stock) {
        this.id = id;
        this.precio = precio;
        this.stock = stock;
    }

    
}
