import java.util.*;
import java.time.Year;
import java.util.stream.Collectors;

class Persona {
    private String nombre;
    private int fechaNacimiento;

    public Persona(String nombre, int fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        int fechaActual = Year.now().getValue();
        return fechaActual - fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " - Edad: " + getEdad();
    }
}

public class PersonaMayor {
    public static void main(String[] args) {

        // Lista inicial con varias personas
        List<Persona> personas = Arrays.asList(
            new Persona("Ana", 2010),
            new Persona("Luis", 1995),
            new Persona("María", 2006),
            new Persona("Juan", 1988),
            new Persona("Pedro", 2005)
        );

        // Imprimo la lista inicial de personas
        System.out.println("--- PERSONAS ---");
        personas.forEach(System.out::println);
        System.out.println();

        //.filter(personasss -> personasss.getEdad() >= 18)
        //.toList();
        //.collect(ArrayList::new, ArrayList::add, ArrayList::addAll); Versión alternativa

        // 1. Generar una nueva lista con personas mayores o iguales a 18 años y que imprima los nombres en mayúscula
        // List<Integer> mayores = 
        
        // boolean hayAdultos = edades.stream()
        // .anyMatch(edad -> edad >= 18);
            

            


        // 2. Mostrar por consola los nombres y edades de las personas filtradas
        // System.out.println("Personas mayores de edad y nombre en mayúscula");
        // mayores.forEach(p -> System.out.println("Nombre: " + p.getNombre() + " - " + p.getEdad() + " años"));
    }
}
