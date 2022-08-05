public class VariablesPte_2 {
    public static void main(String[] args) {

        /*
         * Ejercicio de la sesion 12 - Concatenación con Java.
         */

        var usuario = "juan";
        var titulo = "Ingeniero";
        var union = titulo + " " + usuario;
        System.out.println("union = " + union);

        // Se recomienda hacer variables con nombres y no con letras solas o palabras
        // reservadas
        var i = 3;
        var j = 4;
        System.out.println(i + j); //Realiza la suma de los numeros
        System.out.println(i + j + usuario); // Evaluacion de izquierda a derecha, Realiza la suma de los numeros y la cadena
        System.out.println(usuario + i + j); // contexto cadena, todo es una cadena
        System.out.println(usuario + (i + j)); // uso de parentesis modifican la prioridad en la evaluacion

    }
}
