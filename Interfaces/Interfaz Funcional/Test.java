import java.util.*;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> stuff = new ArrayList<>(); //ArrayList de String

        stuff.add("Denver");
        stuff.add("Boulder");
        stuff.add("Vail");
        stuff.add("Aspen");
        stuff.add("Telluride");
        System.out.println("Unsorted: " + stuff);
        Collections.sort(stuff); //Ordena el ArrayList
        System.out.println("Sorted: " + stuff);
        System.out.println(stuff);
        Collections.reverse(stuff); //Invierte el ArrayList
        System.out.println("Reversed: " + stuff);
        Collections.shuffle(stuff); //Mezcla el ArrayList
        System.out.println("Shuffled: " + stuff);
        Collections.sort(stuff); //Ordena el ArrayList
        System.out.println("Lo ordeno de nuevo: " + stuff);
        Collections.rotate(stuff, 2); //Rota el ArrayList
        System.out.println("Rotated: " + stuff);
        Collections.swap(stuff, 1, 3); //Intercambia dos elementos del ArrayList
        System.out.println("Swapped: " + stuff + "-- Intercambié los elementos en las posiciones 1 y 3(indices)");
    }
}
