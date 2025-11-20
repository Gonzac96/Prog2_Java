

/**
 * Herencia y polimorfismos
 * Polimorfismo -> Sobrecarga de métodos (misma clase) y Sobreescritura de
 * métodos (herencia)
 **/
import java.util.Scanner;

class interfaz {
  private String nombre, apellido;
  private int dni;

  public interfaz(String nombre, String apellido, int dni) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
  }

  @Override // polimorfismo -> sobreescritura
  public String toString() {
    return "- " + this.apellido + ", " + this.nombre + " (DNI: " + this.dni + ")";
  }


  // Desarrolla una función que reciba un objeto que implemente la interfaz InformeDeDatos y muestre en pantalla el informe generado.
  // Además, si se trata de un docente, también deben mostrarse todas las materias que dicta.
  public void informeCompleto(InformeDeDatos objeto) {
    System.out.println(objeto.informe());
    if (objeto instanceof Docentes) {
      ((Docentes) objeto).mostrarMaterias();
    }
  }


  // Desarrolla una función que permita registrar un docente. El programa debe solicitar al usuario el nombre, apellido, DNI y la cantidad de materias que dicta, para luego pedir el nombre de cada materia.
  // Finalmente debe devolver un objeto Docentes con esas materias asignadas.
  public Docentes registrarDocente() {
      Scanner s = new Scanner(System.in);
      System.out.print("Ingrese nombre: ");
      String nombre = s.nextLine().trim();
      System.out.print("Ingrese apellido: ");
      String apellido = s.nextLine().trim();
      System.out.print("Ingrese DNI: ");
      int dni = s.nextInt();
      System.out.print("Ingrese cantidad de materias: ");
      int cantidadMaterias = sc.nextInt();
      s.nextLine();
      Materia[] materias = new Materia[cantidadMaterias];
      for (int i = 0; i < cantidadMaterias; i++) {
          System.out.print("Ingrese nombre de la materia " + (i + 1) + ": ");
          String nombreMateria = s.nextLine().trim();
          materias[i] = new Materia(nombreMateria);
      }
      return new Docentes(nombre, apellido, dni, materias);
  }
}

class Estudiantes extends interfaz {
  private String carrera;

  public Estudiantes(String nombre, String apellido, int dni, String carrera) {
    super(nombre, apellido, dni);
    this.carrera = carrera;
  }

  public Estudiantes(String nombre, String apellido, int dni) {
    super(nombre, apellido, dni);
    this.carrera = "Sin definir";
  }

  public void modificarCarrera(String nuevaCarrera) {
    this.carrera = nuevaCarrera;
  }

  @Override // polimorfismo -> sobreescritura
  public String toString() {
    return super.toString() + " - Carrera: " + this.carrera;
  }

}

class Materia {
  private String nombre;

  public Materia(String nombre) {
    this.nombre = nombre;
  }

  public String toString() {
    return "- " + this.nombre;
  }
}

class Docentes extends interfaz implements InformeDeDatos {
  private Materia[] materias;

  public Docentes(String nombre, String apellido, int dni, Materia[] materias) {
    super(nombre, apellido, dni);
    this.materias = materias;
  }

  @Override
  public String informe() {
    return "El docente " + super.toString() + " dicta materias:";
  }

  public void mostrarMaterias() {
    for (Materia materia : materias) {
      System.out.println(materia.toString());
    }
  }



  @Override // polimorfismo -> sobreescritura
  public String toString() {
    return super.toString();
  }


}

interface InformeDeDatos {
  public String informe();
}

//

public class Practica06 {
  public static void main(String[] args) {
    Estudiantes estudiante = new Estudiantes("María", "Gómez", 87654321, "ISI");
    estudiante.modificarCarrera("TUP");
    Materia isi = new Materia("ISI");
    Materia tup = new Materia("TUP");
    Materia[] materias = { isi, tup };
    Docentes docente = new Docentes("Facundo", "Uferer", 12345678, materias);

    System.out.println(estudiante.toString());
    System.out.println(docente.toString());
    docente.mostrarMaterias();
    //estudiante.informeCompleto(estudiante);
    docente.informeCompleto(docente);

    int f = 5;
    int x  = 10;

    x = f-- * x;
    System.out.println("Hola " + f);

    registrarDocente();

    
  }

}

