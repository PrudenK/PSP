package PrimeraEvaluacion.Ejs_3_Excepciones;

import java.util.Scanner;

public class Ej_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numIntro = 0;
        int indiceNum = 1;
        while (numIntro != -1){
            System.out.println("\nPor favor, vaya introduciendo números enteros (-1 para salir).");
            System.out.print("N "+indiceNum+": ");
            try {
                numIntro = sc.nextInt();
                indiceNum++;
            }catch (Exception e){
                System.out.println("El dato introducido no es correcto, debe ser un número entero.");
                System.out.println("Por favor, inténtelo de nuevo.");
                sc.nextLine();
            }
        }
        System.out.println("Programa terminado");
        sc.close();
    }
}
