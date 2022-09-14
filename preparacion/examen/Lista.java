package examen;

import java.util.ArrayList;
import java.util.List;

// Crear una lista de tipo String
public class Lista {
    public static void main(String[] args) {

        /**
         * Crear una lista de tipo String
         * La lista debe de contener estos elementos (juan, pedro, jose, maria, sofia)
         */
        List<String> nombres = new ArrayList<String>();
        nombres.add("juan");
        nombres.add("pedro");
        nombres.add("jose");
        nombres.add("maria");
        nombres.add("sofia");

        /**
         * Itera la lista y actualizar el primer índice pasando el primer carácter a
         * mayúscula
         */
        for (int i = 0; i < nombres.size(); i++) {
            String nombre = nombres.get(i);
            int endIndex = nombre.length();
            String result = nombre.substring(0, 1).toUpperCase() + nombre.substring(1, endIndex);
            nombres.set(i, result);
        }
        /**
         * Imprimir la lista con un for-each
         */
        for (String hecho : nombres) {
            System.out.println("Los nombres son: " + hecho);
        }

    }
}
