import java.util.Scanner;

import javax.sound.midi.VoiceStatus;

public class VariablesPte_3 {
    public static void main(String[] args) {

        /*
         * Ejercicio de la sesion 13 - Caracteres especiales en Java.
         */

        var nombre = "Karla";

        System.out.println("Nueva linea: \n" + nombre);
        System.out.println("Tabulador. \t" + nombre);
        System.out.println("Retroceso: \b" + nombre);
        System.out.println("Comilla simple: \'" + nombre + "\'");
        System.out.println("Comilla doble: \"" + nombre + "\"");

        System.out.println("__________________");
        /*
         * Ejercicio de la sesion 14 - Classe scanner en Java.
         */
        System.out.println("Escribe tu nombre:");
        Scanner consola = new Scanner(System.in);

        var usuario = consola.nextLine();
        System.out.println("usuario" + usuario);

        System.out.println("Escribe el titulo: ");
        var titulo= consola.nextLine();

        System.out.println("Resultado: " + titulo + " " + usuario);

    }
}
