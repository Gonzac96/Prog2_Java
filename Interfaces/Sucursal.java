interface Sucursal {

    public abstract String mostrarDatos(int id, double precio, int stock);

    public static String mostrarDatos() {
        return "Datos de la sucursal";
    }
    
}
