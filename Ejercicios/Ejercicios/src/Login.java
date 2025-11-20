import java.util.Scanner;

public class Login {

    // 1. Variable global
    private static int intentos = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (intentos < 3) {
            System.out.print("Ingrese usuario: ");
            String usuario = s.nextLine().trim();

            System.out.print("Ingrese contraseña: ");
            String contrasena = s.nextLine().trim();

            if (validarUsuario(usuario, contrasena)) {
                System.out.println("Inicio de sesión exitosa. Bienvenido " + usuario + "!");
                break;
            } else {
                // 3. Incrementar el contador de intentos
                intentos++;
                System.out.println("Usuario o contraseña incorrectos. Intento " + intentos + "/3");
            }
        }

        if (intentos >= 3) {
            // 4. Mensaje de usuario bloqueado
            System.out.println("Usuario bloqueado.\nHa superado el número de intentos permitidos.");
        }

        s.close();
    }

    // 2. Método que usa variables locales para usuario y contraseña
    public static boolean validarUsuario(String usuario, String contrasena) {

        String usuarioCorrecto = "admin";
        String contrasenaCorrecta = "1234";

        return usuario.equals(usuarioCorrecto) && contrasena.equals(contrasenaCorrecta);
    }
}
