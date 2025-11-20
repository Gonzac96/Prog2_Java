public class EjemploException {

    public static void main(String[] args) {
        String texto = null; // Advertencia: texto es null, no una cadena vacía

        try {
            // Esto lanzará NullPointerException porque texto es null
            int longitud = texto.length();
            System.out.println("Longitud: " + longitud);
        } catch (NullPointerException e) {
            System.out.println("Advertencia: Se intentó obtener la longitud de una variable String que es null.");
            System.out.println("Detalle del error: " + e.getMessage());
        }
    }
}

