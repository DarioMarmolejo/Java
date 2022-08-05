
public class Variables {
    /*
     * En este docmento se realizaran las actividades de la seccion 2
     */
    public static void main(String[] args) {

        /*
         * Ejercicio de la sesion 8 - Variables en Java
         * Se realizo una variable entera y se imprimio en consola.
         */
        int miVariableEntera = 10;
        System.out.println("variable entera: " + miVariableEntera);

        /*
         * Ejercicio de la sesion 9 - Tipo Enteros y tipo String en Java.
         */

        // Definimos la variable
        miVariableEntera = 10;
        System.out.println("variable entera: " + miVariableEntera);
        // modificamos el valor de la variable
        miVariableEntera = 5;
        System.out.println(miVariableEntera);

        String miVariableCadena = "Saludos";
        System.out.println(miVariableCadena);

        // Ejercicio sesion 9 : Asignar el valor de adios a la variable String
        miVariableCadena = "Adios";
        System.out.println(miVariableCadena);

        /*
         * Ejercicio de la sesion 10 - Inferencia de tipos en Java.
         */

        // var - Inferencia de tipos en java
        var miVariableEntera2 = 5;
        System.out.println(miVariableEntera2);

        var miVariableCadena2 = "Nueva Cadena";
        System.out.println("miVariableCadena2 = " + miVariableCadena2);

        /*
         * Ejercicio de la sesion 11 - Reglas para definir una variable en Java.
         */
        // Estos son formas permitidas de defiir las variables
        var miVariable = 1;
        var _miVariable = 1;
        var $miVariable = 1;
        // Empezar con un caracter especial no esta permitido.

    }
}
