import java.util.ArrayList;
import java.util.Scanner;

public class ProductosLimpieza {

    private int codigo;
    private String nombre;
    private double precio; 
    private String marca;

    // Constructor
    public ProductosLimpieza(int codigo, String nombre, double precio, String marca) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
    }

    // Constructor vacío
    public ProductosLimpieza() {
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    @Override
    public String toString() {
        return "Producto:\nCódigo: " + codigo + " | Nombre: " + nombre.toUpperCase() + " | Precio: " + precio + " | Marca: " + marca + "\n";
    }

    // Sobreescritura de equals para comparar productos por código
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ProductosLimpieza other = (ProductosLimpieza) obj;
        return codigo == other.codigo;
    }

    public int hashCode() {
        return Integer.hashCode(codigo);
    }

    public void ListadoProductos() {
        // Método para listar productos (puede ser implementado más adelante)
        System.out.println("--- Listado de productos ---");
        if(productos.isEmpty()) {
            System.out.println("La lista de productos está vacía.");
        } else {
            for (ProductosLimpieza p : productos) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {

        // Listado de productos de limpieza
        ArrayList<ProductosLimpieza> productos = new ArrayList<>();

        productos.add(new ProductosLimpieza(101, "Detergente Líquido", 3.99, "CleanCo"));
        productos.add(new ProductosLimpieza(102, "Desinfectante en Aerosol", 4.49, "FreshAir"));
        productos.add(new ProductosLimpieza(103, "Limpiador Multiusos", 2.99, "Sparkle"));
        productos.add(new ProductosLimpieza(104, "Jabón para Platos", 1.99, "DishMaster"));
        productos.add(new ProductosLimpieza(105, "Limpiavidrios", 2.49, "ClearView"));

        System.out.println("--- PRODUCTOS DE LIMPIEZA ---");
        /*  El programa debe permitir al usuario:
        1- Agregar un nuevo producto, y verificar que no exista otro producto con el mismo código antes de agregarlo.
        2- Listar todos los productos y si la lista está vacía, mostrar un mensaje indicándolo.
        3- Buscar un producto por código
        4- Modificar el precio de un producto
        5- Eliminar un producto por código
        */

        System.out.print("Ingrese que acción desea realizar: \n1- Agregar un nuevo producto\n2- Listar todos los productos\n3- Buscar un producto por código\n4- Modificar el precio de un producto\n5- Eliminar un producto por código\nOpción: ");
        Scanner s = new Scanner(System.in);
        int opcion = s.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("--- Agregar un nuevo producto ---");
                System.out.println("Ingrese el código del producto: ");
                int codigo = s.nextInt();
                // Verificar si el código ya existe
                boolean existe = false;
                for (ProductosLimpieza p : productos) {
                    if (p.getCodigo() == codigo) {
                        existe = true;
                        System.out.println("El código ya existe. No se puede agregar el producto.");
                        break;
                    } else {
                        System.out.println("Ingrese el nombre del producto: ");
                        String nombre = s.next();
                        System.out.println("Ingrese el precio del producto: ");
                        // Limpieza de buffer
                        s.nextLine();
                        double precio = s.nextDouble();
                        System.out.println("Ingrese la marca del producto: ");
                        String marca = s.next();
                        productos.add(new ProductosLimpieza(codigo, nombre, precio, marca));
                        System.out.println("Producto agregado exitosamente.");
                        break;
                    }
                }

                break;
            case 2:
                System.out.println("--- Listado de productos ---");
                 if (productos.isEmpty()) {
                    System.out.println("La lista de productos está vacía.");
                } else {
                    for (ProductosLimpieza p : productos) {
                        System.out.println(p);
                    }
                }
                break;
            case 3:
                System.out.println("Buscar un producto por código");
                break;
            case 4:
                System.out.println("Modificar el precio de un producto");
                break;
            case 5:
                System.out.println("Eliminar un producto por código");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        


        s.close();
    }

}
