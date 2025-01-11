package PrimeraEvaluacion.Ejs_2_Colecciones;

import java.util.ArrayList;
import java.util.Arrays;

public class Ej_1 {
    public static void main(String[] args) {
        ArrayList<String> lista_nombres = new ArrayList<>(Arrays.asList("Nacho", "Alejandro", "Alex", "Emi", "Enrique", "Raúl"));
        //lista_nombres.forEach(System.out::println); o
        for(String nombre : lista_nombres){
            System.out.println(nombre);
        }
    }
}
