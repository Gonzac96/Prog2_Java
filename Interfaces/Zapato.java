public class Zapato extends Indumentaria {
    private final String material;

    public Zapato(int id, double precio, int stock, String material, String talle) {
        super(id, precio, stock, talle);
        this.material = material;
    }

    public static String mostrarDatos() {
        String datosSucursal = "Datos de la sucursal para Zapato";
        return datosSucursal;
    }

    @Override
    public String mostrarDatos(int id, double precio, int stock) {
        return "ID: " + id + ", Precio: " + precio + ", Stock: " + stock + ", Material: " + material + ", Talle: " + getTalle();
    }
    
}
