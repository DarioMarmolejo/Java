package examen;

import java.util.Scanner;

//Mediante ciclos o bucles genera la impresión de un triángulo recto de números
public class Ciclos {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa un numero para generar un triángulo recto de números:  ");
        int n = sc.nextInt();
        int cont =1;
        for(int i=1;i <=n ;i++){
            for(int j=1;j<i+1;j++){
                System.out.print(cont+" ");

                cont++;
                
            }
            System.out.println("");
        }
        
    }
}
