package examen;

import java.util.Scanner;

/**
 * 1.-Clase(Rectángulo)
 */
public class Rectangulo implements Forma {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Rectangulo rec = new Rectangulo();
        rec.Area();

    }
    public void Area() {
        //4.- sobrecargar los métodos de la clase.
        System.out.println("Ingresa los valores para calcular el area del rectangulo.");
        System.out.println("Ingresa el valor para la base: ");
        Double b = Double.parseDouble(sc.nextLine());
        System.out.println("Ingresa el valor para la altura: ");
        Double a = Double.parseDouble(sc.nextLine());
        String result = String.valueOf(CalcularArea(b, a));
        System.out.println(result);
    }
    /**
     * 3.-Genera la clase que implemente la interfaz
     */
    @Override
    public double CalcularArea(double b, double a) {
        //4.-Sobre-escribir.
        double result = b * a;
        return result;
    }
}
